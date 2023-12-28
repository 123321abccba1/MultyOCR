package com.ocr.OCR_API.TencentOcrApi.example;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.example.ocrjson.JsonRootBean;
import com.example.ocrjson.Parag;
import com.example.ocrjson.TextDetections;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

public class String void GeneralBasicOCR()throws IOException
{
    FileInputStream fis = new FileInputStream("src/main/java/com/example/ocrRecord.ini");
    String hs="";
    int temp;
    while ((temp=fis.read()) != -1) {
        hs+=(char)temp;
    }
    Gson gson=new Gson();
    int line=1;
    String adv;
    String ParagNoStr;
    int ParagNo=-1;
    JsonRootBean tj=gson.fromJson(hs, JsonRootBean.class);
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
        System.out.println();
        line=ParagNo;
    }
    System.out.print(tj.getTextDetections().get(i).getDetectedText()+" ");
        
    }
    System.out.println();
}