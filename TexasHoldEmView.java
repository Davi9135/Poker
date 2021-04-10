package texasHoldEm.View;


import java.awt.BorderLayout;


public class TexasHoldEmView extends JFrame {

  private JPanel contentPane;
	private JButton btnGo;
	private JTextArea txtEntrada;
	private JLabel lblNewLabel;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TexasHoldEmView frame = new TexasHoldEmView();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public TexasHoldEmView() {
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds( 350, 200, 304, 278);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 58, 274, 141);
		contentPane.add(scrollPane);
		
		txtEntrada = new JTextArea();
		scrollPane.setViewportView(txtEntrada);
		
		btnGo = new JButton("Come\u00E7ar");
		btnGo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				carregarJogo();
				
			}
		});
		btnGo.setBounds(94, 210, 89, 23);
		contentPane.add(btnGo);
		
		JLabel lblColoque = new JLabel("- Informe no maximo 7 Cartas para cada jogador.");
		lblColoque.setBounds(10, 21, 286, 14);
		contentPane.add(lblColoque);
		
		lblNewLabel = new JLabel("- Cada linha representa um Jogador.");
		lblNewLabel.setBounds(10, 36, 215, 14);
		contentPane.add(lblNewLabel);
	}//fim construtor
	
	
	/*
	 * Metodo que prepara os dados recebidos
	 * para serem processados
	 */
	
	public void carregarJogo(){
		
		//Quabra cada linha e transforma em vetor, onde cada indice desse vetor e uma linha
		String[] entrada = txtEntrada.getText().trim().split("\n");
		ArrayList<Jogador> jogadores = new ArrayList<Jogador>();
		
		
		//loop que ira transformar cada linha em um jogador, e cada par de caracter em um objeto Carta
		for( int i = 0 ; i < entrada.length ; i++ ){
			
			Jogador jogador = new Jogador();
			 
			//transforma cada linha que contem N cartas em um vetor de string.
			//onde cada indice e uma carta
			String[] cartas = entrada[ i ].trim().split(" "); 
			
			for( int j = 0 ; j < cartas.length ; j ++ ){ 
				
				if( cartas[ j ] != null && !cartas[ j ].equalsIgnoreCase("") ){
				
				Carta carta = new Carta( cartas[j].trim() );
				jogador.getCartas().add( carta );
				
				}
				
			}//fim 2° for
			
			//caso o jogador tenha menos que 7 cartas, significa que ele abandonou a partida
			if( jogador.getCartas().size() == 7 ){
				
				jogador.setForaPartida( false );
			}
			
			jogadores.add( jogador );
			
		}//fim 1° for
		
		//cria um objeto Jogo
		Jogo jogo = new Jogo();
		//passa a lista de jogadores para o jogo
		jogo.setJogadores( jogadores );
		
		//classifico a mao dos jogadores
		jogo.classificarMaoJogadores();	
		
		JOptionPane.showMessageDialog( null , jogo.getJogadores() );		
		
	}
	
	
}//fim classe
