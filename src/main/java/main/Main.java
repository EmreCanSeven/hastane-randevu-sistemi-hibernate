package main;

import java.awt.EventQueue;

import arayuz.ArayuzLogin;

public class Main {
	
	public static void main(String[] args) {
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ArayuzLogin theWindow = new ArayuzLogin();
					theWindow.getFrame().setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		
	}

}


