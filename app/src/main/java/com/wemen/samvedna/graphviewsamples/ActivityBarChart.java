package com.wemen.samvedna.graphviewsamples;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.utils.EntryXComparator;

import java.util.ArrayList;
import java.util.Collections;

public class ActivityBarChart extends AppCompatActivity {
    BarChart chart;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bar_chart);
        chart = (BarChart) findViewById(R.id.bar_chart);

        ArrayList<BarEntry> entries = new ArrayList<>();
        entries.add(new BarEntry(4f, 1f));
        entries.add(new BarEntry(8f, 1));
        entries.add(new BarEntry(6f, 2));
        entries.add(new BarEntry(12f, 3));
        entries.add(new BarEntry(18f, 4));
        entries.add(new BarEntry(9f, 5));
        //Collections.sort(entries,new EntryXComparator());


        BarDataSet dataset = new BarDataSet(entries, "# of Calls");

        BarData data = new BarData(dataset);
        data.setBarWidth(0.8f);
        chart.setData(data);
        chart.getXAxis().setDrawGridLines(false);
        chart.getAxisRight().setDrawGridLines(false);
        chart.getAxisLeft().setDrawGridLines(false);
        chart.setHighlightFullBarEnabled(false);
        chart.setDoubleTapToZoomEnabled(false);
        chart.setFitBars(true);
        chart.invalidate();
    }
}
