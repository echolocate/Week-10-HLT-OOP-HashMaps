package Wuhan_Game;

public class GameMap {
	private String facility;
	private int x;
	private int y;
	private int currentX;
	private int currentY;

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
	
	// Method to move character. If character hits the boundary, wrap around to
	// other side, like PacMan (2d representation of 3d sphere, walk far enough 
	// S or W, appear at other side as if you had travelled invisibly 'behind' map.
	public void move(String direction) {
		System.out.println("this.currentX " + this.currentX + " this.x " + this.x);
		if (direction.equals("N")) {
			if (this.currentX == this.x) {
				this.currentX = 0;
			} else {
				this.currentX = this.currentX + 1;
			}
		} else if (direction.equals("S")) {
			System.out.println("this.currentX " + this.currentX + " this.x " + this.x);
			if (this.currentX == 0) {
				this.currentX = 10;
			} else {
				this.currentX = this.currentX - 1;
			}
		} else if (direction.equals("E")) {
			System.out.println("this.currentY " + this.currentY + " this.y " + this.y);
			if (this.currentY == this.y) {
				this.currentY = 0;
			} else {
				this.currentY = this.currentY + 1;
			}
		}  else if (direction.equals("W")) {
			System.out.println("this.currentY " + this.currentY + " this.y " + this.y);
			if (this.currentY == 0) {
				this.currentY = 10;
			} else {
				this.currentY = this.currentY - 1;
			}
	}
	}

}
