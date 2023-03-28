import java.net.URI;
import java.net.URL;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandler;
import java.net.http.HttpResponse.BodyHandlers;
import java.util.List;
import java.util.Map;

public class App {
    // Consumir o endpoint de filmes mais populares da API do IMDB. Procure também,
    // na documentação da API do IMDB,
    // o endpoint que retorna as melhores séries e o que retorna as séries mais
    // populares.
    public static void main(String[] args) throws Exception {
        // Series mais populares  --->>>  String url = "https://raw.githubusercontent.com/alura-cursos/imersao-java-2-api/main/MostPopularTVs.json"
        // Mehores series  --->>>  String url = "https://raw.githubusercontent.com/alura-cursos/imersao-java-2-api/main/TopTVs.json"
        //Fazer a conexão do endpoint de filmes mais populares
        String url = "https://raw.githubusercontent.com/alura-cursos/imersao-java-2-api/main/MostPopularMovies.json";
        URI endereco = URI.create(url);
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder(endereco).GET().build();
        HttpResponse<String> response = client.send(request, BodyHandlers.ofString());
        String body = response.body();
        //System.out.println(body);


        //Pegar apenas os dados necessários  (titulo, poster, classificação)
        var parser = new JsonParser();
        List<Map<String, String>> filmesMaisPopulares = parser.parse(body);
        

        //Extrair os dados
        for (Map<String,String> filme : filmesMaisPopulares) {
            System.out.println("Titulo -> " + filme.get("title"));
            System.out.println("Poster ->" + filme.get("image"));
            System.out.println("Classificação ->" + filme.get("imDbRating"));
            System.out.println();
        }
    }
}
