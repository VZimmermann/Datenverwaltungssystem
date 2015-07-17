package org.intercard.template.util;

import org.intercard.generic.proto.propertyservice.msg.PropertyMsg.Property;
import org.intercard.generic.proto.propertyservice.msg.PropertyResponseMsg.PropertyResponse;
import org.intercard.generic.proto.propertyservice.srv.IPropertyService;
import org.intercard.generic.proto.status.enm.StatusCodesEnm.StatusCodes;
import org.intercard.template.ex.PropertyExeption;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Class for helper Methods for the PropertyService.
 * 
 * @author Raphael Biewald
 */
public class PropertyUtils {

	/**
	 * logger
	 */
	private static final Logger logger = LoggerFactory
			.getLogger(PropertyUtils.class);
	private final Property.Builder PROPERTY = Property.newBuilder();

	private IPropertyService propertyService;

	public void setPropertyService(IPropertyService propertyService) {
		this.propertyService = propertyService;
	}

	/**
	 * Reading value for parameter from property file.
	 * 
	 * @param propertyService
	 *            Reference to property object
	 * @param param
	 *            parameter
	 * @return return value
	 */
	public String getProperty(String param) throws PropertyExeption {
		// read property file
		if (propertyService == null)
			throw new PropertyExeption("Propertyservice is NULL!!");

		String value = "";
		try {
			PROPERTY.setName(param);
			PropertyResponse response = propertyService.getProperty(PROPERTY
					.build());
			if (response.getStatus().getCode()
					.equals(StatusCodes.StatusCodes_OK)) {
				value = response.getPropertyList().get(0).getValue();
			} else {
				throw new PropertyExeption(response.getStatus().getMsg());
			}
		} catch (Exception e) {
			logger.error("Fehler", e);
			throw new PropertyExeption("param: " + param);
		}
		return value;

	}
}
