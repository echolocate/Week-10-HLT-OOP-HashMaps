package Wuhan_Game;

import java.util.Scanner;

public class Wuhan {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Character covid = new Character("Covid-19",10,3);
		GameMap wuhan = new GameMap();
	    int totalMoves = 0; 
		wuhan.setX(10);
		wuhan.setY(10);
		
		// set random start position for current x and y
		int x = 1 + (int) (Math.random() * 10);
		int y = 1 + (int) (Math.random() * 10);
		wuhan.setCurrentX(x);
		wuhan.setCurrentY(y);
		
		
		System.out.println("Map size: " + wuhan.getX() + ", " + wuhan.getY());  
		System.out.println("your location: " + wuhan.getCurrentX() + ", " + wuhan.getCurrentY());  

		
		covid.getLives();
		covid.getHealth();
		System.out.println("Hello " + covid.getName());
		
		System.out.println("Choose a path wisely...");
		System.out.println("(N)orth, (S)outh, (E)ast or (W)est.");
		do {
		System.out.println("Direction ?");
		
		String direction = sc.nextLine();
		
		wuhan.move(direction);
		System.out.println("Current location " + wuhan.getCurrentX() + ", " + wuhan.getCurrentY()); 
		
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
