package de.ichmagomaskekse.uiengine.graphics.ui.components;

import de.ichmagomaskekse.uiengine.graphics.ui.UIC;
import de.ichmagomaskekse.uiengine.graphics.ui.UICManager;
import de.ichmagomaskekse.uiengine.graphics.ui.UICType;

import java.awt.*;

public class XLabel extends UIC {

    private Font font;
    private String text = "Unknown text";
    private Color forecolor;

    public XLabel(String name, int x, int y, String fontName, int style, int fontSize) {
        super(UICType.LABEL, name, x, y, 0, 0);
        this.text = name;
        this.font = new Font(fontName, style, fontSize);
        this.forecolor = Color.BLACK;
    }

    @Override
    public void tick() {
        enabled = UICManager.isRegistered(this);
    }

    @Override
    public void draw(Graphics2D g) {
        if(font != null) g.setFont(font);
        if(forecolor != null) g.setColor(forecolor);
        g.drawString(text, x, y);
    }

    public void setForecolor(Color forecolor) {
        this.forecolor = forecolor;
    }

    public void setFont(Font font) {
        this.font = font;
    }
}
