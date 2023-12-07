import java.util.*;

/**
 * @author Sam Kauffman
 * @Version 1.0
 *
 */
public class Airport {
	private List<Plane> approachingPlanes;
	private Queue<Plane> landedPlanes;
	private Runway[] runways;
	private int timestep;

	/**
	 * @param How many runways you want at your airport
	 */
	public Airport(int runwayCount) {
		approachingPlanes = new ArrayList<Plane>();
		landedPlanes = new LinkedList<>();
		runways = new Runway[runwayCount];
		for (int i = 0; i < runwayCount; i++) {
			runways[i] = new Runway(i);
		}
	}

	/**
	 * Generates a new plane and adds it to the approachingPlane List
	 */
	public void generatePlane() {
		approachingPlanes.add(new Plane());
	}

	/**
	 * Adds one to timestep, calls the approach method for each approaching plane.
	 * Prints all approaching planes, handleslanding, and sees if there are any emergancy landings
	 */
	public void processTimestep() {
		System.out.println("Timestep: " + timestep);
		timestep++;
		for (Plane plane : approachingPlanes) {
			plane.approach();

		}
		System.out.println("Approaching Planes: " + approachingPlanes);
		handleLandings();
		removeLandedPlanes();
		emergencyLanding();
	}

	/**
	 * This handles plane landings. Iterates through each approching plane, makes sure there are planes in the
	 * list, Then makes sure there are runways free, if there are it adds a plane to landed planes and 
	 * occupies a runway
	 */
	private void handleLandings() {
		Iterator<Plane> iterator = approachingPlanes.iterator();
		while (iterator.hasNext()) {
			Plane plane = iterator.next();
			if (plane.isReadyToLand()) {
				for (Runway runway : runways) {
					if (!runway.isOccupied()) {
						runway.occupy(plane);
						landedPlanes.offer(plane);
						System.out.println("Plane " + plane.getId() + " landed on runway " + runway.getRunwayID());
						iterator.remove();
						break;
					}
				}
			}
		}
	}

	/**
	 * Removes landed planes from the queue and and frees up the runway it was occupying
	 */
	private void removeLandedPlanes() {
		if (timestep % 5 == 0 && !landedPlanes.isEmpty()) {
			Plane plane = landedPlanes.poll();
			for (Runway runway : runways) {
				if (runway.getPlane() == plane) {
					runway.release();
					System.out.println("Plane " + plane.getId() + " departed from runway " + runway.getRunwayID());
					break;
				}
			}
		}
	}

	/**
	 * 10% chance that a random plane needs to land because of an emergancy
	 * This method also removes the plane from the approaching plane queue
	 */
	private void emergencyLanding() {
		if (Math.random() > .1 || approachingPlanes.size() == 0) {
			return;
		}
		int listSize = approachingPlanes.size();
		Plane emergencyPlane = approachingPlanes.get((int) (listSize * Math.random()));
		emergencyPlane.setEmergency(true);
		System.out.println("Plane " + emergencyPlane.getId() + " had an emergency and landed successfully!");
		approachingPlanes.remove(emergencyPlane);
	}
}