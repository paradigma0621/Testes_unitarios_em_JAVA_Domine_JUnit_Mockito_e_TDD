//Obs para entender esse caso: a chamada do "new Date()" não vem do construtor Date(), mas sim de um método static de dentro
//da classe LocacaoService.java: ex1: Date dataEntrega = Calendar.getInstance().getTime();
//ex2: 	locacao.setDataLocacao(Calendar.getInstance().getTime());
	@Test
	public void deveAlugarFilme() throws Exception {
		//cenario
		Usuario usuario = umUsuario().agora();
		List<Filme> filmes = Arrays.asList(umFilme().comValor(5.0).agora());
		
//		PowerMockito.whenNew(Date.class).withNoArguments().thenReturn(DataUtils.obterData(28, 4, 2017));
		Calendar calendar = Calendar.getInstance();
		calendar.set(Calendar.DAY_OF_MONTH, 28);
		calendar.set(Calendar.MONTH, Calendar.APRIL);
		calendar.set(Calendar.YEAR, 2017);
		PowerMockito.mockStatic(Calendar.class);
		PowerMockito.when(Calendar.getInstance()).thenReturn(calendar);
		
		//acao
		Locacao locacao = service.alugarFilme(usuario, filmes);
			

		//verificacao1
		error.checkThat(locacao.getValor(), is(equalTo(5.0)));
//		error.checkThat(locacao.getDataLocacao(), ehHoje());
//		error.checkThat(locacao.getDataRetorno(), ehHojeComDiferencaDias(1));
		error.checkThat(DataUtils.isMesmaData(locacao.getDataLocacao(), DataUtils.obterData(28, 4, 2017)), is(true));
		error.checkThat(DataUtils.isMesmaData(locacao.getDataRetorno(), DataUtils.obterData(29, 4, 2017)), is(true));
		
		
		
		//verificacao2.... de outro método da classe (obs:de outra data)
		//PowerMockito.verifyStatic(); //Para verificar se o método static "Calendar.getInstance();" abaixo está sendo chamado 1 vez:
		PowerMockito.verifyStatic(Mockito.times(2)); //Idem acima, mas sendo chamado 2 vezes
		Calendar.getInstance();
		
		
	}
