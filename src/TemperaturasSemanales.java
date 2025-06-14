
public class TemperaturasSemanales {

    public static int contarDiasCalurosos(int[][] matriz) {
        
        int diasCalurosos = 0;
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[i].length; j++) {
                if (matriz[i][j] > 30) {
                    diasCalurosos++;
                }
            }
        }
        return diasCalurosos;
    }

    public static double promedioDiasFrescos(int[][] matriz) {
        int sumaTemperaturasFrescas = 0;
        int contadorTemperaturasFrescas = 0;
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[i].length; j++) {
                if (matriz[i][j] < 20) {
                    sumaTemperaturasFrescas += matriz[i][j];
                    contadorTemperaturasFrescas++;
                }
            }
        }
        if (contadorTemperaturasFrescas == 0) {
            return 0.0;
        }
        return (double) sumaTemperaturasFrescas / contadorTemperaturasFrescas;
    }

    public static void imprimirTemperaturasExtremas(int[][] matriz) {
        System.out.println("Temperaturas Extremas:");
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[i].length; j++) {
                if (matriz[i][j] < 10) {
                    System.out.println("Temperatura muy fría: " + matriz[i][j] + "°C en la posición [" + i + "][" + j + "]");
                } else if (matriz[i][j] > 35) {
                    System.out.println("Temperatura muy caliente: " + matriz[i][j] + "°C en la posición [" + i + "][" + j + "]");
                }
            }
        }
    }

    public static int[] posicionTemperaturaMasAlta(int[][] matriz) {
        if (matriz == null || matriz.length == 0 || matriz[0].length == 0) {
            return new int[]{-1, -1};
        }

        int temperaturaMasAlta = matriz[0][0];
        int[] posicion = {0, 0};

        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[i].length; j++) {
                if (matriz[i][j] > temperaturaMasAlta) {
                    temperaturaMasAlta = matriz[i][j];
                    posicion[0] = i;
                    posicion[1] = j;
                }
            }
        }
        return posicion;
    }

    public static void main(String[] args) {
        int[][] temperaturas = {
            {25, 28, 32, 35, 29, 27, 26},
            {18, 15, 20, 22, 19, 17, 16},
            {30, 31, 36, 28, 33, 34, 29},
            {5, 8, 12, 10, 7, 9, 11}
        };

        int diasCalurosos = contarDiasCalurosos(temperaturas);
        System.out.println("Número de días con temperaturas mayores a 30°C: " + diasCalurosos);

        double promedioFrescos = promedioDiasFrescos(temperaturas);
        System.out.println("Promedio de temperaturas menores a 20°C: " + String.format("%.2f", promedioFrescos));

        imprimirTemperaturasExtremas(temperaturas);

        int[] posicionAlta = posicionTemperaturaMasAlta(temperaturas);
        System.out.println("La temperatura más alta se registró en la posición: [" + posicionAlta[0] + "][" + posicionAlta[1] + "]");
    }
}


    
// La documentacion esta en el README