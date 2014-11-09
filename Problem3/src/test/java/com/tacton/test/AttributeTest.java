package com.tacton.test;


import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;

import com.tacton.dao.AttributeDao;
import com.tacton.entity.Attribute;
import com.tacton.util.Type;
 
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="classpath:/META-INF/applicationContext.xml")
@TransactionConfiguration(defaultRollback=true,transactionManager="transactionManager")
public class AttributeTest {
	
	@Autowired
	AttributeDao attributeDao;
 
	@Test
    public void findAttribute() {
        // loads configuration and mappings
        Configuration configuration = new Configuration().configure();
        ServiceRegistry serviceRegistry
            = new StandardServiceRegistryBuilder()
                .applySettings(configuration.getProperties()).build();
         
        // builds a session factory from the service registry
        SessionFactory sessionFactory = configuration.buildSessionFactory(serviceRegistry);
         
        // obtains the session
        Session session = sessionFactory.openSession();
        session.beginTransaction();
         Attribute attribute = new Attribute();
         attribute.setAttributeName("Test Attribute Group");
        attribute.setType(Type.ATTRIBUTE_GROUP);
        session.save(attribute);
         
        session.getTransaction().commit();
        session.close();
        
        session = sessionFactory.openSession();
        session.beginTransaction();
        List<Attribute> attribList = attributeDao.findAllAttributesByType(Type.ATTRIBUTE_GROUP);
       System.out.println(attribList.toString());
         
        StandardServiceRegistryBuilder.destroy(serviceRegistry);
         
    }
 
}
