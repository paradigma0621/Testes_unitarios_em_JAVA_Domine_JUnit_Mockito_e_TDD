	@Test
	public void naoDeveAlugarFilmeParaNegativadoSPC() throws FilmeSemEstoqueException, LocadoraException{
		//cenario
		Usuario usuario = umUsuario().agora();
		Usuario usuario2 = umUsuario().comNome("Usuario 2").agora();
		List<Filme> filmes = Arrays.asList(umFilme().agora());
		
		when(spc.possuiNegativacao(usuario)).thenReturn(true);    //vao dizer ao Mock como se comportar quando 
									//passarmos o Usuario "usuario" para o método 
									//possuiNegativacao(), com argumento "usuario"
								//Obs: se chamarmos service.alugarFilme(usuario2, filmes); 
								//por não ser mais o "usuario" definido no when, processa
								//retornando valor padrão do mock (null,0,false,"",...).
								//É verificado pelo "equals()" se os argumentos passados
								//no chamado do método são os mesmos definidos no when()
		
		exception.expect(LocadoraException.class);
		exception.expectMessage("Usuário Negativado");
		
		//acao
		service.alugarFilme(usuario, filmes);
	}
