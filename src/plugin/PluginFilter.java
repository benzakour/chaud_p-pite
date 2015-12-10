package plugin;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import plugins.Plugin;
import java.io.File;
import java.io.FilenameFilter;
import java.lang.reflect.Constructor;

/**
 *
 * @author barbe
 */
public class PluginFilter implements FilenameFilter {

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
        if (!isClass(filename)) {
            return false;
        } else {
            Class<?> fileClass = getClass(filename);
            return extendsPlugin(fileClass) && hasEmptyConstructor(fileClass);
        }
    }

    /**
     * Check if the file is a class file
     *
     * @param filename
     */
    protected boolean isClass(String filename) {
        return filename.endsWith(".class");
    }

    /**
     * Return the class of a file
     *
     * @param filename
     */
    protected Class<?> getClass(String filename) {
        String classname = filename.replaceFirst("\\.class$", "");
        try {
            return Class.forName("plugins." + classname);
        } catch (ClassNotFoundException e) {
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
     * Check if the class has an empty constructor
     *
     * @param class The class file
     * @return {@code true} if it has, {@code false} if not
     */
    private boolean hasEmptyConstructor(Class<?> cl) {
        Constructor<?>[] constructors = cl.getConstructors();
        for (Constructor<?> cons : constructors) {
            if (cons.getParameterTypes().length == 0) {
                return true;
            }
        }
        return false;
    }
}
