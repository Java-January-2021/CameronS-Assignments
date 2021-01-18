
public class Galaxy extends Phone implements Ringable{

	public Galaxy(String versionNumber, int batteryPercentage, String carrier, String ringTone) {
		super(versionNumber, batteryPercentage, carrier, ringTone);
		// TODO Auto-generated constructor stub
	}

	@Override
    public String ring() {
        String ring = "The "+this.getVersionNumber()+" Ringtone: "+this.getRingTone();
		return ring;
    }
    @Override
    public String unlock() {
        String unlock = "The "+this.getVersionNumber()+" Unlocking via code input";
    	return unlock;
    }
    @Override
    public void displayInfo() {
    	System.out.printf("The Galaxy %s from %s\n", this.getVersionNumber(), this.getCarrier());
    	}
}
