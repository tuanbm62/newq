/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aptech.dal;

import javax.enterprise.inject.Produces;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Chinh
 */
public class DatabaseFactory {
    @Produces
    @PersistenceContext(unitName = "newqPU")
    private EntityManager entityManager;
}
