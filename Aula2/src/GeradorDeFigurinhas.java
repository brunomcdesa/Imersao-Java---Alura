import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.InputStream;
import java.awt.Font;

import javax.imageio.ImageIO;

public class GeradorDeFigurinhas {

    public void criar() throws Exception {
        // Leitura da imagem
        BufferedImage imgOriginal = ImageIO.read(new File("imgEntrada/filme.jpg"));

        // Criar nova imagem com transparencia e com tamanho novo
        int largura = imgOriginal.getWidth();
        int altura = imgOriginal.getHeight();
        int novaAltura = altura + 200;
        BufferedImage novaImagem = new BufferedImage(largura, novaAltura, BufferedImage.TRANSLUCENT);

        // Copiar a imagem original para a nova imagem (em memoria)
        Graphics2D graphics = (Graphics2D) novaImagem.getGraphics();
        graphics.drawImage(imgOriginal, 0, 0, null);

        // Configurar fonte
        var fonte = new Font(Font.SANS_SERIF, Font.BOLD, 32);
        graphics.setFont(fonte);

        // Escrever uma frase na nova imagem
        graphics.drawString("TOPZERA", 0, novaAltura-100);

        // Escrever a nova imagem em um arquivo
        ImageIO.write(novaImagem, "png", new File("imgSaida/figurinha.png"));
    }

    public static void main(String[] args) throws Exception {
       var gerador = new GeradorDeFigurinhas();
       gerador.criar();
    }
}
