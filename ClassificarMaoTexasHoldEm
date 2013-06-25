package texasHoldEm.Modelo;

import java.util.ArrayList;

import texasHoldEm.Modelo.Beans.Carta;
import texasHoldEm.Modelo.Beans.Jogador;

/*
 * Classe concreta. referente a CLassificarMaoPoker
 */
public class ClassificarMaoTexasHoldEm extends ClassificarMaoPoker {

  
	/* Metodo que percorre uma lista de cartas comparando somente seus valores.
	 * Contando a quantidade de cartas que tenham o mesmo valor dentro da lista espeficicada( 2° parametro ) 
	 *  
	 *   Ex: Caso 1° parametro seja igual a = 2. Entao o metodo ira percorrer a lista especificada
	 *   afim de achar 2 cartas com o mesmo valor. Caso possua 2 cartas com o mesmo valor o metodo
	 *   retorna as 2 cartas.    
	 */
	
	@Override
	public ArrayList<Carta> mesmoValor( int qtdCarta , ArrayList<Carta> cartas ) {

		ordernarCartaAlta( cartas );
		ArrayList<Carta> retorno = new ArrayList<Carta>();
		int contador = 1;

		for ( int i = 0; i < cartas.size(); i++ ) {

			for ( int j = i + 1; j < cartas.size(); j++ ) {

				if ( cartas.get( i ).getValorFace() == cartas.get( j ).getValorFace() ) {

					contador++;
					retorno.add( cartas.get( j ) );

					if ( contador == qtdCarta ) {

						retorno.add( cartas.get( i ) );
						return retorno;

					}// fim 2° if
					
				}// fim 1° if
				
			}// fim 2° for

			contador = 1;

		}// fim 1° for

		return null;

	}// fim mesmoValor

	
	/* Metodo que percorre uma lista de cartas comparando somente seus Nipes.
	 * Contando a quantidade de cartas que tenham o mesmo Nipe dentro da lista espeficicada( 2° parametro ) 
	 *   
	 *   Ex: Caso 1° parametro seja igual a = 2. Entao o metodo ira percorrer a lista especificada
	 *   afim de achar 2 cartas com o mesmo Nipe. Caso possua 2 cartas como mesmo Nipe o metodo
	 *   retorna as 2 cartas.    
	 */
	@Override
	public ArrayList<Carta> mesmoNipe(int qtdCarta, ArrayList<Carta> cartas) {

		ordernarCartaAlta( cartas );
		ArrayList<Carta> retorno = new ArrayList<Carta>();
		int contador = 1;

		for ( int i = 0; i < cartas.size(); i++ ) {

			for ( int j = i + 1; j < cartas.size(); j++ ) {

				if ( cartas.get( i ).getNipe() == cartas.get( j ).getNipe() ) {

					contador++;
					retorno.add( cartas.get( j ) );

					if ( contador == qtdCarta ) {

						retorno.add( cartas.get( i ) );
						return retorno;

					}// fim 2° if
				}// fim 1° if
			}// fim 2° for

			contador = 1;

		}// fim 1° for

		return null;

	}// fim mesmoNipe

	
	
	/* Metodo que ordena uma lista de cartas.
	 * Ordem decrescente    
	 */
	public void ordernarCartaAlta(ArrayList<Carta> cartas) {

		for ( int i = 0; i < cartas.size(); i++ ) {

			for ( int j = i + 1; j < cartas.size(); j++ ) {

				if ( cartas.get( i ).getValorFace() < cartas.get( j ).getValorFace() ) {

					Carta a = cartas.get( i );
					Carta b = cartas.get( j );

					cartas.set( i , b );
					cartas.set( j , a );

				}// fim if

			}// fim 2° for

		}// fim 1° for

	}// fim metodo rdernarCartaAlta


	
	/*
	 * Metodo que verifica se a mao do jogador possui um "Four of a kind"    
	 * Caso possuir retorna true;
	 */
	
	@Override
	public boolean quatroCartasIguais(Jogador jogador) {
		
		ArrayList<Carta> quatroCartas = mesmoValor( 4 , jogador.getCartas() );
		
		if( quatroCartas != null ){
			
			jogador.getCartas().removeAll( quatroCartas );
			retirarCartas( jogador );
			jogador.setKicker( retornaKicker( 1 , jogador.getCartas() ) ); 
			jogador.getKicker().add( 0 ,  quatroCartas.get( 0 ) ); 
			
			jogador.getCartas().addAll( quatroCartas );
			jogador.setTipoMao( "Four of a kind" );
			
			return true;
			
		}else{
			
			return false;
		}

	}//fim quatroCartasIguais

	
	/*
	 * Metodo que verifica se a mao do jogador possui um "Flush"    
	 * Caso possuir retorna true;
	 */
	@Override
	public boolean cincoCartasIguais(Jogador jogador) {
		
		ArrayList<Carta> cincoCartas = mesmoNipe( 5 , jogador.getCartas() ); 
		
		if( cincoCartas != null ){
			
			jogador.getCartas().removeAll( cincoCartas );
			retirarCartas( jogador );
			jogador.getCartas().addAll( cincoCartas );
			
			jogador.setKicker( retornaKicker( 5 ,  cincoCartas ) );			
			jogador.setTipoMao( "Flush" );
			
			return true;
			
		}else{
			
			return false;
		}
		
	}//fim cincoCartasIguais
	
	
	/*
	 * Metodo que verifica se a mao do jogador possui um "Full House" ou "Three of a Kind"
	 * Caso possuir um dos 2 retorna true;
	 */
	@Override
	public boolean tresCartasIguais(Jogador jogador) {
		
		ArrayList<Carta> tresCartas = mesmoValor( 3 , jogador.getCartas() );
		
		if( tresCartas != null ){
			
			jogador.getCartas().removeAll( tresCartas );
			ArrayList<Carta> par1 = mesmoValor( 2, jogador.getCartas() );
			
			if( par1 != null ){
				
				//Full House				
				jogador.getCartas().removeAll( par1 );
				jogador.getKicker().add( 0 , tresCartas.get( 0 ) );
				jogador.getKicker().add( 1 , par1.get( 0 ) );
				
				retirarCartas( jogador );
				jogador.getCartas().addAll( par1 );
				jogador.getCartas().addAll( tresCartas );
				
				jogador.setTipoMao( "Full House" );
				return true;
				
			}else{
				 
				//Three of a Kind 
				jogador.setKicker( retornaKicker( 2 , jogador.getCartas() )  );
				jogador.getKicker().add( 0 , tresCartas.get( 0 ) );
				retirarCartas( jogador );
				
				jogador.getCartas().addAll( tresCartas );				
				jogador.setTipoMao( "Three of a Kind" );
				
				return true;				
			}
			
		}else{
			
			return false;
		}
		
	}
	
	
	/*
	 * Metodo que verifica se a mao do jogador possui um "Two Pair" ou "Pair"
	 * Caso possuir um dos 2 retorna true;
	 */
	@Override
	public boolean par(Jogador jogador) {

		ArrayList<Carta> par1 = mesmoValor( 2, jogador.getCartas() );

		if (par1 != null) {

			jogador.getCartas().removeAll( par1 );
			ArrayList<Carta> par2 = mesmoValor( 2 , jogador.getCartas() );

			if (par2 != null) {

				jogador.getCartas().removeAll( par2 );
				jogador.setKicker( retornaKicker( 1, jogador.getCartas() ) );
				jogador.getKicker().add( 0, par1.get( 0 ) );

				jogador.getKicker().add( 1, par2.get( 0 ) );
				retirarCartas( jogador );
				jogador.getCartas().addAll( par1 );

				jogador.getCartas().addAll( par2 );
				jogador.setTipoMao( "Two Pair" );

				return true;

			} else {
				
				jogador.setKicker( retornaKicker( 3 , jogador.getCartas() ) );
				jogador.getKicker().add( 0 , par1.get( 0 ) );
				retirarCartas( jogador );
				
				jogador.getCartas().addAll( par1 );
				jogador.setTipoMao( "Pair" );
				
				return true;
			}

		} else {
			
			//carta alta
			return false;
		}
		
	}// fim par

	
	/*
	 * Metodo que classifica a mao do jogador com as 5 cartas mais altas que ele possui
	 */
	@Override
	public void cartaAlta(Jogador jogador) {
		
		ordernarCartaAlta( jogador.getCartas() );
		jogador.setKicker( retornaKicker( 5 ,  jogador.getCartas() ) ); 
		retirarCartas( jogador );		
		
		jogador.setTipoMao("Carta Alta");
		
	}
	
	
	/*
	 * Metodo que retira as 2 cartas que nao fazem parte da melhor jogada
	 */
	public void retirarCartas(Jogador jogador) {

		int qtdCarta = jogador.getCartas().size() - 1;
		jogador.getNaoUsada().add( jogador.getCartas().get( qtdCarta ) );
		jogador.getCartas().remove( qtdCarta );

		qtdCarta--;
		jogador.getNaoUsada().add( jogador.getCartas().get( qtdCarta ) );
		jogador.getCartas().remove( qtdCarta );
		
	}//retirarCartas
	

	/* Metodo que retorna uma lista de kicker.
	 * 
	 * Caso o 1° parametro seja igual a 2, entao o metodo ira percorrer a lista especificada
	 * e retornar as 2 cartas mais altas que a lista de cartas especificadas possui.
	 */
	@Override
	public ArrayList<Carta> retornaKicker(int qtdKicker, ArrayList<Carta> cartas) {

		ordernarCartaAlta( cartas );
		ArrayList<Carta> retorno = new ArrayList<Carta>();

		for (int i = 0; i < qtdKicker; i++) {

			retorno.add( cartas.get( i ) );
		}

		return retorno;
		
	}//retornaKicker

	
}// fim classe
