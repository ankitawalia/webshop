package com.tacton.test;


import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.jboss.resteasy.client.jaxrs.ResteasyClient;
import org.jboss.resteasy.client.jaxrs.ResteasyClientBuilder;
import org.jboss.resteasy.client.jaxrs.ResteasyWebTarget;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.tacton.dao.AttributeDao;
import com.tacton.entity.Attribute;
import com.tacton.util.Type;
 

public class AttributeTest {
	
	@Autowired
	AttributeDao attributeDao;
	
	public Attribute mockAttribute() {
		Attribute attribute = new Attribute();
		attribute.setType(Type.ATTRIBUTE_GROUP);
		attribute.setAttributeId(1);
		attribute.setAttributeName("Cost_group");
		return attribute;
	}

	@Test
	public void getAllAttributesGroup() {
		
		//Attribute attribute = mockAttribute();
		ResteasyClient client = new ResteasyClientBuilder().build();
		ResteasyWebTarget target = client.target("http://localhost:8080/Problem3/api/attributes/group");
		
		//<List<Attribute>> response = target.request.get(new GenericType<List<Attribute>>(){});

		//Attribute response= target.request().get(Attribute.class);
		//Attribute response1 = response.getEntity();
		System.out.println(target);
	   // Assert.notNull(response);
	    
	    //ClientRequest request = new ClientRequest("http://localhost:8080/Problem3/api/attributes/group");
	    
	     // ClientResponse<User> response = request.get(User.class);
	    
	     // Attribute response1 = response.getEntity();
	    
	     // Assert.assertNotNull(user);

		//Assert.assertEquals(response.getAttributeId(),attribute.getAttributeId());
		//Assert.assertEquals(response.getAttributeName(),attribute.getAttributeName());
		//Assert.assertEquals(response.getType(),attribute.getType());
	}	
 
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
