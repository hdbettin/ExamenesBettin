package co.edu.unimagdalena.s2.t1.e3;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import co.edu.unimagdalena.s2.t1.e3.preguntas.OpcionesMultiples;
import co.edu.unimagdalena.s2.t1.e3.preguntas.PreguntaBoleana;
import co.edu.unimagdalena.s2.t1.e3.preguntas.Test;

public class MainClass04 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		EnunciadoExamen enunciado1;
		if (args.length > 0) {
			System.out.println(args[0]);
			enunciado1 = new EnunciadoExamen(args[0]);
		} else {
			System.out.println("Examen");
			enunciado1 = new EnunciadoExamen("Examen");
		}
		System.out.println();
		Pregunta p1 = new Test("¿Cuál es el valor decimal del número binario 0010?\n a. 1, b. 2, c. 3", "b", 3);
		p1.setDificultad(1);
		enunciado1.agregarPregunta(p1);
		Pregunta p2 = new OpcionesMultiples("¿Cuáles son protocolos de URL?\n a. http, b. ftp, c. coco", "a b", 3);
		enunciado1.agregarPregunta(p2);
		Pregunta p3 = new PreguntaBoleana("¿Un byte equivale a 16 bits?", "falso");
		enunciado1.agregarPregunta(p3);
		enunciado1.ordenar();
		Examen examen = new Examen(enunciado1);
		Scanner teclas = new Scanner(System.in);
		List<Pregunta> pgs = examen.getEnunciado().getPreguntas();
		ArrayList<String> respuestas = new ArrayList<String>();
		for (int i = 0; i < pgs.size(); i++) {
			System.out.println((i + 1) + "- " + pgs.get(i).getTexto());
			System.out.print("Opciones validas = ");
			System.out.println(pgs.get(i).opcionesValidas());
			respuestas.add(teclas.nextLine());
			if (respuestas.get(i) != null)
				examen.responder(i, respuestas.get(i));
			System.out.println();
		}
		for (int j = 0; j < respuestas.size(); j++) {
			if (respuestas.get(j).isEmpty()) {
				String r;
				do {
					System.out.println("¿Deseas responder otra vez la pregunta " + (j + 1) + "?");
					r = teclas.nextLine();
				} while (!r.equals("y") && !r.equals("n"));
				if (r.equals("y")) {
					System.out.println();
					System.out.println((j + 1) + "- " + pgs.get(j).getTexto());
					System.out.print("Opciones validas = ");
					System.out.println(pgs.get(j).opcionesValidas());
					respuestas.set(j, teclas.nextLine());
					if (respuestas.get(j) != null)
						examen.responder(j, respuestas.get(j));
					System.out.println();
				}

			}
		}
		System.out.println("nota final: " + examen.corregir());
		teclas.close();
	}

}
