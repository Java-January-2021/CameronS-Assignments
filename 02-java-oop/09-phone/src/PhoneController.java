
public class PhoneController {

	public static void main(String[] args) {
		Galaxy s9 = new Galaxy("S9", 99, "Verizon", "Ring Ring Ring");
		IPhone x = new IPhone("X", 100, "Apple", "Buzz Buzz Buzz");
		x.displayInfo();
		System.out.println(x.ring());
		System.out.println(x.unlock());
		s9.displayInfo();
		System.out.println(s9.ring());
		System.out.println(s9.unlock());

	}

}
