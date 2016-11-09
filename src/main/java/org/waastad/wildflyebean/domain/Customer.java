/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.waastad.wildflyebean.domain;

import org.waastad.wildflyebean.domain.finder.CustomerFinder;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 *
 * @author helge
 */
@Entity
@Table(name = "t_customer")
public class Customer extends BaseModel {

  public static final CustomerFinder find = new CustomerFinder();

    private String name;

    public Customer() {
    }

    public Customer(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
