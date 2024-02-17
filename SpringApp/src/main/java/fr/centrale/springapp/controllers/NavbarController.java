/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fr.centrale.springapp.controllers;

import fr.centrale.springapp.items.SubjectGroup;
import fr.centrale.springapp.repositories.SubjectGroupRepository;
import java.util.HashMap;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author Alex
 */
@Controller
public class NavbarController {
    
    @Autowired
    private SubjectGroupRepository subjectGroupRepository;
    
    @RequestMapping(value="sidebar.do")
    public ModelAndView handleGetNavbar() {
        
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
}
