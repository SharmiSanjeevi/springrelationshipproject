package com.gamestore;

import com.gamestore.model.*;
import com.gamestore.service.ICategoryService;
import com.gamestore.service.IGameService;
import com.gamestore.service.IPublisherService;
import com.gamestore.service.IRequirementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

@SpringBootApplication
public class SpringGamestoreRestapiApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(SpringGamestoreRestapiApplication.class, args);
	}

	@Autowired
	IGameService gameService;
	@Autowired
	ICategoryService categoryService;
	@Autowired
	IPublisherService publisherService;
	@Autowired
	IRequirementService requirementService;

	@Override
	public void run(String... args) throws Exception {

//		Requirement requirement = new Requirement();
//		requirement.setRequiredRAM("1GB");
//		requirement.setRequiredStorage("500MB");
//
//		Category category = new Category();
//		category.setName(CategoryName.ONLINE);
//		Category savedCategory1 = categoryService.addCategory(category);
//
//		Category category2 = new Category();
//		category2.setName(CategoryName.PUZZLE);
//		Category savedCategory2 = categoryService.addCategory(category2);
//
//		Set<Category> categories = new HashSet<>(Arrays.asList(savedCategory1, savedCategory2));
//
//
//		Game game = new Game();
//		game.setName("Candy Crush");
//		game.setDownloads(10000);
//		game.setRating(4.5);
//		game.setSize("78MB");
//		game.setRequirement(requirement);
//		game.setCategories(categories);
//
//		Set<Game> games = new HashSet<>(Arrays.asList(game));
//
//		Publisher publisher = new Publisher();
//		publisher.setPublisherName("2K Games");
//		publisher.setCountry("USA");
//		publisher.setGames(games);
//
//		publisherService.addPublisher(publisher);
//
//		Requirement requirement = new Requirement();
//		requirement.setRequiredStorage("300MB");
//		requirement.setRequiredRAM("1GB");
//
//		Publisher publisher = publisherService.getById(1);
//
//		Category category = new Category();
//		category.setName(CategoryName.BOARD);
//		Category savedCategory = categoryService.addCategory(category);
//
//		Category category1 = new Category();
//		category1.setName(CategoryName.OFFLINE);
//		Category savedCategory2 = categoryService.addCategory(category1);
//
//
//		Set<Category> categories = new HashSet<>(Arrays.asList(savedCategory, savedCategory2));
//
//		Game game = new Game();
//		game.setName("Ludo star");
//		game.setSize("77MB");
//		game.setDownloads(20000);
//		game.setRating(4.3);
//		game.setCategories(categories);
//		game.setRequirement(requirement);
//		game.setPublisher(publisher);
//
//		gameService.addGame(game);
//
//



	}
}
