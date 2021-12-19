package com.gamestore.service;

import com.gamestore.exceptions.RequirementNotFoundException;
import com.gamestore.model.Requirement;
import com.gamestore.repository.IRequirementRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RequirementServiceImpl implements IRequirementService {

    @Autowired
    IRequirementRepository requirementRepository;

    @Override
    public Requirement addRequirement(Requirement requirement) {
        return requirementRepository.save(requirement);
    }

    @Override
    public Requirement updateRequirement(Requirement requirement) {
        return requirementRepository.save(requirement);
    }

    @Override
    public void deleteRequirement(int requirementId) {

        requirementRepository.deleteById(requirementId);
    }

    @Override
    public Requirement getById(int requirementId) throws RequirementNotFoundException {

        return requirementRepository.findById(requirementId).orElseThrow(() -> new RequirementNotFoundException("Invalid Id"));
    }

    @Override
    public List<Requirement> getAll() {
        return requirementRepository.findAll();
    }

    @Override
    public List<Requirement> getByRAM(String RAM) throws RequirementNotFoundException {
        List<Requirement> requirement = requirementRepository.findByRequiredRAM(RAM);
        if (requirement.isEmpty()) {
            throw new RequirementNotFoundException("Required RAM not Found");
        }
        return requirement;
    }

    @Override
    public List<Requirement> getByStorage(String storage) throws RequirementNotFoundException {
        List<Requirement> requirement = requirementRepository.findByRequiredStorage(storage);
        if (requirement.isEmpty()) {
            throw new RequirementNotFoundException("Required Storage not Found");
        }
        return requirement;
    }


    @Override
    public List<Requirement> getByRAMAndStorage(String RAM, String storage) throws RequirementNotFoundException {
        List<Requirement> requirement = requirementRepository.findByRequiredRAMAndRequiredStorage(RAM, storage);
        if (requirement.isEmpty()) {
            throw new RequirementNotFoundException("Required RAM and Storage not Found");
        }
        return requirement;

    }
}
