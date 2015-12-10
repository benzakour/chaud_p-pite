package pluginTest;

import static org.junit.Assert.*;

import java.io.File;

import javax.swing.JMenu;
import javax.swing.JTextArea;

import org.junit.Before;
import org.junit.Test;

import plugin.PluginFinder;

public class PluginFinderTest {

	PluginFinder pf ;
	File f;
	JMenu j;
	JTextArea jta;
	
	@Before
	public void createBefore(){
		f = new File("bin/plugins");
		j= new JMenu();
		jta = new JTextArea();
		pf = new PluginFinder(f, j, jta);
	}
	
}
