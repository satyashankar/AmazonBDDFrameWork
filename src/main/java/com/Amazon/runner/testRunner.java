package com.Amazon.runner;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(
		features = "C:\\Users\\SandeepGoud\\eclipse-workspace\\AmazonBDDFrameWork\\src\\main\\java\\com\\Amazon\\Features\\amazon.features", //the path of the feature files
		glue={"com\\Amazon\\stepDefinations"}, // path of sstepdefinition file
		format= {"pretty","html:test-outout","json:json_output/cucumber.json"}, 
		monochrome = true,	////display the console output in a proper readable format
		dryRun = false //to check the mapping is proper between feature file and step def file
			
		)
 



public class testRunner {

}
