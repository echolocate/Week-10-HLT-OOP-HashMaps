package Wuhan_Game;

public class LabTech extends Character{
	private boolean vaccinated;
	
	public LabTech(String name, int lives, int health, boolean vaccinated) {
		super(name, lives, health);
		this.vaccinated = vaccinated;
	}

	public boolean isVaccinated() {
		return vaccinated;
	}

	public void setVaccinated(boolean vaccinated) {
		this.vaccinated = vaccinated;
	}
	
}
