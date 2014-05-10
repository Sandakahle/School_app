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
public class MedicalRecord implements Serializable {
    
    private String bloodType;
    private String allergy;
    private String chronicIllnesses;
    private String previosOperations;

    public String getBloodType() {
        return bloodType;
    }

    public void setBloodType(String bloodType) {
        this.bloodType = bloodType;
    }

    public String getAllergy() {
        return allergy;
    }

    public void setAllergy(String allergy) {
        this.allergy = allergy;
    }

    public String getChronicIllnesses() {
        return chronicIllnesses;
    }

    public void setChronicIllnesses(String chronicIllnessess) {
        this.chronicIllnesses = chronicIllnesses;
    }

    public String getPreviosOperations() {
        return previosOperations;
    }

    public void setPreviosOperations(String previosOperations) {
        this.previosOperations = previosOperations;
    }
    
    
    
    
    
}
