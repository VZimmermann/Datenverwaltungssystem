/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.intercard.template.util;

import java.util.List;
import java.util.Properties;

import org.intercard.generic.proto.propertyservice.msg.PropertyMsg.Property;
import org.intercard.generic.proto.propertyservice.msg.PropertyResponseMsg.PropertyResponse;
import org.intercard.generic.proto.propertyservice.srv.IPropertyService;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.config.PropertyPlaceholderConfigurer;

/**
 * 
 * @author Torsten Kopf
 */
public class IcPlaceHolderConfigurer extends PropertyPlaceholderConfigurer {

	// Injection
	private IPropertyService propertyService;

	public IcPlaceHolderConfigurer() {
		super();
	}

	// setter DI
	public void setPropertyService(IPropertyService propertyService) {
		this.propertyService = propertyService;
	}

	@Override
	protected void processProperties(
			ConfigurableListableBeanFactory beanFactoryToProcess,
			Properties props) throws BeansException {

		Property.Builder propParam = Property.newBuilder();
		propParam.setName("");

		PropertyResponse response = propertyService.getAllProperties(propParam
				.build());

		List<Property> list = response.getPropertyList();

		Properties commonsProperties = new Properties();

		for (Property prop : list) {
			commonsProperties.setProperty(prop.getName(), prop.getValue());
		}

		// XMLConfiguration config = new XMLConfiguration("config.xml");
		// Properties commonsProperties = config.getProperties("someKey");

		// Or something else with the configuration
		super.processProperties(beanFactoryToProcess, commonsProperties);
	}

}
