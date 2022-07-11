package Wuhan_Game;

public class GameMap {
	private int x;
	private int y;
	private int currentX;
	private int currentY;
	private int ltCurrentX; // LabTech position X and Y, reversed
	private int ltCurrentY; // in relation to Virus position
	
	// Virus position Getters and Setters (players character)
	public int getCurrentX() {
		return currentX;
	}

	public void setCurrentX(int currentX) {
			this.currentX = currentX;
		}

	public int getCurrentY() {
		return currentY;
	}

	public void setCurrentY(int currentY) {
			this.currentY = currentY;
		}
	
	// Getters and Setters for LabTech position (enemy character).
	public int getLtCurrentX() {
		return ltCurrentX;
	}

	public void setLtCurrentX(int ltCurrentX) {
		this.ltCurrentX = ltCurrentX;
	}

	public int getLtCurrentY() {
		return ltCurrentY;
	}

	public void setLtCurrentY(int ltCurrentY) {
		this.ltCurrentY = ltCurrentY;
	}

	// Game Map Getters and Setters, defines map area boundaries
	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}


	
	// Method to move character. If character hits the boundary, wrap around to
	// other side, like PacMan (2d representation of 3d sphere, walk far enough 
	// S or W, appear at other side as if you had travelled invisibly 'behind' map.
	public void move(String direction) {
		//System.out.println("this.currentX " + this.currentX + " this.x " + this.x);
		if (direction.equals("N")) {
			if (this.currentX == this.x) {
				this.currentX = 0;
			} else {
				this.currentX = this.currentX + 1;
			}
		} else if (direction.equals("S")) {
			// System.out.println("this.currentX " + this.currentX + " this.x " + this.x);
			if (this.currentX == 0) {
				this.currentX = 10;
			} else {
				this.currentX = this.currentX - 1;
			}
		} else if (direction.equals("E")) {
			// System.out.println("this.currentY " + this.currentY + " this.y " + this.y);
			if (this.currentY == this.y) {
				this.currentY = 0;
			} else {
				this.currentY = this.currentY + 1;
			}
		}  else if (direction.equals("W")) {
			// System.out.println("this.currentY " + this.currentY + " this.y " + this.y);
			if (this.currentY == 0) {
				this.currentY = 10;
			} else {
				this.currentY = this.currentY - 1;
			}
		}
	}
	
	public boolean collision(int plX, int plY, int ltX, int ltY) {
		if ((plX == ltX) && (plY == ltY)) {
			boolean hasCollided = true;
			return hasCollided;
		} else {
			boolean hascollided = false;
			return hascollided;
		}
	}
		
//	public int whoWins(boolean vax, int ltHealth, boolean mutant, int vHealth) {
//		if ((vax = true) && (mutant = true)) {
//			ltHealth -= 1;
//		} else if ((vax = false) && (mutant = true)) {
//			ltHealth -= 5;
//		} else if ((vax = true) && (mutant = false)) {
//			vHealth = 0;
//		} else if ((vax = false) && (mutant = false)) {
//			mutant = true;
//			// maybe LabTech loses health too ???
//		}
//		return vHealth;
//	}	
}
