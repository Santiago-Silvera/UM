import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Iterator;

public class Colegio {
    private ArrayList<Estudiante> estudiantes;
    private ArrayList<ClaseNivel> claseNiveles;

    public Colegio(ArrayList<ClaseNivel> claseNiveles) {
        this.claseNiveles = claseNiveles;
    }

    public void crearClasePreescolar(String salon, String maestroPrincipal, Nivel nivel, String maestroPsicomotriz) {
        Preescolar clasePreescolar = new Preescolar(salon, maestroPrincipal, nivel, maestroPsicomotriz);
        claseNiveles.addLast(clasePreescolar);
    }

    public void crearClasePrimaria(String salon, String maestroPrincipal, Nivel nivel, String maestroTrunoTarde) {
        Primaria clasePrimaria = new Primaria(salon, maestroPrincipal, nivel, maestroTrunoTarde);
        claseNiveles.addLast(clasePrimaria);
    }

    public void crearEstudiante(long cedula, String nombre, LocalDate fechaNacimiento) throws EstudianteYaExiste {
        Estudiante estudiante = new Estudiante(cedula, nombre, fechaNacimiento, null);
        for (Estudiante e: estudiantes) {
            if (e.equals(estudiante)) {
                throw new EstudianteYaExiste();
            }
        }
    }

    public void asociarEstudianteClase(long cedula, boolean esPrimaria, int nivel) throws EstudianteNoExiste {
        ClaseNivel claseSeleccionada = esPrimaria ? new Primaria(null, null, null, null)
                                                  : new Preescolar(null, null, null, null);
        for (ClaseNivel cn: claseNiveles) {
            if (cn.)
        }

        for (Estudiante e: estudiantes) {
            if (e.cedula == cedula && e.asiste != null) {
                e.asiste = claseSeleccionada;
                return;
            }
        }
        throw new EstudianteNoExiste();
    }

}
