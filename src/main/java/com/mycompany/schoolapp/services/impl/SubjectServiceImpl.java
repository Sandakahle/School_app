/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.mycompany.schoolapp.services.impl;

import com.mycompany.schoolapp.domain.Subject;
import com.mycompany.schoolapp.repository.SubjectRepository;
import com.mycompany.schoolapp.services.SubjectService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author 211062715
 */
public class SubjectServiceImpl implements SubjectService{
    
    @Autowired
    private SubjectRepository subjecRepo;

    @Override
    public List<Subject> getAllSubjects() {
        return subjecRepo.findAll();
    }
    
    
}
