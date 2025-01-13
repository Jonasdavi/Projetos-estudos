package baixarhtml;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;

import org.json.JSONException;
import org.json.JSONObject;

public class FileUploader {
    public FileUploader() {
        
    }

    public static String getLinkDownload(){
        try {
            String filePath = "src/main/java/cartelahtml/cartela_nova.html"; // Substitua pelo caminho do seu arquivo
            File file = new File(filePath);

            // Verifica se o arquivo existe
            if (!file.exists() || file.length() == 0) {
                System.out.println("Arquivo não encontrado ou vazio.");
                return "";
            }

            String urlString = "https://file.io";
            String boundary = Long.toHexString(System.currentTimeMillis()); // Gera um boundary único

            HttpURLConnection conn = (HttpURLConnection) new URL(urlString).openConnection();
            conn.setDoOutput(true);
            conn.setRequestMethod("POST");
            conn.setRequestProperty("Content-Type", "multipart/form-data; boundary=" + boundary);

            try (DataOutputStream out = new DataOutputStream(conn.getOutputStream())) {
                out.writeBytes("--" + boundary + "\r\n");
                out.writeBytes("Content-Disposition: form-data; name=\"file\"; filename=\"" + file.getName() + "\"\r\n");
                out.writeBytes("Content-Type: application/octet-stream\r\n"); // Adicionando o tipo de conteúdo
                out.writeBytes("\r\n");

                // Lê o arquivo e escreve no output stream
                try (FileInputStream fis = new FileInputStream(file)) {
                    byte[] buffer = new byte[4096];
                    int bytesRead;
                    while ((bytesRead = fis.read(buffer)) != -1) {
                        out.write(buffer, 0, bytesRead);
                    }
                }
                
                out.writeBytes("\r\n--" + boundary + "--\r\n");
            }

            // Verifica a resposta
            int responseCode = conn.getResponseCode();
            if (responseCode == HttpURLConnection.HTTP_OK) {
                BufferedReader reader = new BufferedReader(new InputStreamReader(conn.getInputStream()));
                StringBuilder response = new StringBuilder();
                String line;
                while ((line = reader.readLine()) != null) {
                    response.append(line);
                }
                reader.close();

                // Analisa a resposta JSON e extrai o link
                JSONObject jsonResponse = new JSONObject(response.toString());
                String downloadLink = jsonResponse.getString("link");

                //System.out.println(downloadLink);

                // Exibe o link gerado
                return downloadLink;
            }
        } catch (IOException e) {
            e.printStackTrace();
        } 
        return "";
    }
}
