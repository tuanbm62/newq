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

/**
 *
 * @author Chinh
 */
@Stateless
public class SignIn {
    @Inject
    private AppUserFacade userFacade;
    
    public AppUser check(AppUser user){
        user.setPwd(encryptPwd(user.getPwd()));
        AppUser result = userFacade.findByNamePwd(user);
        return result != null ? result : null;
    }
    
    private String encryptPwd (String pwd){
        return pwd;
    }
    
    //Some bussiness
}
