/**
 * Provides the menu-driven user interface for the Borderlands Collector App.
 * 
 * This class displays menus, handles user input, and calls appropriate
 * methods in GearDatabase to display and update gear information.
 * 
 * It separates user interaction logic from data storage and file handling.
 * 
 * @author Orion
 */

public class MenuSystem {

	
	/**
	 * Displays the main menu and controls overall program flow.
	 *
	 * @param db the GearDatabase used by the application
	 */
	public static void mainMenu(GearDatabase db) {
		while (true) {
			System.out.println("Welcome to the Borderlands Collection app!");
			System.out.println("Please select an option to get started!");
			System.out.println("=========================================");
			System.out.println("1. Weapons");
			System.out.println("2. Armor/Shield"); 
			System.out.println("3. Ordinance");
			System.out.println("4. Repkit"); 
			System.out.println("5. Class Mods");
			System.out.println("6. Enhancements");
			System.out.println("7. Exit and save Program");
			int choice = UserInput.menuChoice();
			
			switch(choice) {
			case 1: 
				MenuSystem.showWeaponsMenu(db);
				break;
				
			case 2:
				MenuSystem.showArmorShieldMenu(db);
				break;
				
			case 3:
				MenuSystem.showOrdinanceMenu(db);
				break;
				
			case 4:
				MenuSystem.showRepkitMenu(db);
				break;
				
			case 5:
				MenuSystem.showClassModMenu(db);
				break;
			
			case 6:
				MenuSystem.showEnhancementMenu(db);
				break;
				
			case 7:
				System.out.println("Exiting program...");
				return;
				
			}
		}
	}
	
	public static void showWeaponsMenu(GearDatabase db) {
		//Show all the different sub types of weapons, assault rifles, smgs, shotguns, snipers, handguns
		 /*showWeaponSubTypeMenu("Assault Rifle") (Switch case for each one)*/
		while(true) {
		System.out.println("Choose your weapon type");
		System.out.println("=======================");
		System.out.println("1. Assault Rifle");
		System.out.println("2. Pistol");
		System.out.println("3. Shotgun");
		System.out.println("4. Sniper Rifle");
		System.out.println("5. SMG");
		System.out.println("6. Return to previous menu"); 
		int choice = UserInput.menuChoice();
		
		switch(choice) {
		case 1: 
			MenuSystem.showWeaponSubTypeMenu("Assault Rifle", db);
			break;
			
		case 2: 
			MenuSystem.showWeaponSubTypeMenu("Pistol", db);
			break;
			
		case 3: 
			MenuSystem.showWeaponSubTypeMenu("Shotgun", db);
			break;
		
		case 4: 
			MenuSystem.showWeaponSubTypeMenu("Sniper Rifle", db);
			break;
			
		case 5: 
			MenuSystem.showWeaponSubTypeMenu("SMG", db);
			break;
			
		case 6:
			System.out.println("Returning to previous menu...");
			return;
			}
		}
	}
	
	public static void showWeaponSubTypeMenu(String weaponType, GearDatabase db) {
		boolean foundSomething;
		boolean success;
		String name;
		
		while(true) {
		System.out.println("=====" + weaponType + "=====");
		System.out.println("Please choose an option");
		System.out.println("1. Show All");
		System.out.println("2. Show Collected/Not Collected");
		System.out.println("3. Show Phospherene/Not Phospherene");
		System.out.println("4. Add Collected");
		System.out.println("5. Add Phospherene");
		System.out.println("6. Remove Collected");
		System.out.println("7. Remove Phospherene");
		System.out.println("8. Return to previous menu");
		int choice = UserInput.menuChoice();
		
		switch(choice) {
		case 1:
			db.displayGearByTypeAndCategory("Weapon", weaponType);
			break;
			
		case 2: 
			MenuSystem.showCollectedNotCollected("Weapon", weaponType, db);
			break;
			
		case 3:
			MenuSystem.showPhosphereneNotPhospherene(weaponType, db);
			break;
			
		case 4: 
			foundSomething = false;
			for(Gear g : db.getAllGear()) {
				if(g.getCategory().equalsIgnoreCase("Weapon") && g.getType().equalsIgnoreCase(weaponType) && !g.isCollected()){
			System.out.println(g);
			foundSomething = true;
				}	
			}
			
			if(!foundSomething) {
				System.out.println("No weapons found");
				System.out.println("Congratulations! You have found all " + weaponType + " weapons!");
				break;
			}
			
			
			System.out.println("Please input the name of the weapon you want to add to the collection");
			name = UserInput.getString("Name: ");
			success = db.markCollected(name);
			
			if(success) {
				System.out.println(name + " marked correctly!");
				for(Gear g : db.getAllGear()) {
					if(g.getName().equalsIgnoreCase(name)) {
						System.out.println(g);
					}
				}
			} else {
				System.out.println(name + " not found");
			}
			
			break;
			
			
		case 5:
			foundSomething = false;
			for(Gear g : db.getAllGear()) {
				if(g.getCategory().equalsIgnoreCase("Weapon") && g.getType().equalsIgnoreCase(weaponType) && !g.isPhospherene()) {
					System.out.println(g);
					foundSomething = true;
				}
			}
			
			if(!foundSomething) {
				System.out.println("No phospherene weapons found");
				System.out.println("All " + weaponType + " weapons are already phospherene!");
				break;
			}
			System.out.println("Please input the name of the weapon you want to add as phospherene");
			name = UserInput.getString("Name: ");
			success = db.markPhospherene(name);
			
			if(success) {
				System.out.println(name + " marked correctly!");
				for(Gear g : db.getAllGear()) {
					if(g.getName().equalsIgnoreCase(name)) {
						System.out.println(g);
					}
				}
			} else {
				System.out.println(name + " not found");
			}
			
			break;
			
		case 6:
			foundSomething = false;
			for(Gear g : db.getAllGear()) {
				if(g.getCategory().equalsIgnoreCase("Weapon") && g.getType().equalsIgnoreCase(weaponType) && g.isCollected()) {
					System.out.println(g);
					foundSomething = true;
				}
			}
			if(!foundSomething) {
				System.out.println("No collected weapons found for type " + weaponType);
				break;
			}
			System.out.println("Please input the name of the weapon you want to remove from the collection");
			name = UserInput.getString("Name: "); 
			success = db.unmarkCollected(name);
			
			if(success) {
				System.out.println(name + " removed correctly!");
				for(Gear g : db.getAllGear()) {
					if(g.getName().equalsIgnoreCase(name)) {
						System.out.println(g);
					}
				}
			} else {
				System.out.println(name + " not found");
			}
			
			break;
			
		case 7:
			foundSomething = false;
			
			for(Gear g : db.getAllGear()) {
				if(g.getCategory().equalsIgnoreCase("Weapon") && g.getType().equalsIgnoreCase(weaponType) && g.isPhospherene()) {
					System.out.println(g);
					foundSomething = true;
				}
			}
			if(!foundSomething) {
				System.out.println("No phospherene weapons found for type " + weaponType);
				break;
			}
			System.out.println("Please input the name of the weapon you want to remove from phospherene");
			name = UserInput.getString("Name: ");
			success = db.unmarkPhospherene(name);
			
			if(success) {
				System.out.println(name + " removed correctly!");
				for(Gear g : db.getAllGear()) {
					if(g.getName().equalsIgnoreCase(name)) {
						System.out.println(g);
					}
				}
			} else {
				System.out.println(name + " not found");
			}
			
			break;
			
		case 8:
			System.out.println("Returning to previous menu");
			return;
			
			}
		}
	}
	
	public static void showArmorShieldMenu(GearDatabase db) {
		while(true) {
			System.out.println("Select if you want Armors or Shields");
			System.out.println("====================================");
			System.out.println("1. Armor");
			System.out.println("2. Energy");
			System.out.println("3. Return to previous menu");
			int choice = UserInput.menuChoice();
			
			switch(choice) {
			case 1:
				MenuSystem.showSubArmorShieldMenu("Armor", db);
				break;
				
			case 2: 
				MenuSystem.showSubArmorShieldMenu("Energy", db);
				break;
				
			case 3: 
				System.out.println("Returning to previous menu");
				return;
			}
		}
	}
	
	public static void showSubArmorShieldMenu(String shieldType, GearDatabase db) {
		boolean foundSomething = false;
		String name;
		boolean success;
		while(true) {
			System.out.println("=====" + shieldType + "=====");
			System.out.println("Please choose an option");
			System.out.println("1. Show All");
			System.out.println("2. Show Collected/Not Collected");
			System.out.println("3. Add Collected");
			System.out.println("4. Remove Collected");
			System.out.println("5. Return to previous menu");
			int choice = UserInput.menuChoice();
			
			switch(choice) {
			case 1:
				db.displayGearByTypeAndCategory("Shield", shieldType);
				break;
				
			case 2: 
				MenuSystem.showCollectedNotCollected("Shield", shieldType, db);
				break;
				
			case 3: 
				foundSomething = false;
				for(Gear g : db.getAllGear()) {
					if(g.getCategory().equalsIgnoreCase("Shield") && g.getType().equalsIgnoreCase(shieldType) && !g.isCollected()) {
						System.out.println(g);
						foundSomething = true;
					}
				}
				if(!foundSomething) {
					System.out.println("No shields found");
					System.out.println("Congratulations you found all the " + shieldType + " type for shields!");
					break;
				}
					
				System.out.println("Please input the name of the shield you want to mark as collected.");
				name = UserInput.getString("Name: ");
				success = db.markCollected(name);
				
				if(success) {
					System.out.println(name + " marked correctly!");
					for(Gear g : db.getAllGear()) {
						if(g.getName().equalsIgnoreCase(name)) {
							System.out.println(g);
						}
					}
				}else{
					System.out.println(name + " not found");
				}
				
				break;
				
			case 4: 
				foundSomething = false;
				for(Gear g : db.getAllGear()) {
					if(g.getCategory().equalsIgnoreCase("Shield") && g.getType().equalsIgnoreCase(shieldType) && g.isCollected()) {
			
						System.out.println(g);
						foundSomething = true;
					}
				}
				if(!foundSomething) {
					System.out.println("No shields found");
					break;
				}
					
				System.out.println("Please input the name of the shield you want to remove from collected.");
				name = UserInput.getString("Name: ");
				success = db.unmarkCollected(name);
				
				if(success) {
					System.out.println(name + " unmarked correctly!");
					for(Gear g : db.getAllGear()) {
						if(g.getName().equalsIgnoreCase(name)) {
							System.out.println(g);
						}
					}
				}else{
					System.out.println("Shield not found");
				}

				break;
				
			case 5:
				System.out.println("Returning to previous menu");
				return;
			}
			
		}
	}
	
	public static void showOrdinanceMenu(GearDatabase db) {
		while(true) {
			System.out.println("Select which type of ordinance you want");
			System.out.println("=======================================");
			System.out.println("1. Grenade");
			System.out.println("2. Heavy Weapon");
			System.out.println("3. Knife");
			System.out.println("4. Return to previous menu");
			int choice = UserInput.menuChoice();
			
			switch(choice) {
			case 1:
				MenuSystem.showSubOrdinanceMenu("Grenade", db);
				break;
				
			case 2:
				MenuSystem.showSubOrdinanceMenu("Heavy Weapon", db);
				break;
				
			case 3:
				MenuSystem.showSubOrdinanceMenu("Knife", db);
				break;
				
			case 4:
				System.out.println("Returning to previous menu");
				return;
			}
		}
	}
	
	public static void showSubOrdinanceMenu(String ordinanceType, GearDatabase db) {
		boolean foundSomething;
		boolean success;
		String name;
		
		while(true) {
			System.out.println("=====" + ordinanceType +"=====" );
			System.out.println("1. Show All");
			System.out.println("2. Show Collected/Not Collected");
			System.out.println("3. Add Collected");
			System.out.println("4. Remove Collected");
			System.out.println("5. Return to previous menu");
			int choice = UserInput.menuChoice();
			
			switch(choice) {
			case 1:
				db.displayGearByTypeAndCategory("Ordinance", ordinanceType);
				break;
				
			case 2: 
				MenuSystem.showCollectedNotCollected("Ordinance", ordinanceType, db);
				break;
				
			case 3:
				foundSomething = false;
				for(Gear g : db.getAllGear()) {
					if(g.getCategory().equalsIgnoreCase("Ordinance") && g.getType().equalsIgnoreCase(ordinanceType) && !g.isCollected()) {
						System.out.println(g);
						foundSomething = true;
					}
				}
				if(!foundSomething) {
					System.out.println("No ordinance found");
					System.out.println("Congratulations you found all the " + ordinanceType + " type for ordinances!");
					break;
				}
				System.out.println("Please input the name of the ordinance you want to mark as collected");
				name = UserInput.getString("Name: ");
				success = db.markCollected(name);
				
				if(success) {
					System.out.println(name + " marked correctly!");
					for(Gear g : db.getAllGear()) {
						if(g.getName().equalsIgnoreCase(name)) {
							System.out.println(g);
						}
					}
				}else{
					System.out.println(name + " not found");
				}
				
				break;
				
			case 4:
				foundSomething = false;
				for(Gear g : db.getAllGear()) {
					if(g.getCategory().equalsIgnoreCase("Ordinance") && g.getType().equalsIgnoreCase(ordinanceType) && g.isCollected()) {
						System.out.println(g);
						foundSomething = true;
					}
				}
				if(!foundSomething) {
					System.out.println("No ordinance found");
					break;
				}
				System.out.println("Please input the name of the ordinance you want to unmark from collected");
				name = UserInput.getString("Name: ");
				success = db.unmarkCollected(name);
				
				if(success) {
					System.out.println(name + " unmarked correctly!");
					for(Gear g : db.getAllGear()) {
						if(g.getName().equalsIgnoreCase(name)) {
							System.out.println(g);
						}
					}
				}else{
					System.out.println("Ordinance not found");
				}
				
				break;
				
			case 5:
				System.out.println("Returning to previous menu");
				return;
			}
		}
	}
	
	public static void showRepkitMenu(GearDatabase db) {
		boolean foundSomething;
		boolean success;
		String name;
		
		while(true) {
			System.out.println("=====Repkits======");
			System.out.println("1. Show All");
			System.out.println("2. Show Collected/Not Collected");
			System.out.println("3. Add Collected");
			System.out.println("4. Remove Collected");
			System.out.println("5. Return to previous menu");
			int choice = UserInput.menuChoice();
			
			switch(choice) {
			case 1:
				db.displayAllByCategory("Repkit");
				break;
				
			case 2: 
				MenuSystem.showCollectedNotCollected("Repkit", "Repkit", db);
				break;
				
			case 3:
				foundSomething = false;
				for(Gear g : db.getAllGear()) {
					if(g.getCategory().equalsIgnoreCase("Repkit") && !g.isCollected()) {
						System.out.println(g);
						foundSomething = true;
					}
				}
				if(!foundSomething) {
					System.out.println("No repkit found");
					System.out.println("Congratulations you found all the repkits!");
					break;
				}
				System.out.println("Please input the name of the repkit you want to mark as collected");
				name = UserInput.getString("Name: ");
				success = db.markCollected(name);
				
				if(success) {
					System.out.println(name + " marked correctly!");
					for(Gear g : db.getAllGear()) {
						if(g.getName().equalsIgnoreCase(name)) {
							System.out.println(g);
						}
					}
				}else{
					System.out.println(name + " not found");
				}
				
				break;
				
			case 4:
				foundSomething = false;
				for(Gear g : db.getAllGear()) {
					if(g.getCategory().equalsIgnoreCase("Repkit") && g.isCollected()) {
						System.out.println(g);
						foundSomething = true;
					}
				}
				if(!foundSomething) {
					System.out.println("No repkit found");
					break;
				}
				System.out.println("Please input the name of the repkit you want to ummark as collected");
				name = UserInput.getString("Name: ");
				success = db.unmarkCollected(name);
				
				if(success) {
					System.out.println(name + " unmarked correctly!");
					for(Gear g : db.getAllGear()) {
						if(g.getName().equalsIgnoreCase(name)) {
							System.out.println(g);
						}
					}
				}else{
					System.out.println(name + " not found");
				}
	
				break;
				
			case 5:
				System.out.println("Returning to previous menu");
				return;
			}
		}
	}
	
	public static void  showClassModMenu(GearDatabase db) {
		while(true) {
			System.out.println("Please choose which character for class mods");
			System.out.println("============================================");
			System.out.println("1. Amon");
			System.out.println("2. Harlowe");
			System.out.println("3. Rafa");
			System.out.println("4. Vex");
			System.out.println("5. C4SH"); //not out yet, DLC character
			System.out.println("6. Return to previous menu");
			int choice = UserInput.menuChoice();
			
			switch(choice) {
			case 1:
				MenuSystem.showSubClassModMenu("Amon", db);
				break;
				
			case 2:
				MenuSystem.showSubClassModMenu("Harlowe", db);
				break;
				
			case 3:
				MenuSystem.showSubClassModMenu("Rafa", db);
				break;
				
			case 4: 
				MenuSystem.showSubClassModMenu("Vex", db);
				break;
				
			case 5:
				MenuSystem.showSubClassModMenu("C4SH", db);
				break;
				
			case 6:
				System.out.println("Returning to previous menu");
				return;
			}
		}
	}
	
	public static void showSubClassModMenu(String characterType, GearDatabase db) {
		boolean foundSomething;
		boolean success;
		String name;
		
		while(true) {
			System.out.println("=====" + characterType + "=====");
			System.out.println("1. Show All");
			System.out.println("2. Show Collected/Not Collected");
			System.out.println("3. Add Collected");
			System.out.println("4. Remove Collected");
			System.out.println("5. Return to previous menu");
			int choice = UserInput.menuChoice();
			
			switch(choice) {
			case 1:
				db.displayGearByTypeAndCategory("Class Mod", characterType);
				break;
				
			case 2:
				MenuSystem.showCollectedNotCollected("Class Mod", characterType, db);
				break;
				
			case 3:
				foundSomething = false;
				for(Gear g : db.getAllGear()) {
					if(g.getCategory().equalsIgnoreCase("Class Mod") && g.getType().equalsIgnoreCase(characterType) && !g.isCollected()) {
						System.out.println(g);
						foundSomething = true;
					}
				}
				if(!foundSomething) {
					System.out.println("No class mods found");
					System.out.println("Congratulations you found all the class mods for " + characterType + "!");
					break;
				}
					
				System.out.println("Please input the name of the class mod you want to mark as collected.");
				name = UserInput.getString("Name: ");
				success = db.markCollected(name);
				
				if(success) {
					System.out.println(name + " marked correctly!");
					for(Gear g : db.getAllGear()) {
						if(g.getName().equalsIgnoreCase(name)) {
							System.out.println(g);
						}
					}
				}else{
					System.out.println(name + " not found");
				}
				
				break;
				
			case 4:
				foundSomething = false;
				for(Gear g : db.getAllGear()) {
					if(g.getCategory().equalsIgnoreCase("Class Mod") && g.getType().equalsIgnoreCase(characterType) && g.isCollected()) {
						System.out.println(g);
						foundSomething = true;
					}
				}
				if(!foundSomething) {
					System.out.println("No class mods found");
					break;
				}
					
				System.out.println("Please input the name of the class mod you want to unmark as collected.");
				name = UserInput.getString("Name: ");
				success = db.unmarkCollected(name);
				
				if(success) {
					System.out.println(name + " unmarked correctly!");
					for(Gear g : db.getAllGear()) {
						if(g.getName().equalsIgnoreCase(name)) {
							System.out.println(g);
						}
					}
				}else{
					System.out.println(name + " not found");
				}
				
				break;
				
			case 5:
				System.out.println("Returning to previous menu");
				return;
				
			
			}
		}
	}
	
	public static void showEnhancementMenu(GearDatabase db) {
		boolean foundSomething;
		boolean success;
		String name;
		
		while(true) {
			System.out.println("=====Enhancements Menu=====");
			System.out.println("1. Show All");
			System.out.println("2. Show Collected/Not Collected");
			System.out.println("3. Add collected");
			System.out.println("4. Remove Collected");
			System.out.println("5. Return to previous menu");
			int choice = UserInput.menuChoice();
			
			switch(choice) {
			case 1:
				db.displayAllByCategory("Enhancement");
				break;
				
			case 2: 
				MenuSystem.showCollectedNotCollected("Enhancement", "Enhancement", db);
				break;
				
			case 3:
				foundSomething = false;
				for(Gear g : db.getAllGear()) {
					if(g.getCategory().equalsIgnoreCase("Enhancement") && !g.isCollected()) {
						System.out.println(g);
						foundSomething = true;
					}
				}
				if(!foundSomething) {
					System.out.println("No enhancement found");
					System.out.println("Congratulations you found all the enhancements!");
					break;
				}
				System.out.println("Please input the name of the enhancements you want to mark as collected");
				name = UserInput.getString("Name: ");
				success = db.markCollected(name);
				
				if(success) {
					System.out.println(name + " marked correctly!");
					for(Gear g : db.getAllGear()) {
						if(g.getName().equalsIgnoreCase(name)) {
							System.out.println(g);
						}
					}
				}else{
					System.out.println(name + " not found");
				}
				
				break;
				
			case 4:
				foundSomething = false;
				for(Gear g : db.getAllGear()) {
					if(g.getCategory().equalsIgnoreCase("Enhancement") && g.isCollected()) {
						System.out.println(g);
						foundSomething = true;
					}
				}
				if(!foundSomething) {
					System.out.println("No enhancements found");
					break;
				}
				System.out.println("Please input the name of the enhancement you want to mark as collected");
				name = UserInput.getString("Name: ");
				success = db.unmarkCollected(name);
				
				if(success) {
					System.out.println(name + " marked correctly!");
					for(Gear g : db.getAllGear()) {
						if(g.getName().equalsIgnoreCase(name)) {
							System.out.println(g);
						}
					}
				}else{
					System.out.println(name + " not found");
				}
				
				break;
				
			case 5:
				System.out.println("Returning to previous menu");
				return;
			}
			
		}
		
	}
	
	public static void showCollectedNotCollected(String category, String type, GearDatabase db) {
		boolean foundSomething = false;
		while (true) {
			System.out.println("1. Show collected");
			System.out.println("2. Show not collected");
			System.out.println("3. Return to previous menu");
			int choice = UserInput.menuChoice();
			
			switch(choice) {
			case 1:
				foundSomething = false;
				for(Gear g : db.getAllGear()) {
				if(g.getType().equalsIgnoreCase(type) && g.getCategory().equalsIgnoreCase(category) && g.isCollected() == true) {
					System.out.println(g);
					foundSomething = true;
				}
				}
				if(!foundSomething) {
					System.out.println("Nothing has been collected");
				}
				break;
				
			case 2:
				foundSomething = false;
				for(Gear g : db.getAllGear()) {
					if(g.getType().equalsIgnoreCase(type) && g.getCategory().equalsIgnoreCase(category) && !g.isCollected()) {
						System.out.println(g);
						foundSomething = true;
					}
				}
				if(!foundSomething) {
					System.out.println("You have collected everything! Congratulations!");
				}
				
				break;
				
			case 3:
				System.out.println("Returning to main menu.");
				return;
			}
		}
	}
	
	public static void showPhosphereneNotPhospherene(String weaponType, GearDatabase db) {
		boolean foundSomething = false;
		while (true) {
			System.out.println("1. Show collected phospherene");
			System.out.println("2. Show non-phospherene weapons");
			System.out.println("3. Return to previous menu");
			int choice = UserInput.menuChoice();
			
			switch(choice) {
			case 1:
				foundSomething = false;
				for(Gear g : db.getAllGear()) {
					if(g.getType().equalsIgnoreCase(weaponType) && g.getCategory().equalsIgnoreCase("Weapon") && g.isPhospherene() == true) {
						System.out.println(g);
						foundSomething = true;
					}
				}
				
				if(!foundSomething) {
					System.out.println("No phospherene gear found");
				}
				break;
				
			case 2:
				foundSomething = false;
				for(Gear g : db.getAllGear()) {
					if(g.getType().equalsIgnoreCase(weaponType) && g.getCategory().equalsIgnoreCase("Weapon") && !g.isPhospherene()) {
						System.out.println(g);
						foundSomething = true;
					}
				}
				if(!foundSomething) {
					System.out.println("You have found all the phospherene weapons! Congratulations!");
				}
				break;
				
			case 3:
				System.out.println("Returning to main menu.");
				return;
			}
		}
	}
}
