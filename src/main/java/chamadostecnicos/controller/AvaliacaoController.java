package chamadostecnicos.controller;

import java.time.LocalDate;
import java.util.Scanner;

import chamadostecnicos.model.Avaliacao;


public class AvaliacaoController {
	
	Scanner scan = new Scanner(System.in);
	
	public Avaliacao realizarAvaliacao() {
		Avaliacao avaliacao = new Avaliacao();
		boolean aux = false;
		
		System.out.println("");
		System.out.println("===================================");
		System.out.println("||           AVALIA��O           ||");
		System.out.println("===================================");
		System.out.println("");
		
		while (aux == false) {
			System.out.print("Avalie o acompanhamento dando nota de 1 a 5: ");
			avaliacao.setQuantEstrelas(scan.nextInt());
			
			if (avaliacao.getQuantEstrelas() <= 0 || avaliacao.getQuantEstrelas() > 5) {
				System.out.println("!! Inv�lido! Digite um valor de 1 a 5 !!");
				aux = false;
			} else {
				aux = true;
			}
			
		}
		
		scan.nextLine();
		System.out.print("Escreva um coment�rio, caso deseje: ");
		avaliacao.setComentario(String.valueOf(scan.nextLine()));
		
		avaliacao.setDataAvalicacao(LocalDate.now());

		return avaliacao;
		
	}
	
	
}
