package codingcareers.webapp.client.PageComponents;

import com.google.gwt.i18n.client.NumberFormat;
import com.google.gwt.user.client.DOM;
import com.google.gwt.user.client.Element;
import com.google.gwt.user.client.ui.Widget;

/*
 Courtesy of Italo Borssatto at http://stackoverflow.com/questions/9482665/progress-bar-for-gwt
 */

public class ProgressBar extends Widget {
    private static final String PERCENT_PATTERN = "#,##0%";
    private static final NumberFormat percentFormat = NumberFormat.getFormat(PERCENT_PATTERN);

    private final Element progress;
    private final Element percentageLabel;
    private double percentage;
    private final double max;

    public ProgressBar(double value, double max) {
        assert max != 0;
        this.max = max;

        progress = DOM.createElement("progress");
        progress.setAttribute("max", Double.toString(max));
        progress.setAttribute("value", Double.toString(value));

        percentageLabel = DOM.createElement("span");
        percentage = value / max;
        percentageLabel.setInnerHTML(percentFormat.format(percentage));
        progress.insertFirst(percentageLabel);

        setElement(progress);
    }

    public void setProgress(double value) {
        progress.setAttribute("value", Double.toString(value));
        percentage = value / max;
        percentageLabel.setInnerHTML(percentFormat.format(percentage));
    }

}