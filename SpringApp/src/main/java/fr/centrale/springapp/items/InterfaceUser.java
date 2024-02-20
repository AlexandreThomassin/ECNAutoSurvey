/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fr.centrale.springapp.items;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author alex4
 */
@Entity
@Table(name = "interface_user")
@NamedQueries({
    @NamedQuery(name = "InterfaceUser.findAll", query = "SELECT i FROM InterfaceUser i"),
    @NamedQuery(name = "InterfaceUser.findByIdUser", query = "SELECT i FROM InterfaceUser i WHERE i.idUser = :idUser"),
    @NamedQuery(name = "InterfaceUser.findByUserType", query = "SELECT i FROM InterfaceUser i WHERE i.userType = :userType"),
    @NamedQuery(name = "InterfaceUser.findByUserName", query = "SELECT i FROM InterfaceUser i WHERE i.userName = :userName"),
    @NamedQuery(name = "InterfaceUser.findByUserFirstName", query = "SELECT i FROM InterfaceUser i WHERE i.userFirstName = :userFirstName")})
public class InterfaceUser implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_user")
    private Integer idUser;
    @Size(max = 2147483647)
    @Column(name = "user_type")
    private String userType;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2147483647)
    @Column(name = "user_name")
    private String userName;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2147483647)
    @Column(name = "user_first_name")
    private String userFirstName;
    @ManyToMany(mappedBy = "interfaceUserCollection")
    private Collection<Subject> subjectCollection;

    public InterfaceUser() {
    }

    public InterfaceUser(Integer idUser) {
        this.idUser = idUser;
    }

    public InterfaceUser(Integer idUser, String userName, String userFirstName) {
        this.idUser = idUser;
        this.userName = userName;
        this.userFirstName = userFirstName;
    }

    public Integer getIdUser() {
        return idUser;
    }

    public void setIdUser(Integer idUser) {
        this.idUser = idUser;
    }

    public String getUserType() {
        return userType;
    }

    public void setUserType(String userType) {
        this.userType = userType;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserFirstName() {
        return userFirstName;
    }

    public void setUserFirstName(String userFirstName) {
        this.userFirstName = userFirstName;
    }

    public Collection<Subject> getSubjectCollection() {
        return subjectCollection;
    }

    public void setSubjectCollection(Collection<Subject> subjectCollection) {
        this.subjectCollection = subjectCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idUser != null ? idUser.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof InterfaceUser)) {
            return false;
        }
        InterfaceUser other = (InterfaceUser) object;
        if ((this.idUser == null && other.idUser != null) || (this.idUser != null && !this.idUser.equals(other.idUser))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "fr.centrale.springapp.items.InterfaceUser[ idUser=" + idUser + " ]";
    }
    
}
