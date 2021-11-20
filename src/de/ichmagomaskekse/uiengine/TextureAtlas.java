package de.ichmagomaskekse.uiengine;

import de.ichmagomaskekse.uiengine.graphics.Material;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.HashMap;

import javax.imageio.ImageIO;

public class TextureAtlas {
	
	private BufferedImage image;
	private HashMap<String, BufferedImage> textures;
	
	public TextureAtlas() {
		this.textures=new HashMap<String, BufferedImage>();
		reloadTextures();
	}
	
	public BufferedImage loadImage(String path) {
		try {
			System.out.println(path);
			image = ImageIO.read(getClass().getResource(path));
		} catch (IOException e) {
			e.printStackTrace();
		}
		return image;
	}
	public void reloadTextures() {
		/* Lädt alle Texturen neu und fügt sie zum Atlas(textures(hashmap)) hinzu */
		textures.clear();
		for(int i = 0; i < Material.values().length; i++) {
			Material material = Material.values()[i];
			textures.put(material.getName(), loadImage(material.getFilePath()));
		}
		//textures.put("", loadImage("/.png"));
	}
	
	public HashMap<String, BufferedImage> getTextures() {
		return textures;
	}
	
}
