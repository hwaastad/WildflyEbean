/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.waastad.wildflyebean.ejb;

import com.avaje.ebean.EbeanServerFactory;
import com.avaje.ebean.config.ServerConfig;
import com.avaje.ebean.config.dbplatform.H2Platform;
import com.avaje.ebean.config.dbplatform.HsqldbPlatform;
import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.sql.DataSource;
import org.waastad.wildflyebean.domain.Customer;

/**
 *
 * @author helge
 */
@Startup
@Singleton
public class EbeanInitializer {

    @Resource(lookup = "java:jboss/datasources/DS")
    private DataSource ds;

    @PostConstruct
    public void construct() {
        ServerConfig config = new ServerConfig();
        config.loadFromProperties();
        config.setDataSource(ds);
        config.setName("DefaultServer");
        config.setUseJtaTransactionManager(true);
        config.setAutoCommitMode(true);
        config.setDatabasePlatform(new H2Platform());
        config.setRegister(true);
        config.setDefaultServer(true);
//        config.getAutoTuneConfig().setProfiling(true);
//        config.getAutoTuneConfig().setQueryTuning(true);
        config.setDdlGenerate(true);
        config.setDdlRun(true);
        //config.setCurrentUserProvider(new UserProvider());
        config.addPackage(Customer.class.getPackage().getName());
        EbeanServerFactory.create(config);
    }
}
