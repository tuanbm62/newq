/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aptech.bl.crud;

import com.aptech.model.AppUser;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;

/**
 *
 * @author Chinh
 */
@Stateless
public class AppUserFacade extends AbstractFacade<AppUser> {
    @Inject
    private EntityManager em;
    
    @Override
    protected EntityManager getEntityManager() {
        return em;
    }
    
    public AppUser findByNamePwd(AppUser appUser) throws Exception{
        if (em == null) {
            throw new Exception("em null");
        }
        List<AppUser> result = em.createNamedQuery("AppUser.findByNamePwd")
                .setParameter("appName", appUser.getAppName())
                .setParameter("appPwd", appUser.getAppPwd())
                .getResultList();
        return result.isEmpty() ? null : result.get(0);
    }

    public AppUserFacade() {
        super(AppUser.class);
    }
    
}
