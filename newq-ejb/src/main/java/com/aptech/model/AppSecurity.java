/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aptech.model;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Chinh
 */
@Entity
@Table(name = "appSecurity")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "AppSecurity.findAll", query = "SELECT a FROM AppSecurity a"),
    @NamedQuery(name = "AppSecurity.findByAppSecurityId", query = "SELECT a FROM AppSecurity a WHERE a.appSecurityId = :appSecurityId"),
    @NamedQuery(name = "AppSecurity.findBySalt", query = "SELECT a FROM AppSecurity a WHERE a.salt = :salt"),
    @NamedQuery(name = "AppSecurity.findBySCount", query = "SELECT a FROM AppSecurity a WHERE a.sCount = :sCount"),
    @NamedQuery(name = "AppSecurity.findByIsAvailable", query = "SELECT a FROM AppSecurity a WHERE a.isAvailable = :isAvailable")})
public class AppSecurity implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "appSecurityId")
    private Integer appSecurityId;
    @Size(max = 200)
    @Column(name = "salt")
    private String salt;
    @Column(name = "sCount")
    private Integer sCount;
    @Column(name = "isAvailable")
    private Boolean isAvailable;

    public AppSecurity() {
    }

    public AppSecurity(Integer appSecurityId) {
        this.appSecurityId = appSecurityId;
    }

    public Integer getAppSecurityId() {
        return appSecurityId;
    }

    public void setAppSecurityId(Integer appSecurityId) {
        this.appSecurityId = appSecurityId;
    }

    public String getSalt() {
        return salt;
    }

    public void setSalt(String salt) {
        this.salt = salt;
    }

    public Integer getSCount() {
        return sCount;
    }

    public void setSCount(Integer sCount) {
        this.sCount = sCount;
    }

    public Boolean getIsAvailable() {
        return isAvailable;
    }

    public void setIsAvailable(Boolean isAvailable) {
        this.isAvailable = isAvailable;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (appSecurityId != null ? appSecurityId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof AppSecurity)) {
            return false;
        }
        AppSecurity other = (AppSecurity) object;
        if ((this.appSecurityId == null && other.appSecurityId != null) || (this.appSecurityId != null && !this.appSecurityId.equals(other.appSecurityId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.aptech.model.AppSecurity[ appSecurityId=" + appSecurityId + " ]";
    }
    
}
