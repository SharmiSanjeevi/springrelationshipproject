package com.gamestore.service;

import com.gamestore.exceptions.CategoryNotFoundException;
import com.gamestore.exceptions.PublisherNotFoundException;
import com.gamestore.model.Category;
import com.gamestore.model.Publisher;

import java.util.List;

public interface IPublisherService {

    Publisher addPublisher(Publisher publisher);

    Publisher updatePublisher(Publisher publisher);

    void deletePublisher(int publisherId);

    Publisher getById(int publisherId) throws PublisherNotFoundException;

    List<Publisher> getAll();

    List<Publisher> getByCountry(String country) throws PublisherNotFoundException;

    List<Publisher> getByPublisherAndCountry(String publisherName, String country) throws PublisherNotFoundException;
}
