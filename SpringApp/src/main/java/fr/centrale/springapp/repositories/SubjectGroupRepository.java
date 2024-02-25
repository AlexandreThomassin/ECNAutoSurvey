/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package fr.centrale.springapp.repositories;

import fr.centrale.springapp.items.SubjectGroup;
import java.util.Collection;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Alex
 */
@Repository
public interface SubjectGroupRepository extends JpaRepository<SubjectGroup, Integer>, SubjectGroupRepositoryCustom {
    @Query("select distinct g.groupType from SubjectGroup g")
    List<String> getGroupTypes();

    @Query("select g.groupName from SubjectGroup g where g.groupType like ?1")
    List<String> findAllByGroupType(String type);
    
    @Query("select g from SubjectGroup g where g.groupName like ?1")
    SubjectGroup findByGroupName(String group);
    
    @Query("select g from SubjectGroup g where g.idGroup in ?1")
    Collection<SubjectGroup> findByGroupIdIn(Collection<Integer> subjectGroupsIds);
   
}
