package com.ocr.OCR_API.TencentOcrApi.ocrjson;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.ocr.OCR_API.TencentOcrApi.ocrjson.Parag;
import com.ocr.OCR_API.TencentOcrApi.ocrjson.TextDetections;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

public class GeneralBasicOCR
{
    String Base64img;
    String SecretId;
    String SecretKey;
    String Region;
    tencentOCR tocr=new tencentOCR();
    public GeneralBasicOCR(String Base64img,String SecretId,String SecretKey,String Region){
        this.Base64img=Base64img;
        this.SecretId=SecretId;
        this.SecretKey=SecretKey;
        this.Region=Region;
    }
    public String sendAPI(){
        return tocr.ocrAPI(Base64img, SecretId, SecretKey, Region);
    }
    public String transferjSON(String jsonString){
        String result="";
        Gson gson=new Gson();
        int line=1;
        String adv;
        String ParagNoStr;
        int ParagNo=-1;
        JsonRootBean tj=gson.fromJson(jsonString, JsonRootBean.class);
        for(int i =0; i<tj.getTextDetections().size();i++){
            ParagNoStr="";
            adv=tj.getTextDetections().get(i).getAdvancedInfo();
            for(int j=0;j<adv.length();j++){
                if(Character.isDigit(adv.charAt(j))){
                    ParagNoStr+=adv.charAt(j);
                }
            }
        ParagNo=Integer.parseInt(ParagNoStr);
            //System.out.println(adv);
        if(ParagNo!=line){
            result+="\n";
            line=ParagNo;
        }
        result+=tj.getTextDetections().get(i).getDetectedText()+" ";
            
        }
        result+="\n";
        return result;
    }
    public void setBase64img(String base64img) {
        Base64img = base64img;
    }
    public void setSecretId(String secretId) {
        SecretId = secretId;
    }
    public void setSecretKey(String secretKey) {
        SecretKey = secretKey;
    }
    public void setRegion(String region) {
        Region = region;
    }
    public void setTocr(tencentOCR tocr) {
        this.tocr = tocr;
    }
}