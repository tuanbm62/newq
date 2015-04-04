/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aptech.admin;

import com.aptech.bl.SignIn;
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

    @Inject
    private SignIn signIn;
    private AppUser appUser = new AppUser();

    public String adminSignIn() {
        try {
            AppUser temp = signIn.check(appUser, true);
            if (temp == null) {
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Sign in failure", "ABCZYZ"));
                return "failure";
            }
            return "success";
        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, e.toString(), e.toString()));
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
