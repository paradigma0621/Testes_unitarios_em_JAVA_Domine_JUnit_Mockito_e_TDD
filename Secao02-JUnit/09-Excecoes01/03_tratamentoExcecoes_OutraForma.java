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
	public ExpectedException exception = ExpectedException.none();
	

	@Test
	public void testLocacao_filmeSemEstoque_3() throws FilmeSemEstoqueException {
		//cenario
		LocacaoService service = new LocacaoService();
		Usuario usuario = new Usuario("Usuario 1");
		Filme filme = new Filme("Filme 2", 1, 4.0);
		
		exception.expect(FilmeSemEstoqueException.class);
		exception.expectMessage("Filme sem estoque");
		
		//acao
		service.alugarFilme(usuario, filme);
		
		
		System.out.println("Esse código nunca é executado. Para continuar executando depois da verificação da exceção: usar a forma robusta");
	}
}


/*Obs: dentro de LocacaoService.java do projeto TestesUnitarios+-+fim tem uma parte que tem:
	public Locacao alugarFilme(Usuario usuario, Filme filme) throws FilmeSemEstoqueException {
		if(filme.getEstoque() == 0) {
			throw new FilmeSemEstoqueException("Filme sem estoque");
		}
*/
