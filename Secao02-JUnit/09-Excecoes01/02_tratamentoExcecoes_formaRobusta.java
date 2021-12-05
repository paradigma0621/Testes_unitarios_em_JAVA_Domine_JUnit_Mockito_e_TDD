package br.ce.wcaquino.servicos;


import br.ce.wcaquino.entidades.Filme;
import br.ce.wcaquino.entidades.Locacao;
import br.ce.wcaquino.entidades.Usuario;
import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ErrorCollector;
import org.junit.rules.ExpectedException;

import java.util.Date;

import static br.ce.wcaquino.utils.DataUtils.isMesmaData;
import static br.ce.wcaquino.utils.DataUtils.obterDataComDiferencaDias;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class LocacaoServiceTest {

	@Rule
	public ErrorCollector error = new ErrorCollector(); //não sei se precisa desse import por caso do "is()"
	
	@Test 
	public void testLocacao_filmeSemEstoque_2() { //Da mais controle sobre como trabalhar com a excecao
		//cenario
		LocacaoService service = new LocacaoService();
		Usuario usuario = new Usuario("Usuario 1");
		Filme filme = new Filme("Filme 2", 0, 4.0);
		
		//acao
		try {
			service.alugarFilme(usuario, filme);
			Assert.fail("Deveria ter lancado uma excecao");
		} catch (FilmeSemEstoqueException e) {
			assertThat(e.getMessage(), is("Filme sem estoque"));
		}
		
		System.out.println("A robusta continua rodando depois!!");
	}
}


/*Obs: dentro de LocacaoService.java do projeto TestesUnitarios+-+fim tem uma parte que tem:
	public Locacao alugarFilme(Usuario usuario, Filme filme) throws FilmeSemEstoqueException {
		if(filme.getEstoque() == 0) {
			throw new FilmeSemEstoqueException("Filme sem estoque");
		}
*/
