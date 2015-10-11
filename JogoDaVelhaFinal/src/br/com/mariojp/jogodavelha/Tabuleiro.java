package br.com.mariojp.jogodavelha;

import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;

public class Tabuleiro extends JFrame implements ActionListener {

	private static final long serialVersionUID = 1L;

	/**
	 * Constantes
	 */
	public static String JOGADOR_X = "X";
	public static String JOGADOR_O = "O";
	


	private List<JButton> botoes = new ArrayList<JButton>();

	
	/**
	 * Variaveis
	 */
	private String jogador = JOGADOR_X;
	private int jogada = 1;
	
	/**
	 * Engine
	 */
	private IJogo jogo;
	
	public Tabuleiro(IJogo jogo) {
		this(jogo, JOGADOR_X);
	}
	


	public Tabuleiro(IJogo jogo, String jogador) {
		super("Jogo da Velha");
		this.setLayout(new GridLayout(3, 3));
		this.setSize(300, 300);
		this.jogo = jogo;
		for (int i = 1; i <= 3; i++) {
			for (int j = 1; j <= 3; j++) {
				JButton botao = new JButton("");
				botao.setName(i+""+j);
				botao.setFont(new Font(Font.MONOSPACED, Font.BOLD, 40));
				botao.addActionListener(this);
				this.add(botao);
				this.botoes.add(botao);
			}
		}

		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		JButton botao = (JButton) e.getSource();
		botao.setEnabled(false);
		botao.setText(jogador);
		int linha = Integer.parseInt(botao.getName().substring(0, 1));
		int coluna = Integer.parseInt(botao.getName().substring(1,2));
		int vez = (jogada % 2 != 0)?1:2;
		jogada++;
		jogo.jogada(linha, coluna, vez);
		if (jogador.equals(JOGADOR_X)) {
			this.jogador = JOGADOR_O;
		} else {
			this.jogador = JOGADOR_X;
		}
	}
	

	public static void main(String[] args) {
		new Tabuleiro(new Jogo(),JOGADOR_X);
	}



}
