/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author trang
 */
public class Adshowreq {
    int idMentee,idRequest;
    String username,title,content,skill,status, startdate,deadline;
    float hour;
   String fullname, dob,avatar,sex,address,phone;
   
           
    public Adshowreq() {
    }

    public Adshowreq(int idMentee, String username, String title, String content, String skill, String status, String startdate, String deadline) {
        this.idMentee = idMentee;
        this.username = username;
        this.title = title;
        this.content = content;
        this.skill = skill;
        this.status = status;
        this.startdate = startdate;
        this.deadline = deadline;
    }

    

    public Adshowreq(int idMentee, int idRequest, String username, String title, String content, String skill, String status, String fullname, String dob, String avatar, String sex, String address, String phone) {
        this.idMentee = idMentee;
        this.idRequest = idRequest;
        this.username = username;
        this.title = title;
        this.content = content;
        this.skill = skill;
        this.status = status;
        this.fullname = fullname;
        this.dob = dob;
        this.avatar = avatar;
        this.sex = sex;
        this.address = address;
        this.phone = phone;
    }

   

    public Adshowreq(int idMentee, String username, String title, String content, String status, String deadline, float hour) {
        this.idMentee = idMentee;
        this.username = username;
        this.title = title;
        this.content = content;
        this.status = status;
        this.deadline = deadline;
        this.hour = hour;
    }

    public Adshowreq(int idMentee, String username, String title, String content, String skill, String status, String deadline, float hour) {
        this.idMentee = idMentee;
        this.username = username;
        this.title = title;
        this.content = content;
        this.skill = skill;
        this.status = status;
        this.deadline = deadline;
        this.hour = hour;
    }

    public int getIdRequest() {
        return idRequest;
    }

    public void setIdRequest(int idRequest) {
        this.idRequest = idRequest;
    }

    public String getStartdate() {
        return startdate;
    }

    public void setStartdate(String startdate) {
        this.startdate = startdate;
    }

   

    public int getIdMentee() {
        return idMentee;
    }

    public void setIdMentee(int idMentee) {
        this.idMentee = idMentee;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getSkill() {
        return skill;
    }

    public void setSkill(String skill) {
        this.skill = skill;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getDeadline() {
        return deadline;
    }

    public void setDeadline(String deadline) {
        this.deadline = deadline;
    }

    public float getHour() {
        return hour;
    }

    public void setHour(float hour) {
        this.hour = hour;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Override
    public String toString() {
        return "Adshowreq{" + "idMentee=" + idMentee + ", username=" + username + ", title=" + title + ", content=" + content + ", skill=" + skill + ", status=" + status + ", deadline=" + deadline + ", hour=" + hour + '}';
    }

    
}
