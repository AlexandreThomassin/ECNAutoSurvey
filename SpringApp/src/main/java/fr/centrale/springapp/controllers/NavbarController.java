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
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
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
public class NavbarController {
    
    @Autowired
    private SubjectGroupRepository subjectGroupRepository;
    
    @Autowired
    private SubjectRepository subjectRepository;
    
    @RequestMapping(value="sidebar.do")
    public ModelAndView handleGetSidebar() {
        
        ModelAndView sidebar = new ModelAndView("sidebar");
        
        List<String> groupTypes = subjectGroupRepository.getGroupTypes();
        
        System.out.println(groupTypes);
        
        sidebar.addObject("types", groupTypes);
        
        HashMap<String, List<String>> groupsByTypes = new HashMap<>();
        
        for (String type: groupTypes){
            groupsByTypes.put(type, subjectGroupRepository.findAllByGroupType(type));
        }
        
        System.out.println(groupsByTypes);
        
        sidebar.addObject("groupsByTypes", groupsByTypes);
                
        return sidebar;
    }
    
    @RequestMapping(value="synthesis.do")
    public ModelAndView handleSynthesis(@RequestParam String group) {
        System.out.println("Test " + group);
        ModelAndView returned = new ModelAndView("synthesis");
        returned.addObject("group", group);
        
        return returned;
    }
    
    @RequestMapping(value="json/jsonSynthesis.do")
    public ModelAndView handleGetSynthesis(@RequestParam String group) throws JsonProcessingException {
        ModelAndView returned = new ModelAndView("json/jsonSynthesis");

        SubjectGroup subjectGroup = subjectGroupRepository.findByGroupName(group);
        
        Collection<Subject> subjectList = subjectGroup.getSubjectCollection();
        System.out.println(subjectList);
        
        ObjectMapper objectMapper = new ObjectMapper();
        
        String returnJSON = objectMapper.writeValueAsString(subjectList);
        
        returned.addObject("list", returnJSON);
        return returned;
    }
}
