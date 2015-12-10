package main;

import java.io.File;
import javax.swing.Timer;
import plugin.PluginFinder;
import view.Window;

public class Main {

    public static void main(String[] args) {
        Window w = new Window();

        PluginFinder pf = new PluginFinder(new File(System.getProperty("java.class.path") + "/plugins"), w.getTools(), w.getTextArea());
        pf.addObserver(w);
        Timer timer = new Timer(1000, pf);
        timer.start();

        w.setVisible(true);
        w.pack();
    }
}
