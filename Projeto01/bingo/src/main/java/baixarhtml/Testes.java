/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package baixarhtml;

import com.google.zxing.WriterException;

/**
 *
 * @author Jonas
 */
public class Testes {
    public static void main(String[] args) throws WriterException {
        GeradorDeQr teste= new GeradorDeQr(FileUploader.getLinkDownload());
        
    }
}
