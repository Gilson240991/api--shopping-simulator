package com.api.shoppingsimulator.service.impl;

import com.api.shoppingsimulator.ApiExceptionEnum;
import com.api.shoppingsimulator.api.response.Payment;
import com.api.shoppingsimulator.api.request.SimulatorRequest;
import com.api.shoppingsimulator.api.response.SimulatorResponse;
import com.api.shoppingsimulator.entity.Card;
import com.api.shoppingsimulator.entity.Client;
import com.api.shoppingsimulator.repository.SimulatorRepository;
import com.api.shoppingsimulator.service.SimulatorService;
import com.api.shoppingsimulator.util.Response;
import com.api.shoppingsimulator.util.Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;
import java.time.Month;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.IntStream;

@Service
public class SimulatorServiceImpl implements SimulatorService {

    @Autowired
    private SimulatorRepository repository;
    @Override
    public Response<SimulatorResponse> getPayment(SimulatorRequest simulatorRequest){
        Response<SimulatorResponse> response = new Response<>();

        List<Client> infoClient = infoClientByDni(simulatorRequest.getDni());

        if(infoClient.isEmpty()){
            response.setException(ApiExceptionEnum.S0002.getException());
            return response;
        }

        if(validateProductOfClient(infoClient)){
            response.setException(ApiExceptionEnum.S0003.getException());
            return response;
        }

       if(!validateTypeCard(simulatorRequest.getCard(),infoClient.get(0))){
           response.setException(ApiExceptionEnum.S0001.getException());
           return response;
       }

       response.setResult(buildResponsePayments(simulatorRequest));

        return response;
    }

    private SimulatorResponse buildResponsePayments(SimulatorRequest simulatorRequest) {
        List<Payment> payments = buildListPayments(simulatorRequest);

        return SimulatorResponse.builder()
                .firstQuota(payments.get(0))
                .listPayment(payments)
                .build();
      }

    private List<Payment> buildListPayments(SimulatorRequest simulatorRequest) {
        List<Payment> listPayment = new ArrayList<>();
        Integer quota = simulatorRequest.getQuota();
        double quotaAmount = calculateQuota(simulatorRequest);
        LocalDate dateBuy = LocalDate.parse(simulatorRequest.getDateBuy(), DateTimeFormatter.ofPattern("yyyy/MM/dd"));

        IntStream.range(0, quota)
                .forEach(i ->
                        listPayment.add(Payment.builder()
                        .quotaAmount(quotaAmount)
                        .currency(simulatorRequest.getCurrency())
                        .firstQuota(buildDateQuota(dateBuy,simulatorRequest,i))
                        .state("Exitoso")
                        .build()));
        return listPayment;
    }

    private LocalDate buildDateQuota(LocalDate dateBuy,SimulatorRequest request, int count) {
        LocalDate datePayment = LocalDate.of(dateBuy.getYear(), dateBuy.getMonth(), Integer.parseInt(request.getPayDay()));
        return datePayment.plusMonths(count+1);
    }

    private double calculateQuota(SimulatorRequest simulatorRequest){
        double tem;
        double frc;
        double quota;
        double amountToPay;

        tem = Math.pow((1 + (Double.parseDouble(Util.removeLastCharacter(simulatorRequest.getTea())))/100),0.0833333333333333)-1;
        frc = (tem*(Math.pow(1+ tem, simulatorRequest.getQuota())))/(Math.pow(1+tem,simulatorRequest.getQuota()) -1);
        quota = frc * simulatorRequest.getAmount();
        amountToPay = quota + quota*(0.005/100);
        return BigDecimal.valueOf(amountToPay).
                setScale(2, RoundingMode.HALF_UP).
                doubleValue();
      }

    private boolean validateProductOfClient(List<Client> info) {
        return  info.get(0).getProducts().isEmpty();
    }

    public List<Client> infoClientByDni(String documentNumber) {
       return repository.findByDocumentNumber(documentNumber);
    }

    private boolean validateTypeCard(String typeCard, Client client){
        Optional<Card> optional = client.getProducts().get(0).getCards().stream()
                .filter(card ->card.getCardName().equals(typeCard))
                .findAny();
        return optional.isPresent();
    }

}
