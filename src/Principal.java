import java.util.InputMismatchException;
import java.util.Scanner;

public class Principal {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ConversorMoneda conversor = new ConversorMoneda();

        System.out.println("***************************************");
        System.out.println("");
        System.out.println("Bienvenido al conversor de monedas");
        System.out.println("1- Dólar => Peso argentino");
        System.out.println("2- Peso argentino => Dólar");
        System.out.println("3- Dólar => Real brasileño");
        System.out.println("4- Real brasileño => Dólar");
        System.out.println("5- Dólar => Peso colombiano");
        System.out.println("6- Peso colombiano => Dólar");
        System.out.println("7- Salir");
        System.out.println("");
        System.out.println("***************************************");
        System.out.println("Elige una opción válida:");

        try {
            int opcionMoneda = 0;
            opcionMoneda = scanner.nextInt();

            if (opcionMoneda >= 1 && opcionMoneda <= 7) {
                System.out.println("Ingresa la cantidad a convertir:");
                double monto = scanner.nextDouble();
                String monedaBase = "";
                String monedaCambio = "";

                switch (opcionMoneda) {
                    case 1:
                        monedaBase = "USD";
                        monedaCambio = "ARS";
                        break;
                    case 2:
                        monedaBase = "ARS";
                        monedaCambio = "USD";
                        break;
                    case 3:
                        monedaBase = "USD";
                        monedaCambio = "BRL";
                        break;
                    case 4:
                        monedaBase = "BRL";
                        monedaCambio = "USD";
                        break;
                    case 5:
                        monedaBase = "USD";
                        monedaCambio = "COP";
                        break;
                    case 6:
                        monedaBase = "COP";
                        monedaCambio = "USD";
                        break;
                }
                double montoConvertido = conversor.convertir(monedaBase, monedaCambio, monto);
                System.out.println(monto + " " + monedaBase + " es igual a " + montoConvertido +
                        " " + monedaCambio);
            } else if (opcionMoneda == 7) {
                System.out.println("Gracias por usar el conversor de monedas.");
            } else {
                System.out.println("Opción no válida.");
            }
        } catch (Exception e) {
            System.out.println("Opción no válida. Inténtelo de nuevo.");
        }
    }
}