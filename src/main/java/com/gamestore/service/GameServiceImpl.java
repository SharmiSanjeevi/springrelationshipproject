package com.gamestore.service;

import com.gamestore.exceptions.GameNotFoundException;
import com.gamestore.exceptions.RequirementNotFoundException;
import com.gamestore.model.CategoryName;
import com.gamestore.model.Game;
import com.gamestore.repository.IGameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class GameServiceImpl implements IGameService {

    @Autowired
    IGameRepository gameRepository;

    @Override
    public Game addGame(Game game) {
        return gameRepository.save(game);
    }

    @Override
    public Game updateGame(Game game) {
        return gameRepository.save(game);
    }

    @Override
    public void deleteGame(int gameId) {

        gameRepository.deleteById(gameId);
    }

    @Override
    public Game getById(int gameId) throws GameNotFoundException {
        return gameRepository.findById(gameId).orElseThrow(() -> new GameNotFoundException("Invalid Id"));
    }

    @Override
    public List<Game> getAll() {
        return gameRepository.findAll();
    }

    @Override
    public List<Game> getByGame(String gameName) throws GameNotFoundException {
        List<Game> game = gameRepository.findByName(gameName);
        if (game.isEmpty()) {
            throw new RequirementNotFoundException("GameName  not Found");
        }
        return game;
    }


    @Override
    public List<Game> getByDownloads(int downloads) throws GameNotFoundException {
        List<Game> game = gameRepository.findByDownloads(downloads);
        if (game.isEmpty()) {
            throw new RequirementNotFoundException("Game Downloads  not Found");
        }
        return game;
    }

    @Override
    public List<Game> getByRatings(double ratings) throws GameNotFoundException {
        List<Game> game = gameRepository.findByRating(ratings);
        if (game.isEmpty()) {
            throw new RequirementNotFoundException("Game rating not Found");
        }
        return game;
    }

    @Override
    public List<Game> getBySize(String size) throws GameNotFoundException {
        List<Game> game = gameRepository.findBySize(size);
        if (game.isEmpty()) {
            throw new RequirementNotFoundException("Game size  not Found");
        }
        return game;
    }

    @Override
    public List<Game> getByPublisherName(String publisherName) throws GameNotFoundException {
        List<Game> game = gameRepository.findByPublisherName(publisherName);
        if (game.isEmpty()) {
            throw new RequirementNotFoundException("Game Publisher Name not Found");
        }
        return game;
    }

    @Override
    public List<Game> getByPublisherCountry(String country) throws GameNotFoundException {
        List<Game> game = gameRepository.findByPublisherCountry(country);
        if (game.isEmpty()) {
            throw new RequirementNotFoundException("GamePublisher Country  not Found");
        }
        return game;
    }

    @Override
    public List<Game> getByCategoryName(String categoryName) throws GameNotFoundException {
        List<Game> game = gameRepository.findByCategoryName(CategoryName.valueOf(categoryName.toUpperCase()));
        if (game.isEmpty()) {
            throw new RequirementNotFoundException("Game Category Name not Found");
        }
        return game;
    }

    @Override
    public List<Game> getByRequiredRAM(String RAM) throws GameNotFoundException {
        List<Game> game = gameRepository.findByRequiredRAM(RAM);
        if (game.isEmpty()) {
            throw new RequirementNotFoundException("Game required RAM  not Found");
        }
        return game;
    }

    @Override
    public List<Game> getByRequiredStorage(String storage) throws GameNotFoundException {
        List<Game> game = gameRepository.findByRequiredStorage(storage);
        if (game.isEmpty()) {
            throw new RequirementNotFoundException("Game required storage not Found");
        }
        return game;
    }

    @Override
    public List<Game> getByGameAndRatings(String gameName, String ratings) throws GameNotFoundException {
        List<Game> game = gameRepository.findByNameAndRating(gameName, ratings);
        if (game.isEmpty()) {
            throw new RequirementNotFoundException("GameName And Ratings  not Found");
        }
        return game;
    }

    @Override
    public List<Game> getByGameAndDownloads(String gameName, int downloads) throws GameNotFoundException {
        List<Game> game = gameRepository.findByNameAndDownloads(gameName, downloads);
        if (game.isEmpty()) {
            throw new RequirementNotFoundException("GameName And Downloads not Found");
        }
        return game;
    }

    @Override
    public List<Game> getByGameAndPublisher(String gameName, String publisherName) throws GameNotFoundException {
        List<Game> game = gameRepository.findByGameAndPublisher(gameName, publisherName);
        if (game.isEmpty()) {
            throw new RequirementNotFoundException("GameName And Publisher not Found");
        }
        return game;
    }

    @Override
    public List<Game> getByGameAndSize(String gameName, String size) throws GameNotFoundException {
        List<Game> game = gameRepository.findByNameAndSize(gameName, size);
        if (game.isEmpty()) {
            throw new RequirementNotFoundException("GameName ANd Size  not Found");
        }
        return game;
    }

    @Override
    public List<Game> getByGameAndCategory(String gameName, String name) throws GameNotFoundException {
        List<Game> game = gameRepository.findByGameAndCategory(gameName, CategoryName.valueOf(name.toUpperCase()));
        if (game.isEmpty()) {
            throw new RequirementNotFoundException("GameName And Category not Found");
        }
        return game;
    }

    @Override
    public List<Game> getByDownloadsAndCategory(int downloads, String name) throws GameNotFoundException {
        List<Game> game = gameRepository.findByDownloadsAndCategory(downloads, CategoryName.valueOf(name.toUpperCase()));
        if (game.isEmpty()) {
            throw new RequirementNotFoundException("Game Downloads And category not Found");
        }
        return game;
    }

    @Override
    public List<Game> getByCategoryAndRatings(String name, double ratings) throws GameNotFoundException {
        List<Game> game = gameRepository.findByCategoryAndRating(CategoryName.valueOf(name.toUpperCase()), ratings);
        if (game.isEmpty()) {
            throw new RequirementNotFoundException("Category and Ratings not Found");
        }
        return game;
    }

    @Override
    public List<Game> getByCategoryAndStorage(String name, String storage) throws GameNotFoundException {
        List<Game> game = gameRepository.findByCategoryAndStorage(CategoryName.valueOf(name.toUpperCase()), storage);
        if (game.isEmpty()) {
            throw new RequirementNotFoundException("Category and storage not Found");
        }
        return game;
    }

    @Override
    public List<Game> getByCategoryPublisher(String name, String publisherName) throws GameNotFoundException {
        List<Game> game = gameRepository.findByCategoryPublisher(CategoryName.valueOf(name.toUpperCase()), publisherName);
        if (game.isEmpty()) {
            throw new RequirementNotFoundException("Category and PublisherName  not Found");
        }
        return game;
    }

    @Override
    public List<Game> getByCategoryRatingSize(String name, double ratings, String size) throws GameNotFoundException {
        List<Game> game = gameRepository.findByCategoryRatingSize(CategoryName.valueOf(name.toUpperCase()), ratings, size);
        if (game.isEmpty()) {
            throw new RequirementNotFoundException("Category,Ratings and Size not Found");
        }
        return game;
    }

    @Override
    public List<Game> getByCategoryRatingsDownloads(String name, double ratings, int downloads) throws GameNotFoundException {
        List<Game> game = gameRepository.findByCategoryRatingsDownloads(CategoryName.valueOf(name.toUpperCase()), ratings, downloads);
        if (game.isEmpty()) {
            throw new RequirementNotFoundException("Category,Ratings and Download  not Found");
        }
        return game;
    }
}
