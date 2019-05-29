package co.edu.unimagdalena.s2.t1.e3;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class EnunciadoExamen {

	private String nombre;
	private List<Pregunta> preguntas;
	private int numPreguntas;

	public EnunciadoExamen(String nombre) {
		this.nombre = nombre;
		preguntas = new ArrayList<Pregunta>();
		numPreguntas = 0;
	}

	public String getNombre() {
		return nombre;
	}

	public List<Pregunta> getPreguntas() {
		return preguntas;
	}

	public int getNumPreguntas() {
		return numPreguntas;
	}

	public void agregarPregunta(Pregunta pregunta) {
		preguntas.add(pregunta);
		numPreguntas = preguntas.size();
	}

	public Pregunta obtenerPregunta(int indice) {
		if (indice < numPreguntas)
			return preguntas.get(indice);
		else
			return null;
	}

	public boolean permutarPregunta(int indicePregunta, int nuevoIndice) {
		if ((indicePregunta < numPreguntas) && (nuevoIndice < numPreguntas)) {
			preguntas.add(nuevoIndice, preguntas.remove(indicePregunta));
			return true;
		} else
			return false;
	}

	public boolean borrarPregunta(int indice) {
		return borrarPregunta(preguntas.get(indice));
	}

	public boolean borrarPregunta(Pregunta pregunta) {
		return preguntas.remove(pregunta);
	}

	public boolean contienePregunta(Pregunta pregunta) {
		return preguntas.contains(pregunta);
	}

	public void ordenar() {
		Collections.sort(preguntas);
	}

}
