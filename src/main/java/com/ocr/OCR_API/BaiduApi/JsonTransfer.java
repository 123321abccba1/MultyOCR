package com.ocr.OCR_API.BaiduApi;

import java.util.List;
public class JsonTransfer {

    private List<Words_result> words_result;
    private int words_result_num;
    private String log_id;
    public void setWords_result(List<Words_result> words_result) {
         this.words_result = words_result;
     }
     public List<Words_result> getWords_result() {
         return words_result;
     }

    public void setWords_result_num(int words_result_num) {
         this.words_result_num = words_result_num;
     }
     public int getWords_result_num() {
         return words_result_num;
     }

    public void setLog_id(String log_id) {
         this.log_id = log_id;
     }
     public String getLog_id() {
         return log_id;
     }

}