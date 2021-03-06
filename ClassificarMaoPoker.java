package texasHoldEm.Modelo;

import java.util.ArrayList;
import texasHoldEm.Modelo.Beans.*;

public abstract class ClassificarMaoPoker {

  	public abstract ArrayList<Carta> mesmoValor( int qtdCarta, ArrayList<Carta> cartas );
	
	public abstract ArrayList<Carta> mesmoNipe( int qtdCarta, ArrayList<Carta> cartas );
	
	public abstract boolean par( Jogador jogador );
	
	public abstract boolean tresCartasIguais( Jogador jogador );
	
	public abstract boolean quatroCartasIguais( Jogador jogador );
	
	public abstract boolean cincoCartasIguais( Jogador jogador );
	
	public abstract void cartaAlta( Jogador jogador );
	
	public abstract ArrayList<Carta> retornaKicker( int qtdKicker, ArrayList<Carta> cartas );
	
}
