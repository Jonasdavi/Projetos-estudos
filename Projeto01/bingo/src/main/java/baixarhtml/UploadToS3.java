package baixarhtml;

import software.amazon.awssdk.auth.credentials.ProfileCredentialsProvider; // Provedor de credenciais (arquivo local ~/.aws/credentials).
import software.amazon.awssdk.regions.Region; // Região onde o bucket S3 está localizado.
import software.amazon.awssdk.services.s3.S3Client; // Cliente S3 para interagir com o serviço.
import software.amazon.awssdk.services.s3.model.PutObjectRequest; // Classe para configurar a requisição de upload.

import java.io.File; // Classe para trabalhar com arquivos locais.

public class UploadToS3 {
    public static void main(String[] args) {
        // Nome do bucket S3 onde o arquivo será enviado.
        String bucketName = "meu-bucket";

        // Caminho do arquivo local que será enviado para o S3.
        String filePath = "qrcode.png";

        // Nome do arquivo no bucket S3 (chave de armazenamento).
        String keyName = "qrcodes/qrcode.png";

        // Define a região onde o bucket S3 está localizado (altere conforme necessário).
        Region region = Region.US_EAST_1;

        // Criação do cliente S3 para comunicação com o serviço.
        S3Client s3 = S3Client.builder()
                .region(region) // Define a região do bucket.
                .credentialsProvider(ProfileCredentialsProvider.create()) // Define o provedor de credenciais (perfil local).
                .build();

        try {
            // Configuração do pedido de upload do arquivo.
            PutObjectRequest putObjectRequest = PutObjectRequest.builder()
                    .bucket(bucketName) // Nome do bucket S3.
                    .key(keyName) // Caminho/identificador do arquivo dentro do bucket.
                    .build();

            // Envia o arquivo local para o bucket S3 usando a configuração definida acima.
            s3.putObject(putObjectRequest, new File(filePath).toPath());

            // Mensagem de sucesso após o upload.
            System.out.println("Arquivo enviado com sucesso para o bucket S3: " + bucketName);
        } catch (Exception e) {
            // Tratamento de erros durante o upload.
            System.err.println("Erro ao enviar o arquivo: " + e.getMessage());
        } finally {
            // Fecha o cliente S3 para liberar os recursos.
            s3.close();
        }
    }
}
