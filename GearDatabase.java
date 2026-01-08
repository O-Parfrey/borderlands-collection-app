/**
 * Manages the collection of all Gear objects in the Borderlands Collector App.
 * 
 * This class acts as an in-memory database, storing gear in an ArrayList
 * and providing methods to add, search, display, and update gear data.
 * 
 * It contains logic for marking gear as collected or phospherene and
 * filtering gear by category and type.
 * 
 * This class separates data management from user interface logic.
 * 
 * @author Orion
 */
import java.util.ArrayList;

public class GearDatabase { 

	private ArrayList<Gear> gearList = new ArrayList<>();
	
	public GearDatabase() {
		this.gearList = new ArrayList<>();
	} 
	
	public void displayAllGear() {
		for(Gear g : gearList) {
			System.out.println(g);
		}
	}
	
	public void displayAllByCategory(String category) {
		boolean foundSomething = false;
		
		for(Gear g : gearList) {
			if(g.getCategory().equalsIgnoreCase(category)) {
				foundSomething = true;
				System.out.println(g);
			}
		}
		if(!foundSomething) {
			System.out.println("No gear found for category: " + category);
			
		}
	}
	
	public void displayCollectedGear() {
		for (Gear g : gearList) {
			if(g.isCollected() == true) {
				System.out.println(g);
			}
		}
	}
	
	public void displayGearByTypeAndCategory(String category, String type ) {
		boolean foundSomething = false;
		
		for( Gear g : gearList) {
			if((g.getType().equalsIgnoreCase(type) && g.getCategory().equalsIgnoreCase(category))) {
				foundSomething = true;
				System.out.println(g);
			}
		}
		if(!foundSomething) {
			System.out.println("No gear found");
		}
	}

	public void displayPhosphereneGear() {
		for (Gear g : gearList) {
			if(g.isPhospherene() == true) {
				System.out.println(g);
				
			}
		}
	}
	
	public Gear findGearByName(String name) {
		
		for(Gear g : gearList) {
			if(g.getName().equalsIgnoreCase(name)) {
				return g;
			}
		}
		return null;
	}
	
	public boolean removeGearByName(String name) {
		for (int i = 0; i<gearList.size(); i++) {
			if(gearList.get(i).getName().equalsIgnoreCase(name)) {
				gearList.remove(i);
				return true;
			}
		}
		return false;
	}
	
	/**
	 * Adds a new Gear object to the database.
	 *
	 * @param g the Gear object to add
	 */
	public void addGear(Gear g) {
		gearList.add(g);
	}
	
	/**
	 * Returns a list of all gear stored in the database.
	 *
	 * @return an ArrayList containing all Gear objects
	 */
	public ArrayList<Gear> getAllGear() {
		return gearList;
	}

	/**
	 * Marks the specified gear as collected.
	 *
	 * @param name the name of the gear to mark
	 * @return true if the gear was found and updated, false otherwise
	 */
	public boolean markCollected(String name) {
		for(Gear g : gearList) {
			if(g.getName().equalsIgnoreCase(name)) {
				g.setCollected(true);
				return true;
			}
		}
		return false;
	}
	
	public boolean unmarkCollected(String name) {
		for(Gear g : gearList) {
			if(g.getName().equalsIgnoreCase(name)) {
				g.setCollected(false);
				return true;
			}
		}
		return false;
	}
	
	/**
	 * Marks the specified weapon as phospherene.
	 *
	 * @param name the name of the weapon
	 * @return true if the weapon was found and updated, false otherwise
	 */
	public boolean markPhospherene(String name) {
		for(Gear g : gearList) {
			if(g.getName().equalsIgnoreCase(name) && g.getCategory().equalsIgnoreCase("Weapon")) {
				g.setPhospherene(true);
				return true;
			}
		}
		return false;	
	}
	
	public boolean unmarkPhospherene(String name) {
		for(Gear g : gearList) {
			if(g.getName().equalsIgnoreCase(name) && g.getCategory().equalsIgnoreCase("Weapon")) {
				g.setPhospherene(false);
				return true;
			}
		}
		return false;	
	}
	
	
	}
	

