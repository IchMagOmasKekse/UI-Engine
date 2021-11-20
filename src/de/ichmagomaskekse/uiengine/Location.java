package de.ichmagomaskekse.uiengine;


public class Location {
	
	private double xCurrent, yCurrent;
	private double xPrev, yPrev;
	
	public Location(double x, double y) {
		this.xCurrent=x;
		this.yCurrent=y;
	}
	public Location clone() {
		return new Location(getX(), getY());
	}
	public double getX() {
		return xCurrent;
	}
	public double getY() {
		return yCurrent;
	}
	public double getPreviousX() {
		return xPrev;
	}
	public double getPreviousY() {
		return yPrev;
	}
	public Location setX(double x) {
		this.xPrev=xCurrent;
		this.xCurrent=x;
		return this.clone();
	}
	public Location setY(double y) {
		this.yPrev=yCurrent;
		this.yCurrent=y;
		return this.clone();
	}
	public Location setXY(double x, double y) {
		this.xPrev=xCurrent;
		this.xCurrent=x;
		this.yPrev=yCurrent;
		this.yCurrent=y;
		return this.clone();
	}
	public Location add(double x, double y) {
		this.xPrev=xCurrent;
		this.yPrev=yCurrent;
		this.xCurrent+=x;
		this.yCurrent+=y;
		return this.clone();
	}
	public Location addAndConvert(double xD, double yD) {
		xD*= UIEngine.blocksize;
		yD*= UIEngine.blocksize;
		this.xPrev=xCurrent;
		this.yPrev=yCurrent;
		this.xCurrent+=xD;
		this.yCurrent+=yD;
		return this.clone();
	}
	public int getBlockIntX() {
//		int ax = ((int)(xCurrent / Game.blocksize))*Game.blocksize;
		int ax = ((int)(xCurrent / UIEngine.blocksize));
		return ax;
	}
	public int getBlockIntY() {
//		int ay = ((int)(yCurrent / Game.blocksize))*Game.blocksize;
		int ay = ((int)(yCurrent / UIEngine.blocksize));
		return ay;
	}
	public int getConvertedIntX() {
		return (int)(xCurrent/ UIEngine.blocksize);
	}
	public int getConvertedIntY() {
		return (int)(yCurrent/ UIEngine.blocksize);
	}
	public int getIntX() {
		return (int)xCurrent;
	}
	public int getIntY() {
		return (int)yCurrent;
	}
	public int getIntPreviousX() {
		return (int)xPrev;
	}
	public int getIntPreviousY() {
		return (int)yPrev;
	}
	public String getConvertedLocationString() {
		return getConvertedIntX()+":"+getConvertedIntY();
	}
	public static int convertToBlock(int i) {
		return (i/ UIEngine.blocksize)* UIEngine.blocksize;
	}
	public int getFootY() {
		return (getIntY()+(2* UIEngine.blocksize)-1);
	}
	public int getFootBlockY() {
		return (getBlockIntY()+(1* UIEngine.blocksize));
	}
	public Location setAndConvert(double xD, double yD) {
		xD*= UIEngine.blocksize;
		yD*= UIEngine.blocksize;
		this.xPrev=xCurrent;
		this.yPrev=yCurrent;
		this.xCurrent=xD;
		this.yCurrent=yD;
		return this.clone();
	}
	
}
