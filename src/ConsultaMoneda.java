import com.google.gson.Gson;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ConsultaMoneda {
    Moneda buscaMoneda(String monedaBase, String monedaCambio) {
        URI direccion = URI.create("https://v6.exchangerate-api.com/v6/16f97a2a7cdc6dfd409d3909/pair/" +
                monedaBase + "/" + monedaCambio);

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(direccion)
                .build();

        HttpResponse<String> response = null;
        try {
            response = client
                    .send(request, HttpResponse.BodyHandlers.ofString());
        } catch (Exception e) {
            throw new RuntimeException("No encontré esa Moneda.");
        }

        return new Gson().fromJson(response.body(), Moneda.class);
    }
}
