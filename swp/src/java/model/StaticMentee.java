/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author admin
 */
public class StaticMentee {
   String FullName;
   String UserName;
   int NumRequests;
   float TotalHours;
   int TotalSkills;

    public StaticMentee() {
    }

    public StaticMentee(String FullName, String UserName, int NumRequests, float TotalHours, int TotalSkills) {
        this.FullName = FullName;
        this.UserName = UserName;
        this.NumRequests = NumRequests;
        this.TotalHours = TotalHours;
        this.TotalSkills = TotalSkills;
    }

    public String getFullName() {
        return FullName;
    }

    public void setFullName(String FullName) {
        this.FullName = FullName;
    }

    public String getUserName() {
        return UserName;
    }

    public void setUserName(String UserName) {
        this.UserName = UserName;
    }

    public int getNumRequests() {
        return NumRequests;
    }

    public void setNumRequests(int NumRequests) {
        this.NumRequests = NumRequests;
    }

    public float getTotalHours() {
        return TotalHours;
    }

    public void setTotalHours(float TotalHours) {
        this.TotalHours = TotalHours;
    }

    public int getTotalSkills() {
        return TotalSkills;
    }

    public void setTotalSkills(int TotalSkills) {
        this.TotalSkills = TotalSkills;
    }

    @Override
    public String toString() {
        return "StaticMentee{" + "FullName=" + FullName + ", UserName=" + UserName + ", NumRequests=" + NumRequests + ", TotalHours=" + TotalHours + ", TotalSkills=" + TotalSkills + '}';
    }

    
   
}
