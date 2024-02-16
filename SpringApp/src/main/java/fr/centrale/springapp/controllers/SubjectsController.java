/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fr.centrale.springapp.controllers;

import fr.centrale.springapp.items.Subject;
import fr.centrale.springapp.repositories.SubjectRepository;
import java.util.Collection;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author Alex
 */
@Controller
public class SubjectsController {
    
    @Autowired
    private SubjectRepository subjectRepository;
    
    @RequestMapping(value="admin/subjects.do")
    public ModelAndView handleIndexGet() {
        System.out.println("Test");
        return new ModelAndView("admin/subjects");
    }
    
    @RequestMapping(value="json/jsonSubjects.do", produces = MediaType.APPLICATION_JSON_VALUE)
    public ModelAndView getSubjects () {
        ModelAndView returned = new ModelAndView("json/jsonSubjects");

        
        List<Subject> subjectList = subjectRepository.findAll();
        System.out.println(subjectList);
        
        
        JSONArray returnJSON = new JSONArray(subjectList);
        
        returned.addObject("list", returnJSON);
        return returned;
    }

}