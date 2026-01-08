//Personal Testing class for me. Name/Category/Manufacturer/Type/phospherene/collected
public class GearTester {

	public static void main(String[] args) {
		Gear test = new Gear("Hellfire", "Weapon", "SMG", "Maliwan", true, true);
		Gear test1 = new Gear ("Acey May", "Weapon", "Shotgun", "Daedalus", false, false);
		Gear test2 = new Gear ("Avatar", "Class Mod", "Vex", "N/A", true, true);
		Gear test3 = new Gear ("Extra Medium", "Shield", "Energy", "Maliwan",true,false);
		
		System.out.println(test); 
		System.out.println(test1);
		System.out.println(test2);
		System.out.println(test3);
		


	}

}
