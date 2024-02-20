/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fr.centrale.springapp.items;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
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
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import org.json.JSONPropertyIgnore;

/**
 *
 * @author alex4
 */
@Entity
@Table(name = "subject")
@NamedQueries({
    @NamedQuery(name = "Subject.findAll", query = "SELECT s FROM Subject s"),
    @NamedQuery(name = "Subject.findByIdSubject", query = "SELECT s FROM Subject s WHERE s.idSubject = :idSubject"),
    @NamedQuery(name = "Subject.findBySubjectCode", query = "SELECT s FROM Subject s WHERE s.subjectCode = :subjectCode"),
    @NamedQuery(name = "Subject.findBySubjectAcronym", query = "SELECT s FROM Subject s WHERE s.subjectAcronym = :subjectAcronym"),
    @NamedQuery(name = "Subject.findBySubjectName", query = "SELECT s FROM Subject s WHERE s.subjectName = :subjectName"),
    @NamedQuery(name = "Subject.findBySubjectNbStudents", query = "SELECT s FROM Subject s WHERE s.subjectNbStudents = :subjectNbStudents"),
    @NamedQuery(name = "Subject.findByHasProject", query = "SELECT s FROM Subject s WHERE s.hasProject = :hasProject"),
    @NamedQuery(name = "Subject.findBySubjectSemester", query = "SELECT s FROM Subject s WHERE s.subjectSemester = :subjectSemester"),
    @NamedQuery(name = "Subject.findBySubjectCreationYear", query = "SELECT s FROM Subject s WHERE s.subjectCreationYear = :subjectCreationYear"),
    @NamedQuery(name = "Subject.findBySubjectStudentMail", query = "SELECT s FROM Subject s WHERE s.subjectStudentMail = :subjectStudentMail"),
    @NamedQuery(name = "Subject.findBySubjectTeacherMail", query = "SELECT s FROM Subject s WHERE s.subjectTeacherMail = :subjectTeacherMail"),
    @NamedQuery(name = "Subject.findByLastSurveyDate", query = "SELECT s FROM Subject s WHERE s.lastSurveyDate = :lastSurveyDate"),
    @NamedQuery(name = "Subject.findByLastReportFileName", query = "SELECT s FROM Subject s WHERE s.lastReportFileName = :lastReportFileName"),
    @NamedQuery(name = "Subject.findByToRenew", query = "SELECT s FROM Subject s WHERE s.toRenew = :toRenew")})
public class Subject implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_subject")
    private Integer idSubject;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2147483647)
    @Column(name = "subject_code")
    private String subjectCode;
    @Size(max = 2147483647)
    @Column(name = "subject_acronym")
    private String subjectAcronym;
    @Size(max = 2147483647)
    @Column(name = "subject_name")
    private String subjectName;
    @Column(name = "subject_nb_students")
    private Integer subjectNbStudents;
    @Column(name = "has_project")
    private Boolean hasProject;
    @Column(name = "subject_semester")
    private Integer subjectSemester;
    @Column(name = "subject_creation_year")
    private Integer subjectCreationYear;
    @Size(max = 2147483647)
    @Column(name = "subject_student_mail")
    private String subjectStudentMail;
    @Size(max = 2147483647)
    @Column(name = "subject_teacher_mail")
    private String subjectTeacherMail;
    @Column(name = "last_survey_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date lastSurveyDate;
    @Size(max = 2147483647)
    @Column(name = "last_report_file_name")
    private String lastReportFileName;
    @Basic(optional = false)
    @NotNull
    @Column(name = "to_renew")
    private boolean toRenew;
    @JsonIgnore
    @ManyToMany(mappedBy = "subjectCollection")
    private Collection<SubjectGroup> subjectGroupCollection;
    
    @JoinTable(name = "user_linked_to_subject", joinColumns = {
        @JoinColumn(name = "id_subject", referencedColumnName = "id_subject")}, inverseJoinColumns = {
        @JoinColumn(name = "id_user", referencedColumnName = "id_user")})
    @JsonIgnore
    @ManyToMany
    private Collection<InterfaceUser> interfaceUserCollection;

    public Subject() {
    }

    public Subject(Integer idSubject) {
        this.idSubject = idSubject;
    }

    public Subject(Integer idSubject, String subjectCode, boolean toRenew) {
        this.idSubject = idSubject;
        this.subjectCode = subjectCode;
        this.toRenew = toRenew;
    }

    public Integer getIdSubject() {
        return idSubject;
    }

    public void setIdSubject(Integer idSubject) {
        this.idSubject = idSubject;
    }

    public String getSubjectCode() {
        return subjectCode;
    }

    public void setSubjectCode(String subjectCode) {
        this.subjectCode = subjectCode;
    }

    public String getSubjectAcronym() {
        return subjectAcronym;
    }

    public void setSubjectAcronym(String subjectAcronym) {
        this.subjectAcronym = subjectAcronym;
    }

    public String getSubjectName() {
        return subjectName;
    }

    public void setSubjectName(String subjectName) {
        this.subjectName = subjectName;
    }

    public Integer getSubjectNbStudents() {
        return subjectNbStudents;
    }

    public void setSubjectNbStudents(Integer subjectNbStudents) {
        this.subjectNbStudents = subjectNbStudents;
    }

    public Boolean getHasProject() {
        return hasProject;
    }

    public void setHasProject(Boolean hasProject) {
        this.hasProject = hasProject;
    }

    public Integer getSubjectSemester() {
        return subjectSemester;
    }

    public void setSubjectSemester(Integer subjectSemester) {
        this.subjectSemester = subjectSemester;
    }

    public Integer getSubjectCreationYear() {
        return subjectCreationYear;
    }

    public void setSubjectCreationYear(Integer subjectCreationYear) {
        this.subjectCreationYear = subjectCreationYear;
    }

    public String getSubjectStudentMail() {
        return subjectStudentMail;
    }

    public void setSubjectStudentMail(String subjectStudentMail) {
        this.subjectStudentMail = subjectStudentMail;
    }

    public String getSubjectTeacherMail() {
        return subjectTeacherMail;
    }

    public void setSubjectTeacherMail(String subjectTeacherMail) {
        this.subjectTeacherMail = subjectTeacherMail;
    }

    public Date getLastSurveyDate() {
        return lastSurveyDate;
    }

    public void setLastSurveyDate(Date lastSurveyDate) {
        this.lastSurveyDate = lastSurveyDate;
    }

    public String getLastReportFileName() {
        return lastReportFileName;
    }

    public void setLastReportFileName(String lastReportFileName) {
        this.lastReportFileName = lastReportFileName;
    }

    public boolean getToRenew() {
        return toRenew;
    }

    public void setToRenew(boolean toRenew) {
        this.toRenew = toRenew;
    }

    public Collection<SubjectGroup> getSubjectGroupCollection() {
        return subjectGroupCollection;
    }

    public void setSubjectGroupCollection(Collection<SubjectGroup> subjectGroupCollection) {
        this.subjectGroupCollection = subjectGroupCollection;
    }

    public Collection<InterfaceUser> getInterfaceUserCollection() {
        return interfaceUserCollection;
    }

    public void setInterfaceUserCollection(Collection<InterfaceUser> interfaceUserCollection) {
        this.interfaceUserCollection = interfaceUserCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idSubject != null ? idSubject.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Subject)) {
            return false;
        }
        Subject other = (Subject) object;
        if ((this.idSubject == null && other.idSubject != null) || (this.idSubject != null && !this.idSubject.equals(other.idSubject))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "fr.centrale.springapp.items.Subject[ idSubject=" + idSubject + " ]";
    }
    
}
