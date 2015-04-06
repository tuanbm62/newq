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
import javax.resource.spi.AuthenticationMechanism;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Chinh
 */
@Entity
@Table(name = "newQItem")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "NewQItem.findAll", query = "SELECT n FROM NewQItem n"),
    @NamedQuery(name = "NewQItem.findByNewQItemId", query = "SELECT n FROM NewQItem n WHERE n.newQItemId = :newQItemId"),
    @NamedQuery(name = "NewQItem.findByTitle", query = "SELECT n FROM NewQItem n WHERE n.title = :title"),
    @NamedQuery(name = "NewQItem.findByPresentImage", query = "SELECT n FROM NewQItem n WHERE n.presentImage = :presentImage"),
    @NamedQuery(name = "NewQItem.findByContent", query = "SELECT n FROM NewQItem n WHERE n.content = :content"),
    @NamedQuery(name = "NewQItem.findByInsertDate", query = "SELECT n FROM NewQItem n WHERE n.insertDate = :insertDate"),
    @NamedQuery(name = "NewQItem.findByTag", query = "SELECT n FROM NewQItem n WHERE n.tag = :tag"),
    @NamedQuery(name = "NewQItem.findByIsAvailable", query = "SELECT n FROM NewQItem n WHERE n.isAvailable = :isAvailable")})
public class NewQItem implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "newQItemId")
    private Integer newQItemId;
    @Size(max = 50)
    @Column(name = "title")
    private String title;
    @Size(max = 200)
    @Column(name = "presentImage")
    private String presentImage;
    @Size(max = 2147483647)
    @Column(name = "content")
    private String content;
    @Column(name = "insertDate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date insertDate;
    @Size(max = 255)
    @Column(name = "tag")
    private String tag;
    @Column(name = "isAvailable")
    private Boolean isAvailable;
    @JoinColumn(name = "appUserId", referencedColumnName = "appUserId")
    @ManyToOne
    private AppUser appUserId;
    @JoinColumn(name = "newQGroupId", referencedColumnName = "newQGroupId")
    @ManyToOne
    private NewQGroup newQGroupId;

    public NewQItem() {
        newQGroupId = new NewQGroup();
    }

    public NewQItem(Integer newQItemId) {
        this.newQItemId = newQItemId;
    }

    public Integer getNewQItemId() {
        return newQItemId;
    }

    public void setNewQItemId(Integer newQItemId) {
        this.newQItemId = newQItemId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPresentImage() {
        return presentImage;
    }

    public void setPresentImage(String presentImage) {
        this.presentImage = presentImage;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getInsertDate() {
        return insertDate;
    }

    public void setInsertDate(Date insertDate) {
        this.insertDate = insertDate;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    public Boolean getIsAvailable() {
        return isAvailable;
    }

    public void setIsAvailable(Boolean isAvailable) {
        this.isAvailable = isAvailable;
    }

    public AppUser getAppUserId() {
        return appUserId;
    }

    public void setAppUserId(AppUser appUserId) {
        this.appUserId = appUserId;
    }

    public NewQGroup getNewQGroupId() {
        return newQGroupId;
    }

    public void setNewQGroupId(NewQGroup newQGroupId) {
        this.newQGroupId = newQGroupId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (newQItemId != null ? newQItemId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof NewQItem)) {
            return false;
        }
        NewQItem other = (NewQItem) object;
        if ((this.newQItemId == null && other.newQItemId != null) || (this.newQItemId != null && !this.newQItemId.equals(other.newQItemId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.aptech.model.NewQItem[ newQItemId=" + newQItemId + " ]";
    }
    
}
