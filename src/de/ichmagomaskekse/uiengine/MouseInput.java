package de.ichmagomaskekse.uiengine;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class MouseInput extends MouseAdapter {
	
	public MouseInput() {
	}
	
	@SuppressWarnings("unused")
	public void mousePressed(MouseEvent e) {
		if(e.getButton() == MouseEvent.BUTTON1) {			
			Camera camera = UIEngine.getInstance().getCamera();
			int mx = (int) (e.getX() + camera.getX());
			int my = (int) (e.getY() + camera.getY());
		}
	}
}
