package com.wemen.samvedna.graphviewsamples;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.components.AxisBase;
import com.github.mikephil.charting.components.Description;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;
import com.github.mikephil.charting.formatter.IAxisValueFormatter;
import com.github.mikephil.charting.highlight.Highlight;
import com.github.mikephil.charting.interfaces.datasets.ILineDataSet;
import com.github.mikephil.charting.listener.OnChartValueSelectedListener;
import com.github.mikephil.charting.utils.EntryXComparator;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class ActivityLineChart extends AppCompatActivity implements OnChartValueSelectedListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_line_chart);

        LineChart chart = (LineChart) findViewById(R.id.chart);
        List<Entry> entriesC1 = new ArrayList<Entry>();
        List<Entry> entriesC2 = new ArrayList<Entry>();

        entriesC1.add(new Entry(0,1000));
        entriesC1.add(new Entry(2,1100));
        entriesC1.add(new Entry(6,1100));
        entriesC1.add(new Entry(4,1300));
        entriesC1.add(new Entry(5,1000));
        entriesC1.add(new Entry(8,900));
        Collections.sort(entriesC1,new EntryXComparator());


        entriesC2.add(new Entry(0,1000));
        entriesC2.add(new Entry(2,1200));
        entriesC2.add(new Entry(4,1200));
        entriesC2.add(new Entry(5,1000));
        entriesC2.add(new Entry(7,1300));
        entriesC2.add(new Entry(8,1200));

        LineDataSet dataSetC1 = new LineDataSet(entriesC1, "Comp1"); // add entries to dataset
        LineDataSet dataSetC2 = new LineDataSet(entriesC2,"Comp2");
        /*dataSet.setColor(getResources().getColor(R.color.colorPrimary));
        dataSet.setValueTextColor(getResources().getColor(R.color.colorAccent));*/

        dataSetC1.setAxisDependency(YAxis.AxisDependency.LEFT);
        dataSetC1.setColor(Color.GREEN);
        dataSetC2.setAxisDependency(YAxis.AxisDependency.LEFT);
        dataSetC2.setColor(Color.RED);

        List<ILineDataSet> dataSets = new ArrayList<ILineDataSet>();
        dataSets.add(dataSetC1);
        dataSets.add(dataSetC2);

        final String[] quarters = new String[]{ "Q1", "Q2", "Q3", "Q4","Q4","Q5","Q6","Q7","Q8","Q9"};

        IAxisValueFormatter formatter = new IAxisValueFormatter() {

            @Override
            public String getFormattedValue(float value, AxisBase axis) {
                return quarters[(int) value];
            }
        };

        XAxis xAxis = chart.getXAxis();
        xAxis.setDrawGridLines(false);
        xAxis.setGranularity(1f); // minimum axis-step (interval) is 1
        xAxis.setValueFormatter(formatter);

        YAxis yAxis = chart.getAxisLeft();
        yAxis.setDrawGridLines(false);

        chart.getAxisRight().setDrawGridLines(false);



        LineData lineData = new LineData(dataSets);
        chart.setData(lineData);
        chart.invalidate();
        chart.setOnChartValueSelectedListener(this);

    }

    @Override
    public void onValueSelected(Entry e, Highlight h) {
        if(e.getY()>15){
            Toast.makeText(this, "Value Greater than 100", Toast.LENGTH_SHORT).show();
        }else {
            Toast.makeText(this, "less value ", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void onNothingSelected() {

    }
}
