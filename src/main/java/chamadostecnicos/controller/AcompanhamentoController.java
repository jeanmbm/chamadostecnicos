package chamadostecnicos.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

import chamadostecnicos.model.Acompanhamento;


public class AcompanhamentoController {
	
	static List<Acompanhamento> acompanhamentos = new ArrayList<Acompanhamento>();
	Scanner scan = new Scanner(System.in);
	Random r = new Random();

	
	public void gerarAcompanhamento() {
		Acompanhamento acompanhamento = new Acompanhamento();
		UsuarioController controller = new UsuarioController();
		controller.pegarTecnico(acompanhamento);
		
	}
}
