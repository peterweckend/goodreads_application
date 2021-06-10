package com.peterweckend.dotdashpweckendclient;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DotdashpweckendclientApplication {
	private static final String HOSTNAME = "127.0.0.1";
	private static final String SEARCH_PARAM = "--search";
	private static final String SEARCH_PARAM_ABBR = "-s";
	private static final String SORT_PARAM = "--sort";
	private static final String PAGE_PARAM_ABBR = "-p";
	private static final String HOST_PARAM = "--host";
	private static final String HOST_PARAM_ABBR = "-h";
	private static final String HELP_PARAM = "--help";

	public static void main(String[] args) {
		SpringApplication.run(DotdashpweckendclientApplication.class, args);
	}
}
