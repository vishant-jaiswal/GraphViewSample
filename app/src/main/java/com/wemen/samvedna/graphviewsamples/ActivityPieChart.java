package com.wemen.samvedna.graphviewsamples;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.data.PieEntry;
import com.github.mikephil.charting.utils.ColorTemplate;

import java.util.ArrayList;

public class ActivityPieChart extends AppCompatActivity {

    PieChart pie_chart;
    public static final int[] VORDIPLOM_COLORS = {
            Color.rgb(192, 255, 140), Color.rgb(255, 247, 140), Color.rgb(255, 208, 140),
            Color.rgb(140, 234, 255), Color.rgb(255, 140, 157),Color.CYAN,Color.MAGENTA
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pie_chart);

        pie_chart = (PieChart) findViewById(R.id.pie_chart);

        pie_chart.setUsePercentValues(true);

        ArrayList<PieEntry> yvalues = new ArrayList<PieEntry>();
        yvalues.add(new PieEntry(8f, "Monday"));
        yvalues.add(new PieEntry(15f, "Tuesday"));
        yvalues.add(new PieEntry(12f, "Wednesday"));
        yvalues.add(new PieEntry(25f, "Thursday"));
        yvalues.add(new PieEntry(23f, "Friday"));
        yvalues.add(new PieEntry(17f, "Saturday"));
        yvalues.add(new PieEntry(17f, "Sunday"));

        PieDataSet dataSet = new PieDataSet(yvalues, "Election Results");
        dataSet.setColors(VORDIPLOM_COLORS);
/*
        ArrayList<String> xVals = new ArrayList<String>();
        xVals.add("Monday");
        xVals.add("Tuesday");
        xVals.add("Wednesday");
        xVals.add("Thursday");
        xVals.add("Friday");
        xVals.add("Saturday");*/

        PieData data = new PieData(dataSet);

        data.setValueTextSize(13f);
        data.setValueTextColor(Color.DKGRAY);

        pie_chart.setData(data);
        pie_chart.invalidate();
    }
}
