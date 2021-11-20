package de.ichmagomaskekse.uiengine.graphics.ui;

import de.ichmagomaskekse.uiengine.Code;
import de.ichmagomaskekse.uiengine.graphics.Texture;

import java.awt.*;

public abstract class UIC {

    protected String id = Code.getRandomCode(4,14); //ID for identification
    protected UICType type = UICType.UNDEFINED;
    protected Texture texture; //Stays null, if no Texture is needed
    protected int x=0, y=0, w=0, h=0; //X & Y = Coordinate, W & H = Size
    protected boolean enabled = true;

    public UIC(UICType type, String name, int x, int y, int w, int h) {
        this.type = type;
        this.x = x;
        this.y = y;
        this.w = w;
        this.h = h;
        register();
    }

    public abstract void tick();
    public void render(Graphics2D g) {
        if(!isEnabled()) return;
        /* Storing defaults */
        Font f = g.getFont();
        Color c = g.getColor();
        Stroke s = g.getStroke();

        /* Rendering XLabel */
        draw(g);

        /* Resetting */
        g.setFont(f);
        g.setColor(c);
        g.setStroke(s);
    }
    public abstract void draw(Graphics2D g);

    /**
     * Returns true, if the UICManager has already registered this UIC Component.
     */
    public boolean isRegistered() {
        return UICManager.isRegistered(this);
    }

    public int width() {
        return w;
    }

    public int height() {
        return h;
    }

    public int x() {
        return x;
    }

    public int y() {
        return y;
    }

    public String getId() {
        return id;
    }

    public UICType getType() {
        return type;
    }

    public Texture getTexture() {
        return texture;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public void register() {
        UICManager.registerUIC(this);
    }

    public void unregister() {
        UICManager.unregisterUIC(this);
    }
}
