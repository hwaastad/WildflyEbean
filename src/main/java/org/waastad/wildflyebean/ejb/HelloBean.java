/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.waastad.wildflyebean.ejb;

import com.avaje.ebean.Ebean;
import javax.ejb.Stateless;
import org.waastad.wildflyebean.domain.Customer;

/**
 *
 * @author helge
 */
@Stateless
public class HelloBean {

    public void createCustomer(String name) {
        Customer c = new Customer(name);
        c.save();
    }

    public Customer find(String name) {
        System.out.println("Saying hello.....");
        return Customer.find.byName(name);
    }
}
