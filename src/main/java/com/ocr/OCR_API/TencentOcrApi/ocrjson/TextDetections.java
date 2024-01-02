/**
  * Copyright 2023 json.cn 
  */
package com.ocr.OCR_API.TencentOcrApi.ocrjson;
import java.util.List;

/**
 * Auto-generated: 2023-12-27 13:15:38
 *
 * @author json.cn (i@json.cn)
 * @website http://www.json.cn/java2pojo/
 */
public class TextDetections {

    private String DetectedText;
    private int Confidence;
    private List<Polygon> Polygon;
    private String AdvancedInfo;
    private ItemPolygon ItemPolygon;
    private List<String> Words;
    private List<String> WordCoordPoint;
    public void setDetectedText(String DetectedText) {
         this.DetectedText = DetectedText;
     }
     public String getDetectedText() {
         return DetectedText;
     }

    public void setConfidence(int Confidence) {
         this.Confidence = Confidence;
     }
     public int getConfidence() {
         return Confidence;
     }

    public void setPolygon(List<Polygon> Polygon) {
         this.Polygon = Polygon;
     }
     public List<Polygon> getPolygon() {
         return Polygon;
     }

    public void setAdvancedInfo(String AdvancedInfo) {
         this.AdvancedInfo = AdvancedInfo;
     }
     public String getAdvancedInfo() {
         return AdvancedInfo;
     }

    public void setItemPolygon(ItemPolygon ItemPolygon) {
         this.ItemPolygon = ItemPolygon;
     }
     public ItemPolygon getItemPolygon() {
         return ItemPolygon;
     }

    public void setWords(List<String> Words) {
         this.Words = Words;
     }
     public List<String> getWords() {
         return Words;
     }

    public void setWordCoordPoint(List<String> WordCoordPoint) {
         this.WordCoordPoint = WordCoordPoint;
     }
     public List<String> getWordCoordPoint() {
         return WordCoordPoint;
     }

}