package com.ocr.OCR_API.TencentOcrApi.example.ocrjson;

/**
  * Copyright 2023 json.cn 
  */

import java.util.List;

/**
 * Auto-generated: 2023-12-27 13:15:38
 *
 * @author json.cn (i@json.cn)
 * @website http://www.json.cn/java2pojo/
 */
public class JsonRootBean {

    private List<TextDetections> TextDetections;
    private String Language;
    private double Angel;
    private int PdfPageSize;
    private double Angle;
    private String RequestId;
    public void setTextDetections(List<TextDetections> TextDetections) {
         this.TextDetections = TextDetections;
     }
     public List<TextDetections> getTextDetections() {
         return TextDetections;
     }

    public void setLanguage(String Language) {
         this.Language = Language;
     }
     public String getLanguage() {
         return Language;
     }

    public void setAngel(double Angel) {
         this.Angel = Angel;
     }
     public double getAngel() {
         return Angel;
     }

    public void setPdfPageSize(int PdfPageSize) {
         this.PdfPageSize = PdfPageSize;
     }
     public int getPdfPageSize() {
         return PdfPageSize;
     }

    public void setAngle(double Angle) {
         this.Angle = Angle;
     }
     public double getAngle() {
         return Angle;
     }

    public void setRequestId(String RequestId) {
         this.RequestId = RequestId;
     }
     public String getRequestId() {
         return RequestId;
     }

}