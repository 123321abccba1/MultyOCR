package com.ocr.OCR_API.BaiduApi;

import java.io.IOException;
import java.net.URLEncoder;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Base64;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.JsonObject;

import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import okhttp3.*;

import java.io.*;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.ocr.OCR_API.TencentOcrApi.ocrjson.JsonRootBean;

public class BaiduApi {
    public String API_KEY = "";
    public String SECRET_KEY = "";
    static final OkHttpClient HTTP_CLIENT = new OkHttpClient().newBuilder().build();

    public BaiduApi(String aPI_KEY, String sECRET_KEY) {
        API_KEY = aPI_KEY;
        SECRET_KEY = sECRET_KEY;
    }



    public String sendApi(String imageBase64String) throws IOException{
        MediaType mediaType = MediaType.parse("application/x-www-form-urlencoded");
        RequestBody body = RequestBody.create(mediaType, "image="+imageBase64String+"&detect_direction=false&detect_language=false&paragraph=false&probability=false");
        Request request = new Request.Builder()
            .url("https://aip.baidubce.com/rest/2.0/ocr/v1/general_basic?access_token=" + getAccessToken())
            .method("POST", body)
            .addHeader("Content-Type", "application/x-www-form-urlencoded")
            .addHeader("Accept", "application/json")
            .build();
        Response response = HTTP_CLIENT.newCall(request).execute();
        return response.body().string();

    }
    
    

    public String getAccessToken() throws IOException {
        MediaType mediaType = MediaType.parse("application/x-www-form-urlencoded");
        RequestBody body = RequestBody.create(mediaType, "grant_type=client_credentials&client_id=" + API_KEY
            + "&client_secret=" + SECRET_KEY);
        Request request = new Request.Builder()
            .url("https://aip.baidubce.com/oauth/2.0/token")
            .method("POST", body)
            .addHeader("Content-Type", "application/x-www-form-urlencoded")
            .build();
        Response response = HTTP_CLIENT.newCall(request).execute();
        String responseBody = response.body().string();
        JsonObject jsonObject = JsonParser.parseString(responseBody).getAsJsonObject();
        return jsonObject.get("access_token").getAsString();
    }
    public String transferjSON(String jsonString){
        Gson gson=new Gson();
        String result="";
        JsonTransfer jt=gson.fromJson(jsonString, JsonTransfer.class);
        List<Words_result> worlds=jt.getWords_result();
        for(int i=0;i<jt.getWords_result_num();i++){
            result+=worlds.get(i).getWords();
            result+="\n";
        }
        return result;
        
    }
 /**
     * 获取文件base64编码
     *
     * @param path      文件路径
     * @param urlEncode 如果Content-Type是application/x-www-form-urlencoded时,传true
     * @return base64编码信息，不带文件头
     * @throws IOException IO异常
     */
    public static String getFileContentAsBase64(String path, boolean urlEncode) throws IOException {
        byte[] b = Files.readAllBytes(Paths.get(path));
        String base64 = Base64.getEncoder().encodeToString(b);
        if (urlEncode) {
            base64 = URLEncoder.encode(base64, "utf-8");
        }
        return base64;
    }

    public void setAPI_KEY(String aPI_KEY) {
        API_KEY = aPI_KEY;
    }


    public void setSECRET_KEY(String sECRET_KEY) {
        SECRET_KEY = sECRET_KEY;
    }
    
}
