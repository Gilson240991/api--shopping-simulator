package com.api.shoppingsimulator.repository;

import com.api.shoppingsimulator.entity.Client;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SimulatorRepository extends JpaRepository<Client,Integer> {

    List<Client> findByDocumentNumber(String documentNumber);

}
