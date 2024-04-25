public class Primaria extends ClaseNivel {
    private String maestroTurnoTarde;
    public boolean esDeDobleTurno() {
        return true;
    }
    public Primaria(String salon, String maestroPrincipal, Nivel nivel, String maestroTurnoTarde) {
        super(salon, maestroPrincipal, nivel);
        this.maestroTurnoTarde = maestroTurnoTarde;
    }
}
