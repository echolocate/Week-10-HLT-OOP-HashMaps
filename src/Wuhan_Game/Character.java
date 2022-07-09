package Wuhan_Game;

public abstract class Character {	
		private String name;
		private int health;
		
		//Custom Constructor Method
		public Character(String name,int health) {
			this.name = name;
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

		
		public void status() {			
			System.out.println(this.name + " has " + this.health + "health points");
		}

}
