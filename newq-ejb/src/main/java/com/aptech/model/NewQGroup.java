/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aptech.model;

import java.io.Serializable;
import java.util.List;
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
@Table(name = "newQGroup")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "NewQGroup.findAll", query = "SELECT n FROM NewQGroup n"),
    @NamedQuery(name = "NewQGroup.findByNewQGroupId", query = "SELECT n FROM NewQGroup n WHERE n.newQGroupId = :newQGroupId"),
    @NamedQuery(name = "NewQGroup.findByNewQGroupName", query = "SELECT n FROM NewQGroup n WHERE n.newQGroupName = :newQGroupName"),
    @NamedQuery(name = "NewQGroup.findByIsAvailable", query = "SELECT n FROM NewQGroup n WHERE n.isAvailable = :isAvailable")})
public class NewQGroup implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "newQGroupId")
    private Integer newQGroupId;
    @Size(max = 50)
    @Column(name = "newQGroupName")
    private String newQGroupName;
    @Column(name = "isAvailable")
    private Boolean isAvailable;
    @OneToMany(mappedBy = "newQGroupId")
    private List<NewQItem> newQItemList;

    public NewQGroup() {
    }

    public NewQGroup(Integer newQGroupId) {
        this.newQGroupId = newQGroupId;
    }

    public Integer getNewQGroupId() {
        return newQGroupId;
    }

    public void setNewQGroupId(Integer newQGroupId) {
        this.newQGroupId = newQGroupId;
    }

    public String getNewQGroupName() {
        return newQGroupName;
    }

    public void setNewQGroupName(String newQGroupName) {
        this.newQGroupName = newQGroupName;
    }

    public Boolean getIsAvailable() {
        return isAvailable;
    }

    public void setIsAvailable(Boolean isAvailable) {
        this.isAvailable = isAvailable;
    }

    @XmlTransient
    public List<NewQItem> getNewQItemList() {
        return newQItemList;
    }

    public void setNewQItemList(List<NewQItem> newQItemList) {
        this.newQItemList = newQItemList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (newQGroupId != null ? newQGroupId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof NewQGroup)) {
            return false;
        }
        NewQGroup other = (NewQGroup) object;
        if ((this.newQGroupId == null && other.newQGroupId != null) || (this.newQGroupId != null && !this.newQGroupId.equals(other.newQGroupId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.aptech.model.NewQGroup[ newQGroupId=" + newQGroupId + " ]";
    }
    
}
