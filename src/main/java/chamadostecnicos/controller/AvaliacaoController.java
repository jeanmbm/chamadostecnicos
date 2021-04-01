package chamadostecnicos.controller;

import java.time.LocalDate;
import java.util.Random;
import java.util.Scanner;

import chamadostecnicos.model.Avaliacao;


public class AvaliacaoController {
	
	
	Scanner scan = new Scanner(System.in);
	Random r = new Random();
	
	
	public void realizarAvaliacao() {
		Avaliacao avaliacao = new Avaliacao();
		System.out.println("Escreva um comentário, caso deseje:");
		avaliacao.setComentario(String.valueOf(scan.nextLine()));
		System.out.println("Avalie o acompanhamento dando nota de 1 a 5");
		avaliacao.setQuantEstrelas(scan.nextInt());
		avaliacao.setDataAvalicacao(LocalDate.now());
		avaliacao.setId(r.nextInt(100));
		AvaliacaoController a = new AvaliacaoController();
		a.exibirAvaliacao(avaliacao);
	}
	
	public void exibirAvaliacao(Avaliacao avaliacao) {
		System.out.println("ID: " + avaliacao.getId());
		System.out.println("Comentario: " + avaliacao.getComentario());
		System.out.println("Nota: " + avaliacao.getQuantEstrelas());
		System.out.println("Data: " + avaliacao.getDataAvalicacao());
	}
	
}
