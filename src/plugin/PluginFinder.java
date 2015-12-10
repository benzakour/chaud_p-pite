/**
 * @author theGroup
 * Plugin finder : this class represent 
 */
package plugin;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.ArrayList;
import java.util.Observable;

import javax.swing.JMenu;
import javax.swing.JTextArea;

public class PluginFinder extends Observable implements ActionListener {

	/**
	 * this class had 3 attributes
	 * - pf : the plugin filter
	 * - dpath : the pathname of the current directory
	 * - plugins : a list of all plugins find in the plugin's path
	 */
    protected PluginFilter pf;
    protected File dPath;
    protected ArrayList<Class<?>> plugins;

    /**
     * PluginFinder constructor
     * @param f
     * @param jMenu
     * @param jta
     */
    public PluginFinder(File f, JMenu jMenu, JTextArea jta) {
        this.pf = new PluginFilter();
    	this.dPath = f;
        this.plugins = new ArrayList<Class<?>>();
    }

    /**
     * thi method allows to have the list of all file in directories
     * @return the list of all file in directories
     */
    File[] listPluginFile() {
        return dPath.listFiles(pf);
    }

    /**
     * method which use when an action is call
     * this method look all file in a directories and checked if the file had <strong>.class</strong> extension.
     * if the plugins exist meaning is present in the plugins list, method do nothing else she had this class in the list
     * and update the bar menu     * 
     */
    public void actionPerformed(ActionEvent e) {
        File[] liste = listPluginFile();
        for (int i = 0; i < liste.length; i++) {
            File current = liste[i];// recup le fichier courant
            String pName = current.getName().substring(0, current.getName().length() - 6); //retire l'extension.class
            try {
                Class<?> className = Class.forName("plugins." + pName); //cree la class associ� au nom
                if (!existPlugin(className)) {//test si le plugin n'existe aps deja
                    plugins.add(className);
                    notifyObservers(className);// on previent la barre de menu qu'il y a un nouveau plugin
                    //createMenuItem(className);
                }
            } catch (ClassNotFoundException e1) {
                e1.printStackTrace();
            }
        }
    }

    /**
     * verify if a plugins exist in the list
     * @param pluginClass : the plugin class check in the list
     * @return True : if exist
     * @return False : if is'not exist
     */
    private boolean existPlugin(Class<?> cl) {
        return plugins.contains(cl);
    }

    @Override
    public void notifyObservers(Object o) {
        setChanged();
        super.notifyObservers(o);
    }

}
