package packTest;



import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import packModelo.packCartas.CartaAnimal;
import packModelo.packCartas.PuertaDelCielo;

public class PuertaDelCieloTest {
	CartaAnimal c= new CartaAnimal();
	PuertaDelCielo p= PuertaDelCielo.getPuertaDelCielo();
	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testAdd() {
		p.add(c);
	}

}