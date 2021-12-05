	@Mock
	Calculadora calcMock;
	
	@Spy
	Calculadora calcSpy;
	
	
	@Test
	public void devoMostrarDiferencaEntreMockSpy(){
	
		Mockito.when(calcMock.somar(1, 2)).thenReturn(5);
		Mockito.when(calcSpy.somar(1, 2)).thenReturn(5);

		System.out.println("Mock:" + calcMock.somar(1, 2)); //saída: Mock:5
		System.out.println("Spy:" + calcSpy.somar(1, 2)); //saída: Spy:5
		
		
		System.out.println("Mock:" + calcMock.somar(2, 6)); //saída: Mock:0
		System.out.println("Spy:" + calcSpy.somar(2, 6)); //saída: Spy:8   .... quando não há expectativa programada
								//ele executa o método. Por conta disso o Spy não funciona
								//com Interfaces, mas apenas com classes concretas
		
		//Caso queiramos que um Mock chame a implementação real de um método: é possível
		Mockito.when(calcMock.somar(3, 4)).thenCallRealMethod();//assim como o Spy, esse método não funciona para Interfaces
		System.out.println("Mock:" + calcMock.somar(3, 4)); //saída: Mock:7.
		
		
		System.out.println("Mock");
		calcMock.imprime(); //imprime() é um método void da calculadora. Como é um Mock que chama, ele não executa
		System.out.println("Spy");
		calcSpy.imprime();//imprime() é um método void da calculadora. Como é um Spy que chama, ele o executa
	}
	
	
		Mockito.when(calcMock.somar(1, 2)).thenReturn(5);
		Mockito.when(calcSpy.somar(1, 2)).thenReturn(5); //Há uma ordem de precedência nessa chamada: ele executará
								//tudo o que estiver em somar(1,2) (calcSpy.somar(1, 2))
								//(que no código do professor faz um Sysout pra tela, pra 
								//provar) e depois definirá que a some de 1,2 deve retornar
								//o valor 5.
		
		Mockito.doReturn(5).when(calcSpy).somar(1, 2); //Já nessa atribuição ele não executa o somar(1,2) do Spy
								//Apenas programa o valor de retorno
					
		
		Mockito.doNothing().when(calcSpy).imprime(); // programa o Spy para não executar o método quando for chamado
								
		System.out.println("Mock:" + calcMock.somar(1, 2));
		System.out.println("Spy:" + calcSpy.somar(1, 2));
		
	
		System.out.println("MockOutro");
		calcMock.imprime(); //imprime() é um método void da calculadora. Como é um Mock que chama, ele não executa
		System.out.println("SpyOutro");
		calcSpy.imprime();//imprime() é um método void da calculadora. Como é um Spy que chamaria, mas foi dito na
					// linha: Mockito.doNothing().when(calcSpy).imprime();   pra não chamá-lo - então
					//esse imprime() não faz nada
	}
