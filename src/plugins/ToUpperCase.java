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
public class ToUpperCase implements Plugin {

    @Override
    public String transform(String s) {
        return s.toUpperCase();
    }

    @Override
    public String getLabel() {
        return "To Upper Case";
    }
}
