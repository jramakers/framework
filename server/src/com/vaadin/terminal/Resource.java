/* 
@VaadinApache2LicenseForJavaFiles@
 */

package com.vaadin.terminal;

import java.io.Serializable;

/**
 * <code>Resource</code> provided to the client terminal. Support for actually
 * displaying the resource type is left to the terminal.
 * 
 * @author Vaadin Ltd.
 * @since 3.0
 */
public interface Resource extends Serializable {

    /**
     * Gets the MIME type of the resource.
     * 
     * @return the MIME type of the resource.
     */
    public String getMIMEType();
}
