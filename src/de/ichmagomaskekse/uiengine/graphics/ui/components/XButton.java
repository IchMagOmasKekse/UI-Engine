package de.ichmagomaskekse.uiengine.graphics.ui.components;

import de.ichmagomaskekse.uiengine.graphics.ui.UIC;
import de.ichmagomaskekse.uiengine.graphics.ui.UICType;

import java.awt.*;

public class XButton extends UIC {

    public Font font;
    public Color forecolor, bordercolor, infillcolor;
    private String text = "Unknown text";
    private int xOffset = 10, yOffset = 10;

    private int calculated_yOffset = 0;

    public XButton(String name, int x, int y, int w, int h, int xOffset, int yOffset) {
        super(UICType.BUTTON, name, x, y, w, h);
        this.text = name;
        this.xOffset = xOffset;
        this.yOffset = yOffset;
        recalculate();
    }

    @Override
    public void tick() {

    }

    public void recalculate() {
        this.calculated_yOffset = (yOffset+((int)(1.5*h))-3);
    }

    @Override
    public void draw(Graphics2D g) {
        if(font != null) g.setFont(font);
        if(forecolor != null) g.setColor(forecolor);

        if(infillcolor != null) {
            g.setColor(infillcolor);
            g.fillRect(x-xOffset, y-calculated_yOffset, w+xOffset+xOffset, h+(2*yOffset));
        }

        if(bordercolor != null) {
            g.setColor(bordercolor);
            g.setStroke(new BasicStroke(3));
            g.drawRect(x-xOffset, y-calculated_yOffset, w+xOffset+xOffset, h+(2*yOffset));
        }

        g.setColor(Color.BLACK);
        g.drawString(text, x, y-(font == null ? 0 : (font.getSize()/2)));
    }

    public void setFont(Font font) {
        this.font = font;
    }

    public void setForecolor(Color forecolor) {
        this.forecolor = forecolor;
    }

    public void setBorderColor(Color bordercolor) {
        this.bordercolor = bordercolor;
    }

    public void setInfillColor(Color infillcolor) {
        this.infillcolor = infillcolor;
    }
}
