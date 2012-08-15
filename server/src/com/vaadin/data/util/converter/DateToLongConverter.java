/*
@VaadinApache2LicenseForJavaFiles@
 */

package com.vaadin.data.util.converter;

import java.util.Date;
import java.util.Locale;

/**
 * A converter that converts from {@link Long} to {@link Date} and back.
 * 
 * @author Vaadin Ltd
 * @since 7.0
 */
public class DateToLongConverter implements Converter<Date, Long> {

    /*
     * (non-Javadoc)
     * 
     * @see
     * com.vaadin.data.util.converter.Converter#convertToModel(java.lang.Object,
     * java.util.Locale)
     */
    @Override
    public Long convertToModel(Date value, Locale locale) {
        if (value == null) {
            return null;
        }

        return value.getTime();
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * com.vaadin.data.util.converter.Converter#convertToPresentation(java.lang
     * .Object, java.util.Locale)
     */
    @Override
    public Date convertToPresentation(Long value, Locale locale) {
        if (value == null) {
            return null;
        }

        return new Date(value);
    }

    /*
     * (non-Javadoc)
     * 
     * @see com.vaadin.data.util.converter.Converter#getModelType()
     */
    @Override
    public Class<Long> getModelType() {
        return Long.class;
    }

    /*
     * (non-Javadoc)
     * 
     * @see com.vaadin.data.util.converter.Converter#getPresentationType()
     */
    @Override
    public Class<Date> getPresentationType() {
        return Date.class;
    }

}
