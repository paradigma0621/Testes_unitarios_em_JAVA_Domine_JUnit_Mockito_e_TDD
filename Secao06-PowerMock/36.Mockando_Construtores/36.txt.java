
@Test
public void deveAlugarFilme() throws Exception {
	
	//Abaixo: Quando eu mockar uma new Date() (sem argumentos) dentro da classe Service do projeto main: ele vai ser
	//instânciada conforme eu definir:
	PowerMockito.whenNew(Date.class).withNoArguments().thenReturn(DataUtils.obterData(28, 4, 2017));
---------------------------------------	
	//Porém, pra funcionar temos que colocar uma annotation em cima da declaração da classe de Test:
	@RunWith(PowerMockRunner.class)
	public class LocacaoServiceTest {
---------------------------------------	
	//Porém, pra funcionar temos que colocar mais uma annotation em cima da declaração da classe de Test:
	@RunWith(PowerMockRunner.class)
	@PrepareForTest(LocacaoService.class)  //e pq LocacaoService.class?? Porque é nela que queremos
						//que as datas (new Date()) sejam inseridas conforme desejarmos
	public class LocacaoServiceTest {

---------------------------------------	
	//Outro caso:
	@RunWith(PowerMockRunner.class)
	@PrepareForTest({LocacaoService.class, DataUtils.class})  //e pq DataUtils.class?? Porque queremos que em ambas
								//classes onde as datas (new Date()) sejam inseridas
								//seja feito o mock com a data conforme desejamos
	public class LocacaoServiceTest {
------------------------------------------------------------------------------------------
//Caso eu quisesse verificar se o construtor foi chamado (ver seção "verificação" do Test abaixo:)
	
	@Test
	public void deveDevolverNaSegundaAoAlugarNoSabado() throws Exception{
		//cenario
		Usuario usuario = umUsuario().agora();
		List<Filme> filmes = Arrays.asList(umFilme().agora());
		
		PowerMockito.whenNew(Date.class).withNoArguments().thenReturn(DataUtils.obterData(29, 4, 2017));
		
		//acao
		Locacao retorno = service.alugarFilme(usuario, filmes);
		
		//verificacao
		assertThat(retorno.getDataRetorno(), caiNumaSegunda());
		//PowerMockito.verifyNew(Date.class).withNoArguments(); //verifica se foi executado 1 vez
		PowerMockito.verifyNew(Date.class, Mockito.times(2)).withNoArguments(); //verifica se foi executado 2 vez
				///Obs: na linha acima: observar como interação do PowerMockito com o Mockito é boa!
	}
