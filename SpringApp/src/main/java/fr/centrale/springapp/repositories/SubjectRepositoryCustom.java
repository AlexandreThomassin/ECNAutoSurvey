/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package fr.centrale.springapp.repositories;

import fr.centrale.springapp.items.Subject;
import fr.centrale.springapp.items.SubjectGroup;
import java.util.Collection;

/**
 *
 * @author Alex
 */
public interface SubjectRepositoryCustom {
    public Subject update(int id, Subject subject);
        public Subject create(Subject subject);
}
