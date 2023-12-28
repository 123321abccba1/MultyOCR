package com.ocr.OCR_API.TencentOcrApi.example;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Base64;



public class pictureBase64 {

     public static String imageToBase64Str(String imgFile) {
        File file = new File(imgFile);
        try (FileInputStream imageInFile = new FileInputStream(file)) {
            byte[] imageData = new byte[(int) file.length()];
            imageInFile.read(imageData);
            return Base64.getEncoder().encodeToString(imageData);
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
}
