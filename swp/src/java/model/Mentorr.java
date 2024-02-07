/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author trang
 */
public class Mentorr {

    public int idMentor;
    String fullname;

    public Mentorr() {
    }

    public Mentorr(int idMentor, String fullname) {
        this.idMentor = idMentor;
        this.fullname = fullname;
    }

    public int getIdMentor() {
        return idMentor;
    }

    public void setIdMentor(int idMentor) {
        this.idMentor = idMentor;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    @Override
    public String toString() {
        return "Mentorr{" + "idMentor=" + idMentor + ", fullname=" + fullname + '}';
    }
    
}
