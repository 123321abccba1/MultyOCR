package com.ocr;
import com.ocr.OCR_API.TencentOcrApi.example.pictureBase64;
import com.ocr.OCR_API.TencentOcrApi.example.tencentOCR;


public class Main {
    public static void main(String[] args) {
        String SecretId="AKIDwnhUAmMjr0mLky3yeeU7WlncPu0FI6jD";
        String SecretKey="KPHxPehiX7TaJwMXS9cXKxUyPdeS3MTM";
        String Region="ap-guangzhou";
        String base64img = pictureBase64.imageToBase64Str("src/main/java/com/ocr/OCR_API/cache/img.png");
        tencentOCR tocr=new tencentOCR();
        System.out.println(tocr.ocrAPI(base64img, SecretId, SecretKey,Region));
    }
}