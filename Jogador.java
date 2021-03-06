package texasHoldEm.Modelo.Beans;
import java.util.ArrayList;

public class Jogador {
  
	// lista que ira referenciar as 5 melhores cartas do jogador
	private ArrayList<Carta> cartas;
	
	//armazena o tipo de mao que o jogador possui. Pair, Two Pair...
	private String tipoMao;
	 
	//lista que ira referenciar as cartas kicker do jogador
	//esta lista ira conter cartas da lista cartas
	private ArrayList<Carta> kicker;
	
	// lista que ira referenciar as cartas nao usadas pelo jogador
	// no caso 2.
	private ArrayList<Carta> naoUsada;
	
	//variavel boolean que ira sinalizar se o jogador e ou nao vencedor
	private boolean vencedor;
	
	//variavel boolean que ira sinalizar se o jogador desistiu ou nao da partida
	private boolean foraPartida;
	
	
	public Jogador(){
		
		cartas = new ArrayList<Carta>();
		kicker = new ArrayList<Carta>();
		naoUsada = new ArrayList<Carta>();
		
		vencedor = false;
		foraPartida = true;
		
	}
	
	public ArrayList<Carta> getNaoUsada() {
		return naoUsada;
	}

	public void setNaoUsada(ArrayList<Carta> naoUsada) {
		this.naoUsada = naoUsada;
	}
	
	public boolean isVencedor() {
		return vencedor;
	}

	public boolean isForaPartida() {
		return foraPartida;
	}

	public void setVencedor(boolean vencedor) {
		this.vencedor = vencedor;
	}

	public void setForaPartida(boolean foraPartida) {
		this.foraPartida = foraPartida;
	}
	
	public ArrayList<Carta> getCartas() {
		return cartas;
	}
	
	public String getTipoMao() {
		return tipoMao;
	}
	
	/* Metodo que retorna um inteiro para representar
	 * o peso da mao do jogador
	 */
	public int getValorTipoMao() {
		
		switch( this.tipoMao ){
		
		case "Carta Alta": return 0;		
		case "Pair": return 1;		
		case "Two Pair": return 2;
		
		case "Three of a Kind": return 3;
		case "Flush": return 4; 
		case "Full House": return 5;
		
		case "Four of a kind": return 6;
		
		default: return -1;
		
		}
		
	}//fim getValorTipo
	
	public ArrayList<Carta> getKicker() {
		return kicker;
	}
	
	public void setCartas(ArrayList<Carta> cartas) {
		this.cartas = cartas;
	}
	
	public void setTipoMao(String tipoMao) {
		this.tipoMao = tipoMao;
	}
	
	public void setKicker(ArrayList<Carta> kicker) {
		this.kicker = kicker;
	}
	
	
	/*
	 *	sobrecarga do metodo tostring()
	 *  responsavel por retornar as informaçoes do o objeto
	 */
	public String toString(){
		
		String tipoMao = "";
		
		if( this.tipoMao != null ){
			tipoMao = this.tipoMao;
		}
		
		String vencedor = "";
		
		if( this.isVencedor() == true ){
			vencedor = " (winner)";
		}
		
		return naoUsada.toString() +" "+ cartas.toString()+ "  " + tipoMao + vencedor +  "\n"; 
	}

}//fim classe
