package br.com.lucas.testRunnerJavaApplication;
	import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

import br.com.lucas.testes.C2enarioGoogleTest;
import br.com.lucas.testes.CenarioGoogleTest;


public class TestRunnerJavaApplication {
	
	public static void main(String[] args) {
			Result result = JUnitCore.runClasses(CenarioGoogleTest.class,C2enarioGoogleTest.class);
			for(Failure failure : result.getFailures()) {
				System.out.println(failure.toString());
			}
			System.out.println("Todos Passaram? " +result.wasSuccessful());
		}
}
