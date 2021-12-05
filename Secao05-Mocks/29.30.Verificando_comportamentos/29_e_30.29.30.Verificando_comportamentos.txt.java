No video 28 tinha:
	when(spc.possuiNegativacao(usuario)).thenReturn(true); //vale apenas para a instância de Usuario "usuario"
No vido 30 tem:
	when(spc.possuiNegativacao(Mockito.any(Usuario.class))).thenReturn(true); //vale para qualquer instância de Usuario
	
-------------------------------------------------------------------------------------

***	se um método que eu estou verificando possui mais de um parâmetro, se eu utilizar mathers em algum desses parâmetros, eu terei que usar em todos.
		Calculadora calc = Mockito.mock(Calculadora.class);
		Mockito.when(calc.somar(1,2)).thenReturn(5);
		System.out.println(calc.somar(1, 2));   // Saída:5

		Mockito.when(calc.somar(1, Mockito.anyInt())).thenReturn(5); // Saída: erro... tem que mockar
										// todos se mockar 1
		Mockito.when(calc.somar(Mockito.anyInt()), Mockito.anyInt()));   // ok
		
		Mockito.when(calc.somar(Mockito.eq(1), Mockito.anyInt())).thenReturn(5); //Mockito.eq(1) generaliza para 
										//para todos casos onde o primeiro parâmetro
										//vale 1. (eq vem de equals)
		System.out.println(calc.somar(1, 100000)); //saída: 5
--------------------------------------------------------------------------------------------------------	
	@Test
	public void deveEnviarEmailParaLocacoesAtrasadas(){
		//cenario
		Usuario usuario = umUsuario().agora();
		Usuario usuario2 = umUsuario().comNome("Usuario em dia").agora();
		Usuario usuario3 = umUsuario().comNome("Outro atrasado").agora();
		List<Locacao> locacoes = Arrays.asList(
				umLocacao().atrasada().comUsuario(usuario).agora(),
				umLocacao().comUsuario(usuario2).agora(),
				umLocacao().atrasada().comUsuario(usuario3).agora(),
				umLocacao().atrasada().comUsuario(usuario3).agora());
		when(dao.obterLocacoesPendentes()).thenReturn(locacoes);
		
		//acao
		service.notificarAtrasos();
		
		//verificacao
		verify(email, times(3)).notificarAtraso(Mockito.any(Usuario.class)); //forma enviados 3 emails, não importa
										//para quem
										
		verify(email).notificarAtraso(usuario);		//Diferente da estrutura do when(). No verify é
								//verify(mock).metodoqueestouchamando(parametro)
								//=verificar "email" se o método notificarAtraso foi chamado
								//passando por argumento "usuario"
								
		verify(email, Mockito.atLeastOnce()).notificarAtraso(usuario3);
		verify(email, Mockito.atLeast(2)).notificarAtraso(usuario3); //usuario3 recebeu no mínimo 2 emails
		verify(email, Mockito.atMost(5)).notificarAtraso(usuario3); //usuario3 recebeu no máximo 5 emails
		verify(email, never()).notificarAtraso(usuario2);  //fazer um caso onde o test não deveria passar:
								//é importante fazer o teste com um usuário para o qual não
								//foi enviado email, o que geraria não aprovação do teste
								//----
								 //verificar que o notificarAtraso() para o usuario2 nunca
								  //ocorreu. Ou seja: que não foi enviado email para o 
								  //usuario2

		verifyNoMoreInteractions(email);  	//verifica que não foi enviado emails além dos enviados ao 
							//usuario e usuario3... porém o instrutor da Udemy mostrou que
							//foi verificado que foi enviado o email "email" (ao "usuario") e 								//mais um outro, que suponho seja o do usuario3
								
	}
}
