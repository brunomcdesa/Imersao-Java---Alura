import java.io.InputStream;
import java.net.URL;
import java.util.List;

public class App {
    public static void main(String[] args) throws Exception {
        System.out.println("Hello, World!");

        // Fazer uma conexão HTTP e buscar os TOP 250 filmes
        //String url ="https://raw.githubusercontent.com/alura-cursos/imersao-java-2-api/main/TopMovies.json";
       // var extrator = new ExtratorDeConteudoIMDB();

        String url = "https://raw.githubusercontent.com/alura-cursos/imersao-java-2-api/main/NASA-APOD.json";
        var extrator = new ExtratorDeConteudoNasa();
        var http = new ClienteHTTp();
        String json = http.buscaDados(url);

        // Exibir e manipular os dados

        List<Conteudo> conteudos = extrator.extrairConteudo(json);

        var gerador = new GeradorDeFigurinhas();
        for (Conteudo conteudo : conteudos) {

            // String urlImagem = conteudo.get("image");

            InputStream inputStream = new URL(conteudo.getUrlImagem()).openStream();
            String nomeArquivo = "saida/" + conteudo.getTitulo() + ".png";

            gerador.criar(inputStream, nomeArquivo);

            System.out.println(conteudo.getTitulo());
            System.out.println();
        }
    }
}
