/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.waastad.wildflyebean.domain;

import com.avaje.ebean.config.ServerConfig;
import com.avaje.ebean.config.dbplatform.DatabasePlatform;
import java.io.File;
import org.waastad.wildflyebean.ejb.HelloBean;
import javax.annotation.Resource;
import javax.inject.Inject;
import javax.sql.DataSource;
import org.avaje.datasource.DataSourcePool;
import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.modules.maven.MavenResolver;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.asset.EmptyAsset;
import org.jboss.shrinkwrap.api.spec.WebArchive;
import org.jboss.shrinkwrap.resolver.api.maven.Maven;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.waastad.wildflyebean.domain.finder.CustomerFinder;
import org.waastad.wildflyebean.domain.query.QCustomer;

/**
 *
 * @author helge
 */
@RunWith(Arquillian.class)
public class HelloBeanIT {

    public HelloBeanIT() {
    }

    @Inject
    private HelloBean helloBean;
    @Resource(lookup = "java:jboss/datasources/DS")
    private DataSource ds;

    @Deployment
    public static WebArchive createdeployment() {
        File[] asFile = Maven.resolver().loadPomFromFile("pom.xml").importCompileAndRuntimeDependencies().resolve().withTransitivity().asFile();

        return ShrinkWrap.create(WebArchive.class, "test.war")
                .addPackage(HelloBean.class.getPackage())
                .addPackage(CustomerFinder.class.getPackage())
                .addPackage(Customer.class.getPackage())
                .addPackage(QCustomer.class.getPackage())
                .addPackage(DataSourcePool.class.getPackage())
                .addAsLibraries(asFile)
                .addAsWebInfResource("wildfly-ds.xml")
                .addAsWebInfResource(EmptyAsset.INSTANCE, "beans.xml");
    }

    /**
     * Test of find method, of class HelloBean.
     * @throws java.lang.Exception
     */
    @Test
    public void testSayHello() throws Exception {
        System.out.println("sayHello");
//        helloBean.createCustomer("xxx");
        for (int i = 0; i < 30; i++) {
            helloBean.find("xxx");
        }
    }

}
