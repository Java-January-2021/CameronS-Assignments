
public class Mammal {
	protected int energyLevel;
	private static int defaultEnergyLevel = 0;
	
	public Mammal(int eLev) {
		this.setEnergyLevel(eLev);
	}
	
	public Mammal() {
		this.energyLevel = defaultEnergyLevel;
	}
	
	public int getEnergyLevel() {
		return energyLevel;
	}

	public void setEnergyLevel(int eLev) {
		this.energyLevel = eLev;
	}

	public int displayEnergy() {
		int eLev = this.getEnergyLevel();
		System.out.println(eLev);
		return eLev;
	}

}