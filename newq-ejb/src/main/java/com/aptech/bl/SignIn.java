/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aptech.bl;

import com.aptech.bl.crud.AppUserFacade;
import com.aptech.model.AppUser;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.inject.Named;

/**
 *
 * @author Chinh
 */
@Named
@Stateless
public class SignIn {

    @Inject
    private AppUserFacade userFacade;

    public AppUser check(AppUser user, boolean isAdmin) {
        try {
//            user.setPwd(encryptPwd(user.getPwd()));
            AppUser result = userFacade.findByNamePwd(user);
            if (isAdmin) {
                return result.getUserRole().equals("admin") && result.getIsAvailable() ? result : null;
            }
            return result.getIsAvailable() ? result : null;
        } catch (NullPointerException e) {
            return null;
        }
    }

    private String encryptPwd(String pwd) {
        return pwd;
    }

    //Some bussiness
}
