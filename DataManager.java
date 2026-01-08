/**
 * Handles loading and saving gear data for the Borderlands Collector App.
 * 
 * This class is responsible for reading gear data from a CSV file
 * at program startup and writing updated data back to the file
 * when the program exits.
 * 
 * It uses BufferedReader for reading and PrintWriter for writing
 * to ensure efficient file I/O and data persistence.
 * 
 * @author Orion
 */
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;

public class DataManager {
	public static final String DATA_FILE = "bl4CSV.csv"; 
	
	
	/**
	 * Loads gear data from a CSV file and populates the GearDatabase.
	 *
	 * @param fileName the name of the CSV file to load
	 * @param db the GearDatabase to populate
	 */
	public static void loadCSV(String fileName, GearDatabase db) {
		
		try(FileReader fr = new FileReader(fileName);
				BufferedReader br = new BufferedReader(fr);
				){	
			br.readLine();
			String line;
			while((line = br.readLine()) != null) {
				String[] parts = line.split(",");
				if(parts.length != 6) {
					continue;
				}
				String name = parts[0].trim();
				String category = parts[1].trim();
				String type = parts[2].trim();
				String manufacturer = parts[3].trim();
				String phosphereneStr = parts[4].trim();
				String collectedStr = parts[5].trim();
				
				boolean phospherene = Boolean.parseBoolean(phosphereneStr);
				boolean collected = Boolean.parseBoolean(collectedStr);
				
				Gear g = new Gear(name, category, type, manufacturer, phospherene, collected);
				db.addGear(g);
			}
		} catch (Exception e) {
			System.out.println("Error loading CSV file: " + e.getMessage());
		}
		}
	
	/**
	 * Saves all gear data from the GearDatabase to a CSV file.
	 *
	 * @param fileName the name of the CSV file to write to
	 * @param db the GearDatabase containing the gear to save
	 */
	public static void saveCSV(String fileName, GearDatabase db) {
		
		try(FileWriter fw = new FileWriter(fileName);
				PrintWriter pw = new PrintWriter(fw);){
			pw.println("Name,Category,Type,Manufacturer,Phospherene,Collected");
			
			for(Gear g : db.getAllGear()) {
				String name = g.getName();
				String category = g.getCategory();
				String type = g.getType();
				String manufacturer = g.getManufacturer();
				boolean phospherene = g.isPhospherene();
				boolean collected = g.isCollected();
				
				String line = name + ","
						+ category + ","
						+ type + ","
						+ manufacturer + ","
						+ phospherene + ","
						+ collected;
				
				pw.println(line);
			}
			
		} catch (Exception e) {
			System.out.println("Error saving CSV file: " + e.getMessage());
		}
						
	}
}
