import com.google.gson.*;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class Connection {

    public UsableData grabData(String key) {
        try {
            HttpClient client = HttpClient.newHttpClient();
            HttpRequest request = HttpRequest.newBuilder().uri(URI.create("https://v6.exchangerate-api.com/v6/"+key+"/latest/BRL")).build();
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

            String json = response.body();
            Gson gson = new GsonBuilder().setFieldNamingPolicy(FieldNamingPolicy.UPPER_CASE_WITH_UNDERSCORES).create();

            JsonObject object = JsonParser.parseString(json).getAsJsonObject();
            JsonObject getData = object.getAsJsonObject("conversion_rates");

            String newJson = getData.toString();


            return gson.fromJson(newJson, UsableData.class);


        } catch (IOException | InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
