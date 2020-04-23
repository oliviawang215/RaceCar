/**
 * This class represent a racecar with various fields of its stat and methods to
 * interact with other classes
 * 
 * @author Olivia Wang 
 * <PA04> 
 * <03/05/2020>
 */
public class RaceCar {
	private int speed;
	private int strength;
	private int location;
	private int lap;
	private boolean ifCollision;
	private boolean ifInPit;
	public int tickInPit;
	public int tickCount;
	public boolean ifFinished;

	/**
	 * A constructor that sets this RaceCar's speed between 55 and 30, and strength
	 * between 2 and 4. If goes beyond, set them to the min/max bounds
	 * 
	 * @param speed
	 * @param strength
	 */
	public RaceCar(int speed, int strength) {
		if (speed > 55) {
			this.speed = 55;
		} else if (speed < 30) {
			this.speed = 30;
		} else {
			this.speed = speed;
		}
		if (strength < 2) {
			this.strength = 2;
		} else if (strength > 4) {
			this.strength = 4;
		} else {
			this.strength = strength;
		}
		this.location = 0;
		this.lap = 0;
		this.ifCollision = false;
		this.ifInPit = false;
		this.tickInPit = 0;
		this.ifFinished = false;
	}

	public RaceCar() {
		this.speed = 40;
		this.strength = 3;
	}

	/**
	 * This method moves race car one displacement forward. If the location exceeds
	 * 100, which means the car finishes one lap, the lap will add.
	 * 
	 * @param displace
	 */
	public void advanceLocation(int displace) {
		this.location += displace;
		if (location >= 100) {
			int count = location / 100;
			this.location -= 100 * count;
			this.lap += count;
		}
	}

	public void setLocation(int loca) {
		this.location = loca;
	}

	public int getLocation() {
		return this.location;
	}

	public int getLap() {
		return this.lap;
	}

	public String toString() {
		return "RaceCar" + this.speed + "/" + this.strength;

	}

	public int getSpeed() {
		return this.speed;
	}

	public void setSpeed(int newspeed) {
		this.speed = newspeed;
	}

	public int getStrength() {
		return this.strength;
	}

	public void setStrength(int newstrength) {
		this.strength = newstrength;
	}

	public boolean getCollision() {
		return this.ifCollision;
	}

	public void setCollision(boolean b) {
		ifCollision = b;
	}

	public boolean getIfPit() {
		return this.ifInPit;
	}

	public void setIfPit(boolean b) {
		ifInPit = b;
	}
}
