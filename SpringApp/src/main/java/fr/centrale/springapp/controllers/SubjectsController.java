/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fr.centrale.springapp.controllers;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import fr.centrale.springapp.items.Subject;
import fr.centrale.springapp.repositories.SubjectRepository;
import java.util.Collection;
import java.util.List;
import java.util.Optional;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
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
    
    @RequestMapping(value="json/jsonSubjects.do")
    public ModelAndView getSubjects () throws JsonProcessingException {
        ModelAndView returned = new ModelAndView("json/jsonSubjects");

        
        Collection<Subject> subjectList = subjectRepository.findAll();
        System.out.println(subjectList);
        
        ObjectMapper objectMapper = new ObjectMapper();
        
        String returnJSON = objectMapper.writeValueAsString(subjectList);
        
        returned.addObject("list", returnJSON);
        return returned;
    }
    
    @RequestMapping(value="admin/modifySubject.do", method=RequestMethod.GET)
    public ModelAndView handleGetAddSubject(@RequestParam int id) {
        ModelAndView returned = new ModelAndView("admin/modifySubject");
        
        Subject subject = subjectRepository.findByIdSubject(id);
        
        returned.addObject("subject", subject);
        
        return returned;
    }

}