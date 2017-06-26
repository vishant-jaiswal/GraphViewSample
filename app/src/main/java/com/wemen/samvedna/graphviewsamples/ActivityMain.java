package com.wemen.samvedna.graphviewsamples;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class ActivityMain extends AppCompatActivity implements View.OnClickListener {

    Button btn_line_chart;
    Button btn_bar_chart;
    Button btn_horizontal_bar_chart;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn_bar_chart = (Button) findViewById(R.id.btn_bar_chart);
        btn_line_chart = (Button) findViewById(R.id.btn_line_chart);
        btn_horizontal_bar_chart = (Button) findViewById(R.id.btn_horizontal_bar_chart);

        btn_bar_chart.setOnClickListener(this);
        btn_line_chart.setOnClickListener(this);
        btn_horizontal_bar_chart.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.btn_bar_chart:
                openBarChartActivity();
                break;
            case R.id.btn_line_chart:
                openLineChartActivity();
                break;
            case R.id.btn_horizontal_bar_chart:
                openHorizonatlBarChartActivity();
                break;
        }
    }

    private void openHorizonatlBarChartActivity() {
        Intent intent = new Intent(this,ActivityHorizontalBarChart.class);
        startActivity(intent);
    }

    private void openBarChartActivity() {
        Intent intent = new Intent(this,ActivityBarChart.class);
        startActivity(intent);
    }

    private void openLineChartActivity() {
        Intent intent = new Intent(this,ActivityLineChart.class);
        startActivity(intent);
    }
}
