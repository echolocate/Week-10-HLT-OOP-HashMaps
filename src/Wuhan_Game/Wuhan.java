package Wuhan_Game;

import java.util.Scanner;

public class Wuhan {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Virus covid = new Virus("Covid-19", 10, false); // name, health, NO mutation
		LabTech fauci = new LabTech("Dr. Fauci", 10, false); // name, health, NOT vaccinated
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
		wuhan.setLtCurrentX(y); // reverse the coordinates of player start position
		wuhan.setLtCurrentY(x); // to set LabTech start position.

		// set random 1 or 2, is LabTech vaccinated?
		int randVac = 1 + (int) (Math.random() * 2);
		if (randVac == 1) {
			isVaccinated = true;
		} else {
			isVaccinated = false;
		}
		fauci.setVaccinated(isVaccinated);
		// Next line for testing.
		// System.out.println(fauci.getName() + " vaccinated ? " + fauci.isVaccinated());

		// System.out.println("Map size: " + wuhan.getX() + ", " + wuhan.getY());
		System.out.println("Your location: " + wuhan.getCurrentX() + ", " + wuhan.getCurrentY());
		// Remove next line in final version, just for testing game.
		// System.out.println("labtech location: " + wuhan.getLtCurrentX() + ", " + wuhan.getLtCurrentY());

		covid.getHealth();

		System.out.println("Escape From Wuhan");
		System.out.println("Hello " + covid.getName());
		System.out.println("You are a virus. You did not ask to be created.");
		System.out.println("A collaboration between American and Chinese Lab Techs");
		System.out.println("created you from bats or pangolins or whatever.");
		System.out.println("You must escape. You need to find your creator");
		System.out.println("and battle their experimental vaccines.....");
		System.out.println(fauci.getName() + " is lurking around the lab.");
		System.out.println();
		System.out.println("Choose a path wisely...");
		System.out.println("(N)orth, (S)outh, (E)ast or (W)est.");
		do {  // While the virus is still active, 14 moves (days) or virus / Lab Tech is killed
			System.out.print("Direction ?");

			String direction = sc.nextLine();

			wuhan.move(direction);
			System.out.println("Current location " + wuhan.getCurrentX() + ", " + wuhan.getCurrentY());
			// Next line for testing purposes
			System.out.println(fauci.getName() + " is at " + wuhan.getLtCurrentX() + ", " + wuhan.getLtCurrentY());

			// Check for player occupying LabTech position (collision).
			int playerX = wuhan.getCurrentX();
			int playerY = wuhan.getCurrentY();
			int foeX = wuhan.getLtCurrentX();
			int foeY = wuhan.getLtCurrentY();

			// Following 4 lines for testing.
//			System.out.println("Vax = " + fauci.isVaccinated());
//			System.out.println("ltHealth = " + fauci.getHealth());
//			System.out.println("Mutated = " + covid.isMutation());
//			System.out.println("Virus Health = " + covid.getHealth());

			// Have you stummbled upon the Lab Tech (same position on map) ?
			boolean collided = wuhan.collision(playerX, playerY, foeX, foeY);
						
			// When virus and lab tech occupy same coordinates...
			if (collided) {
				System.out.println("You meet your Creator, let the battle commence...");
				// Mutated virus causes lab tech to lose a health point
				// since they only have partial protection. Virus loses mutation.
				if ((fauci.isVaccinated()) && (covid.isMutation())) {
					int ltHealth = fauci.getHealth();
					ltHealth -= 1;
					fauci.setHealth(ltHealth);
					covid.setMutation(false);
					System.out.println("Lab Tech was vaccinated, but you have the mutation.");
					System.out.println("You revert to your non-mutated form.");
					// Or if Lab Tech has no vaccination, same again but more hp lost for Lab Tech
				} else if ((!fauci.isVaccinated()) && (covid.isMutation())) {
					int ltHealth = fauci.getHealth();
					ltHealth -= 2;
					fauci.setHealth(ltHealth);
					System.out.println("Lab Tech didn't follow their own guidelines.");
					System.out.println("Your mutation is particularly virilant to the Lab Tech.");
					// But if Lab Tech is vaccinated with no mutation in the virus
					// Virus is killed, game over.
				} else if ((fauci.isVaccinated()) && (!covid.isMutation())) {
					int vHealth = covid.getHealth();
					vHealth = 0;
					covid.setHealth(vHealth);
					System.out.println("Lab Tech was vaccinated and you are wiped out.");
					// Virus mutates if not vaccinated, since it adapts and evolves.
				} else if ((!fauci.isVaccinated()) && (!covid.isMutation())) {
					covid.setMutation(true);
					System.out.println("Lab Tech wasn't vaccinated, you aquire a mutation.");
					// maybe LabTech loses health too ???
				}
			}
			totalMoves--;
			System.out.println(totalMoves + " infection days remaining... ");

			// Probably clumsy to use totalMoves to 'kill' Virus or Lab Tech,
			// but, hey, I got lazy and it is late and I am tired.
			if (covid.getHealth() <= 0) {
				System.out.println("Covid is eliminated !! You Lose !!!");
				totalMoves = 0;
			} else if (fauci.getHealth() <= 0) {
				System.out.println("Virus has escaped the lab, watch out mankind !!! You Win !!!!");
				totalMoves = 0;
			}

		} while (totalMoves > 0);

		sc.close();
	}

}
