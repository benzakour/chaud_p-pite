/**
 * @author theGroup
 * ToUpperCase : this class represent toUpperCase plugin
 */
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package plugins;

public class ToUpperCase implements Plugin {

	/**
	 * this method transform the selected string to a upper case string
	 * @return an upper case string
	 */
    @Override
    public String transform(String currentString) {
        return currentString.toUpperCase();
    }

    /**
     * get the label of the plugin
     * @return the plugin name
     */
    @Override
    public String getLabel() {
        return "To Upper Case";
    }
}
