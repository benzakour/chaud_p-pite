package plugin;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.ArrayList;
import java.util.Observable;

import javax.swing.JMenu;
import javax.swing.JTextArea;

public class PluginFinder extends Observable implements ActionListener {

    PluginFilter pf = new PluginFilter();
    File dPath;
    ArrayList<Class<?>> plugins = new ArrayList<>();

    public PluginFinder(File f, JMenu jMenu, JTextArea jta) {
        this.dPath = f;
    }

    
    /**
     * List the files in the directory
     *
     *
     * @return an array of the files
     */
    File[] listPluginFile() {
        return dPath.listFiles(pf);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        File[] liste = listPluginFile();
        for (File file : liste) {
            String pName = file.getName().substring(0, file.getName().length() - 6); //retire l'extension.class
            try {
                Class<?> cl = Class.forName("plugins." + pName); //cree la class associ� au nom
                if (!existPlugin(cl)) {//test si le plugin n'existe aps deja
                    plugins.add(cl);
                    notifyObservers(cl);// on previent la barre de menu qu'il y a un nouveau plugin

                }
            } catch (ClassNotFoundException e1) {
                e1.printStackTrace();
            }
        }
    }

    private boolean existPlugin(Class<?> cl) {
        return plugins.contains(cl);
    }

    @Override
    public void notifyObservers(Object o) {
        setChanged();
        super.notifyObservers(o);
    }

}
