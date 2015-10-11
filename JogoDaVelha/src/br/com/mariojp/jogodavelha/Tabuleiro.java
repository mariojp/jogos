/*
 * The MIT License (MIT)
 *
 * Copyright (c) 2015 Mario Jorge Pereira
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 *
 */
package br.com.mariojp.jogodavelha;
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
