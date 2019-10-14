package br.com.lucas.testes;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

	
	@RunWith(Cucumber.class)
	@CucumberOptions(features = {"features/PesquisaNoGoogle.feature","features/PesquisaNoGoogle2.feature"}, glue = {	//caminho da feature do test
			"" },  plugin = { "pretty" },monochrome = true, dryRun = false)
	public class TesteDataProvider {
//TESTNG		
//		private TestNGCucumberRunner tcr;
//
//	    @BeforeClass(alwaysRun=true)
//	    public void beforeClass() throws Exception{
//	        tcr = new TestNGCucumberRunner(this.getClass());
//	    }
//
//	    @Test(groups="cucumber", description="Runs CucumberFeature", dataProvider="features")
//	    public void feature(CucumberFeatureWrapper cucumberFeature){
//	        tcr.runCucumber(cucumberFeature.getCucumberFeature());
//	    }
//
//	    @DataProvider
//	    public Object[][] features(){
//	        return tcr.provideFeatures();
//	    }
//
//	    @AfterClass (alwaysRun=true)
//	    public void afterClass(){
//	        tcr.finish();
//	    }
	}