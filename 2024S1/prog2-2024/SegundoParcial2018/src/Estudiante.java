import java.time.*;
public class Estudiante {
    public long cedula;
    private String nombre;
    private LocalDate fechaNacimiento;
    public ClaseNivel asiste;

    public Estudiante(long cedula, String nombre, LocalDate fechaNacimiento, ClaseNivel asiste) {
        this.cedula = cedula;
        this.nombre = nombre;
        this.fechaNacimiento = fechaNacimiento;
        this.asiste = asiste;
    }
}
