package texasHoldEm.Modelo.Beans;

import java.util.ArrayList;


import texasHoldEm.Modelo.*;



public class Jogo {

  // variavel que ira referencia a lista de todos os jogadores
	private ArrayList<Jogador> jogadores;
	 
	//variave que ira referenciar o jogador vencedor
	private Jogador vencedor;
	
	public Jogo(){ }
	
	
	/* Metodo que ira percorre toda a lista de jogadores 
	 * Classificando a mao de cada jogar caso ele ainda continue na partida.
	 */
	public void classificarMaoJogadores(){
		
		// variaval de referencia da classe Abstrata ClassificarMaoPoker recebe 
		// um objeto da classe concreta ClassificarMaoTexasHoldEm, para que seja feitoa 
		// a classificaçao de acordo com a implementacao de ClassificarMaoTexasHoldEm
		ClassificarMaoPoker poker = new ClassificarMaoTexasHoldEm();
		
		for( Jogador jogador : this.jogadores ){		
			
			//verifica se o jogador ainda esta na partida, se sim ele classifica a mao deste jogador
			if( !jogador.isForaPartida() ){	
				
				//verifica se a mao do jogador possui um "Flush"
				if ( poker.cincoCartasIguais( jogador ) ) {
	
				} else {
					
					//verifica se a mao do jogador possui um "Four of a kind"
					if ( poker.quatroCartasIguais( jogador ) ) {
	
					} else {
						
						//verifica se a mao do jogador possui um "Full House" ou um "Three of a Kind"
						if ( poker.tresCartasIguais( jogador ) ) {
	
						} else {
							
							//verifica se a mao do jogador possui um "Pair" ou um "Two Pair"
							if( poker.par(jogador) ){
								
							}else{
								
								//Caso ele chegue ate aqui entao ele ficara com as 
								//5 melhores cartas de sua mao
								poker.cartaAlta( jogador );
							}
						}
					}
	
				}
				
				//compara a mao do vencedor com a do jogador do loop
				if( vencedor == null || jogador.getValorTipoMao() > vencedor.getValorTipoMao() ){
					
					// se o jogador possuir a maior mao, ele sera o novo vencedor
					vencedor = jogador;			
				}else{
					
					//compara a mao do vencedor com a do jogador do loop
					if( vencedor == null || vencedor.getValorTipoMao() == jogador.getValorTipoMao() ){
						
						//chama o metodo para o desempate
						
					}
					
				}				
				
			}//1° if
				
		}//fim for
		
		// depois de classificar todas as mao, entao setar o jogador vencedor como true
		vencedor.setVencedor( true );
		
	}
	
	
	/*
	 * Metodos Getters e Setters
	 */
	public ArrayList<Jogador> getJogadores() {
		return jogadores;
	}
	
	public Jogador getVencedor() {
		return vencedor;
	}
	
	public void setJogadores(ArrayList<Jogador> jogadores) {
		this.jogadores = jogadores;
	}
	
	public void setVencedor(Jogador vencedor) {
		this.vencedor = vencedor;
	}
	
}
