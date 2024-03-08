/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fr.centrale.springapp.controllers;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import fr.centrale.springapp.items.Subject;
import fr.centrale.springapp.items.SubjectGroup;
import fr.centrale.springapp.repositories.SubjectGroupRepository;
import fr.centrale.springapp.repositories.SubjectRepository;
import java.io.StringWriter;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import org.python.util.PythonInterpreter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author Alex
 */
@Controller
public class DashboardController {
    
    @Autowired
    private SubjectGroupRepository subjectGroupRepository;
    
    @Autowired
    private SubjectRepository subjectRepository;
    
    @RequestMapping(value="generateSynthesis.do")
    public boolean handleSynthesisGeneration() {
        
        ModelAndView dashboard = new ModelAndView("admin/dashboard");
        
        PythonInterpreter pyInterp = new PythonInterpreter();
        StringWriter output=new StringWriter();
        pyInterp.setOut(output);
        
        String filename;
        filename="python_code/main.py";
        pyInterp.execfile(filename);
        output.toString().trim();
        
        return true;
    }
    
}
