package de.ichmagomaskekse.uiengine.graphics.ui.sampleapp;

import de.ichmagomaskekse.uiengine.graphics.ui.UIC;
import de.ichmagomaskekse.uiengine.graphics.ui.components.XButton;
import de.ichmagomaskekse.uiengine.graphics.ui.components.XLabel;

import java.awt.*;
import java.lang.reflect.Array;
import java.util.ArrayList;

public class SampleAppUi1 {

    private ArrayList<UIC> uics = new ArrayList<>();

    public SampleAppUi1() {
        XLabel lbl = new XLabel("C O D I N G    T I M E R", 0, 20, "Bahnschrift Light", Font.PLAIN, 24);
        lbl.setForecolor(Color.WHITE);
        uics.add(lbl);
        XButton btn = new XButton("Start", 100, 144, 50, 24, 50, 10);
        btn.setFont(new Font("Bahnschrift Light", Font.PLAIN, 24));
        btn.setBorderColor(new Color(105, 105, 105));
        btn.setInfillColor(new Color(143, 143, 143));
        uics.add(btn);
    }

    public void tick() {
        if(!uics.isEmpty()) {
            for(UIC uic : uics) uic.tick();
        }
    }

    public void render(Graphics2D g) {
        if(!uics.isEmpty()) {
            for(UIC uic : uics) uic.render(g);
        }
    }

}
