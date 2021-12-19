package com.gamestore.service;

import com.gamestore.exceptions.PublisherNotFoundException;
import com.gamestore.exceptions.RequirementNotFoundException;
import com.gamestore.model.Publisher;
import com.gamestore.model.Requirement;
import com.gamestore.repository.IPublisherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PublisherServiceImpl implements IPublisherService {

    @Autowired
    IPublisherRepository publisherRepository;

    @Override
    public Publisher addPublisher(Publisher publisher) {
        return publisherRepository.save(publisher);
    }

    @Override
    public Publisher updatePublisher(Publisher publisher) {
        return publisherRepository.save(publisher);
    }

    @Override
    public void deletePublisher(int publisherId) {

        publisherRepository.deleteById(publisherId);
    }

    @Override
    public Publisher getById(int publisherId) throws PublisherNotFoundException {
        return publisherRepository.findById(publisherId).orElseThrow(() -> new PublisherNotFoundException("Invalid Id"));
    }

    @Override
    public List<Publisher> getAll() {
        return publisherRepository.findAll();
    }

    @Override
    public List<Publisher> getByCountry(String country) throws PublisherNotFoundException {
        List<Publisher> publisher = publisherRepository.findByCountry(country);
        if (publisher.isEmpty()) {
            throw new RequirementNotFoundException("Country not Found");
        }
        return publisher;
    }


    @Override
    public List<Publisher> getByPublisherAndCountry(String publisherName, String country) throws PublisherNotFoundException {
        List<Publisher> publisher = publisherRepository.findByPublisherNameAndCountry(publisherName, country);
        if (publisher.isEmpty()) {
            throw new RequirementNotFoundException("Publisher and Country not Found");
        }
        return publisher;
    }
}

