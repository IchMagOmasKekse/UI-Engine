package de.ichmagomaskekse.uiengine;

public class Camera {
	private float x,y;
	
	public Camera(float x, float y) {
		this.x=x;
		this.y=y;
	}
	public Camera(Location location) {
		this.x=(float)location.getX();
		this.y=(float)location.getY();
	}
	
	public void tick() {
		x += ((x) - UIEngine.windowWidth/2) * 0.05f;
		y += ((y) - UIEngine.windowHeight/2) * 0.05f;
	
		if(x <= 0) x = 0; 
		if(x >= (UIEngine.windowWidth + 32)) x = (UIEngine.windowWidth+32);
		if(y <= 0) y = 0; 
		if(x >= (UIEngine.windowHeight + 16)) x = (UIEngine.windowHeight+16);
	}

	public float getX() {
		return x;
	}

	public void setX(float x) {
		this.x = x;
	}

	public float getY() {
		return y;
	}

	public void setY(float y) {
		this.y = y;
	}
	
}
