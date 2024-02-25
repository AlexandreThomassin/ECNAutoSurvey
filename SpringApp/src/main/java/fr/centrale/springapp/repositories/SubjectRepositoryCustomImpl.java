/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fr.centrale.springapp.repositories;

import fr.centrale.springapp.items.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Alex
 */
@Repository
public class SubjectRepositoryCustomImpl implements SubjectRepositoryCustom {
    
    @Autowired
    @Lazy
    private SubjectRepository subjectRepository;
    
    @Override
    public Subject update(int id, Subject subject) {
        if ((id > 0) && (subject != null)) {
            Subject item = subjectRepository.getReferenceById(id);
            
            item.setSubjectName(subject.getSubjectName());
            item.setSubjectAcronym(subject.getSubjectAcronym());
            item.setSubjectCode(subject.getSubjectCode());
            item.setSubjectSemester(subject.getSubjectSemester());
            item.setHasProject(subject.getHasProject());
            item.setSubjectGroupCollection(subject.getSubjectGroupCollection());
            item.setToRenew(subject.getToRenew());
            
            subjectRepository.saveAndFlush(item);
            return item;
            
        }
        
        return null;
    }
    
}

