/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aptech.model;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
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
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Chinh
 */
@Entity
@Table(name = "actHistory")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ActHistory.findAll", query = "SELECT a FROM ActHistory a"),
    @NamedQuery(name = "ActHistory.findByActHistoryId", query = "SELECT a FROM ActHistory a WHERE a.actHistoryId = :actHistoryId"),
    @NamedQuery(name = "ActHistory.findByTypeAction", query = "SELECT a FROM ActHistory a WHERE a.typeAction = :typeAction"),
    @NamedQuery(name = "ActHistory.findByActionTime", query = "SELECT a FROM ActHistory a WHERE a.actionTime = :actionTime"),
    @NamedQuery(name = "ActHistory.findByActionDescription", query = "SELECT a FROM ActHistory a WHERE a.actionDescription = :actionDescription")})
public class ActHistory implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "actHistoryId")
    private Integer actHistoryId;
    @Size(max = 20)
    @Column(name = "typeAction")
    private String typeAction;
    @Column(name = "actionTime")
    @Temporal(TemporalType.TIMESTAMP)
    private Date actionTime;
    @Size(max = 255)
    @Column(name = "actionDescription")
    private String actionDescription;
    @JoinColumn(name = "appUserId", referencedColumnName = "appUserId")
    @ManyToOne
    private AppUser appUserId;

    public ActHistory() {
    }

    public ActHistory(Integer actHistoryId) {
        this.actHistoryId = actHistoryId;
    }

    public Integer getActHistoryId() {
        return actHistoryId;
    }

    public void setActHistoryId(Integer actHistoryId) {
        this.actHistoryId = actHistoryId;
    }

    public String getTypeAction() {
        return typeAction;
    }

    public void setTypeAction(String typeAction) {
        this.typeAction = typeAction;
    }

    public Date getActionTime() {
        return actionTime;
    }

    public void setActionTime(Date actionTime) {
        this.actionTime = actionTime;
    }

    public String getActionDescription() {
        return actionDescription;
    }

    public void setActionDescription(String actionDescription) {
        this.actionDescription = actionDescription;
    }

    public AppUser getAppUserId() {
        return appUserId;
    }

    public void setAppUserId(AppUser appUserId) {
        this.appUserId = appUserId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (actHistoryId != null ? actHistoryId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ActHistory)) {
            return false;
        }
        ActHistory other = (ActHistory) object;
        if ((this.actHistoryId == null && other.actHistoryId != null) || (this.actHistoryId != null && !this.actHistoryId.equals(other.actHistoryId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.aptech.model.ActHistory[ actHistoryId=" + actHistoryId + " ]";
    }
    
}
