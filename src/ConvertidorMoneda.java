import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class ConvertidorMoneda {

    private static final String API_URL = "https://v6.exchangerate-api.com/v6/2700f5ff2c8c80f25587f2fa/pair/";
    public static void main(String[] args) {
        java.util.Scanner scanner = new java.util.Scanner(System.in);
        while (true){
            System.out.println("\n***************");

            System.out.println("Bienvenido al conversor de moneda");

            System.out.println("Elija una opcion");

            String opciones = """
                
                1) Dolar a Peso argentino
                2) Peso argentino a dolar
                3) Dolar a Real brasileño
                4) Real brasileño a Dolar
                5) Dolar a Peso colombiano
                6) Peso colombiano a dolar
                7) Salir
                
                """;
            System.out.println(opciones);
            int opcion = scanner.nextInt();
            if (opcion == 7){
                System.out.println("Saliste del programa");
                break;
            }

            if (opcion < 1 || opcion > 7){
                System.out.println("Opcion no valida. Elija una opcion Valida");
                continue;
            }
            System.out.println("Ingrese la cantidad a convertir: ");
            double cantidad = scanner.nextDouble();
            double resultado = 0;

            switch (opcion) {
                case 1:
                    resultado = convertir ("USD", "ARS", cantidad);
                    System.out.printf("%.2f Dólares = %.2f Pesos argentinos%n", cantidad, resultado);
                    break;
                case 2:
                    resultado = convertir("ARS", "USD", cantidad);
                    System.out.printf("%.2f Pesos argentinos = %.2f Dólares%n", cantidad, resultado);
                    break;
                case 3:
                    resultado = convertir("USD", "BRL", cantidad);
                    System.out.printf("%.2f Dólares = %.2f Reales brasileños%n", cantidad, resultado);
                    break;
                case 4:
                    resultado = convertir("BRL", "USD", cantidad);
                    System.out.printf("%.2f Reales brasileños = %.2f Dólares%n", cantidad, resultado);
                    break;
                case 5:
                    resultado = convertir("USD", "COP", cantidad);
                    System.out.printf("%.2f Dólares = %.2f Pesos colombianos%n", cantidad, resultado);
                    break;
                case 6:
                    resultado = convertir("COP", "USD", cantidad);
                    System.out.printf("%.2f Pesos colombianos = %.2f Dólares%n", cantidad, resultado);
                    break;
            }

        }
        scanner.close();
    }
    private static double convertir(String from, String to, double cantidad) {
        try {
            String urlString = API_URL + from + "/" + to;
            URL url = new URL(urlString);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");

            if (conn.getResponseCode() != 200) {
                throw new RuntimeException("Error en la conexión: " + conn.getResponseCode());
            }

            BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            StringBuilder response = new StringBuilder();
            String inputLine;

            while ((inputLine = in.readLine()) != null) {
                response.append(inputLine);
            }
            in.close();

            // Deserializar la respuesta JSON usando Gson
            Gson gson = new Gson();
            RespuestaCambio respuesta = gson.fromJson(response.toString(), RespuestaCambio.class);
            double tasaCambio = respuesta.getConversionRate();

            return cantidad * tasaCambio;

        } catch (Exception e) {
            System.out.println("Error al realizar la conversión: " + e.getMessage());
            return 0;
        }
    }

}