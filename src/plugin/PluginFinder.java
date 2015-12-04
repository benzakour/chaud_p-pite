/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package plugin;

import timer.MyTimer;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Quietlyben
 */
public class PluginFinder implements ActionListener {
    
    protected PluginFilter pf;
    protected final File DIR;
    protected MyTimer timer;
    protected ArrayList<File> files;

    public PluginFinder(File dir) {
        this.pf = new PluginFilter();
        this.DIR = dir;
        this.timer = new MyTimer(this);
    }
    
    public void start(){
        
    }
    
    public List getFiles(){
        File[] filesInDirectory = this.DIR.listFiles(this.pf);
        if(filesInDirectory == null || filesInDirectory.length == 0){
            return new ArrayList();
        } else {
            List list = new ArrayList();
            for(File file : filesInDirectory){
                list.add(file);
            }
            return list;
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }    
}
