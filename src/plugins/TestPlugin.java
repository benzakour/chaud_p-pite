/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package plugins;

public class TestPlugin implements Plugin {

    public TestPlugin() {
    }

    @Override
    public String transform(String s) {
        String res = "";
        for (int i = 0; i < s.length(); i++) {
            if (i % 2 == 0) {
                res = res + s.charAt(i);
            }
        }
        return res;
    }

    @Override
    public String getLabel() {
        return "Test";
    }
}
