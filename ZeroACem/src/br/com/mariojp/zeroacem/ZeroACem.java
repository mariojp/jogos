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
package br.com.mariojp.zeroacem;

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

		tc.close();
	}

}
