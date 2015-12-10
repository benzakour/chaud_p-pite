package plugins;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class CesarPalace1Test {

	protected String chaine1;
	protected String chaine2;
	protected String chaine3;
	protected CesarPalace1 cp1;
	
	@Before
	public void CreateCesarePalace(){
		this.cp1 = new CesarPalace1();
		this.chaine1 = "chaud pepite";
		this.chaine2 = "BONJOUR MONSIEUR";
		this.chaine3 = "Un 20 S'iL vOuS pLaIt";
	}
	@Test
	public void transformTest() {
		String nouvel1 = cp1.transform(this.chaine1);
		String nouvel2 = cp1.transform(this.chaine2);
		String nouvel3 = cp1.transform(this.chaine3);
		assertEquals("dibve qfqjuf", nouvel1);
		assertEquals("CPOKPVS NPOTJFVS", nouvel2);
		assertEquals("Vo 20 T'jM wPvT qMbJu", nouvel3);
	}

	@Test
	public void getLabelTest(){
		assertEquals("Cesar Palace 1", cp1.getLabel());
	}
}
