package com.gamestore.repository;


import com.gamestore.model.Publisher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IPublisherRepository extends JpaRepository<Publisher, Integer> {

    List<Publisher> findByCountry(String country);

    List<Publisher> findByPublisherNameAndCountry(String publisherName, String country);
}
