
/**
 * @author Sam Kauffman
 * @Version 1.0
 *
 */
public class Plane {

	private static int idCounter = 0;
	private int id;
	private int distance;
	int time;
	Boolean emergency;

	/**
	 * Contructor
	 */
	public Plane() {
		this.id = idCounter++;
		this.distance = 100;
		this.time = 0;
		this.emergency = false;
	}

	/**
	 * @return Planes ID
	 */
	public int getId() {
		return id;
	}

	/**
	 * @return planes time to land
	 */
	public int getTime() {
		return time;
	}

	/**
	 * @return distance of plane from the airport
	 */
	public int getDistance() {
		return distance;
	}

	/**
	 * @param distance (Default 100)
	 */
	public void setDistance(int distance) {
		this.distance = distance;
	}

	/**
	 * @param boolean if theres an emergency
	 */
	public void setEmergency(boolean emergancy) {
		this.emergency = emergancy;
	}

	/**
	 * @return true if plane can land and distance is 0, false if not
	 */
	public boolean isReadyToLand() {
		return distance == 0;
	}

	/**
	 * if distance is not 0 subtracts distance by 20, adds 1 to the time step, if distance is not 0
	 */
	public void approach() {
		if (distance > 0) {
			distance -= 20;
			time += 1;
		} else {
			time += 1;
		}
	}

	/**
	 * @return true if theres an emergancy, false if not
	 */
	public boolean isEmergency() {
		return emergency;
	}

	/**
	 * Prints Planes information, including ID, distance, and time to land
	 */
	@Override
	public String toString() {
		return "Plane{" + "id=" + id + ", distance=" + distance + " time= " + time + '}';
	}

}