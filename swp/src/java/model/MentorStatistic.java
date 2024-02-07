/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author ADMIN-PC
 */
public class MentorStatistic {
    private int processingRequestCount;
    private int openRequestCount;
    private int cancelRequestCount;
    private double cancelRatio;
    private double closedRatio;
    private double averageRating;

    public MentorStatistic() {
    }

    public MentorStatistic(int processingRequestCount, int openRequestCount, int cancelRequestCount, double cancelRatio, double closedRatio, double averageRating) {
        this.processingRequestCount = processingRequestCount;
        this.openRequestCount = openRequestCount;
        this.cancelRequestCount = cancelRequestCount;
        this.cancelRatio = cancelRatio;
        this.closedRatio = closedRatio;
        this.averageRating = averageRating;
    }

    public int getProcessingRequestCount() {
        return processingRequestCount;
    }

    public void setProcessingRequestCount(int processingRequestCount) {
        this.processingRequestCount = processingRequestCount;
    }

    public int getOpenRequestCount() {
        return openRequestCount;
    }

    public void setOpenRequestCount(int openRequestCount) {
        this.openRequestCount = openRequestCount;
    }

    public int getCancelRequestCount() {
        return cancelRequestCount;
    }

    public void setCancelRequestCount(int cancelRequestCount) {
        this.cancelRequestCount = cancelRequestCount;
    }

    public double getCancelRatio() {
        return cancelRatio;
    }

    public void setCancelRatio(double cancelRatio) {
        this.cancelRatio = cancelRatio;
    }

    public double getClosedRatio() {
        return closedRatio;
    }

    public void setClosedRatio(double closedRatio) {
        this.closedRatio = closedRatio;
    }

    public double getAverageRating() {
        return averageRating;
    }

    public void setAverageRating(double averageRating) {
        this.averageRating = averageRating;
    }
    
    
  
    
    
}
