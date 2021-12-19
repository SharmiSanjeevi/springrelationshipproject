package com.gamestore.repository;


import com.gamestore.model.Requirement;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IRequirementRepository extends JpaRepository<Requirement, Integer> {

    List<Requirement> findByRequiredRAM(String RAM);

    List<Requirement> findByRequiredStorage(String storage);

    List<Requirement> findByRequiredRAMAndRequiredStorage(String RAM, String storage);
}
