package Wuhan_Game;

import java.util.Scanner;

public class Wuhan {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Virus covid = new Virus("Covid-19",10,false); // name, health, mutation
		LabTech fauci = new LabTech("Dr. Fauci",10,false); // name, health, vaccinated
		GameMap wuhan = new GameMap();
	    int totalMoves = 14; // Each move takes a day, typical quarantine period !
	    boolean isVaccinated;
		wuhan.setX(10); // Map area.
		wuhan.setY(10); // Adjust for larger or smaller map.
		
		// set random start position for current x and y
		int x = 1 + (int) (Math.random() * 10);
		int y = 1 + (int) (Math.random() * 10);
		wuhan.setCurrentX(x);
		wuhan.setCurrentY(y);
		wuhan.setLtCurrentX(y); // experimental, reverse the
		wuhan.setLtCurrentY(x); // coordinates of player start position.
		
		// set random 1 or 2, is LabTech vaccinated?
		int randVac = 1 + (int) (Math.random() * 2);
		if (randVac == 1) {
			isVaccinated = true;
		} else {
			isVaccinated = false;
		}
		
		fauci.setVaccinated(isVaccinated);
		System.out.println(fauci.getName() + " vaccinated ? " + fauci.isVaccinated());
		
		
		
		System.out.println("Map size: " + wuhan.getX() + ", " + wuhan.getY());  
		System.out.println("your location: " + wuhan.getCurrentX() + ", " + wuhan.getCurrentY());  
		// Remove next line in final version, just for testing game.
		System.out.println("labtech location: " + wuhan.getLtCurrentX() + ", " + wuhan.getLtCurrentY());  
	
		covid.getHealth();
		boolean hasCollided = false;
		
		System.out.println("Hello " + covid.getName());
		
		System.out.println("Choose a path wisely...");
		System.out.println(fauci.getName() + " is lurking around the lab.");
		System.out.println("(N)orth, (S)outh, (E)ast or (W)est.");
		do {
		System.out.print("Direction ?" );
		
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
		// TODO: Write a method to deal with what happens in collision
		// Method takes in LabTech health and vaccinated status
		// and Virus health and mutation status.
		// if LabTech vaccinated and virus mutated, LabTech loses 1 health point
		// if LabTech unvaccinated and mutated is true, labtech loses 5 hp
		// if LabTech vaccinated, virus no mutation, end of game (or virus loses 5 hp???)
		// if Labtech unvaccinated, virus no mutation, virus mutation set to true.
		if (collided) {
			wuhan.whoWins(fauci.isVaccinated(), fauci.getHealth(), covid.isMutation(), covid.getHealth());
		}
		// if virus health = 0 from whoWins, totalMoves is set to 0
		System.out.println(fauci.isVaccinated());	
		
		totalMoves --;
		System.out.println(totalMoves + " infection days remaining... ");
		
		} while (totalMoves>0);
		

		
		
		sc.close();
//		System.out.println("Escape From Wuhan");
//		System.out.println("You are a virus. You did not ask to be created.");
//		System.out.println("Some people in the lab made you from bat DNA.");
//		System.out.println("You must escape.");
//		System.out.println();
	}

}
