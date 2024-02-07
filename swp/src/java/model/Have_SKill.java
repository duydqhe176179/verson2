/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author admin
 */
public class Have_SKill {

    int idMentor;
    int idSkill;
    String skillname;

    public Have_SKill() {
    }

    public Have_SKill(int idMentor, int idSkill, String skillname) {
        this.idMentor = idMentor;
        this.idSkill = idSkill;

        this.skillname = skillname;
    }

    public Have_SKill(int idMentor, int idSkill) {
        this.idMentor = idMentor;
        this.idSkill = idSkill;
    }

    public Have_SKill(int idMentor) {
        this.idMentor = idMentor;
    }

    public int getIdMentor() {
        return idMentor;
    }

    public void setIdMentor(int idMentor) {
        this.idMentor = idMentor;
    }

    public int getIdSkill() {
        return idSkill;
    }

    public void setIdSkill(int idSkill) {
        this.idSkill = idSkill;
    }

    @Override
    public String toString() {
        return "Have_SKill{" + "idMentor=" + idMentor + ", idSkill=" + idSkill + ", skillname=" + skillname + '}';
    }

    

    public String getSkillname() {
        return skillname;
    }

    public void setSkillname(String skillname) {
        this.skillname = skillname;
    }

}
