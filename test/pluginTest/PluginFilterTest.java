package pluginTest;

import static org.junit.Assert.*;

import java.io.File;

import org.junit.Before;
import org.junit.Test;

import plugin.PluginFilter;

public class PluginFilterTest {

	PluginFilter pf;
	File dir1;
	File dir2;
	String filename1;
	String filename2;
	@Before 
	public void creatBefore(){
		dir1 = new File("../../bin/plugins");
		filename1 = "ToUpperCase.class";
		dir2= new File("../../bin/plugin");
		filename2= "MyListener.class";
		pf= new PluginFilter();
	}
	@Test
	public void testAccept() {
		assertTrue(pf.accept(dir1,filename1));
		assertFalse(pf.accept(dir2, filename2));
	}

}
 

