package br.com.lucas.testRunnerJavaApplication;

import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

import br.com.lucas.testes.TestePesquisaNoGoogle;

public class TestRunnerJavaApplication {

	public static void main(String[] args) {
		Result result = JUnitCore.runClasses(TestePesquisaNoGoogle.class);

		System.out.println("resultado: " + result.getClass().getSimpleName());
		for (Failure failure : result.getFailures()) {
			System.out.println(failure.toString());
		}
		System.out.println("Todos Passaram? " + result.wasSuccessful());
	}
}
