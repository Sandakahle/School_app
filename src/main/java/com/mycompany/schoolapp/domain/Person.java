/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.mycompany.schoolapp.domain;

import java.io.Serializable;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.persistence.CascadeType;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.transaction.UserTransaction;

/** 
 *
 * @author Zama
 */
@Entity
public class Person implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private String lastName;
    private int age;
    
    @Embedded
    private Contact contact;
    @Embedded
    private Demographic demographic;
    @Embedded
    private MedicalRecord medRecord;
    
    @OneToMany
    @JoinColumn(name = "person_id")
    private List<TeachingClass> classs;
    
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "person_id")
    private List<Subject> subject;
    
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "person_id")
    private Account account;
    
    private  Person(Builder builder){
        id = builder.id;
        name = builder.name;
        lastName = builder.lastName;
        contact = builder.contact;
        demographic = builder.demographic;
        medRecord = builder.medRecord;
        classs = builder.classs;
        subject = builder.subject;
        account = builder.account;
        
        
        
          
    }
    
    public static class Builder{
    
        private Long id;
        private String name;
        private String lastName;
        private int age;
        private Contact contact;
        private Demographic demographic;
        private MedicalRecord medRecord;
        private List<TeachingClass> classs;
        private List<Subject> subject;
        private Account account;
                
        
        public Builder id(Long value) {
            id = value;
            return this;
        }

        public Builder firstname(String value) {
            name = value;
            return this;
        }

        public Builder lastName(String value) {
            lastName = value;
            return this;
        }

        public Builder age(int value) {
            age = value;
            return this;
        }

        public Builder contact(Contact value) {
            contact = value;
            return this;
        }
        
         public Builder contact(Demographic value) {
            demographic = value;
            return this;
        }
        
        

        public Builder teachingClass(List<TeachingClass> value) {
            classs = value;
            return this;
        }

        public Builder clubs(List<Subject> value) {
            subject = value;
            return this;
        }
        
        public Builder account(Account value)
        {
            account = value;
            return this;
        }
        public Builder person(Person person){
            id = person.getId();
            name = person.getName();
            lastName = person.getLastName();
            age = person.getAge();
            demographic = person.getDemographic();
            classs = person.getClasss();
            subject = person.getSubject();
            contact = person.getContact();
            account = person.getAccount();
            
            return this;
            
        }
        
        public Person build(){
            return new Person(this);
        }    
        
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public String getName() {
        return name;
    }

    public String getLastName() {
        return lastName;
    }

    public int getAge() {
        return age;
    }

    public Contact getContact() {
        return contact;
    }

    public Demographic getDemographic() {
        return demographic;
    }

    public MedicalRecord getMedRecord() {
        return medRecord;
    }

    public List<TeachingClass> getClasss() {
        return classs;
    }

    public List<Subject> getSubject() {
        return subject;
    }

    public Account getAccount() {
        return account;
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
        if (!(object instanceof Person)) {
            return false;
        }
        Person other = (Person) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mycompany.schoolapp.domain.Person[ id=" + id + " ]";
    }

    public void persist(Object object) {
        /* Add this to the deployment descriptor of this module (e.g. web.xml, ejb-jar.xml):
         * <persistence-context-ref>
         * <persistence-context-ref-name>persistence/LogicalName</persistence-context-ref-name>
         * <persistence-unit-name>com.mycompany_SchoolApp_war_1.0-SNAPSHOTPU</persistence-unit-name>
         * </persistence-context-ref>
         * <resource-ref>
         * <res-ref-name>UserTransaction</res-ref-name>
         * <res-type>javax.transaction.UserTransaction</res-type>
         * <res-auth>Container</res-auth>
         * </resource-ref> */
        try {
            Context ctx = new InitialContext();
            UserTransaction utx = (UserTransaction) ctx.lookup("java:comp/env/UserTransaction");
            utx.begin();
            EntityManager em = (EntityManager) ctx.lookup("java:comp/env/persistence/LogicalName");
            em.persist(object);
            utx.commit();
        } catch (Exception e) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, "exception caught", e);
            throw new RuntimeException(e);
        }
    }
    
}
