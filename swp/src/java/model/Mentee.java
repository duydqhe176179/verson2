/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author admin
 */
public class Mentee {
    int idMentee;
     String fullname;
     String avatar;
      String story;
      String dob;
      String phone;
      String sex;
      String experience;
      String registerDate;
      String address;

    public Mentee() {
    }

    public Mentee(int idMentee, String fullname, String avatar, String story, String dob, String phone, String sex, String experience, String registerDate, String address) {
        this.idMentee = idMentee;
        this.fullname = fullname;
        this.avatar = avatar;
        this.story = story;
        this.dob = dob;
        this.phone = phone;
        this.sex = sex;
        this.experience = experience;
        this.registerDate = registerDate;
        this.address = address;
    }

    public int getIdMentee() {
        return idMentee;
    }

    public void setIdMentee(int idMentee) {
        this.idMentee = idMentee;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public String getAvatar() {
        return avatar;
    }

    @Override
    public String toString() {
        return "Mentee{" + "idMentee=" + idMentee + ", fullname=" + fullname + ", avatar=" + avatar + ", story=" + story + ", dob=" + dob + ", phone=" + phone + ", sex=" + sex + ", experience=" + experience + ", registerDate=" + registerDate + ", address=" + address + '}';
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public String getStory() {
        return story;
    }

    public void setStory(String story) {
        this.story = story;
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

    public String getExperience() {
        return experience;
    }

    public void setExperience(String experience) {
        this.experience = experience;
    }

    public String getRegisterDate() {
        return registerDate;
    }

    public void setRegisterDate(String registerDate) {
        this.registerDate = registerDate;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
      
}
