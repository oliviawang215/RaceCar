/**
 * This class represent a pit stop for the race car to enter once it's collided
 * 
 * @author Olivia Wang 
 * <PA04> 
 * <03,05,2020>
 *
 */
public class PitStop {
	/**
	 * This method determines if a car can enter pit stop. If a car is damaged and
	 * pass it during a tick, it will enter the pit stop. When the car is in the pit
	 * stop, it will set the location to 75 unit on the race track; The speed of the
	 * racecar will be reset to its default speed
	 * 
	 * @param racecar
	 */
	public void enterPitStop(RaceCar[] racecar) { // TODO you can add parameters here!
		int num = racecar.length;
		for (int i = 0; i < num; i++) {
			if (racecar[i] != null && racecar[i].ifFinished == false)
				if (racecar[i].getCollision() == true && (racecar[i].getLocation() >= 75
						|| racecar[i].getLocation() + 100 - racecar[i].getSpeed() < 75)) {
					System.out.println(racecar[i].toString() + " has entered the pit stop");
					racecar[i].setIfPit(true);
					racecar[i].setLocation(75);
					racecar[i].tickInPit = 2;
					racecar[i].setSpeed(racecar[i].getSpeed() + 5 * racecar[i].getStrength());
					racecar[i].setCollision(false);
				}
		}
	}
}
