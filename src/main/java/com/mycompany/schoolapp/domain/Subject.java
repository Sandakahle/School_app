/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.mycompany.schoolapp.domain;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 *
 * @author Zama
 */
@Entity
public class Subject implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private String code;
    
    private Subject(Builder builder)
    {
        id = builder.id;
        name = builder.name;
        code = builder.code;
        
    }
    
    public static class Builder
    {
        private Long id;
        private String name;
        private String code;
        
        public Builder(String name,String code)
        {
            this.name = name;
            this.code = code;
        }
        
        public Builder id(Long value)
        {
            this.id = value;
            return this;
        }
        
        public Subject build()
        {
            return new Subject(this);
        }
    }
    
    

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Subject)) {
            return false;
        }
        Subject other = (Subject) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mycompany.schoolapp.domain.Subject[ id=" + id + " ]";
    }
    
}
