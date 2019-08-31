package br.com.lucas.main;

import java.lang.Thread.State;

public class paralela {
	public Thread t;
	
	public Thread getT() {
		return t;
	}
	public State getStatus() {
		return t.getState();
	}
	
	public boolean isAlive() {
		return t.isAlive();
	}
	
	public void stop() {
		if(isAlive()){
			t.stop();
			System.out.println("STOP");
		}
	}
	
	public void paralelo() {
		
		  new Thread() {

			@Override
			public void run() {	
				t = Thread.currentThread();
				teste s = new teste();
				s.StartingHub("4239");
				System.out.println("fim");
			}
		}.start();
	}
}
