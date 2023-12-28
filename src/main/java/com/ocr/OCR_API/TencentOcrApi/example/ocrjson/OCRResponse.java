package com.ocr.OCR_API.TencentOcrApi.example.ocrjson;

import java.util.List;

public class OCRResponse {
    private List<TextDetection> TextDetections;
    private String Language;
    private double Angel;  
    private int PdfPageSize;
    private double Angle;
    private String RequestId;



    public static class TextDetection {
        public String getDetectedText() {
            return DetectedText;
        }

        public void setDetectedText(String detectedText) {
            DetectedText = detectedText;
        }

        public double getConfidence() {
            return Confidence;
        }

        public void setConfidence(double confidence) {
            Confidence = confidence;
        }

        public List<Polygon> getPolygon() {
            return Polygon;
        }

        public void setPolygon(List<Polygon> polygon) {
            Polygon = polygon;
        }

        public String getAdvancedInfo() {
            return AdvancedInfo;
        }

        public void setAdvancedInfo(String advancedInfo) {
            AdvancedInfo = advancedInfo;
        }

        public ItemPolygon getItemPolygon() {
            return ItemPolygon;
        }

        public void setItemPolygon(ItemPolygon itemPolygon) {
            ItemPolygon = itemPolygon;
        }

        private String DetectedText;
        private double Confidence;
        private List<Polygon> Polygon;
        private String AdvancedInfo;
        private ItemPolygon ItemPolygon;


        public static class Polygon {
            public double getX() {
                return X;
            }
            public void setX(double x) {
                X = x;
            }
            public double getY() {
                return Y;
            }
            public void setY(double y) {
                Y = y;
            }
            private double X;
            private double Y;


        }

        public static class ItemPolygon {
            private double X;
            private double Y;
            private double Width;
            private double Height;


        }

    }
}
