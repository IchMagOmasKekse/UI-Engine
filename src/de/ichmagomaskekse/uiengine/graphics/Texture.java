package de.ichmagomaskekse.uiengine.graphics;

import de.ichmagomaskekse.uiengine.UIEngine;

import java.awt.image.BufferedImage;

public class Texture {

    private String path;
    private BufferedImage image;
    private int w = 0, h = 0;

    public Texture(String pathToFile) {
        this.path = pathToFile;
        this.image = UIEngine.getInstance().getTextureAtlas().loadImage(path);
        this.w = image.getWidth();
        this.h = image.getHeight();
    }

    public BufferedImage getImage() { return image; }
    public int width() { return w; }
    public int height() { return h; }

}
