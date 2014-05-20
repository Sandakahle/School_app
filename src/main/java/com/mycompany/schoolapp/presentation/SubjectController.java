/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.mycompany.schoolapp.presentation;

import com.mycompany.schoolapp.domain.Subject;
import com.mycompany.schoolapp.repository.SubjectRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 *
 * @author 211062715
 */

@Controller
public class SubjectController {
    
    @Autowired
   
    private SubjectRepository subjectR;
    
    @RequestMapping(value = "subject", method = RequestMethod.GET)
    @ResponseBody
    public Subject getSubjects()
    {
       Subject s = null;
       List<Subject> subjects = subjectR.findAll();
       System.out.println(" Subjects are:"+ subjects.size());
       return s;
    }
    
}
