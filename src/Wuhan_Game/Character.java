package Wuhan_Game;

public class Character {	
		private String name;
		private int lives;
		private int health;
		
		//Custom Constructor Method
		public Character(String name, int lives, int health) {
			this.name = name;
			this.lives = lives;
			this.health = health;
		}
		
		public String getName() {
			return this.name;
		}
		
		public void setName(String name) {
			this.name = name;
		}
		
		public int getHealth() {
			return this.health;
		}
		public void setHealth(int health) {
			this.health = health;
		}

		public int getLives() {
			return lives;
		}
		public void setLives(int lives) {
			this.lives = lives;
		}
		
		
		public void status() {
			System.out.println(this.name + " has " + this.lives + " number of lives");
			System.out.println(this.name + " has " + this.health + "hp");
		}

}
