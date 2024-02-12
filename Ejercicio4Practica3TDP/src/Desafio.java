class Desafio {
    private String pregunta;
    private String respuestaCorrecta;

    public Desafio(String pregunta, String respuestaCorrecta) {
        this.pregunta = pregunta;
        this.respuestaCorrecta = respuestaCorrecta;
    }

    public String getPregunta() {
        return pregunta;
    }

    public boolean comprobarRespuesta(String respuesta) {
        return respuestaCorrecta.equalsIgnoreCase(respuesta.trim());
    }
}