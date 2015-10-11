package br.com.mariojp;

import java.util.Scanner;

public class ZeroACem {

	public static void main(String[] args) {
		Scanner tc = new Scanner(System.in);

		// Variaveis
		int numero = 0;
		int palpite = 0;
		;
		int max = 100;
		int min = 1;
		System.out.println("Digite um Numero: ");
		numero = tc.nextInt();
		while ((palpite != numero) && !(min == numero - 1 && max == numero + 1)) {
			System.out.println("Escreva seu palpite de " + min + " a " + max);
			palpite = tc.nextInt();
			while (palpite <= min || palpite >= max) {
				palpite = tc.nextInt();
			}
			if (numero < palpite) {
				max = palpite;
			} else {
				if (numero > palpite) {
					min = palpite;
				}
			}
		}

		if (palpite == numero) {
			System.out.println("BEBE O DONO DO PALPITE");
		} else {
			System.out.println("BEBE O DONO DO NUMERO");
		}

	}

}
