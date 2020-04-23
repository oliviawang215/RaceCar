/**
 * @author Olivia Wang 
 * <PA04> 
 * <03/05/2020>
 */
public class FinishLine {
	private int place;

	public FinishLine() {
		place = 1;
	}

	/**
	 * This method would enter the racecar with a lap time of 10 to the finishline
	 * by keeping track of the location of each car. It will also set the place
	 * finishes of each race car
	 * 
	 * @param racecar
	 */
	public void enterFinishLine(RaceCar[] racecar) { // TODO you can add parameters here!
		int num = racecar.length;
		for (int i = 0; i < num; i++) {
			if (racecar[i] != null && racecar[i].ifFinished == false) {
				if (racecar[i].getLap() == 10) {
					if (!racecar[i].ifFinished) {
						System.out.println(racecar[i].toString() + " has finished the race in place " + place);
						racecar[i].ifFinished = true;
						place++;
					}
				}
			}
		}
	}

	/**
	 * This method would return true if the game is finished by tracking the status
	 * of all race cars in the track
	 * 
	 * @param racecar
	 * @return
	 */
	public boolean finished(RaceCar[] racecar) {
		int num = racecar.length;
		for (int i = 0; i < num; i++) {
			if (racecar[i] != null) {
				if (racecar[i].ifFinished == false)
					return false;
			}
		}
		return true;
	}
}
