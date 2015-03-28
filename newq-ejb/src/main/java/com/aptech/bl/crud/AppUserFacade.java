/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aptech.bl.crud;

import com.aptech.model.AppUser;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.Query;

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
    
    public AppUser findByNamePwd(AppUser appUser){
        Query query = em.createNamedQuery("AppUser.findByNamePwd");
        query.setParameter("name", appUser.getName());
        query.setParameter("pwd", appUser.getPwd());
        return (AppUser) query.getSingleResult();
    }

    public AppUserFacade() {
        super(AppUser.class);
    }
    
    
    
}
