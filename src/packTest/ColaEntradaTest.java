package packTest;


import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import packModelo.ColaEntrada;
import packModelo.EnumColor;
import packModelo.Animal.*;
import packModelo.packCartas.*;

public class ColaEntradaTest {
	@Before
	public void setUp() throws Exception {
		
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testComprobarColaCompleta() {
		ColaEntrada c= ColaEntrada.getColaEntrada();
		c.add(new CartaAnimal(" ",3,EnumColor.ROJO, new Leon()));
		c.add(new CartaAnimal(" ",3,EnumColor.ROJO, new Leon()));
		c.add(new CartaAnimal(" ",3,EnumColor.ROJO, new Leon()));
		c.add(new CartaAnimal(" ",3,EnumColor.ROJO, new Leon()));
		c.add(new CartaAnimal(" ",3,EnumColor.ROJO, new Leon()));
		assertTrue(c.revisarCola());
		
	}

}
