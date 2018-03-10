

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class ColaEntradaTest {
	ColaEntrada c= ColaEntrada.getColaEntrada();
	@Before
	public void setUp() throws Exception {
		
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testComprobarColaCompleta() {
		c.revisarCola();
	}

}
