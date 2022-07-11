package Wuhan_Game;

public class LabTech extends Character{
	private boolean vaccinated;
	
	public LabTech(String name, int health, boolean vaccinated) {
		super(name, health);
		this.vaccinated = vaccinated;
	}
	
	public boolean isVaccinated() {
		return vaccinated;
	}

	public void setVaccinated(boolean vaccinated) {
		this.vaccinated = vaccinated;
		System.out.println(this.name + " vaccinated = " + vaccinated);
	}
	
}
