package br.com.lucas.main;

import java.io.BufferedReader;
import java.io.InputStreamReader;

//netstat -a -n -o | findstr :7777
//taskKill.exe /F /PID 6676
public class teste {
	static final Runtime run = Runtime.getRuntime();
	static BufferedReader read;
	static String pid ;

	public void StartingHub(String port) {
		String caminhoSeleniumServer = "cd C:\\DEV\\Lucas\\Framework_Automacao\\drivers";
		String comandoStartHubComPorta = "java -jar selenium-server-standalone-3.141.59.jar -role hub -port ".concat(port);
		String[] cmds = {caminhoSeleniumServer,comandoStartHubComPorta};
		
		try {

			ProcessBuilder builder = new ProcessBuilder("cmd", "/c", String.join("& ", cmds));

			builder.redirectErrorStream(true);

			Process p = builder.start();
			

			String processName = java.lang.management.ManagementFactory.getRuntimeMXBean().getName();
			System.out.println(processName);
			pid = processName.split("@")[0];
			

			read = new BufferedReader(new InputStreamReader(p.getInputStream()));
			String line ="";

			while (true) {
				int c = -1;
				if(read.ready()){
					 c = read.read();
				}
				if(c != -1) {
					System.out.print((char)c);
				} else if (line.contains("is busy, please choose a free port for the hub")) {
					System.out.println("Porta ocupada");
				}
			}
		} catch (Exception e) {
			System.err.println(e);
		}
	}
}