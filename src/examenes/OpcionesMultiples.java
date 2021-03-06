package co.edu.unimagdalena.s2.t1.e3.preguntas;

import java.util.Arrays;
import java.util.List;

public class OpcionesMultiples extends Test {

	private List<String> respuestasCorrectas;
	private int numRespuestasCorrectas;

	public OpcionesMultiples(String texto, String respuestaCorrecta, int numOpciones) {
		super(texto, respuestaCorrecta, numOpciones);
		// TODO Auto-generated constructor stub
		respuestasCorrectas = extraerOpciones(respuestaCorrecta);
		numRespuestasCorrectas = respuestasCorrectas.size();
	}

	@Override
	public double calificacion(String respuesta) {
		// TODO Auto-generated method stub
		List<String> posiblesRespuestas = extraerOpciones(respuesta);
		double valorRespuesta = 0;
		for (String str : posiblesRespuestas) {
			if (opcionesValidas().contains(str) && respuestasCorrectas.contains(str))
				valorRespuesta++;
			else
				valorRespuesta--;
		}
		return 1 - (Math.abs(numRespuestasCorrectas - valorRespuesta) / numRespuestasCorrectas);
	}

	private List<String> extraerOpciones(String str) {
		return Arrays.asList(str.split(" "));
	}

}
