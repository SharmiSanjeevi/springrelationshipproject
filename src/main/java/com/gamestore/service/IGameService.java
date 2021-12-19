package com.gamestore.service;

import com.gamestore.exceptions.CategoryNotFoundException;
import com.gamestore.exceptions.GameNotFoundException;
import com.gamestore.exceptions.PublisherNotFoundException;
import com.gamestore.exceptions.RequirementNotFoundException;
import com.gamestore.model.Game;

import java.util.List;

public interface IGameService {

    Game addGame(Game game);

    Game updateGame(Game game);

    void deleteGame(int gameId);

    Game getById(int gameId) throws GameNotFoundException;

    List<Game> getAll();

    List<Game> getByGame(String gameName) throws GameNotFoundException;

    List<Game> getByDownloads(int downloads) throws GameNotFoundException;

    List<Game> getByRatings(double ratings) throws GameNotFoundException;

    List<Game> getBySize(String size) throws GameNotFoundException;

    List<Game> getByPublisherName(String publisherName) throws GameNotFoundException;

    List<Game> getByPublisherCountry(String country) throws GameNotFoundException;

    List<Game> getByCategoryName(String categoryName) throws GameNotFoundException;

    List<Game> getByRequiredRAM(String RAM) throws GameNotFoundException;

    List<Game> getByRequiredStorage(String storage) throws GameNotFoundException;

    List<Game> getByGameAndRatings(String gameName, String ratings) throws GameNotFoundException;

    List<Game> getByGameAndDownloads(String gameName, int downloads) throws GameNotFoundException;

    List<Game> getByGameAndPublisher(String gameName, String publisherName) throws GameNotFoundException;

    List<Game> getByGameAndSize(String gameName, String size) throws GameNotFoundException;

    List<Game> getByGameAndCategory(String gameName, String name) throws GameNotFoundException;

    List<Game> getByDownloadsAndCategory(int downloads, String name) throws GameNotFoundException;

    List<Game> getByCategoryAndRatings(String name, double ratings) throws GameNotFoundException;

    List<Game> getByCategoryAndStorage(String name, String storage) throws GameNotFoundException;

    List<Game> getByCategoryPublisher(String name, String publisherName) throws GameNotFoundException;

    List<Game> getByCategoryRatingSize(String name, double ratings, String size) throws GameNotFoundException;

    List<Game> getByCategoryRatingsDownloads(String name, double ratings, int downloads) throws GameNotFoundException;

}
