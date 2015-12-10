package plugins;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class CesarPalace13Test {

	protected String chaine1;
	protected String chaine2;
	protected String chaine3;
	protected CesarPalace13 cp13;
	
	@Before
	public void CreateCesarePalace(){
		this.cp13 = new CesarPalace13();
		this.chaine1 = "chaud pepite";
		this.chaine2 = "BONJOUR MONSIEUR";
		this.chaine3 = "Un 20 S'iL vOuS pLaIt";
	}
	@Test
	public void transformTest() {
		String nouvel1 = cp13.transform(this.chaine1);
		String nouvel2 = cp13.transform(this.chaine2);
		String nouvel3 = cp13.transform(this.chaine3);
		assertEquals("punhq crcvgr", nouvel1);
		assertEquals("OBAWBHE ZBAFVRHE", nouvel2);
		assertEquals("Ha 20 F'vY iBhF cYnVg", nouvel3);
	}

	@Test
	public void getLabelTest(){
		assertEquals("Cesar Palace 13", cp13.getLabel());
	}
}

