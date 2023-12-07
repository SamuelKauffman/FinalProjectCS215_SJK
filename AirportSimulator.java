import java.io.IOException;

/**
 * @author Sam Kauffman
 * @Version 1.0
 *
 *This class is the application class for my Airport simulator. What this simulation does
 *is goes through 50 timesteps, each timestep takes 2 seconds and has a 20% chance of generating
 *a plane. 
 */
public class AirportSimulator {
	/**
	 * @param args
	 * @throws InterruptedException
	 */
	public static void main(String[] args) throws InterruptedException {
		// Instantiating Airport with 3 runways
		Airport airport = new Airport(3);

		// 50 timesteps
		for (int i = 0; i < 50; i++) {
			// 20% chance to generate a plane
			if (Math.random() < 0.2) {
				airport.generatePlane();
			}
			// waits 2 seconds before printing the timestep
			Thread.sleep(2000);
			clear();
			airport.processTimestep();
		}
	}

	/**
	 * Clears the screen.
	 */
	@SuppressWarnings("deprecation")
	public static void clear()

	{
		try {
			if (System.getProperty("os.name").contains("Windows"))
				new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
			else
				Runtime.getRuntime().exec("clear");
		} catch (IOException | InterruptedException ex) {
		}
	}

}