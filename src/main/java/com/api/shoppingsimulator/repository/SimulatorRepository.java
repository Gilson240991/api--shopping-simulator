package com.api.shoppingsimulator.repository;

import com.api.shoppingsimulator.entity.Card;
import com.api.shoppingsimulator.entity.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface SimulatorRepository extends JpaRepository<Client,Integer> {


    @Query(value = "Select client.document_number, client.names,client.father_last_name,client.mother_last_name  from CLIENT inner join CLIENT_PRODUCT  ON client.id = client_product.id_client " +
            "inner join PRODUCT on product.id = client_product.id_product " +
            "inner join PRODUCT_CARD  on product_card.id_product = product.id " +
            "inner join CARD  on card.id = product_card.id_card " +
            "where client.document_number = ?1", nativeQuery = true)
    List<Object[]> searchByDocumentNumber(String documentNumber);

    List<Client> findByDocumentNumber(String documentNumber);

}
