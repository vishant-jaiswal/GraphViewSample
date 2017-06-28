package com.wemen.samvedna.graphviewsamples;

import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.formatter.IValueFormatter;
import com.github.mikephil.charting.utils.ViewPortHandler;

import java.text.DecimalFormat;

/**
 * Created by Vishant on 6/28/2017.
 */

public class MyValueFormatter implements IValueFormatter {

    private DecimalFormat decimalFormat;

    public MyValueFormatter() {
        decimalFormat = new DecimalFormat("###,###,##0.0");
    }

    @Override
    public String getFormattedValue(float value, Entry entry, int dataSetIndex, ViewPortHandler viewPortHandler) {
        return decimalFormat.format(value) + " $";
    }
}
