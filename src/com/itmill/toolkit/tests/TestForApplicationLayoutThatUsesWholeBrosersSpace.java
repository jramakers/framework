/* 
@ITMillApache2LicenseForJavaFiles@
 */

package com.itmill.toolkit.tests;

import com.itmill.toolkit.Application;
import com.itmill.toolkit.ui.ExpandLayout;
import com.itmill.toolkit.ui.Label;
import com.itmill.toolkit.ui.SplitPanel;
import com.itmill.toolkit.ui.Table;
import com.itmill.toolkit.ui.Window;

public class TestForApplicationLayoutThatUsesWholeBrosersSpace extends
        Application {

    Window main = new Window("Windowing test");

    ExpandLayout rootLayout;

    SplitPanel firstLevelSplit;

    public void init() {
        setMainWindow(main);

        rootLayout = new ExpandLayout();
        main.setLayout(rootLayout);

        rootLayout.addComponent(new Label("header"));

        firstLevelSplit = new SplitPanel();

        final SplitPanel secondSplitPanel = new SplitPanel(
                SplitPanel.ORIENTATION_HORIZONTAL);
        secondSplitPanel.setFirstComponent(new Label("left"));

        final ExpandLayout topRight = new ExpandLayout();
        topRight.addComponent(new Label("topright header"));

        final Table t = TestForTablesInitialColumnWidthLogicRendering
                .getTestTable(4, 100);
        t.setSizeFull();
        topRight.addComponent(t);
        topRight.expand(t);

        topRight.addComponent(new Label("topright footer"));

        secondSplitPanel.setSecondComponent(topRight);

        final ExpandLayout el = new ExpandLayout();
        el.addComponent(new Label("B��"));

        firstLevelSplit.setFirstComponent(secondSplitPanel);
        firstLevelSplit.setSecondComponent(el);

        rootLayout.addComponent(firstLevelSplit);
        rootLayout.expand(firstLevelSplit);

        rootLayout.addComponent(new Label("footer"));

    }

}
