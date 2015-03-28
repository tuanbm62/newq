/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aptech.bl;

import com.aptech.model.NewQItem;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;

/**
 *
 * @author Chinh
 */
@Stateless
public class NewQItemFacade extends AbstractFacade<NewQItem> {
    @Inject
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }
    
    public NewQItemFacade() {
        super(NewQItem.class);
    }
    
}
