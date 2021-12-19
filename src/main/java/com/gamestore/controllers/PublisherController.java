package com.gamestore.controllers;

import com.gamestore.exceptions.PublisherNotFoundException;
import com.gamestore.model.Publisher;
import com.gamestore.service.IPublisherService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("publisher-api")
public class PublisherController {

    IPublisherService publisherService;
    private Logger logger = LoggerFactory.getLogger(PublisherController.class);

    @Autowired
    public void setPublisherService(IPublisherService publisherService) {
        this.publisherService = publisherService;
    }

    @PostMapping("/publisher")
    public ResponseEntity<Publisher> addPublisher(@RequestBody Publisher publisher) {
        logger.debug("inside Add Publisher controller");
        HttpHeaders headers = new HttpHeaders();
        headers.add("desc", "Added new Publisher");
        Publisher npublisher = publisherService.addPublisher(publisher);
        logger.info("Publisher Added");
        return ResponseEntity.status(HttpStatus.CREATED).body(npublisher);
    }

    @PutMapping("/publisher")
    public ResponseEntity<Publisher> updatePublisher(@RequestBody Publisher publisher) {
        logger.debug("Update Publisher controller");
        HttpHeaders headers = new HttpHeaders();
        headers.add("desc", "Updated new Publisher");
        Publisher publisher1 = publisherService.updatePublisher(publisher);
        logger.info("Publisher Added");
        return ResponseEntity.status(HttpStatus.ACCEPTED).headers(headers).body(publisher1);
    }

    @DeleteMapping("/publisher/{publisherId}")
    public ResponseEntity<Void> deletePublisher(@PathVariable("publisherId") int publisherId) {
        logger.debug("Delete Publisher controller");
        HttpHeaders headers = new HttpHeaders();
        headers.add("desc", "deleted new Publisher");
        publisherService.deletePublisher(publisherId);
        logger.info("Publisher Deleted");
        return ResponseEntity.status(HttpStatus.ACCEPTED).headers(headers).build();

    }

    @GetMapping("/publisher/id/{publisherId}")
    public ResponseEntity<Publisher> getById(@PathVariable("publisherId") int publisherId){
        logger.debug("inside get publisher by id controller");
        HttpHeaders headers = new HttpHeaders();
        headers.add("desc", "Getting Publisher By Id");
        Publisher publisher = publisherService.getById(publisherId);
        logger.info("Get One Publisher");
        return ResponseEntity.ok().headers(headers).body(publisher);
    }

    @GetMapping("/publisher")
    public ResponseEntity<List<Publisher>> getAll() {
        HttpHeaders headers = new HttpHeaders();
        headers.add("desc", "Getting All publisher");
        headers.add("info", "publisher details");
        List<Publisher> publishers = publisherService.getAll();
        ResponseEntity<List<Publisher>> publisherResponse = new ResponseEntity<>(publishers, headers, HttpStatus.OK);
        return publisherResponse;
    }

    @GetMapping("/publisher/country/{country}")
    public ResponseEntity<List<Publisher>> getByCountry(@PathVariable("country") String country){
        logger.debug("inside get publisher by country controller");
        HttpHeaders headers = new HttpHeaders();
        headers.add("desc", "Getting Publisher");
        List<Publisher> publishers = publisherService.getByCountry(country);
        logger.info("Get Publisher by Country");
        return ResponseEntity.ok().headers(headers).body(publishers);
    }

    @GetMapping("/publisher/name/{name}/country/{country}")
    public ResponseEntity<List<Publisher>> getByPublisherAndCountry(@PathVariable("name") String publisherName, @PathVariable("country") String country){
        logger.debug("inside get publisher by name and country controller");
        HttpHeaders headers = new HttpHeaders();
        headers.add("desc", "Getting Publisher And Country");
        List<Publisher> publishers = publisherService.getByPublisherAndCountry(publisherName, country);
        logger.info("Get Publisher by name and country");
        return ResponseEntity.ok().headers(headers).body(publishers);
    }
}
