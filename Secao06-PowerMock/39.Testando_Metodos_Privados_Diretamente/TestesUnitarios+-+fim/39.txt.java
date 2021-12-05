	@Test
	public void deveCalcularValorLocacao() throws Exception{
		//cenario
		List<Filme> filmes = Arrays.asList(umFilme().agora());
		
		//acao
		Double valor = (Double) Whitebox.invokeMethod(service, "calcularValorLocacao", filmes); //obs whitebox tem
							//import tanto a partir do mockito como do powermock. Deve-se 
							//importar a do powermock. Desse modo consegue-se executar o
							//método privado calcularValorLocacao passando por argumento o
							//o atributo "filmes". Parece que o whitebox retorna um Objetct - se-
							//rá preciso fazer cast.
							
		
		//verificacao
		Assert.assertThat(valor, is(4.0));
	}
