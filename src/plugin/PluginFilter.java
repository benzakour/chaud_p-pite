
/**
 * @author TheGroup
 * PluginFilter : this class is use the filter the different file iin a directories
 * we want to take all file where extension is <strong>.class</strong>
 */

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package plugin;

import plugins.Plugin;
import java.io.File;
import java.io.FilenameFilter;
import java.lang.reflect.Constructor;

public class PluginFilter implements FilenameFilter {

	/**
	 * pluginFilter constructor
	 */
    public PluginFilter() {
    }

    /**
     * Check if the file is a correct plugin file
     *
     * @param directory The directory where search
     * @param filename The file to check if is a correct plugin
     */
    @Override
    public boolean accept(File dir, String filename) {
        if (!isClass(filename))
            return false;
        else {
            Class<?> fileClass = getClass(filename);
            return (extendsPlugin(fileClass) && packagePlugin(fileClass) && hasEmptyConstructor(fileClass));
        }
    }

    /**
     * Check if the file is a class file
     * 
     * @param filename
     * @return true : is class name
     * @return false : is not a class name 
     */
    protected boolean isClass(String filename) {
        return filename.endsWith(".class");
    }

    /**
     * Return the class of a file
     * 
     * @param filename
     * @return the class file
     * @throws ClassNotFoundException
     */
    protected Class<?> getClass(String filename) {
        String classname = filename.replaceFirst("\\.class$", "");
        try {
            return Class.forName("plugins." + classname);
        }catch (ClassNotFoundException e) {
        	e.printStackTrace();
        }
        return null;
    }

    /**
     * Check if the class implements the Plugin interface
     *
     * @param class The class file
     * @return {@code true} if implements, {@code false} if not
     */
    protected boolean extendsPlugin(Class<?> theClass) {
        return Plugin.class.isAssignableFrom(theClass);
    }

    /**
     * check if the class is in the plugin package
     * @param theClass : the class use to know if is a Plugins package
     * @return {@code true} if is in package
     * @return {@code false} if not
     */
    public boolean packagePlugin(Class<?> theClass){
    	return theClass.getPackage().equals(Plugin.class.getPackage());
    }
    /**
     * Check if the class has an empty constructor
     *
     * @param class The class file
     * @return {@code true} if it has, {@code false} if not
     */
    private boolean hasEmptyConstructor(Class<?> theClass) {
        Constructor<?>[] constructors = theClass.getConstructors();
        for (Constructor<?> cons : constructors) {
            if (cons.getParameterTypes().length == 0) {
                return true;
            }
        }
        return false;
    }
}
