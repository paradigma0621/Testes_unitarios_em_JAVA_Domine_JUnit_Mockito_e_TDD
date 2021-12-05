package br.ce.wcaquino.suites;

import br.ce.wcaquino.servicos.CalculadoraTest;
import br.ce.wcaquino.servicos.CalculoValorLocacaoTest;
import br.ce.wcaquino.servicos.LocacaoServiceTest;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({
	CalculadoraTest.class,
	CalculoValorLocacaoTest.class,
	LocacaoServiceTest.class
})
public class SuiteExecucao {

	@AfterClass
	public static void rodaDepoisTudo() {  //TEM que ser static
		System.out.println("Depois tudo"); //não entendi ser after e rodar antes
		System.out.println("1");
		System.out.println("2");
	}

	@BeforeClass
	public static void rodaAntesTudo() {  //TEM que ser static
		System.out.println("Antes tudo");//não entendi ser before e rodar depois
	}

}
