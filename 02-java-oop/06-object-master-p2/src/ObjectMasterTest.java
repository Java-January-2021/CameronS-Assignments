
public class ObjectMasterTest {

	public static void main(String[] args) {
		Ninja kalem = new Ninja("kalem");
		Wizard quickBen = new Wizard("quickBen");
		Wizard tattersail = new Wizard("tattersail");
		Samurai fiddler = new Samurai("fiddler");
		Ninja cotillion = new Ninja("cotillion");
		Samurai stormy = new Samurai("stormy");
		Samurai gesler = new Samurai("gesler");
		Samurai kindly = new Samurai("kindly");
		Samurai hedge = new Samurai("hedge");
		Wizard icarium = new Wizard("icarium");
		Ninja sorry = new Ninja("sorry");
		kindly.deathBlow(kalem);
		kindly.displayStats();
		kalem.displayStats();
		kalem.steal(stormy);
		kalem.steal(stormy);
		kalem.steal(stormy);
		kalem.avoid();
		kalem.displayStats();
		stormy.displayStats();
		quickBen.fireball(fiddler);
		tattersail.fireball(gesler);
		tattersail.fireball(gesler);
		tattersail.fireball(gesler);
		gesler.displayStats();
		gesler.meditate();
		gesler.displayStats();
		sorry.attack(icarium);
		sorry.attack(icarium);
		kindly.deathBlow(cotillion);
		gesler.displayStats();
		cotillion.displayStats();
		icarium.heal(cotillion);
		hedge.deathBlow(sorry);
		sorry.displayStats();
		tattersail.heal(sorry);
		tattersail.heal(sorry);
		tattersail.heal(sorry);
		tattersail.heal(sorry);
		sorry.displayStats();
		tattersail.displayStats();
		cotillion.displayStats();
		icarium.displayStats();
		fiddler.displayStats();
		Samurai.howMany();
		Ninja.howMany();
		Wizard.howMany();
		
	}

}
