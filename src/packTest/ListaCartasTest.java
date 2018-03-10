package packTest;



import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import packModelo.packCartas.CartaAnimal;
import packModelo.packCartas.ListaCartas;

public class ListaCartasTest {
	ListaCartas c= new ListaCartas();
	CartaAnimal c1= new CartaAnimal();
	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testLongitud() {
		System.out.println(c.longitud());
	}
	public void testConseguirCarta(){
		c.add(c1);
		c.conseguirCarta();
	}
	public void testUltimaCarta(){
		c.add(c1);
		c.ultimaCarta();
	}
}
