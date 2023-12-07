/**
 * @author Sam Kauffman
 * @Version 1.0
 *
 */
public class Runway {
	private boolean isOccupied;
	private Plane plane;
	private int runwayNumber;

	/**
	 * @param Number of runways
	 */
	public Runway(int i) {
		this.runwayNumber = i;
	}

	/**
	 * @return true if runway is occupied, false if not
	 */
	public boolean isOccupied() {
		return isOccupied;
	}

	/**
	 * @param Plane that lands and occupies a runway
	 */
	public void occupy(Plane plane) {
		this.plane = plane;
		this.isOccupied = true;
	}

	/**
	 * Releases the plane from the runway, freeing the runway
	 */
	public void release() {
		this.plane = null;
		this.isOccupied = false;
	}

	/**
	 * @return plane
	 */
	public Plane getPlane() {
		return plane;
	}

	/**
	 * @return runways number
	 */
	public int getRunwayID() {
		return runwayNumber;
	}
}