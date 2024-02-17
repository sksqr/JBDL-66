package com.example.L07LoggingMVCdemo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class L07LoggingMvcDemoApplication {

	private static Logger LOGGER = LoggerFactory.getLogger(L07LoggingMvcDemoApplication.class);

	public static void main(String[] args) {

		LOGGER.trace("trace LOG");
		LOGGER.debug("debug LOG");
		LOGGER.info("Info LOG");
		LOGGER.warn("warn LOG");
		LOGGER.error("error LOG");

		SpringApplication.run(L07LoggingMvcDemoApplication.class, args);

		LOGGER.trace("trace LOG");
		LOGGER.debug("debug LOG");
		LOGGER.info("Info LOG");
		LOGGER.warn("warn LOG");
		LOGGER.error("error LOG");

	}



}
