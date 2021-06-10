package com.peterweckend.dotdashpweckendclient;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

@SpringBootApplication
public class DotdashpweckendclientApplication implements ApplicationRunner {
	private static final String HOSTNAME = "127.0.0.1";
	private static final String SEARCH_PARAM = "--search";
	private static final String SEARCH_PARAM_ABBR = "-s";
	private static final String SORT_PARAM = "--sort";
	private static final String PAGE_PARAM_ABBR = "-p";
	private static final String HOST_PARAM = "--host";
	private static final String HOST_PARAM_ABBR = "-h";
	private static final String HELP_PARAM = "--help";

	private static final Logger logger = LoggerFactory.getLogger(DotdashpweckendclientApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(DotdashpweckendclientApplication.class, args);
	}

	@Override
	public void run(ApplicationArguments args) throws Exception {
//		logger.info("Application started with command-line arguments: {}", Arrays.toString(args.getSourceArgs()));
//		logger.info("NonOptionArgs: {}", args.getNonOptionArgs());
//		logger.info("OptionNames: {}", args.getOptionNames());
//
//		for (String name : args.getOptionNames()){
//			logger.info("arg-" + name + "=" + args.getOptionValues(name));
//		}
//
//		boolean containsOption = args.containsOption("person.name");
//		logger.info("Contains person.name: " + containsOption);

//		Map<String, String> argumentMap = new HashMap<>();
//		for (String argument: arguments) {
//			// assuming none of the input has "=" inside
//			String[] splitArg = argument.split("=");
//			argumentMap.put(splitArg[0], splitArg[1]);
//		}
//
//		if (argumentMap.containsKey(HELP_PARAM)) {
//			logger.info("User requested help");
//			System.exit(0);
//		}
//
//		var hostname = HOSTNAME;
//		var searchBooksRequestModel = new SearchBooksRequestModel();
//		Iterator<Map.Entry<String, String>> iterator = argumentMap.entrySet().iterator();
//		while (iterator.hasNext()) {
//			var pair = iterator.next();
//			switch(pair.getKey()) {
//				case SEARCH_PARAM:
//				case SEARCH_PARAM_ABBR:
//					searchBooksRequestModel.setSearchTerms(pair.getValue());
//					break;
//				case SORT_PARAM:
//					searchBooksRequestModel.setSort(pair.getValue());
//				case PAGE_PARAM_ABBR:
//					searchBooksRequestModel.setPageNumber(Integer.parseInt(pair.getValue()));
//				case HOST_PARAM:
//				case HOST_PARAM_ABBR:
//					hostname = pair.getValue();
//			}
//			iterator.remove(); // avoids a ConcurrentModificationException
//		}
	}

}
