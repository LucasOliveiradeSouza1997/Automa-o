package br.com.lucas.main;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

//netstat -a -n -o | findstr :7777
//taskKill.exe /F /PID 6676
public class teste2 {
	static final Runtime run = Runtime.getRuntime();
	static Process pro;
	static BufferedReader read;

	public static void main(String[] args) {
		String[] cmds = { "cd C:\\DEV\\Lucas\\Framework_Automacao\\drivers",
				"java -jar selenium-server-standalone-3.141.59.jar -role hub -port 4437", "exit" };

		try {

			ProcessBuilder builder = new ProcessBuilder("cmd", "/c", String.join("& ", cmds));

			builder.redirectErrorStream(true);

			Process p = builder.start();

			String processName = java.lang.management.ManagementFactory.getRuntimeMXBean().getName();
			System.out.println(processName);

			BufferedReader r = new BufferedReader(new InputStreamReader(p.getInputStream()));
			String line;

			while (true) {
				line = r.readLine();
				if (line == null) {
					break;
				} else if (line.contains("is busy, please choose a free port for the hub")) {
					System.out.println("Porta ocupada");
				}
				System.out.println(line);
			}
		} catch (Exception e) {
			System.err.println(e);
		}
	}
}