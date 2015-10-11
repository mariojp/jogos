package br.com.mariojp.jogodavelha;

public class Jogo implements IJogo{

	@Override
	public void jogada(int linha, int coluna, int jogador) {
		System.out.println("LOG: Linha: "+linha +" Coluna: "+coluna+" Jogador: "+jogador);
		
	}


}
