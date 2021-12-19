package com.gamestore.controllers;

import com.gamestore.exceptions.RequirementNotFoundException;
import com.gamestore.model.Requirement;
import com.gamestore.service.IRequirementService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("requirement-api")
public class RequirementController {
    IRequirementService requirementService;

    private Logger logger = LoggerFactory.getLogger(RequirementController.class);

    @Autowired
    public void setRequirementService(IRequirementService requirementService) {
        this.requirementService = requirementService;
    }

    @PutMapping("/requirement")
    public ResponseEntity<Requirement> updateRequirement(@RequestBody Requirement requirement) {
        logger.debug("Update  Requirement controller");
        HttpHeaders headers = new HttpHeaders();
        headers.add("desc", "update new Requirement");
        requirementService.updateRequirement(requirement);
        logger.info("Requirement updated");
        return ResponseEntity.status(HttpStatus.ACCEPTED).headers(headers).build();
    }

    @GetMapping("/requirement/id/{requirementId}")
    public ResponseEntity<Requirement> getById(@PathVariable("requirementId") int requirementId) {
        logger.debug("inside get requirement by id controller");
        HttpHeaders headers = new HttpHeaders();
        headers.add("desc", "Got Requirement By Id");
        Requirement requirement = requirementService.getById(requirementId);
        logger.info("Get Requirement");
        return ResponseEntity.ok().headers(headers).body(requirement);
    }

    @GetMapping("/requirement")
    public ResponseEntity<List<Requirement>> getAll() {
        HttpHeaders headers = new HttpHeaders();
        headers.add("desc", "Got All Requirement");
        headers.add("info", "Requirement details");
        List<Requirement> requirements = requirementService.getAll();
        ResponseEntity<List<Requirement>> requirementResponse = new ResponseEntity<>(requirements, headers, HttpStatus.OK);
        return requirementResponse;
    }

    @GetMapping("/requirement/RAM/{RAM}")
    public ResponseEntity<List<Requirement>> getByRAM(@PathVariable("RAM") String RAM) {
        logger.debug("Get requirement by RAM controller");
        HttpHeaders headers = new HttpHeaders();
        List<Requirement> requirements = requirementService.getByRAM(RAM);
        logger.info("Requirement by RAM size");
        return ResponseEntity.ok().headers(headers).body(requirements);
    }

    @GetMapping("/requirement/storage/{storage}")
    public ResponseEntity<List<Requirement>> getByStorage(@PathVariable("storage") String storage) {
        logger.debug("Get requirement by Storage controller");
        HttpHeaders headers = new HttpHeaders();
        headers.add("desc", "Got requirement by Storage");
        List<Requirement> requirements = requirementService.getByStorage(storage);
        logger.info("Requirement by storage");
        return ResponseEntity.ok().headers(headers).body(requirements);
    }

    @GetMapping("/requirement/RAM/{RAM}/storage/{storage}")
    public ResponseEntity<List<Requirement>> getByRAMAndStorage(@PathVariable("RAM") String RAM, @PathVariable("storage") String storage) {
        logger.debug("Get requirement by RAM and Storage controller");
        HttpHeaders headers = new HttpHeaders();
        headers.add("desc", "Got requirement by RAM And Storage");
        List<Requirement> requirements = requirementService.getByRAMAndStorage(RAM, storage);
        logger.info("Requirement by Storage and RAM");
        return ResponseEntity.ok().headers(headers).body(requirements);
    }
}
