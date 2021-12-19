package com.gamestore.service;

import com.gamestore.exceptions.CategoryNotFoundException;
import com.gamestore.exceptions.RequirementNotFoundException;
import com.gamestore.model.Category;
import com.gamestore.model.Publisher;
import com.gamestore.model.Requirement;

import java.util.List;

public interface IRequirementService {

    Requirement addRequirement(Requirement requirement);

    Requirement updateRequirement(Requirement requirement);

    void deleteRequirement(int requirementId);

    Requirement getById(int requirementId) throws RequirementNotFoundException;

    List<Requirement> getAll();

    List<Requirement> getByRAM(String RAM) throws RequirementNotFoundException;

    List<Requirement> getByStorage(String storage) throws RequirementNotFoundException;

    List<Requirement> getByRAMAndStorage(String RAM, String storage) throws RequirementNotFoundException;

}
