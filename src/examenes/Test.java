package co.edu.unimagdalena.s2.t1.e3.preguntas;

import java.util.ArrayList;
import java.util.List;

import co.edu.unimagdalena.s2.t1.e3.Pregunta;

public class Test extends Pregunta {

	private int numOpciones;

	public Test(String texto, String respuestaCorrecta, int numOpciones) {
		super(texto, respuestaCorrecta);
		// TODO Auto-generated constructor stub
		this.numOpciones = numOpciones;
	}

	@Override
	public double calificacion(String respuesta) {
		// TODO Auto-generated method stub
		if (opcionesValidas().contains(respuesta) && getRespuestaCorrecta().equals(respuesta))
			return 1;
		else
			return -(1 / numOpciones);
	}

	@Override
	public List<String> opcionesValidas() {
		// TODO Auto-generated method stub
		ArrayList<String> opciones = new ArrayList<String>();
		for (int i = 0; i < numOpciones; i++)
			opciones.add("" + ((char) ('a' + i)));
		return opciones;
	}

}
