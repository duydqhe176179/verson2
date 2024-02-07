/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author ADMIN
 */
public class Skill {
    int idSkill;
    String title, image, skillName, skill_description, status;

    public Skill() {
    }

    public Skill(String title, String image, String skillName, String skill_description, String status) {
        this.title = title;
        this.image = image;
        this.skillName = skillName;
        this.skill_description = skill_description;
        this.status = status;
    }

    public Skill(int idSkill, String title, String image, String skillName, String skill_description, String status) {
        this.idSkill = idSkill;
        this.title = title;
        this.image = image;
        this.skillName = skillName;
        this.skill_description = skill_description;
        this.status = status;
    }

    public int getIdSkill() {
        return idSkill;
    }

    public void setIdSkill(int idSkill) {
        this.idSkill = idSkill;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getSkillName() {
        return skillName;
    }

    public void setSkillName(String skillName) {
        this.skillName = skillName;
    }

    public String getSkill_description() {
        return skill_description;
    }

    public void setSkill_description(String skill_description) {
        this.skill_description = skill_description;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Skill{" + "title=" + title + ", image=" + image + ", skillName=" + skillName + ", skill_description=" + skill_description + ", status=" + status + '}';
    }
    
    
}
