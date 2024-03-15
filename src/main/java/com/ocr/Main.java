package com.ocr;
import java.io.IOException;
import java.util.Scanner;

import com.ocr.OCR_API.BaiduApi.BaiduApi;
import com.ocr.OCR_API.TencentOcrApi.ocrjson.GeneralBasicOCR;
import com.ocr.function.pictureBase64;


public class Main {
    public static void main(String[] args) throws IOException {
        System.out.println("Select OCR provider(1.tencen 2.Baidu):");

        Scanner scan = new Scanner(System.in);
        String select = scan.next();
        String imagePath="src/main/java/com/ocr/OCR_API/cache/test.png";//Set image Path
        pictureBase64 pb64=new pictureBase64();
        //Tencent OCR
        if (select.equals("1")) {
            String base64img = pb64.getFileContentAsBase64(imagePath, false);//get ImageBase64
            String SecretId="";//Set SecretId here
            String SecretKey="";//Set SecretKey here
            String Region="ap-guangzhou";// Set server location
            GeneralBasicOCR gbo=new GeneralBasicOCR(base64img, SecretId, SecretKey, Region);
            System.out.println(gbo.transferjSON(gbo.sendAPI()));
        }
        //Baidu OCR
        else if (select.equals("2")) {
            String API_KEY = "";//Set API_key here
            String SECRET_KEY = "";//Set SECRET_KEY here
            BaiduApi bApi=new BaiduApi(API_KEY,SECRET_KEY);
            String base64img=pb64.getFileContentAsBase64(imagePath, true);//get ImageBase64
            String JsonResult =bApi.sendApi(base64img);
            System.out.println(bApi.transferjSON(JsonResult));

        }
    }
}