package co.edu.unimagdalena.s2.t1.e3.preguntas;

import java.util.Arrays;
import java.util.List;

import co.edu.unimagdalena.s2.t1.e3.Pregunta;

public class PreguntaBoleana extends Pregunta {

	public PreguntaBoleana(String texto, String respuestaCorrecta) {
		super(texto, respuestaCorrecta);
		// TODO Auto-generated constructor stub
	}

	@Override
	public List<String> opcionesValidas() {
		// TODO Auto-generated method stub
		return Arrays.asList("verdadero", "falso");
	}

	@Override
	public double calificacion(String respuesta) {
		// TODO Auto-generated method stub
		if (getRespuestaCorrecta().equals(respuesta) && opcionesValidas().contains(respuesta))
			return 1;
		else
			return -1;
	}

}
