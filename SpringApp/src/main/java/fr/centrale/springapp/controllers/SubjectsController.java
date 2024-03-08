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
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import javax.servlet.http.HttpServletRequest;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

/**
 *
 * @author Alex
 */
@Controller
public class SubjectsController {
    
    @Autowired
    private SubjectRepository subjectRepository;
    
    @Autowired
    private SubjectGroupRepository subjectGroupRepository;
    
    @RequestMapping(value="admin/subjects.do")
    public ModelAndView handleIndexGet() {
        return new ModelAndView("admin/subjects");
    }
    
    // Affichaghe des données
    
    @RequestMapping(value="json/jsonSubjects.do")
    public ModelAndView getSubjects () throws JsonProcessingException {
        ModelAndView returned = new ModelAndView("json/jsonSubjects");

        
        Collection<Subject> subjectList = subjectRepository.findAll();
        
        ObjectMapper objectMapper = new ObjectMapper();
        
        String returnJSON = objectMapper.writeValueAsString(subjectList);
        
        returned.addObject("list", returnJSON);
        return returned;
    }
    
    @RequestMapping(value="admin/modifySubject.do", method=RequestMethod.GET)
    public ModelAndView handleGetModifySubject(@RequestParam int id) {
        ModelAndView returned = new ModelAndView("admin/modifySubject");
        
        // Get subject from id
        Subject subject = subjectRepository.findByIdSubject(id);
        returned.addObject("subject", subject);
        
        // Get list of subject groups to fill select
        Collection<SubjectGroup> subjectGroups = subjectGroupRepository.findAll();
        
        Map<Integer, String> idsAndNames = new HashMap<Integer, String>();
        for(SubjectGroup s: subject.getSubjectGroupCollection()){
            idsAndNames.put(s.getIdGroup(), s.getGroupName());
        }
        
        returned.addObject("subjectGroups", subjectGroups);
        returned.addObject("map", idsAndNames);
        
        return returned;
    }
    
    // Modification d'un matière
    @RequestMapping(value="admin/modifySubject.do", method=RequestMethod.POST)
    public RedirectView handlePostModifySubject(HttpServletRequest request) {
        
//        List<String> parameterNames = new ArrayList<String>(request.getParameterMap().keySet());
//        
//        
//        for(String s: parameterNames){
//            System.out.println(s);
//        }
        
        int id = Integer.parseInt(request.getParameter("idSubject"));
        System.out.println(id);
        
        String[] subjectGroupsRes = request.getParameterValues("subjectGroup");
                
        List<Integer> subjectGroupsIds = new ArrayList<Integer>();
        
        for(String s: subjectGroupsRes){
            try{
                int i = Integer.parseInt(s);
                System.out.println(i);
                subjectGroupsIds.add(i);
            }
            catch(NumberFormatException e) {
                System.out.println(e);
            }

            
        }
        
        Collection<SubjectGroup> subjectGroups = subjectGroupRepository.findByGroupIdIn(subjectGroupsIds);
        
        Subject subject = new Subject();
        subject.setSubjectName(request.getParameter("subjectName"));
        subject.setSubjectAcronym(request.getParameter("subjectAcronym"));
        subject.setSubjectCode(request.getParameter("subjectCode"));
        try {
            subject.setSubjectNbStudents(Integer.parseInt(request.getParameter("subjectNbStudents")));
        } catch(NumberFormatException e) {
            System.out.println(e);
        }
        
        try {
            subject.setSubjectSemester(Integer.parseInt(request.getParameter("subjectSemester")));
        } catch(NumberFormatException e) {
            System.out.println(e);
        }
        
        //TODO : By default, need to be edited
        subject.setToRenew(false);
        subject.setHasProject(Boolean.getBoolean(request.getParameter("hasProject")));
        subject.setSubjectGroupCollection(subjectGroups);
        
        
        if(id > 0){
            subjectRepository.update(id, subject);
        } else {
            subjectRepository.create(subject);
        }
        
        
        return new RedirectView("../admin/subjects.do");
        
    }
    
    @RequestMapping(value="admin/addSubject.do", method=RequestMethod.GET)
    public ModelAndView handleGetAddSubject(){
        ModelAndView returned = new ModelAndView("admin/modifySubject");
        
        Subject subject = new Subject();
        returned.addObject("subject", subject);
        
        // Get list of subject groups to fill select
        Collection<SubjectGroup> subjectGroups = subjectGroupRepository.findAll();

        returned.addObject("subjectGroups", subjectGroups);
 
        
        return returned;
    }

}