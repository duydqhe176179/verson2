/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author admin
 */
public class info {
    int idInfo;
    int idMentor;
    String link;

    public info(int idInfo, int idMentor, String link) {
        this.idInfo = idInfo;
        this.idMentor = idMentor;
        this.link = link;
    }

    public int getIdInfo() {
        return idInfo;
    }

    public void setIdInfo(int idInfo) {
        this.idInfo = idInfo;
    }

    public int getIdMentor() {
        return idMentor;
    }

    public void setIdMentor(int idMentor) {
        this.idMentor = idMentor;
    }

    public String getLink() {
        return link;
    }

    @Override
    public String toString() {
        return "info{" + "idInfo=" + idInfo + ", idMentor=" + idMentor + ", link=" + link + '}';
    }

    public void setLink(String link) {
        this.link = link;
    }

    public info() {
    }
}
