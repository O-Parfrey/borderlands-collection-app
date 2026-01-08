//tester class for GearDatabase
public class GearDatabaseTester {
	
	public static void main(String[] args) {//Name/Category/Type/Manufacturer/phospherene/collected
		GearDatabase db = new GearDatabase();
		
		Gear g1 = new Gear("Hellfire", "Weapon", "SMG", "Maliwan", true, true);
		Gear g2 = new Gear("Extra Medium", "Shield", "Energy", "Maliwan",true,false);
		Gear g3 = new Gear("Blockbuster", "Ordinance", "Grenade", "Vladof", true, false);
		
		db.addGear(g1);
		db.addGear(g2);
		db.addGear(g3);
		
		db.displayAllGear();
		
		Gear found = db.findGearByName("Unicorn");
		
		if(found != null) {
			System.out.println("Found it: " + found);
		}else{
			System.out.println("Not found");
		}
		
		boolean removed = db.removeGearByName("Hellfire");
		if(removed) {
			System.out.println("Found " + removed + " and removed it!");
		}else{
			System.out.println("Not found");
		}
		
		db.displayAllGear();
		
		System.out.println("Collected Gear");
		db.displayCollectedGear();
		System.out.println("Phospherene Gear");
		db.displayPhosphereneGear();
		
	}
}
