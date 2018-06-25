package pdf.kit;

import lombok.Data;

import java.util.List;

/**
 * Created by fgm on 2017/4/17.
 */
@Data
public class TemplateBO {

   private String checkNo;
   private String title;
   private String checkDate;
   private String author;
   private String totalWordCopyPercent;
   private int totalWordNum;
   private int totalCopyNum;
   private List<String> likeSourceList;
   private String markTxt;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getCheckNo() {
        return checkNo;
    }

    public void setCheckNo(String checkNo) {
        this.checkNo = checkNo;
    }

    public String getCheckDate() {
        return checkDate;
    }

    public void setCheckDate(String checkDate) {
        this.checkDate = checkDate;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getTotalWordCopyPercent() {
        return totalWordCopyPercent;
    }

    public void setTotalWordCopyPercent(String totalWordCopyPercent) {
        this.totalWordCopyPercent = totalWordCopyPercent;
    }

    public int getTotalWordNum() {
        return totalWordNum;
    }

    public void setTotalWordNum(int totalWordNum) {
        this.totalWordNum = totalWordNum;
    }

    public int getTotalCopyNum() {
        return totalCopyNum;
    }

    public void setTotalCopyNum(int totalCopyNum) {
        this.totalCopyNum = totalCopyNum;
    }

    public List<String> getLikeSourceList() {
        return likeSourceList;
    }

    public void setLikeSourceList(List<String> likeSourceList) {
        this.likeSourceList = likeSourceList;
    }

    public String getMarkTxt() {
        return markTxt;
    }

    public void setMarkTxt(String markTxt) {
        this.markTxt = markTxt;
    }
}
