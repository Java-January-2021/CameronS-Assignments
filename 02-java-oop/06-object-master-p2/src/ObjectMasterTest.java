
public class ObjectMasterTest {

	public static void main(String[] args) {
		Ninja kalem = new Ninja();
		Wizard quickBen = new Wizard();
		Wizard tattersail = new Wizard();
		Samurai fiddler = new Samurai();
		Ninja cotillion = new Ninja();
		Samurai stormy = new Samurai();
		Samurai gesler = new Samurai();
		Samurai kindly = new Samurai();
		Wizard icarium = new Wizard();
		Ninja sorry = new Ninja();
		kindly.deathBlow(kalem);
		//kindly.displayStats();
		//kalem.displayStats();
		kalem.steal(stormy);
		kalem.steal(stormy);
		kalem.steal(stormy);
		//kalem.displayStats();
		//stormy.displayStats();
		quickBen.fireball(fiddler);
		tattersail.fireball(gesler);
		tattersail.fireball(gesler);
		tattersail.fireball(gesler);
		//gesler.displayStats();
		gesler.meditate();
		//gesler.displayStats();
		sorry.attack(icarium);
		sorry.attack(icarium);
		kindly.deathBlow(cotillion);
		//gesler.displayStats();
		//cotillion.displayStats();
		icarium.heal(cotillion);
		//cotillion.displayStats();
		//icarium.displayStats();
		//fiddler.displayStats();
	}

}
