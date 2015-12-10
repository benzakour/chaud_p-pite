/**
 * @author theGroup
 * ToLowerCase : this class represent toLowerCase plugin
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
public class ToLowerCase implements Plugin {

	/**
	 * this method transform the selected string to a lower case string
	 * @return a lower case string
	 */
    @Override
    public String transform(String s) {
        return s.toLowerCase();
    }

    /**
     * get the label of the plugin
     * @return the plugin name "To Lower Case"
     */
    @Override
    public String getLabel() {
        return "To Lower Case";
    }
    
}
