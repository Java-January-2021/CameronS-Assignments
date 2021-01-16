
public class ObjectMasterTest {

	public static void main(String[] args) {
		Human wiskeyjack = new Human();
		Human fiddler = new Human();
		wiskeyjack.attack(fiddler);
		fiddler.displayHealth();
	}

}
