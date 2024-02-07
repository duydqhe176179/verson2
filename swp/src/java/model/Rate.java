/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.util.Date;

/**
 *
 * @author trang
 */
public class Rate {

    int idRate, idMentee, idMentor, star;
    String comment;
    String time;

    public Rate() {
    }

    public Rate(int idMentee, int idMentor, int star, String comment, String time) {
        this.idMentee = idMentee;
        this.idMentor = idMentor;
        this.star = star;
        this.comment = comment;
        this.time = time;
    }
     
    
    public Rate(int idRate, int idMentee, int idMentor, int star, String comment, String time) {
        this.idRate = idRate;
        this.idMentee = idMentee;
        this.idMentor = idMentor;
        this.star = star;
        this.comment = comment;
        this.time = time;
    }

    public int getIdRate() {
        return idRate;
    }

    public void setIdRate(int idRate) {
        this.idRate = idRate;
    }

    public int getIdMentee() {
        return idMentee;
    }

    public void setIdMentee(int idMentee) {
        this.idMentee = idMentee;
    }

    public int getIdMentor() {
        return idMentor;
    }

    public void setIdMentor(int idMentor) {
        this.idMentor = idMentor;
    }

    public int getStar() {
        return star;
    }

    public void setStar(int star) {
        this.star = star;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    @Override
    public String toString() {
        return "Rate{" + "idRate=" + idRate + ", idMentee=" + idMentee + ", idMentor=" + idMentor + ", star=" + star + ", comment=" + comment + ", time=" + time + '}';
    }

   
    }

   


