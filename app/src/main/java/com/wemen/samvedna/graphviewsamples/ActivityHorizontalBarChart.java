package com.wemen.samvedna.graphviewsamples;

import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.github.mikephil.charting.charts.HorizontalBarChart;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;

import java.util.ArrayList;
import java.util.Collections;

public class ActivityHorizontalBarChart extends AppCompatActivity {

    HorizontalBarChart chart;
    protected Typeface mTfRegular;
    protected Typeface mTfLight;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_horizontal_bar_chart);

        mTfRegular = Typeface.createFromAsset(getAssets(), "OpenSans-Regular.ttf");
        mTfLight = Typeface.createFromAsset(getAssets(), "OpenSans-Light.ttf");

        chart = (HorizontalBarChart) findViewById(R.id.horizontal_bar_chart);

        ArrayList<BarEntry> entries = new ArrayList<>();
        entries.add(new BarEntry(1f, 3));
        entries.add(new BarEntry(2f, 2));
        entries.add(new BarEntry(3f, 1));
        entries.add(new BarEntry(4f, 5));
        entries.add(new BarEntry(5f, 3));
        entries.add(new BarEntry(6f, 4));
        entries.add(new BarEntry(7f, 4));
        entries.add(new BarEntry(8f, 4));
        entries.add(new BarEntry(9f, 4));
        entries.add(new BarEntry(10f, 6));
        entries.add(new BarEntry(11f, 5));
        entries.add(new BarEntry(12f, 4));
        entries.add(new BarEntry(13f, 4));
        entries.add(new BarEntry(14f, 4));

        //Collections.sort(entries,new EntryXComparator());

        BarDataSet dataset = new BarDataSet(entries, "# of Calls");


        BarData data = new BarData(dataset);
        data.setValueTextSize(10f);
        data.setValueTypeface(mTfLight);
        //data.setValueTypeface(mTfLight);
        data.setBarWidth(0.9f);
        //styling
        /*chart.getXAxis().setDrawGridLines(false);
        chart.getAxisRight().setDrawGridLines(false);
        chart.getAxisLeft().setDrawGridLines(false);*/
        chart.setDrawValueAboveBar(true);
        chart.setData(data);
        chart.setFitBars(true);
        chart.invalidate();
    }
}
