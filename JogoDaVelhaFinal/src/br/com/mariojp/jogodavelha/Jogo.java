package br.com.mariojp.jogodavelha;

import javax.swing.JOptionPane;

public class Jogo implements IJogo{
	
	
	int[][] matriz = new int[3][3];

	@Override
	public void jogada(int linha, int coluna, int jogador) {
		System.out.println("LOG: Linha: "+linha +" Coluna: "+coluna+" Jogador: "+jogador);
		matriz[ajusteMatriz(linha)][ajusteMatriz(coluna)]=jogador;

		int v= vencedorColunasOuLinha(jogador);
		
		if( (v!=0) || 
			(matriz[0][0] == jogador &&  matriz[1][1] == jogador &&  matriz[2][2] == jogador)|| 
			(matriz[2][0] == jogador &&  matriz[1][1] == jogador &&  matriz[0][2] == jogador)) {
			String j = v==0?"X":"O";
			System.out.println("Jogador "+ j + " venceu");
			JOptionPane.showMessageDialog(null,   j + " venceu!" , "Fim", JOptionPane.INFORMATION_MESSAGE);
			System.exit(0);
		}else if(empate()){
			System.out.println("Empate");
			JOptionPane.showMessageDialog(null,  "Empate!" , "Fim", JOptionPane.INFORMATION_MESSAGE);
			System.exit(0);
		}
		memoria();

	}
	
	public boolean empate(){
		boolean empatou= true;
		for (int i = 0; i < matriz.length; i++) {
			for (int j = 0; j < matriz[i].length; j++) {
				if(matriz[i][j] == 0){
					empatou = false;
				}
			}
			
		} 
		return empatou;
	}

	public int ajusteMatriz(int valor) {
		return valor-1;
	}
	
	public void memoria() {
		for (int i = 0; i < matriz.length; i++) {
			for (int j = 0; j < matriz.length; j++) {
				System.out.print(matriz[i][j]+" ");
			}
			System.out.println();
		}
		
	}
	
	public int vencedorColunasOuLinha(int jogador){
		int resultado = 0;
		for (int i = 0; i < matriz.length; i++) {
			if((matriz[i][0] == jogador &&  matriz[i][1] == jogador &&  matriz[i][2] == jogador)|| 
			   (matriz[0][i] == jogador &&  matriz[1][i] == jogador &&  matriz[2][i] == jogador)) {
				resultado = jogador;
			}
		}
		return  resultado;
	}

}
