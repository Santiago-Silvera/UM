import java.util.Arrays;
import java.util.function.DoublePredicate;

public class P2Ejercicio2 {
    public static double calcularDevolucion(double[] remuneraciones, boolean conyugeACargo, int hijosACargo) {
        double CPE = 3246.25;
        double[] aportesPersonalesMensuales = new double[remuneraciones.length];
        for (int i = 0; i < remuneraciones.length; i++) {
            if (remuneraciones[i] <= 2552.5) {
                if (conyugeACargo) {
                    aportesPersonalesMensuales[i] = remuneraciones[i] * 0.05;
                } else {
                    aportesPersonalesMensuales[i] = remuneraciones[i] * 0.03;
                }
            } else {
                if (conyugeACargo) {
                    if (hijosACargo > 0) {
                        aportesPersonalesMensuales[i] = remuneraciones[i] * 0.08;
                    } else {
                        aportesPersonalesMensuales[i] = remuneraciones[i] * 0.065;
                    }
                } else {
                    if (hijosACargo > 0) {
                        aportesPersonalesMensuales[i] = remuneraciones[i] * 0.06;
                    } else {
                        aportesPersonalesMensuales[i] = remuneraciones[i] * 0.045;
                    }
                }
            }
        }
        int cantACargo = hijosACargo + 1;
        if (conyugeACargo) cantACargo++;
        double topeMensual = cantACargo * CPE;
        double devolucion =  Arrays.stream(aportesPersonalesMensuales).sum() - (topeMensual * 12);
        return devolucion >= 0 ? devolucion : 0;
    }
    public static void main(String[] args) {
        double[] remuneraciones = {150000, 150000, 150000, 150000, 150000, 150000,
                150000, 150000, 150000, 150000, 150000, 150000};
        boolean conyugeACargo = true;
        int hijosACargo = 0;
        double devolucion = calcularDevolucion(remuneraciones, conyugeACargo,
                hijosACargo);
        System.out.println("Devolución es " + devolucion);
    }
}
