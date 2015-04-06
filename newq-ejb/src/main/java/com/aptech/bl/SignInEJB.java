/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aptech.bl;

import com.aptech.bl.crud.AppUserFacade;
import com.aptech.exception.AccountUserLockException;
import com.aptech.exception.AccountUserNotFoundException;
import com.aptech.exception.AccountUserNotValidRoleException;
import com.aptech.model.AppUser;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.inject.Named;
import javax.security.auth.login.AccountLockedException;

/**
 *
 * @author Chinh
 */
@Named
@Stateless
public class SignInEJB {

    @Inject
    private AppUserFacade userFacade;

    public AppUser check(AppUser user, boolean isAdmin) throws Exception {
        AppUser result = userFacade.findByNamePwd(user);
        if (result == null) {
            throw new AccountUserNotFoundException("Account does not exist");
        }
        if (!result.getIsAvailable()) {
            throw new AccountUserLockException("Account was locked");
        }
        if (!result.getUserRole().equals("admin") && isAdmin) {
            throw new AccountUserNotValidRoleException("Account does not permission");
        }

        return result;
    }

    private String encryptPwd(String pwd) {
        return pwd;
    }

    //Some bussiness
}
