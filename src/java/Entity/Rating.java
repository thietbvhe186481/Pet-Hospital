/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entity;

/**
 *
 * @author LENOVO
 */
public class Rating {
    private String ratingId;
    private String feedbackId;
    private String bookingId;

    public Rating() {
    }

    public Rating(String feedbackId, String bookingId) {
        this.feedbackId = feedbackId;
        this.bookingId = bookingId;
    }

    public Rating(String ratingId, String feedbackId, String bookingId) {
        this.ratingId = ratingId;
        this.feedbackId = feedbackId;
        this.bookingId = bookingId;
    }

    public String getRatingId() {
        return ratingId;
    }

    public void setRatingId(String ratingId) {
        this.ratingId = ratingId;
    }

    public String getFeedbackId() {
        return feedbackId;
    }

    public void setFeedbackId(String feedbackId) {
        this.feedbackId = feedbackId;
    }

    public String getBookingId() {
        return bookingId;
    }

    public void setBookingId(String bookingId) {
        this.bookingId = bookingId;
    }

    @Override
    public String toString() {
        return "Rating{" + "ratingId=" + ratingId + ", feedbackId=" + feedbackId + ", bookingId=" + bookingId + '}';
    }
    
    
}
