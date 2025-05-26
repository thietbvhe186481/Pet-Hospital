/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entity;

import java.security.Timestamp;

/**
 *
 * @author LENOVO
 */
public class News {
  private String newsId;
    private String imageUrl;
    private Timestamp postTime;
    private String description;
    private boolean isActive;  

    public News() {
    }

    public News(String imageUrl, Timestamp postTime, String description, boolean isActive) {
        this.imageUrl = imageUrl;
        this.postTime = postTime;
        this.description = description;
        this.isActive = isActive;
    }

    public News(String newsId, String imageUrl, Timestamp postTime, String description, boolean isActive) {
        this.newsId = newsId;
        this.imageUrl = imageUrl;
        this.postTime = postTime;
        this.description = description;
        this.isActive = isActive;
    }

    public String getNewsId() {
        return newsId;
    }

    public void setNewsId(String newsId) {
        this.newsId = newsId;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public Timestamp getPostTime() {
        return postTime;
    }

    public void setPostTime(Timestamp postTime) {
        this.postTime = postTime;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isIsActive() {
        return isActive;
    }

    public void setIsActive(boolean isActive) {
        this.isActive = isActive;
    }

    @Override
    public String toString() {
        return "News{" + "newsId=" + newsId + ", imageUrl=" + imageUrl + ", postTime=" + postTime + ", description=" + description + ", isActive=" + isActive + '}';
    }
    
    
}
