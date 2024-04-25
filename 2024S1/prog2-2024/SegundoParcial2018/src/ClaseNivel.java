abstract class ClaseNivel implements DobleTurno {
    private String salon;
    private String maestroPrincipal;
    private Nivel nivel;
    public ClaseNivel(String salon, String maestroPrincipal, Nivel nivel) {
        this.salon = salon;
        this.maestroPrincipal = maestroPrincipal;
        this.nivel = nivel;
    }
}
