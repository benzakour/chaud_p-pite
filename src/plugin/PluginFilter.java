package plugin;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import java.io.File;
import java.io.FilenameFilter;

/**
 *
 * @author barbe
 */
public class PluginFilter implements FilenameFilter {

    public PluginFilter() {
    }

    @Override
    public boolean accept(File dir, String filename) {
        if(!isClass(filename))
            return false;
        else {
            Class<?> fileClass = getClass(filename);
            return extendsPlugin(fileClass);
        }
    }
    
    protected boolean isClass(String filename){
        return filename.endsWith(".class");
    }
    
    protected Class<?> getClass(String filename){
        String classname = filename.replaceFirst("\\.class$", "");
        try {
            return Class.forName("plugins." + classname);
        }
        catch (ClassNotFoundException e) {
        }
        return null;
  }
    
    protected boolean extendsPlugin(Class<?> theClass){
        return Plugin.class.isAssignableFrom(theClass);
    }
    
    
    
}
