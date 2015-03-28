/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aptech.model;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Chinh
 */
@Entity
@Table(name = "appUser")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "AppUser.findAll", query = "SELECT a FROM AppUser a"),
    @NamedQuery(name = "AppUser.findByAppUserId", query = "SELECT a FROM AppUser a WHERE a.appUserId = :appUserId"),
    @NamedQuery(name = "AppUser.findByName", query = "SELECT a FROM AppUser a WHERE a.name = :name"),
    @NamedQuery(name = "AppUser.findByPwd", query = "SELECT a FROM AppUser a WHERE a.pwd = :pwd"),
    @NamedQuery(name = "AppUser.findByUserImage", query = "SELECT a FROM AppUser a WHERE a.userImage = :userImage"),
    @NamedQuery(name = "AppUser.findByIsAvailable", query = "SELECT a FROM AppUser a WHERE a.isAvailable = :isAvailable"),
    @NamedQuery(name = "AppUser.findByUserRole", query = "SELECT a FROM AppUser a WHERE a.userRole = :userRole")})
public class AppUser implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "appUserId")
    private Integer appUserId;
    @Size(max = 15)
    @Column(name = "name")
    private String name;
    @Size(max = 50)
    @Column(name = "pwd")
    private String pwd;
    @Size(max = 200)
    @Column(name = "userImage")
    private String userImage;
    @Column(name = "isAvailable")
    private Boolean isAvailable;
    @Size(max = 5)
    @Column(name = "userRole")
    private String userRole;
    @OneToMany(mappedBy = "appUserId")
    private Collection<ActHistory> actHistoryCollection;
    @OneToMany(mappedBy = "appUserId")
    private Collection<NewQItem> newQItemCollection;

    public AppUser() {
    }

    public AppUser(Integer appUserId) {
        this.appUserId = appUserId;
    }

    public Integer getAppUserId() {
        return appUserId;
    }

    public void setAppUserId(Integer appUserId) {
        this.appUserId = appUserId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public String getUserImage() {
        return userImage;
    }

    public void setUserImage(String userImage) {
        this.userImage = userImage;
    }

    public Boolean getIsAvailable() {
        return isAvailable;
    }

    public void setIsAvailable(Boolean isAvailable) {
        this.isAvailable = isAvailable;
    }

    public String getUserRole() {
        return userRole;
    }

    public void setUserRole(String userRole) {
        this.userRole = userRole;
    }

    @XmlTransient
    public Collection<ActHistory> getActHistoryCollection() {
        return actHistoryCollection;
    }

    public void setActHistoryCollection(Collection<ActHistory> actHistoryCollection) {
        this.actHistoryCollection = actHistoryCollection;
    }

    @XmlTransient
    public Collection<NewQItem> getNewQItemCollection() {
        return newQItemCollection;
    }

    public void setNewQItemCollection(Collection<NewQItem> newQItemCollection) {
        this.newQItemCollection = newQItemCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (appUserId != null ? appUserId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof AppUser)) {
            return false;
        }
        AppUser other = (AppUser) object;
        if ((this.appUserId == null && other.appUserId != null) || (this.appUserId != null && !this.appUserId.equals(other.appUserId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.aptech.model.AppUser[ appUserId=" + appUserId + " ]";
    }
    
}
