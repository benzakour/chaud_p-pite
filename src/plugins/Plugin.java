/**
 * Plugin : this interface represent the different action of a plugin
 */
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package plugins;

/**
 *
 * @author Quietlyben
 */
public interface Plugin {

	/**
	 * transform the current string to an other which implements in this method
	 * @param currentString
	 * @return the current string tansform
	 */
    public String transform(String curentString);
    
    /**
     * get the label of the plugin
     * @return the plugin name
     */
    public String getLabel();
}
