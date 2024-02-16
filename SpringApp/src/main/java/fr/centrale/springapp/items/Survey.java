/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fr.centrale.springapp.items;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author Alex
 */
@Entity
@Table(name = "survey")
@NamedQueries({
    @NamedQuery(name = "Survey.findAll", query = "SELECT s FROM Survey s"),
    @NamedQuery(name = "Survey.findByIdSurvey", query = "SELECT s FROM Survey s WHERE s.idSurvey = :idSurvey"),
    @NamedQuery(name = "Survey.findBySurveyCode", query = "SELECT s FROM Survey s WHERE s.surveyCode = :surveyCode"),
    @NamedQuery(name = "Survey.findBySurveyDate", query = "SELECT s FROM Survey s WHERE s.surveyDate = :surveyDate"),
    @NamedQuery(name = "Survey.findBySurveyJsonFileName", query = "SELECT s FROM Survey s WHERE s.surveyJsonFileName = :surveyJsonFileName")})
public class Survey implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_survey")
    private Integer idSurvey;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2147483647)
    @Column(name = "survey_code")
    private String surveyCode;
    @Column(name = "survey_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date surveyDate;
    @Size(max = 2147483647)
    @Column(name = "survey_json_file_name")
    private String surveyJsonFileName;
    @JoinColumn(name = "id_group", referencedColumnName = "id_group")
    @ManyToOne(optional = false)
    private SubjectGroup idGroup;

    public Survey() {
    }

    public Survey(Integer idSurvey) {
        this.idSurvey = idSurvey;
    }

    public Survey(Integer idSurvey, String surveyCode) {
        this.idSurvey = idSurvey;
        this.surveyCode = surveyCode;
    }

    public Integer getIdSurvey() {
        return idSurvey;
    }

    public void setIdSurvey(Integer idSurvey) {
        this.idSurvey = idSurvey;
    }

    public String getSurveyCode() {
        return surveyCode;
    }

    public void setSurveyCode(String surveyCode) {
        this.surveyCode = surveyCode;
    }

    public Date getSurveyDate() {
        return surveyDate;
    }

    public void setSurveyDate(Date surveyDate) {
        this.surveyDate = surveyDate;
    }

    public String getSurveyJsonFileName() {
        return surveyJsonFileName;
    }

    public void setSurveyJsonFileName(String surveyJsonFileName) {
        this.surveyJsonFileName = surveyJsonFileName;
    }

    public SubjectGroup getIdGroup() {
        return idGroup;
    }

    public void setIdGroup(SubjectGroup idGroup) {
        this.idGroup = idGroup;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idSurvey != null ? idSurvey.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Survey)) {
            return false;
        }
        Survey other = (Survey) object;
        if ((this.idSurvey == null && other.idSurvey != null) || (this.idSurvey != null && !this.idSurvey.equals(other.idSurvey))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "fr.centrale.springapp.items.Survey[ idSurvey=" + idSurvey + " ]";
    }
    
}
