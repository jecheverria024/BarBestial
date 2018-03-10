package packTest;



import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import packModelo.packCartas.CartaAnimal;
import packModelo.packCartas.EsLoQueHay;

public class EsLoQueHayTest {
	EsLoQueHay e= EsLoQueHay.getEsLoQueHay();
	CartaAnimal c= new CartaAnimal();
	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testAddLast() {
		e.addLast(c);
		System.out.println(e.getListCartas());
	}
	

}
