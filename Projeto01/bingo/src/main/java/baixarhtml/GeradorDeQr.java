package baixarhtml;

import java.awt.BorderLayout;
import java.awt.image.BufferedImage;
import java.io.File; // Importa o formato do código de barras (incluindo QR Code).
import java.io.IOException; // Define configurações adicionais para geração do QR Code.
import java.nio.file.Path; // Exceção lançada ao ocorrer erro na escrita do QR Code.
import java.util.HashMap; // Converte a matriz do QR Code em uma imagem.
import java.util.Map; // Estrutura de dados que representa o QR Code em forma de matriz.

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import com.google.zxing.BarcodeFormat; // Classe principal usada para gerar o QR Code.
import com.google.zxing.EncodeHintType; // Permite trabalhar com arquivos no sistema.
import com.google.zxing.WriterException; // Exceção lançada para erros relacionados ao sistema de arquivos.
import com.google.zxing.client.j2se.MatrixToImageWriter; // Representa o caminho para o arquivo no sistema.
import com.google.zxing.common.BitMatrix; // Estrutura de dados para armazenar configurações em pares chave-valor.
import com.google.zxing.qrcode.QRCodeWriter; // Interface usada para o mapa de configurações.

public class GeradorDeQr {

    //private BufferedImage qrImage;

    public GeradorDeQr (String link){
        // O conteúdo do QR Code. Pode ser um link, texto ou qualquer dado que você deseje codificar.
        String data = link; 

        // Caminho do arquivo onde o QR Code será salvo.
        String filePath = "qrcode.png"; 
        
        // Dimensões do QR Code.
        int width = 300; // Largura da imagem do QR Code.
        int height = 300; // Altura da imagem do QR Code.

        // Formato da imagem do QR Code (PNG neste caso).
        String fileFormat = "png"; 

        try {
            // Configurações para o QR Code.
            Map<EncodeHintType, Object> hints = new HashMap<>();
            hints.put(EncodeHintType.CHARACTER_SET, "UTF-8"); // Define o charset para suportar caracteres especiais.

            // Instancia um objeto para gerar o QR Code.
            QRCodeWriter qrCodeWriter = new QRCodeWriter();

            // Gera a matriz do QR Code com base nos dados fornecidos.
            BitMatrix bitMatrix = qrCodeWriter.encode(data, BarcodeFormat.QR_CODE, width, height, hints);

            // Define o caminho do arquivo onde o QR Code será salvo.
            Path path = new File(filePath).toPath();

            // Converte a matriz do QR Code em uma imagem e a salva no caminho especificado.
            MatrixToImageWriter.writeToPath(bitMatrix, fileFormat, path);
            BufferedImage qrImage = MatrixToImageWriter.toBufferedImage(bitMatrix);
            TelaQrCode(qrImage);

            // Exibe uma mensagem de sucesso ao gerar o QR Code.
            System.out.println("QR Code gerado com sucesso em: " + filePath);
        } catch (WriterException | IOException e) {
            // Caso ocorra algum erro durante o processo, exibe a mensagem de erro.
            System.err.println("Erro ao gerar o QR Code: " + e.getMessage());
        }

    }

    public void TelaQrCode(BufferedImage qrImage){
        JLabel mostre = new JLabel(new ImageIcon(qrImage));
        JPanel p = new JPanel();
        p.add(mostre);


        JFrame janela = new JFrame();
        janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        janela.setSize(400, 400);
        janela.setLayout(new BorderLayout());
        janela.setLocationRelativeTo(null);
        janela.setResizable(false);
        janela.getContentPane().add(p);
        janela.setVisible(true);
    }
    
}
