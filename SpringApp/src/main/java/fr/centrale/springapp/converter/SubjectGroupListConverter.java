/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fr.centrale.springapp.converter;

import com.fasterxml.jackson.databind.util.StdConverter;
import fr.centrale.springapp.items.SubjectGroup;
import java.util.Collection;
import java.util.stream.Collectors;

/**
 *
 * @author alex4
 */
public class SubjectGroupListConverter extends StdConverter<Collection<SubjectGroup>, Collection<String>> {
    @Override
    public Collection<String> convert(Collection<SubjectGroup> subjectGroup) {
        return subjectGroup.stream().map(SubjectGroup::getGroupName).collect(Collectors.toList());
    }
}
