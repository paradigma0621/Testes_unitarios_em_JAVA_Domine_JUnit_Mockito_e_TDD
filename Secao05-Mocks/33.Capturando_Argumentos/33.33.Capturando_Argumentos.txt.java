	
	@Test
	public void deveProrrogarUmaLocacao(){
		//cenario
		Locacao locacao = umLocacao().agora();
		
		//acao
		service.prorrogarLocacao(locacao, 3); ///aqui passamos a "locacao", objeto de nosso monitoramento
						//Porém o método prorrogarLocacao() é void, e não teremos mais a referência
						//do nosso o objeto "locacao", pois a mesma foi clonada com nova roupagem
						//dentro do método prorrogarLocacao()
	
		
		//verificacao
		ArgumentCaptor<Locacao> argCapt = ArgumentCaptor.forClass(Locacao.class);
		Mockito.verify(dao).salvar(argCapt.capture()); //como verificar se o objeto "locacao" que mencionamos ali 
								//em cima estará salvo aqui:
								//Mockito.verify(dao).salvar(locacao)  ??
								// Solução
								//O ArgumentCaptor da linha de cima resolve
								
		Locacao locacaoRetornada = argCapt.getValue();
		
		error.checkThat(locacaoRetornada.getValor(), is(12.0));
		error.checkThat(locacaoRetornada.getDataLocacao(), ehHoje());
		error.checkThat(locacaoRetornada.getDataRetorno(), ehHojeComDiferencaDias(3));
	}
	
	-------------------------------------------------- OUTRO EXEMPLO: O da CalculadoraMockTest:
		@Test
	public void teste(){
		Calculadora calc = Mockito.mock(Calculadora.class);
		
		ArgumentCaptor<Integer> argCapt = ArgumentCaptor.forClass(Integer.class);
		Mockito.when(calc.somar(argCapt.capture(), argCapt.capture())).thenReturn(5);
		
		Assert.assertEquals(5, calc.somar(134345, -234));
		System.out.println(argCapt.getAllValues());  //mostra os 2 valores que foram passados pro método somar()
	}
