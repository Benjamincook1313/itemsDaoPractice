package com.benji.practice;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ShoppinglistApplication implements CommandLineRunner {

	Logger LOGGER = LoggerFactory.getLogger(this.getClass());

	@Autowired
	ItemDao itemDao;

	public static void main(String[] args) {
		SpringApplication.run(ShoppinglistApplication.class, args);
	}


	@Override
	public void run(String... args) throws Exception {
		LOGGER.info("Items from db: {}", itemDao.getAllItems());
		LOGGER.info("Item with id 2 -> {}", itemDao.getItemById(2));
		LOGGER.info("Adding blueberries to db. number of rows inserted: {}",
				itemDao.insert(new Item("Blueberries", 3.99, 2, "Wild Alaskan")));
		LOGGER.info("Number of items is: {}", itemDao.getAllItems().size());
	}

}
