/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author trang
 */
public class ReDetail {

    int idMentee, idRequest;
    String username, fullname, dob, phone, sex, avatar, address, title, content, status, skill;

    public ReDetail() {
    }

    public ReDetail(int idMentee, int idRequest, String username, String fullname, String dob, String phone, String sex, String avatar, String address, String title, String content, String status, String skill) {
        this.idMentee = idMentee;
        this.idRequest = idRequest;
        this.username = username;
        this.fullname = fullname;
        this.dob = dob;
        this.phone = phone;
        this.sex = sex;
        this.avatar = avatar;
        this.address = address;
        this.title = title;
        this.content = content;
        this.status = status;
        this.skill = skill;
    }

    public int getIdMentee() {
        return idMentee;
    }

    public void setIdMentee(int idMentee) {
        this.idMentee = idMentee;
    }

    public int getIdRequest() {
        return idRequest;
    }

    public void setIdRequest(int idRequest) {
        this.idRequest = idRequest;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
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

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
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

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getSkill() {
        return skill;
    }

    public void setSkill(String skill) {
        this.skill = skill;
    }

    @Override
    public String toString() {
        return "DetailRequest{" + "idMentee=" + idMentee + ", idRequest=" + idRequest + ", username=" + username + ", fullname=" + fullname + ", dob=" + dob + ", phone=" + phone + ", sex=" + sex + ", avatar=" + avatar + ", address=" + address + ", title=" + title + ", content=" + content + ", status=" + status + ", skill=" + skill + '}';
    }

}
