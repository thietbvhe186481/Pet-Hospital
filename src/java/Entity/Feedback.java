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
public class Feedback {
    private String feedbackId;
    private String userId;
    private String employeeId;
    private String feedbackText;
    private String replyText;
    private Timestamp postTime;
    private int starRating;

    public Feedback() {
    }

    public Feedback(String userId, String employeeId, String feedbackText, String replyText, Timestamp postTime, int starRating) {
        this.userId = userId;
        this.employeeId = employeeId;
        this.feedbackText = feedbackText;
        this.replyText = replyText;
        this.postTime = postTime;
        this.starRating = starRating;
    }

    public Feedback(String feedbackId, String userId, String employeeId, String feedbackText, String replyText, Timestamp postTime, int starRating) {
        this.feedbackId = feedbackId;
        this.userId = userId;
        this.employeeId = employeeId;
        this.feedbackText = feedbackText;
        this.replyText = replyText;
        this.postTime = postTime;
        this.starRating = starRating;
    }

    public String getFeedbackId() {
        return feedbackId;
    }

    public void setFeedbackId(String feedbackId) {
        this.feedbackId = feedbackId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(String employeeId) {
        this.employeeId = employeeId;
    }

    public String getFeedbackText() {
        return feedbackText;
    }

    public void setFeedbackText(String feedbackText) {
        this.feedbackText = feedbackText;
    }

    public String getReplyText() {
        return replyText;
    }

    public void setReplyText(String replyText) {
        this.replyText = replyText;
    }

    public Timestamp getPostTime() {
        return postTime;
    }

    public void setPostTime(Timestamp postTime) {
        this.postTime = postTime;
    }

    public int getStarRating() {
        return starRating;
    }

    public void setStarRating(int starRating) {
        this.starRating = starRating;
    }

    @Override
    public String toString() {
        return "Feedback{" + "feedbackId=" + feedbackId + ", userId=" + userId + ", employeeId=" + employeeId + ", feedbackText=" + feedbackText + ", replyText=" + replyText + ", postTime=" + postTime + ", starRating=" + starRating + '}';
    }
    
    
}
