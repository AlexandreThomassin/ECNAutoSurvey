/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fr.centrale.springapp.items;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author alex4
 */
@Entity
@Table(name = "subject_group")
@NamedQueries({
    @NamedQuery(name = "SubjectGroup.findAll", query = "SELECT s FROM SubjectGroup s"),
    @NamedQuery(name = "SubjectGroup.findByIdGroup", query = "SELECT s FROM SubjectGroup s WHERE s.idGroup = :idGroup"),
    @NamedQuery(name = "SubjectGroup.findByGroupType", query = "SELECT s FROM SubjectGroup s WHERE s.groupType = :groupType"),
    @NamedQuery(name = "SubjectGroup.findByGroupName", query = "SELECT s FROM SubjectGroup s WHERE s.groupName = :groupName"),
    @NamedQuery(name = "SubjectGroup.findByGroupTeacherMail", query = "SELECT s FROM SubjectGroup s WHERE s.groupTeacherMail = :groupTeacherMail"),
    @NamedQuery(name = "SubjectGroup.findByGroupStudentMail", query = "SELECT s FROM SubjectGroup s WHERE s.groupStudentMail = :groupStudentMail")})
public class SubjectGroup implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_group")
    private Integer idGroup;
    @Size(max = 2147483647)
    @Column(name = "group_type")
    private String groupType;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2147483647)
    @Column(name = "group_name")
    private String groupName;
    @Size(max = 2147483647)
    @Column(name = "group_teacher_mail")
    private String groupTeacherMail;
    @Size(max = 2147483647)
    @Column(name = "group_student_mail")
    private String groupStudentMail;
    @ManyToMany(mappedBy = "subjectGroupCollection")
    private Collection<Subject> subjectCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idGroup")
    private Collection<Survey> surveyCollection;

    public SubjectGroup() {
    }

    public SubjectGroup(Integer idGroup) {
        this.idGroup = idGroup;
    }

    public SubjectGroup(Integer idGroup, String groupName) {
        this.idGroup = idGroup;
        this.groupName = groupName;
    }

    public Integer getIdGroup() {
        return idGroup;
    }

    public void setIdGroup(Integer idGroup) {
        this.idGroup = idGroup;
    }

    public String getGroupType() {
        return groupType;
    }

    public void setGroupType(String groupType) {
        this.groupType = groupType;
    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    public String getGroupTeacherMail() {
        return groupTeacherMail;
    }

    public void setGroupTeacherMail(String groupTeacherMail) {
        this.groupTeacherMail = groupTeacherMail;
    }

    public String getGroupStudentMail() {
        return groupStudentMail;
    }

    public void setGroupStudentMail(String groupStudentMail) {
        this.groupStudentMail = groupStudentMail;
    }

    public Collection<Subject> getSubjectCollection() {
        return subjectCollection;
    }

    public void setSubjectCollection(Collection<Subject> subjectCollection) {
        this.subjectCollection = subjectCollection;
    }

    public Collection<Survey> getSurveyCollection() {
        return surveyCollection;
    }

    public void setSurveyCollection(Collection<Survey> surveyCollection) {
        this.surveyCollection = surveyCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idGroup != null ? idGroup.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SubjectGroup)) {
            return false;
        }
        SubjectGroup other = (SubjectGroup) object;
        if ((this.idGroup == null && other.idGroup != null) || (this.idGroup != null && !this.idGroup.equals(other.idGroup))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "fr.centrale.springapp.items.SubjectGroup[ idGroup=" + idGroup + " ]";
    }
    
}
