/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aptech.admin;

import com.aptech.bl.crud.NewQGroupFacade;
import com.aptech.bl.crud.NewQItemFacade;
import com.aptech.model.NewQGroup;
import com.aptech.model.NewQItem;
import java.util.Date;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;

/**
 *
 * @author Chinh
 */
@Named
@RequestScoped
public class NewQManagementController {

    private String pageTitle = "Create the new";
    private int groupId;
    @Inject private NewQItemFacade newqEJB;
    @Inject private NewQGroupFacade newGroupEJB;
//    @Inject private IndexController index;
//    @Inject private AppUserFacade userEJB;
    private NewQItem item = new NewQItem();

    public void createOrUpdateNew() {
        try {
            NewQGroup group = newGroupEJB.find(groupId);
//            AppUser user = index.getAppUser();
//            user = user == null ? userEJB.find(1) : user;
            item.setNewQGroupId(group);
//            item.setAppUserId(user);
            item.setNewQItemId(newqEJB.count()+1);
            item.setInsertDate(new Date());
            newqEJB.createOrUpdate(item);
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Create success", "Create success"));
        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, e.toString(), e.getMessage()));
        }
    }
    
    public void deleteNews(Object target){
        try {
            NewQItem updateTarget = (NewQItem) target;
            updateTarget.setIsAvailable(Boolean.FALSE);
            newqEJB.createOrUpdate(updateTarget);
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Delete success", "Delete success"));
        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, e.toString(), e.getMessage()));
        }
    }
    
    public void loadInfoUpdate(Object target){
        item = (NewQItem) target;
    }
    
    public String viewNews(){
        return "view";
    }

    public String getPageTitle() {
        return pageTitle;
    }

    public void setPageTitle(String pageTitle) {
        this.pageTitle = pageTitle;
    }

    public NewQItem getItem() {
        return item;
    }

    public void setItem(NewQItem item) {
        this.item = item;
    }

    public NewQGroupFacade getNewGroupEJB() {
        return newGroupEJB;
    }

    public NewQItemFacade getNewqEJB() {
        return newqEJB;
    }

    public int getGroupId() {
        return groupId;
    }

    public void setGroupId(int groupId) {
        this.groupId = groupId;
    }
}
