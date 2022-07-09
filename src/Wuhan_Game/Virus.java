package Wuhan_Game;

public class Virus extends Character{
	private boolean mutation;
	
	public Virus(String name, boolean mutation, int health) {
		super(name, health);
		this.mutation = mutation;
	}
//	public Virus(String name, boolean mutation) {
//		super(name);
//		this.mutation = mutation;
//	}
}
