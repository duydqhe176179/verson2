/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author admin
 */
public class SkillMentor {

    int id;
    String tiltle;
    String image;
    String skillName;
    String Skill_description;
    String status;

    public SkillMentor() {
    }

    public SkillMentor(String tiltle, String image, String skillName, String Skill_description) {
        this.tiltle = tiltle;
        this.image = image;
        this.skillName = skillName;
        this.Skill_description = Skill_description;
    }

    public SkillMentor(int id, String tiltle, String image, String skillName, String Skill_description, String status) {
        this.id = id;
        this.tiltle = tiltle;
        this.image = image;
        this.skillName = skillName;
        this.Skill_description = Skill_description;
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTiltle() {
        return tiltle;
    }

    public void setTiltle(String tiltle) {
        this.tiltle = tiltle;
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
        return Skill_description;
    }

    public void setSkill_description(String Skill_description) {
        this.Skill_description = Skill_description;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "SkillMentor{" + "id=" + id + ", tiltle=" + tiltle + ", image=" + image + ", skillName=" + skillName + ", Skill_description=" + Skill_description + ", status=" + status + '}';
    }

}
