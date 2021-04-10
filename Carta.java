package texasHoldEm.Modelo.Beans;

/*
 * Classe reponsavel por representar uma carta
 */

public class Carta {

  // armazena o valor completo da ccarta. os seus 2 caracters
	private String carta;	
	
	//armazena um numero representativo caso a carta seja T, J, K, A, Q
	private int face;
	
	//armazena o Nipe da carta
	private char nipe;
	
	public Carta( String carta ){
		
		int qtdCaracter = carta.length();
		String face = "";
				
		if( qtdCaracter == 2 ){
			
			//face armazena o 1° caracter da string carta passada como parametro
			face = "" +  carta.charAt( 0 ); 
			
			// compara a face, caso ela seja T, J, Q, K, A. ela recebera um numero que a represente
			// para retornar o valor Q, T, J... que o numero represente chamar o metodo getFace().
			switch( face ){
			
			case "T": this.face = 10;
					  break;
			
			case "J": this.face = 11;
			 		  break;
			
			case "Q": this.face = 12;
			 		  break;
			
			case "K": this.face = 13;
				      break;
			
			case "A": this.face = 14;
					  break;
			
			default: this.face = Integer.parseInt( face.trim() );			
			
			}//fim shitch			
						
			//nipe armazena o 2° caracter da string carta passada como parametro
			this.nipe = carta.charAt( 1 );
			this.carta = carta;
		
		}else{
			
			if( qtdCaracter == 3 ){
				
				//face armazena os 2 primeiros caracter da string carta passada como parametro
				face = carta.substring( 0, 2 );
				
				if( face.equalsIgnoreCase( "10" ) ){ 
					
					this.nipe = carta.charAt( 2 ); 
					this.face = Integer.parseInt( face );
					this.carta = carta;
					
				}else{
					
					System.out.println("Carta Invalida " + carta);
				}
				
			}//fim if
			
		}//fim else
		
		
	}//fim construtor
	
	
	public String getCarta() {
		return carta;
	}
	
	public int getValorFace(){
		
		return this.face;		
	}
	
	/*
	 * Metodo que retorna um inte que representa o valor da carta
	 * Facilitando na hora de comparar seus valores
	 */
	public String getFace() { 
		
		switch( this.face ){
		
		case 10: return "T";
		
		case 11: return "J";				
				
		case 12: return "Q";
		
		case 13: return "K";
		
		case 14: return "A";
		
		default: return "" + this.face; 
		
		}
	
	}//fim getFace()
	
	public char getNipe() {
		return nipe;
	}
	
	
	
	/*sobrecarga do metodo tostring()
	 *  responsavel por retornar as informaçoes do o objeto
	 */
	public String toString(){
		
		return this.carta + " ";
	}
	
}//fim classe
