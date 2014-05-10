/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.mycompany.schoolapp.domain;

import java.io.Serializable;
import javax.persistence.Embeddable;

/**
 *
 * @author Zama
 */

@Embeddable
public class Demographic implements Serializable {
    
    private String gender;
    private String race;
    private String language;

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getRace() {
        return race;
    }

    public void setRace(String race) {
        this.race = race;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }
    
    
    
}
