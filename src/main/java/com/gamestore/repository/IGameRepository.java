package com.gamestore.repository;


import com.gamestore.model.CategoryName;
import com.gamestore.model.Game;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IGameRepository extends JpaRepository<Game, Integer> {


    List<Game> findByName(String gameName);

    List<Game> findByDownloads(int downloads);

    List<Game> findByRating(double ratings);

    List<Game> findBySize(String size);

    List<Game> findByNameAndRating(String gameName, String ratings);

    List<Game> findByNameAndDownloads(String gameName, int downloads);

    List<Game> findByNameAndSize(String gameName, String size);

    @Query("from Game g inner join g.publisher p where p.publisherName=?1")
    List<Game> findByPublisherName(String publisherName);

    @Query("from Game g inner join g.publisher p where p.country=?1")
    List<Game> findByPublisherCountry(String country);

    @Query("from Game g inner join g.categories c where c.name=?1")
    List<Game> findByCategoryName(CategoryName categoryName);

    @Query("from Game g inner join g.requirement r where r.requiredRAM=?1")
    List<Game> findByRequiredRAM(String RAM);

    @Query("from Game g inner join g.requirement r where r.requiredStorage=?1")
    List<Game> findByRequiredStorage(String storage);

    @Query("from Game g inner join g.publisher p where p.publisherName=?2 and g.name=?1")
    List<Game> findByGameAndPublisher(String gameName, String publisherName);

    @Query("from Game g inner join g.categories c where c.name=?2 and g.name=?1")
    List<Game> findByGameAndCategory(String gameName, CategoryName name);

    @Query("from Game g inner join g.categories c where c.name=?2 and g.downloads=?1")
    List<Game> findByDownloadsAndCategory(int downloads, CategoryName name);

    @Query("from Game g inner join g.categories c where c.name=?1 and g.rating=?2")
    List<Game> findByCategoryAndRating(CategoryName name, double ratings);

    @Query("from Game g inner join g.categories c inner join g.requirement r where c.name=?1 and r.requiredStorage=?2")
    List<Game> findByCategoryAndStorage(CategoryName name, String storage);

    @Query("from Game g inner join g.categories c inner join g.publisher p where c.name=?1 and p.publisherName=?2")
    List<Game> findByCategoryPublisher(CategoryName name, String publisherName);

    @Query("from Game g inner join g.categories c where c.name=?1 and g.rating=?2 and g.size=?3")
    List<Game> findByCategoryRatingSize(CategoryName name, double ratings, String size);

    @Query("from Game g inner join g.categories c where c.name=?1 and g.rating=?2 and g.downloads=?3")
    List<Game> findByCategoryRatingsDownloads(CategoryName name, double ratings, int downloads);

}
