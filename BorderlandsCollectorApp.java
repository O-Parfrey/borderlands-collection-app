/**
 * The main class of the app
 * 
 * @author Orion Parfrey
 * @date 11/10/2025 - 12/15/2025
 */
public class BorderlandsCollectorApp {

	public static void main(String[] args) {
		GearDatabase db = new GearDatabase();
		DataManager.loadCSV(DataManager.DATA_FILE, db);
		MenuSystem.mainMenu(db);

		DataManager.saveCSV(DataManager.DATA_FILE, db);
	}

}
