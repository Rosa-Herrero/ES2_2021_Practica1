import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class MitjanaTest {

	private Mitjana instance; //Objecte a provar
    private short[] val; //1er argument d'entrada
    private short maxval; // 2on argument d'entrada
    private short[] resultObtingut; //retorn del mètode
    private short[] resultEsperat; //resultat esperat en el cas de prova
    

	@Before
	public void setUp() throws Exception {
		System.out.println("Before");
		instance = new Mitjana();
        val = new short[Mitjana.MAXVECTOR];
        resultEsperat = new short[3];
	}

	@Test
	public void testVectorNul() {
		System.out.println("Vector nul");
		try{
			resultObtingut = instance.calculMitjana(null, maxval);
			fail("Cal fallar per què el vector és nul");
		}catch(IllegalArgumentException e)
		{
			assertTrue(true);
		}
		catch(Exception e)
		{
			fail("Cal fallar per què el programa dona una excepció");
		}
	}
	@Test
	public void testMAXVECTOR() {
		System.out.println("MAXVECTOR");
		try{
			maxval = 1;
			val = new short[maxval];
			resultObtingut = instance.calculMitjana(val, maxval);
			fail("Cal fallar per què el vector no és de la longitud desitjada");
		}catch(IllegalArgumentException e)
		{
			assertTrue(true);
		}
		catch(Exception e)
		{
			fail("Cal fallar per què el programa dona una excepció");
		}
	}
	@Test
	public void testMaxVal() {
		System.out.println("maxval");
		try{
			maxval = Mitjana.MAXVECTOR + 1;
			resultObtingut = instance.calculMitjana(val, maxval);
			fail("Cal fallar per què el maxval es superior a la longitud");
		}catch(IllegalArgumentException e)
		{
			assertTrue(true);
		}
		catch(Exception e)
		{
			fail("Cal fallar per què el programa dona una excepció");
		}
	}
	
	@Test
	public void testMitjanaDecimals() {
		System.out.println("comprovació càlcul decimal");
		val[0] = 8;
		val[1] = 3;
		maxval = 2;
		resultObtingut = instance.calculMitjana(val, maxval);
		//Sortida esperada
        resultEsperat[0] = 10.5f;
        resultEsperat[1] = 2;
        resultEsperat[2] = 2;
        //comparar resultat obtingut amb l'esperat
        assertArrayEquals(resultEsperat, resultObtingut);
	}


}
