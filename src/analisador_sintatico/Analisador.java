/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package analisador_sintatico;

import analisador_lexico.Analex2;
import analisador_lexico.Token;
import java.io.IOException;
import java.util.ArrayList;


/**
 *
 * @author jackson
 */
public class Analisador {

	Analex2 analisadorLexico = new Analex2();
	ArrayList<Token> tokens = new ArrayList<>();
	Token token = new Token();
	ArrayList<Sintatico> sintaticos = new ArrayList<>();
	Gramatica gramatica;

	public static void analise(ArrayList<Sintatico> sintatico) {
		// System.out.println("LEXEMA\t\t\t\tLinha\t\t\t\tTOKEN\n");
		for (Sintatico sint : sintatico) {
			System.out.println(sint.getEr() + "|\t" + "Linha: " + sint.getLinha() + "|\t" + sint.getErro());
			System.out.println("____________________________________________________________________________________");
		}
	}

	public ArrayList analisador() throws IOException {

		ArrayList<Token> tokens = analisadorLexico.analisador();
		Gramatica gramatica = new Gramatica(tokens);
		gramatica.analise();

		return gramatica.errosSintaticos();

	}

	public ArrayList analisador2() throws IOException {
        NovaGramatica grama = new NovaGramatica();
        analise(grama.errosSintaticos());
		return grama.errosSintaticos();
	}

}
