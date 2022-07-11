package Wuhan_Game;

public class Virus extends Character {
	private boolean mutation;
	
	public Virus(String name, int health, boolean mutation) {
		super(name, health);
		this.mutation = mutation;
	}

	public boolean isMutation() {
		return mutation;
	}

	public void setMutation(boolean mutation) {
		this.mutation = mutation;
		System.out.println("Mutation is now set to " + mutation);
	}	
	
//	public Virus(String name, boolean mutation) {
//		super(name);
//		this.mutation = mutation;
//	}
}
