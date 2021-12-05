import br.ce.wcaquino.entidades.Usuario;
import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ErrorCollector;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;

public class AssertTest {

	@Rule
	public ErrorCollector error = new ErrorCollector();

	@Test
	public void test() {

		//verificacao
		error.checkThat(1, is(equalTo(5.0)));
		error.checkThat(1, is(equalTo(5.0)));
		error.checkThat(2, is(equalTo(2)));
		error.checkThat(2, is(equalTo(1.0)));
		error.checkThat(2, is(equalTo(2)));
		error.checkThat(2, is(equalTo(2)));

	}


	@Test
	public void test2(){
		Assert.assertTrue(true);
		Assert.assertFalse(false);

		Assert.assertEquals("Erro de comparacao", 1, 1);
		Assert.assertEquals(0.51234, 0.512, 0.001);
		Assert.assertEquals(Math.PI, 3.14, 0.01);

		int i = 5;
		Integer i2 = 5;
		Assert.assertEquals(Integer.valueOf(i), i2);
		Assert.assertEquals(i, i2.intValue());



		Assert.assertEquals("bola", "bola");
		Assert.assertNotEquals("bola", "casa");
		Assert.assertTrue("bola".equalsIgnoreCase("Bola"));
		Assert.assertTrue("bola".startsWith("bo"));

		Usuario u1 = new Usuario("Usuario 1");
		Usuario u2 = new Usuario("Usuario 1");
		Usuario u3 = null;

		Assert.assertEquals(u1, u2);

		Assert.assertSame(u2, u2);
		Assert.assertNotSame(u1, u2);

		Assert.assertNull(u3);
		Assert.assertNotNull(u2);
	}
}
