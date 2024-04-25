public class Preescolar extends ClaseNivel {
    private String maestroPsicomotriz;
    public boolean esDeDobleTurno() {
        return false;
    }
    public Preescolar(String salon, String maestroPrincipal, Nivel nivel, String maestroPsicomotriz) {
        super(salon, maestroPrincipal, nivel);
        this.maestroPsicomotriz = maestroPsicomotriz;
    }
}
