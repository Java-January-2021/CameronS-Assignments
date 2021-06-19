	
public class IPhone extends Phone implements Ringable{

	public IPhone(String versionNumber, int batteryPercentage, String carrier, String ringTone) {
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
        String unlock = "The "+this.getVersionNumber()+" Unlocking via fingerprint scan";
    	return unlock;
    }
    @Override
    public void displayInfo() {
    	System.out.printf("The iPhone %s from %s\n", this.getVersionNumber(), this.getCarrier() );
    }
}
