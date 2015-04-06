/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aptech.admin;

import com.aptech.bl.SignInEJB;
import com.aptech.model.AppUser;
import java.io.Serializable;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;

/**
 *
 * @author Chinh
 */
@Named
@SessionScoped
public class IndexController implements Serializable {
    private static final boolean SIGNIN_ROLE_ADMIN = true;
    @Inject
    private SignInEJB signIn;
    private AppUser appUser = new AppUser();

    public String adminSignIn() {
        try {
            appUser = signIn.check(appUser, SIGNIN_ROLE_ADMIN);
            return "success";
        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, e.getMessage(), e.getMessage()));
            return "failure";
        }
    }

    public AppUser getAppUser() {
        return appUser;
    }

    public void setAppUser(AppUser appUser) {
        this.appUser = appUser;
    }
}
