	@Test
	public void deveAlugarFilme_SemCalcularValor() throws Exception{
		//cenario
		Usuario usuario = umUsuario().agora();
		List<Filme> filmes = Arrays.asList(umFilme().agora());
		
		
		//quero que retorne o valor 1.0 quando eu chamar o método calcularValorLocacao da classe que estou esperando o comportamento (service) passando o valor "filmes"
		//obs: calcularValorLocacao é um método privado
		PowerMockito.doReturn(1.0).when(service, "calcularValorLocacao", filmes);
		
		
		//acao
		Locacao locacao = service.alugarFilme(usuario, filmes);
		
		//verificacao
		Assert.assertThat(locacao.getValor(), is(1.0));
		PowerMockito.verifyPrivate(service).invoke("calcularValorLocacao", filmes);
	}
	
	
	
	------------------------------------
	Obs: lá em cima na classe LocacaoServiceTest.java temos que definir o Spy:
	@Before
	public void setup(){
		MockitoAnnotations.initMocks(this);
		service = PowerMockito.spy(service);    //<--- essa linha é nova
	}
