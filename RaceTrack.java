/*
 * Olivia Wang
 * PA04
 * 03/05/2020
 */
public class RaceTrack {
	
	public int ticks;
	public int num;
	RaceCar[] racecar = null;
	PitStop ps = new PitStop();
	FinishLine fl = new FinishLine();

	/**
	 * DO NOT REMOVE THIS - you should be using this to log this track's events in
	 * part B. For more see the assignment PDF / documentation for TrackLoggerA.java
	 */
	// private TrackLoggerA logger;

	public RaceTrack() {
		// logger = new TrackLoggerA(); // DO NOT REMOVE THIS LINE
		racecar = new RaceCar[10]; 
		ticks = 1;
	}

	public void setCars(RaceCar[] raceCars) {
		this.num = raceCars.length;
		if (num == 0) {
			racecar[0] = raceCars[0];
			num++;
		}
		if (num <= 10) {
			for (int i = 0; i < num; i++) {
				racecar[i] = raceCars[i];
			}
		}
	}
/**
 * This method moves all the cars one tick to a new location, and then check if any car can
 * go into pit stop. Then check if any car reaches the finish line. Last check if collision
 * happens after the tick. 
 */
	public void tick() {
		for (int i = 0; i < num; i++) {
			if (racecar[i] != null && racecar[i].ifFinished==false)
				if (racecar[i].tickInPit == 0) {
				//	System.out.println(racecar[i]);
					if (!racecar[i].getIfPit()) {	
						racecar[i].advanceLocation(racecar[i].getSpeed());
					}
				} else if (racecar[i].tickInPit == 2) {
					racecar[i].tickInPit--;
				} else if (racecar[i].tickInPit == 1) {
					racecar[i].tickInPit--;
					racecar[i].setIfPit(false);
					System.out.println(racecar[i].toString() + " has exited the pit stop");
				}
		}
		ps.enterPitStop(racecar);
		fl.enterFinishLine(racecar);
		checkCollision();
	}
/**
 * This method check if two cars collide: if one of two cars is already damaged, the penalty won't add. if one or
 * two cars aren't damaged, it decreased its speed by 5 times its strength.
 */
	public void checkCollision() {
		for (int i = 0; i < num - 1; i++) {
			for (int j = i + 1; j < num; j++) {
				if (racecar[i] != null)
					if (racecar[i].getLocation() == racecar[j].getLocation() && racecar[i].getLocation() != 50
							&& racecar[i] != null && racecar[j] != null && !racecar[i].getIfPit()) {
						if (racecar[i].getCollision() == true && racecar[j].getCollision() == false) {
							System.out.println(racecar[j].toString() + " has been damaged");
							racecar[j].setSpeed(racecar[j].getSpeed() - (racecar[j].getStrength() * 5));
							racecar[j].setCollision(true);
						} else if (racecar[i].getCollision() == false && racecar[j].getCollision() == true) {
							System.out.println(racecar[i].toString() + " has been damaged");
							racecar[i].setSpeed(racecar[i].getSpeed() - (racecar[i].getStrength() * 5));
							racecar[i].setCollision(true);
						} else if (racecar[i].getCollision() == false && racecar[j].getCollision() == false) {
							System.out.println(racecar[j].toString() + " has been damaged");
							System.out.println(racecar[i].toString() + " has been damaged");
							racecar[i].setSpeed(racecar[i].getSpeed() - (racecar[i].getStrength() * 5));
							racecar[j].setSpeed(racecar[j].getSpeed() - (racecar[j].getStrength() * 5));
							racecar[j].setCollision(true);
							racecar[i].setCollision(true);
						}
					}
			}
		}
	}
/**
 * This method runs the whole race. When the race is not finished, it keeps runs running
 * one tick and add the number of ticks. When all cars in the arrayList are finished, it 
 * prints out the score and end game statement.
 */
	public void run() {
		while (fl.finished(racecar) == false){
			System.out.println("tick " + ticks);
			tick();
			this.ticks++;
			
		}
		if (fl.finished(racecar) == true) {
			calculateScore(ticks);
			System.out.println("You scored "+ calculateScore(ticks) +" points.");
			System.out.println("End of game");
		}
	}
/**
 * This method calculates the final score
 * @param ticks
 * @return final score
 */
	public int calculateScore(int ticks) {
		return 1000 - ticks * 20 + 150 * num;
	}

	/**
	 * Needed for part B This method returns the logger instance used by this
	 * RaceTrack. You <b>SHOULD NOT</b> be using this method.
	 * 
	 * @return logger with this track's events
	 */
	/*
	 * public TrackLoggerA getLogger() { return logger; }
	 */
}
