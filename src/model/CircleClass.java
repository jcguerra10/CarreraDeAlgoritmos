package model;

public class CircleClass {
	public static final int STEP = 1;
	private double r;
	private double max;
	private double min;
	private Direction dir;
	
	public CircleClass(double r, double max, double min, Direction dir) {
		super();
		this.r = r;
		this.max = max;
		this.min = min;
		this.dir = dir;
	}

	public double getR() {
		return r;
	}

	public void setR(double r) {
		this.r = r;
	}

	public double getMax() {
		return max;
	}

	public void setMax(double max) {
		this.max = max;
	}

	public double getMin() {
		return min;
	}

	public void setMin(double min) {
		this.min = min;
	}

	public Direction getDir() {
		return dir;
	}

	public void setDir(Direction dir) {
		this.dir = dir;
	}
	
	public void move() {
		if (dir == Direction.increseases) {
			r += STEP;
		}else {
			r -= STEP;
		}
		verify();
	}

	private void verify() {
		if (r >= max ) {
			dir = Direction.decreases;
		}else if (r <= min) {
			dir = Direction.increseases;
		}
			
	}
	
	
}
