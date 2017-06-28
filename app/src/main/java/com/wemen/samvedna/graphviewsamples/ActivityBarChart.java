package com.wemen.samvedna.graphviewsamples;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.utils.EntryXComparator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ActivityBarChart extends AppCompatActivity {
    BarChart chart;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bar_chart);
        chart = (BarChart) findViewById(R.id.bar_chart);

        float[] group1 = new float[]{3f,1f,2f,3f,4f,5f,6f,2f};
        float[] group2 = new float[]{1f,2f,3f,4f,5f,6f,2f,3f};


        List<BarEntry> entriesGroup1 = new ArrayList<>();
        List<BarEntry> entriesGroup2 = new ArrayList<>();
        //Collections.sort(entries,new EntryXComparator());

        for(int i = 0; i < group1.length; i++) {
            entriesGroup1.add(new BarEntry(i,group1[i]));
            entriesGroup2.add(new BarEntry(i, group2[i]));
        }


        BarDataSet set1 = new BarDataSet(entriesGroup1, "Group 1");
        set1.setColor(Color.RED);
        BarDataSet set2 = new BarDataSet(entriesGroup2, "Group 2");
        set2.setColor(Color.GREEN);

        BarData data = new BarData(set1,set2);
        data.setBarWidth(0.45f);
       // chart.getXAxis().setCenterAxisLabels(true);
        chart.setData(data);

        YAxis left = chart.getAxisLeft();
        left.setValueFormatter(new MyYAxisValueFormatter());

        String[] values = new String[] {"A","B","C","D","E","F","G","H","I","J","K","L","M"};
        XAxis xAxis = chart.getXAxis();
        xAxis.setValueFormatter(new MyXAxisValueFormatter(values));
        xAxis.setGranularity(1f);
        /*chart.getXAxis().setDrawGridLines(false);
        chart.getAxisRight().setDrawGridLines(false);
        chart.getAxisLeft().setDrawGridLines(false);
        chart.setHighlightFullBarEnabled(false);
        chart.setDoubleTapToZoomEnabled(false);*/
        chart.groupBars(0f,0.06f,0.02f);
        chart.animateY(1000);
        chart.animateX(4000);

        //chart.setFitBars(true)
        chart.invalidate();
    }
}
