/**
 * Represents a single piece of legendary or phospherene gear from Borderlands 4.
 * Stores its name, type, manufacturer, and whether it has been collected.
 * @author Orion Parfrey
 * @date 11/10/2025 - 
 */
public class Gear {

	private String name;
	private String category;
	private String manufacturer; 
	private String type;
	private boolean phospherene;
	private boolean collected;
	//add DPS,ammo,element,accuracy, etc.
	
	
	 /**
     * Full constructor for a gear item.
     * @param name the name of the gear
     * @param category the type of gear (Weapon, Shield, Grenade, Repkit, Mod, Enhancement)
     * @param manufacturer the manufacturer of the gear
     * @param phospherene true if this gear is phospherene, false otherwise
     * @param collected true if the player has collected this gear, false otherwise
     */
	
	public Gear(String name, String category,String type, String manufacturer, boolean phospherene, boolean collected) {
		this.name = name;
		this.category = category;
		this.manufacturer = manufacturer;
		this.type =  type;
		this.phospherene = phospherene;
		this.collected = collected;
		if(!category.equalsIgnoreCase("Weapon")) {
			this.phospherene = false;
		}
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getCategory() {
		return category;
	}
	
	public void setCategory(String category) {
		this.category = category;
	}
	
	public String getManufacturer() {
		return manufacturer;
	}
	
	public void setManufacturer(String manufacturer) {
		this.manufacturer = manufacturer;
	}
	
	public String getType() {
		return type;
	}
	
	public void setType(String type) {
		 this.type = type; 
	}
	
	public boolean isPhospherene() {
		return phospherene;
	}
	
	public void setPhospherene(boolean phospherene) {
		this.phospherene = phospherene;
	}
	
	public boolean isCollected() {
		return collected;
	}
	
	public void setCollected(boolean collected) {
		this.collected = collected;
	}
	
	@Override
	public String toString() {
		return String.format("Name: %s | Category: %s | Type: %s | Manufacturer: %s | Collected: %s | Phospherene: %s", name, category, type, manufacturer,
				collected ? "Yes" : "No",
			category.equalsIgnoreCase("Weapon") ? (phospherene ? "Yes" : "No") : "N/A");

	}
}
