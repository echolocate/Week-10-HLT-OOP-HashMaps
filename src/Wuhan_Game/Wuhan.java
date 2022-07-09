package Wuhan_Game;

import java.util.Scanner;

public class Wuhan {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Virus covid = new Virus("Covid-19",10,3, false);
		LabTech fauci = new LabTech("Dr. Fauci",10,3,false);
		GameMap wuhan = new GameMap();
	    int totalMoves = 0; 
		wuhan.setX(10); // Map area.
		wuhan.setY(10); // Adjust for preference.
		
		// set random start position for current x and y
		int x = 1 + (int) (Math.random() * 10);
		int y = 1 + (int) (Math.random() * 10);
		wuhan.setCurrentX(x);
		wuhan.setCurrentY(y);
		wuhan.setLtCurrentX(y); // experimental, reverse the
		wuhan.setLtCurrentY(x); // coordinates of player start position.
		
		
		System.out.println("Map size: " + wuhan.getX() + ", " + wuhan.getY());  
		System.out.println("your location: " + wuhan.getCurrentX() + ", " + wuhan.getCurrentY());  
		System.out.println("labtech location: " + wuhan.getLtCurrentX() + ", " + wuhan.getLtCurrentY());  

		
		covid.getLives();
		covid.getHealth();
		boolean hasCollided = false;
		
		System.out.println("Hello " + covid.getName());
		
		System.out.println("Choose a path wisely...");
		System.out.println(fauci.getName() + " is on your ass.");
		System.out.println("(N)orth, (S)outh, (E)ast or (W)est.");
		do {
		System.out.println("Direction ?");
		
		String direction = sc.nextLine();
		
		wuhan.move(direction);
		System.out.println("Current location " + wuhan.getCurrentX() + ", " + wuhan.getCurrentY()); 
		System.out.println(fauci.getName() + " is at " + wuhan.getLtCurrentX() + ", " + wuhan.getLtCurrentY());
		
		// Check for player occupying LabTech position (collision).
		int playerX = wuhan.getCurrentX();
		int playerY = wuhan.getCurrentY();
		int foeX = wuhan.getLtCurrentX();
		int foeY = wuhan.getLtCurrentY();
		
		System.out.println("Collision = " + wuhan.collision(playerX, playerY, foeX, foeY));
		boolean collided = wuhan.collision(playerX, playerY, foeX, foeY);

		System.out.println();	
		
		totalMoves ++;
		
		} while (totalMoves<20);
		

		
		
		sc.close();
//		System.out.println("Escape From Wuhan");
//		System.out.println("You are a virus. You did not ask to be created.");
//		System.out.println("Some people in the lab made you from bat DNA.");
//		System.out.println("You must escape.");
//		System.out.println();
	}

}
