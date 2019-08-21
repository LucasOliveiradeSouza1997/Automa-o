package br.com.lucas.testes;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

	
	@RunWith(Cucumber.class)
	@CucumberOptions(features = "features/C2enarioGoogle.feature", glue = {	//caminho da feature do test
			"" }, monochrome = true, dryRun = false)
	public class C2enarioGoogleTest {
	}