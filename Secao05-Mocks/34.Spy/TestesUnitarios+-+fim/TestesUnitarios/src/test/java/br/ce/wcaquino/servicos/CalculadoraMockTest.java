package br.ce.wcaquino.servicos;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.Spy;


public class CalculadoraMockTest {
	
	@Mock
	private Calculadora calcMock;
	
	@Spy
	private Calculadora calcSpy;
	
	@Mock
	private EmailService email;
	
	@Before
	public void setup(){
		MockitoAnnotations.initMocks(this);
	}
	
	@Test
	public void devoMostrarDiferencaEntreMockSpy(){


		System.out.println("Mock0:" + calcMock.somar(1, 2)); //saída: Mock:5
		System.out.println("Spy0:" + calcSpy.somar(1, 2)); //saída: Spy:5


		System.out.println("Mock1");
		calcMock.imprime();
		System.out.println("Spy1");
		calcSpy.imprime();

		Mockito.when(calcMock.somar(1, 2)).thenReturn(5);
	Mockito.when(calcSpy.somar(1, 2)).thenReturn(5);
		Mockito.doReturn(5).when(calcSpy).somar(1, 2);
		Mockito.doNothing().when(calcSpy).imprime();
		
		System.out.println("Mock2:" + calcMock.somar(1, 2));
		System.out.println("Spy2:" + calcSpy.somar(1, 2));
		
		System.out.println("Mock3");
		calcMock.imprime();
		System.out.println("Spy3");
		calcSpy.imprime();
	}
	
	
	
	@Test
	public void teste(){
		Calculadora calc = Mockito.mock(Calculadora.class);
		
		ArgumentCaptor<Integer> argCapt = ArgumentCaptor.forClass(Integer.class);
		Mockito.when(calc.somar(argCapt.capture(), argCapt.capture())).thenReturn(5);
		
		Assert.assertEquals(5, calc.somar(134345, -234));
//		System.out.println(argCapt.getAllValues());
	}
}
