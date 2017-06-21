package com.wemen.samvedna.graphviewsamples;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;
import com.github.mikephil.charting.highlight.Highlight;
import com.github.mikephil.charting.listener.OnChartValueSelectedListener;

import java.util.ArrayList;
import java.util.List;

public class ActivityMain extends AppCompatActivity implements OnChartValueSelectedListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        LineChart chart = (LineChart) findViewById(R.id.chart);
        List<Entry> entries = new ArrayList<Entry>();
        entries.add(new Entry(1,5));
        entries.add(new Entry(2,1));
        entries.add(new Entry(3,2));
        entries.add(new Entry(4,6));
        entries.add(new Entry(5,8));
        entries.add(new Entry(6,15));
        entries.add(new Entry(7,35));
        entries.add(new Entry(8,500));
        entries.add(new Entry(9,-250));

        LineDataSet dataSet = new LineDataSet(entries, "Label"); // add entries to dataset
        dataSet.setColor(getResources().getColor(R.color.colorPrimary));
        dataSet.setValueTextColor(getResources().getColor(R.color.colorAccent));

        LineData lineData = new LineData(dataSet);
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
