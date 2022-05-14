package com.gamestore.controllers;

import com.gamestore.exceptions.GameNotFoundException;
import com.gamestore.model.Game;
import com.gamestore.service.IGameService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("game-api")
public class GameController {

    IGameService gameService;
    private Logger logger = LoggerFactory.getLogger(CategoryController.class);

    @Autowired
    public void setGameService(IGameService gameService) {
        this.gameService = gameService;
    }

    /**
     * Add a Game into the database
     * @param game
     * @return Game
     */
    @PostMapping("/games")
    public ResponseEntity<Game> addGame(@RequestBody Game game) {

        logger.debug("inside Add Game controller");
        HttpHeaders headers = new HttpHeaders();
        headers.add("desc", "Added new Game");
        Game ngame = gameService.addGame(game);
        logger.info("Category Added");
        return ResponseEntity.status(HttpStatus.CREATED).body(ngame);

    }

    /**
     * update Game in the database
     * @param game
     * @return Game
     */

    @PutMapping("/games")
    public ResponseEntity<Game> updateGame(@RequestBody Game game) {
        logger.debug("Update Game controller");
        HttpHeaders headers = new HttpHeaders();
        headers.add("desc", "update new Game");
        gameService.updateGame(game);
        logger.info("Game Added");
        return ResponseEntity.status(HttpStatus.ACCEPTED).headers(headers).build();
    }

    /**
     * Delete game in the database
     * @param gameId
     * @return
     */

    @DeleteMapping("/games/{gameId}")
    public ResponseEntity<Void> deleteGame(@PathVariable("gameId") int gameId) {
        logger.debug("Delete Game controller");
        HttpHeaders headers = new HttpHeaders();
        headers.add("desc", "deleted new Game");
        gameService.deleteGame(gameId);
        logger.info("Game Deleted");
        return ResponseEntity.status(HttpStatus.ACCEPTED).headers(headers).build();
    }

    /**
     * Find game By Id
     * @param gameId
     * @return Game
     * @throws GameNotFoundException
     */
    @GetMapping("/games/id/{gameId}")
    public ResponseEntity<Game> getById(@PathVariable("gameId") int gameId) throws GameNotFoundException {
        logger.debug("Get game by id controller");
        HttpHeaders headers = new HttpHeaders();
        headers.add("desc", "Got Game By Id");
        Game game = gameService.getById(gameId);
        logger.info("Got Game");
        return ResponseEntity.ok().headers(headers).body(game);
    }

    /**
     * Find all Game
     * @return game
     */
    @GetMapping("/games")
    public ResponseEntity<List<Game>> getAll() {
        logger.debug("Get All game controller");
        HttpHeaders headers = new HttpHeaders();
        headers.add("desc", "Getting All Game");
        headers.add("info", "Game details");
        List<Game> games = gameService.getAll();
        logger.info("Got All Game");
        ResponseEntity<List<Game>> gameResponse = new ResponseEntity<>(games, headers, HttpStatus.OK);
        return gameResponse;
    }

    /**
     * Find By Game Name
     * @param gameName
     * @return Game
     */
    @GetMapping("/games/gamename/{game}")
    public ResponseEntity<List<Game>> getByGame(@PathVariable("game") String gameName) {
        logger.debug("Get game by name  controller");
        HttpHeaders headers = new HttpHeaders();
        headers.add("desc", "Getting Game");
        List<Game> games = gameService.getByGame(gameName);
        logger.info("Got Game by name");
        return ResponseEntity.ok().headers(headers).body(games);
    }

    /**
     * Find by game downloads
     * @param downloads
     * @return Game
     */

    @GetMapping("/games/downloads/{downloads}")
    public ResponseEntity<List<Game>> getByDownloads(@PathVariable("downloads") int downloads) {
        logger.debug("Get game by downloads  controller");
        HttpHeaders headers = new HttpHeaders();
        headers.add("desc", "Getting Downloads");
        List<Game> game = gameService.getByDownloads(downloads);
        logger.info("Got Game by downloads");
        return ResponseEntity.ok().headers(headers).body(game);
    }

    /**
     * Find by Game Rating
     * @param ratings
     * @return Game
     */
    @GetMapping("/games/rating/{rating}")
    public ResponseEntity<List<Game>> getByRatings(@PathVariable("rating") double ratings) {
        logger.debug("Get game by rating  controller");
        HttpHeaders headers = new HttpHeaders();
        headers.add("desc", "Getting rating");
        List<Game> games = gameService.getByRatings(ratings);
        logger.info("Got Game by rating");
        return ResponseEntity.ok().headers(headers).body(games);
    }

    /**
     * Find by Game size
     * @param size
     * @return Game
     */

    @GetMapping("/games/size/{size}")
    public ResponseEntity<List<Game>> getBySize(@PathVariable("size") String size) {
        logger.debug("Get game by size  controller");
        HttpHeaders headers = new HttpHeaders();
        headers.add("desc", "Getting Size");
        List<Game> games = gameService.getBySize(size);
        logger.info("Got Game by size");
        return ResponseEntity.ok().headers(headers).body(games);
    }

    /**
     * Find by Game Publisher Name
     * @param publisherName
     * @return Game
     */
    @GetMapping("/games/publisherName/{publisherName}")
    public ResponseEntity<List<Game>> getByPublisherName(@PathVariable("publisherName") String publisherName) {
        logger.debug("Get game by publisher name controller");
        HttpHeaders headers = new HttpHeaders();
        headers.add("desc", "Getting PublisherName");
        List<Game> games = gameService.getByPublisherName(publisherName);
        logger.info("Got Game by publisher name");
        return ResponseEntity.ok().headers(headers).body(games);
    }

    /**
     * Find by Game Publisher Country
     * @param country
     * @return Game
     */
    @GetMapping("/games/country/{country}")
    public ResponseEntity<List<Game>> getByPublisherCountry(@PathVariable("country") String country) {
        logger.debug("Get game by publisher country controller");
        HttpHeaders headers = new HttpHeaders();
        headers.add("desc", "Getting PublisherCountry");
        List<Game> games = gameService.getByPublisherCountry(country);
        logger.info("Got Game by publisher country");
        return ResponseEntity.ok().headers(headers).body(games);
    }

    /**
     * Find by Game Category name
     * @param categoryName
     * @return Game
     */
    @GetMapping("/games/category/{category}")
    public ResponseEntity<List<Game>> getByCategoryName(@PathVariable("category") String categoryName) {
        logger.debug("Get game by category name controller");
        HttpHeaders headers = new HttpHeaders();
        headers.add("desc", "Getting CategoryName");
        List<Game> games = gameService.getByCategoryName(categoryName);
        logger.info("Got Game by category name");
        return ResponseEntity.ok().headers(headers).body(games);
    }

    /**
     * Find by Game required RAM
     * @param RAM
     * @return Game
     */
    @GetMapping("/games/RAM/{RAM}")
    public ResponseEntity<List<Game>> getByRequiredRAM(@PathVariable("RAM") String RAM) {
        logger.debug("Get game by required RAM controller");
        HttpHeaders headers = new HttpHeaders();
        headers.add("desc", "Getting RAM");
        List<Game> games = gameService.getByRequiredRAM(RAM);
        logger.info("Got Game by required RAM");
        return ResponseEntity.ok().headers(headers).body(games);
    }

    /**
     * Find by Game Required storage
     * @param storage
     * @return Game
     */
    @GetMapping("/games/storage/{storage}")
    public ResponseEntity<List<Game>> getByRequiredStorage(@PathVariable("storage") String storage) {
        logger.debug("Get game by required storage controller");
        HttpHeaders headers = new HttpHeaders();
        headers.add("desc", "Getting Storage");
        List<Game> games = gameService.getByRequiredStorage(storage);
        logger.info("Got Game by required storage");
        return ResponseEntity.ok().headers(headers).body(games);
    }

    /**
     * Find by Game name and Game ratings
     * @param gameName
     * @param ratings
     * @return Game
     */

    @GetMapping("/games/game/{game}/rating/{rating}")
    public ResponseEntity<List<Game>> getByGameAndRatings(@PathVariable("game") String gameName, @PathVariable("rating") String ratings) {
        logger.debug("Get game by game and rating controller");
        HttpHeaders headers = new HttpHeaders();
        headers.add("desc", "Getting Game And Ratings");
        List<Game> games = gameService.getByGameAndRatings(gameName, ratings);
        logger.info("Got Game by game and rating");
        return ResponseEntity.ok().headers(headers).body(games);
    }

    /**
     * Find by Game name and Game downloads
     * @param gameName
     * @param downloads
     * @return Game
     */

    @GetMapping("/games/game/{game}/downloads/{downloads}")
    public ResponseEntity<List<Game>> getByGameAndDownloads(@PathVariable("game") String gameName, @PathVariable("downloads") int downloads) {
        logger.debug("Get game by game and downloads controller");
        HttpHeaders headers = new HttpHeaders();
        headers.add("desc", "Getting Game And Downloads");
        List<Game> games = gameService.getByGameAndDownloads(gameName, downloads);
        logger.info("Got Game by game and downloads");
        return ResponseEntity.ok().headers(headers).body(games);
    }

    /**
     * Find by Game name and Game Publisher
     * @param gameName
     * @param publisherName
     * @return Game
     */

    @GetMapping("/games/game/{game}/publisher/{publisher}")
    public ResponseEntity<List<Game>> getByGameAndPublisher(@PathVariable("game") String gameName, @PathVariable("publisher") String publisherName) {
        logger.debug("Get game by game and Publisher controller");
        HttpHeaders headers = new HttpHeaders();
        headers.add("desc", "Getting Game And Publisher");
        List<Game> games = gameService.getByGameAndPublisher(gameName, publisherName);
        logger.info("Got Game by game and publisher");
        return ResponseEntity.ok().headers(headers).body(games);
    }

    /**
     * Find by Game name and Game size
     * @param gameName
     * @param size
     * @return Game
     */

    @GetMapping("/games/game/{game}/size/{size}")
    public ResponseEntity<List<Game>> getByGameAndSize(@PathVariable("game") String gameName, @PathVariable("size") String size) {
        logger.debug("Get game by game and size controller");
        HttpHeaders headers = new HttpHeaders();
        headers.add("desc", "Getting Game And Size");
        List<Game> games = gameService.getByGameAndSize(gameName, size);
        logger.info("Got Game by game and size");
        return ResponseEntity.ok().headers(headers).body(games);
    }

    /**
     * Find by Game name and Game Category
     * @param gameName
     * @param name
     * @return Game
     */
    @GetMapping("/games/game/{game}/category/{category}")
    public ResponseEntity<List<Game>> getByGameAndCategory(@PathVariable("game") String gameName, @PathVariable("category") String name) {
        logger.debug("Get game by game and category controller");
        HttpHeaders headers = new HttpHeaders();
        headers.add("desc", "Getting Game And Category");
        List<Game> games = gameService.getByGameAndCategory(gameName, name);
        logger.info("Got Game by game and category");
        return ResponseEntity.ok().headers(headers).body(games);
    }

    /**
     * Find By Game downloads and Game category
     * @param downloads
     * @param name
     * @return Game
     */

    @GetMapping("/games/downloads/{downloads}/category/{category}")
    public ResponseEntity<List<Game>> getByDownloadsAndCategory(@PathVariable("downloads") int downloads, @PathVariable("category") String name) {
        logger.debug("Get game by download and category controller");
        HttpHeaders headers = new HttpHeaders();
        headers.add("desc", "Getting Downloads And Category");
        List<Game> games = gameService.getByDownloadsAndCategory(downloads, name);
        logger.info("Got Game by download and category");
        return ResponseEntity.ok().headers(headers).body(games);
    }

    /**
     * Find by Game Category and Game Ratings
     * @param name
     * @param ratings
     * @return Game
     */
    @GetMapping("/games/category/{category}/rating/{rating}")
    public ResponseEntity<List<Game>> getByCategoryAndRatings(@PathVariable("category") String name, @PathVariable("rating") double ratings) {
        logger.debug("Get game by category and ratings controller");
        HttpHeaders headers = new HttpHeaders();
        headers.add("desc", "Getting Category And Ratings");
        List<Game> games = gameService.getByCategoryAndRatings(name, ratings);
        logger.info("Got Game by category and ratings");
        return ResponseEntity.ok().headers(headers).body(games);
    }

    /**
     * Find by Game Category and Game storage
     * @param name
     * @param storage
     * @return Game
     */

    @GetMapping("/games/category/{category}/storage/{storage}")
    public ResponseEntity<List<Game>> getByCategoryAndStorage(@PathVariable("category") String name, @PathVariable("storage") String storage) {
        logger.debug("Get game by category and storage controller");
        HttpHeaders headers = new HttpHeaders();
        headers.add("desc", "Getting Category And Storage");
        List<Game> games = gameService.getByCategoryAndStorage(name, storage);
        logger.info("Got Game by category and storage");
        return ResponseEntity.ok().headers(headers).body(games);
    }

    /**
     * Find by Game Category and Publisher
     * @param name
     * @param publisherName
     * @return Game
     */

    @GetMapping("/games/category/{category}/publisher/{publisher}")
    public ResponseEntity<List<Game>> getByCategoryPublisher(@PathVariable("category") String name, @PathVariable("publisher") String publisherName) {
        logger.debug("Get game by category and publisher controller");
        HttpHeaders headers = new HttpHeaders();
        headers.add("desc", "Getting Category And Publisher");
        List<Game> games = gameService.getByCategoryPublisher(name, publisherName);
        logger.info("Got Game by category and publisher");
        return ResponseEntity.ok().headers(headers).body(games);
    }

    /**
     * Find by GAme category,rating and size
     * @param name
     * @param ratings
     * @param size
     * @return Game
     */
    @GetMapping("/games/category/{category}/rating/{rating}/size/{size}")
    public ResponseEntity<List<Game>> getByCategoryRatingSize(@PathVariable("category") String name, @PathVariable("rating") double ratings, @PathVariable("size") String size) {
        logger.debug("Get game by category, rating and size controller");
        HttpHeaders headers = new HttpHeaders();
        headers.add("desc", "Getting Category,Rating And Size");
        List<Game> games = gameService.getByCategoryRatingSize(name, ratings, size);
        logger.info("Got Game by category, rating and size");
        return ResponseEntity.ok().headers(headers).body(games);
    }

    /**
     * Find by Game category,ratingd and download
     * @param name
     * @param ratings
     * @param downloads
     * @return Game
     */
    @GetMapping("/games/category/{category}/rating/{rating}/download/{download}")
    public ResponseEntity<List<Game>> getByCategoryRatingsDownloads(@PathVariable("category") String name, @PathVariable("rating") double ratings, @PathVariable("download") int downloads) {
        logger.debug("Get game by category, rating and downloads controller");
        HttpHeaders headers = new HttpHeaders();
        headers.add("desc", "Getting Category,Rating And Downloads");
        List<Game> games = gameService.getByCategoryRatingsDownloads(name, ratings, downloads);
        logger.info("Got Game by category, rating and downloads");
        return ResponseEntity.ok().headers(headers).body(games);
    }

}
