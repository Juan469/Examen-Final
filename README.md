public class AnalisisTemperaturas {

    /**
     * Cuenta cuántos días hubo temperaturas mayores a 30°C.
     * @param matriz La matriz de temperaturas, donde cada fila es una ciudad y cada columna un día.
     * @return El número de días con temperaturas mayores a 30°C.
     */
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

    /**
     * Calcula el promedio de temperaturas menores a 20°C.
     * @param matriz La matriz de temperaturas, donde cada fila es una ciudad y cada columna un día.
     * @return El promedio de temperaturas menores a 20°C. Si no hay temperaturas menores a 20°C, devuelve 0.0.
     */
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
            return 0.0; // Para evitar división por cero
        }
        return (double) sumaTemperaturasFrescas / contadorTemperaturasFrescas;
    }

    /**
     * Imprime las temperaturas menores a 10°C y mayores a 35°C, junto con su posición.
     * @param matriz La matriz de temperaturas, donde cada fila es una ciudad y cada columna un día.
     */
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

    /**
     * Devuelve la posición [i][j] donde se registró la temperatura más alta.
     * Si hay múltiples temperaturas máximas iguales, devuelve la primera que encuentre.
     * @param matriz La matriz de temperaturas, donde cada fila es una ciudad y cada columna un día.
     * @return Un arreglo de enteros [i, j] que representa la posición de la temperatura más alta.
     * Si la matriz está vacía, devuelve [-1, -1].
     */
    public static int[] posicionTemperaturaMasAlta(int[][] matriz) {
        if (matriz == null || matriz.length == 0 || matriz[0].length == 0) {
            return new int[]{-1, -1}; // Matriz vacía o inválida
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
        // Ejemplo de uso
        int[][] temperaturas = {
            {25, 28, 32, 35, 29, 27, 26}, // Ciudad 0
            {18, 15, 20, 22, 19, 17, 16}, // Ciudad 1
            {30, 31, 36, 28, 33, 34, 29}, // Ciudad 2
            {5, 8, 12, 10, 7, 9, 11}     // Ciudad 3
        };

        // 1. Contar días calurosos
        int diasCalurosos = contarDiasCalurosos(temperaturas);
        System.out.println("Número de días con temperaturas mayores a 30°C: " + diasCalurosos); // Esperado: 7 (32, 35, 31, 36, 33, 34, 28)

        // 2. Promedio de días frescos
        double promedioFrescos = promedioDiasFrescos(temperaturas);
        System.out.println("Promedio de temperaturas menores a 20°C: " + String.format("%.2f", promedioFrescos)); // Esperado: (18+15+19+17+16+5+8+12+10+7+9+11)/12 = 11.42

        // 3. Imprimir temperaturas extremas
        imprimirTemperaturasExtremas(temperaturas);
        /* Esperado:
           Temperatura muy fría: 5°C en la posición [3][0]
           Temperatura muy fría: 8°C en la posición [3][1]
           Temperatura muy fría: 7°C en la posición [3][4]
           Temperatura muy fría: 9°C en la posición [3][5]
           Temperatura muy caliente: 36°C en la posición [2][2]
        */

        // 4. Posición de la temperatura más alta
        int[] posicionAlta = posicionTemperaturaMasAlta(temperaturas);
        System.out.println("La temperatura más alta se registró en la posición: [" + posicionAlta[0] + "][" + posicionAlta[1] + "]"); // Esperado: [2][2] (36°C)
    }
}