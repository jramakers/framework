/* 
@VaadinApache2LicenseForJavaFiles@
 */

package com.vaadin.tests.minitutorials.v7a1;

import com.vaadin.Application;
import com.vaadin.RootRequiresMoreInformationException;
import com.vaadin.terminal.WrappedRequest;
import com.vaadin.terminal.WrappedRequest.BrowserDetails;
import com.vaadin.terminal.gwt.server.WebBrowser;
import com.vaadin.ui.Label;
import com.vaadin.ui.Root;

/**
 * Mini tutorial code for
 * https://vaadin.com/wiki/-/wiki/Main/Creating%20an%20application
 * %20with%20different%20features%20for%20different%20clients
 * 
 * @author Vaadin Ltd
 * @since 7.0.0
 */
public class DifferentFeaturesForDifferentClients extends Application {

    @Override
    protected Root getRoot(WrappedRequest request)
            throws RootRequiresMoreInformationException {
        BrowserDetails browserDetails = request.getBrowserDetails();
        // This is a limitation of 7.0.0.alpha1 that there is no better way to
        // check if WebBrowser has been fully initialized
        if (browserDetails.getUriFragment() == null) {
            throw new RootRequiresMoreInformationException();
        }

        // could also use screen size, browser version etc.
        if (browserDetails.getWebBrowser().isTouchDevice()) {
            return new TouchRoot();
        } else {
            return new DefaultRoot();
        }
    }
}

class DefaultRoot extends Root {
    @Override
    protected void init(WrappedRequest request) {
        getContent().addComponent(
                new Label("This browser does not support touch events"));
    }
}

class TouchRoot extends Root {
    @Override
    protected void init(WrappedRequest request) {
        WebBrowser webBrowser = request.getBrowserDetails().getWebBrowser();
        String screenSize = "" + webBrowser.getScreenWidth() + "x"
                + webBrowser.getScreenHeight();
        getContent().addComponent(
                new Label("Using a touch enabled device with screen size"
                        + screenSize));
    }
}
