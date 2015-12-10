/**
 * @author : thegroup
 * Window : this class represents the windows of graphical interface
 */
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Observable;
import java.util.Observer;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class Window extends JFrame implements Observer {

    /**
	 * this class had 5 attributes
	 * - serialVerionUID : an id
	 * - text : the textarea where the user can write
	 * - jsp : the scroll pane
	 * - menu : the menu of windows
	 */
	private static final long serialVersionUID = 6353669783404880748L;
	private JTextArea text = new JTextArea();
    private JScrollPane jsp = new JScrollPane(text);
    private JMenuBar menu = new JMenuBar();
    private JMenu tools = new JMenu("Tools");

    /**
     * Window constructor
     * construct a windows with a title a size and the different object
     */
    public Window() {
        this.setTitle("Extendable Editor");
        this.setResizable(false);
        this.setPreferredSize(new Dimension(500, 300));

        initMenu();

        this.setJMenuBar(menu);
        this.getContentPane().add(jsp);

        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    /**
     * this method is use for init the menu on the window
     */
    public void initMenu() {
        JMenu file = new JMenu("File");
        JMenu help = new JMenu("Help");
        JMenuItem close = new JMenuItem("Close");

        menu.add(file);
        menu.add(tools);
        menu.add(help);
        file.add(close);
    }

    /**
     * getter for tools attribute
     * @return the tools menu
     */
    public JMenu getTools() {
        return tools;
    }

    /**
     * getter for textarea attribute
     * @return the textarea attribute
     */
    public JTextArea getTextArea() {
        return text;
    }

    @Override
    public void update(Observable o, Object arg) {
        createMenuItem((Class<?>) arg);
    }

    private void createMenuItem(Class<?> cl) {
        try {
            final Object o = cl.newInstance();
            final Method transform = cl.getMethod("transform", String.class);
            Method getLabel = cl.getMethod("getLabel");
            String label = (String) getLabel.invoke(o);

            JMenuItem jmi = new JMenuItem(label);
            jmi.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    try {
                        String newLabel = (String) transform.invoke(o, text.getText());
                        text.setText(newLabel);
                    } catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException e1) {
                        e1.printStackTrace();
                    }
                }
            });
            tools.add(jmi);

        } catch (InstantiationException | IllegalAccessException | NoSuchMethodException | SecurityException | IllegalArgumentException | InvocationTargetException e1) {
            e1.printStackTrace();
        }
    }
}
