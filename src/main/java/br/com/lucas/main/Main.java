package br.com.lucas.main;

import java.io.IOException;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) throws IOException {
		
		paralela p = new paralela();
		String stop="";
		p.paralelo();
		Scanner scanner = new Scanner(System.in);
		do {
			System.out.println("pronto para parar: ");
			stop = scanner.nextLine();
		}while(!stop.equals("stop"));
		p.stop();
		Runtime.getRuntime().exec("taskKill.exe /F /T /PID " + teste.pid);
		System.out.println("state:" + p.getT().getState());
		
		scanner.nextLine();
		
		
//		Runtime.getRuntime().exec("cmd /c start C:\\Users\\lucas.souza\\Desktop\\teste.bat");
//		Runtime.getRuntime().exec("cmd /c start C:\\Users\\lucas.souza\\Desktop\\teste2.bat");
	}

}
