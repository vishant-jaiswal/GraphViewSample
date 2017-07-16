package com.wemen.samvedna.graphviewsamples;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class ActivityMain extends AppCompatActivity implements View.OnClickListener {

    Button btn_line_chart;
    Button btn_bar_chart;
    Button btn_horizontal_bar_chart;
    Button btn_pie_chart;
    Button btn_wheel_view;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn_bar_chart = (Button) findViewById(R.id.btn_bar_chart);
        btn_line_chart = (Button) findViewById(R.id.btn_line_chart);
        btn_horizontal_bar_chart = (Button) findViewById(R.id.btn_horizontal_bar_chart);
        btn_pie_chart = (Button) findViewById(R.id.btn_pie_chart);
        btn_wheel_view = (Button) findViewById(R.id.btn_wheel_view);

        btn_bar_chart.setOnClickListener(this);
        btn_line_chart.setOnClickListener(this);
        btn_horizontal_bar_chart.setOnClickListener(this);
        btn_pie_chart.setOnClickListener(this);
        btn_wheel_view.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_bar_chart:
                openBarChartActivity();
                break;
            case R.id.btn_line_chart:
                openLineChartActivity();
                break;
            case R.id.btn_horizontal_bar_chart:
                openHorizonatlBarChartActivity();
                break;
            case R.id.btn_pie_chart:
                openPieChartActivity();
                break;
            case R.id.btn_wheel_view:
                openWheelActivity();
                break;
        }
    }

    private void openWheelActivity() {
        Intent intent = new Intent(this, ActivityWheelView.class);
        startActivity(intent);
    }

    private void openPieChartActivity() {
        Intent intent = new Intent(this, ActivityPieChart.class);
        startActivity(intent);
    }

    private void openHorizonatlBarChartActivity() {
        Intent intent = new Intent(this, ActivityHorizontalBarChart.class);
        startActivity(intent);
    }

    private void openBarChartActivity() {
        Intent intent = new Intent(this, ActivityBarChart.class);
        startActivity(intent);
    }

    private void openLineChartActivity() {
        Intent intent = new Intent(this, ActivityLineChart.class);
        startActivity(intent);
    }
}
