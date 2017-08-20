package com.diabin.imoocdaily;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.ListViewCompat;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private List<CostBean> mCostBeanList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ListView costList = (ListView) findViewById(R.id.lv_main);

        initCostData();

        costList.setAdapter(new CostlistAdapter(MainActivity.this,mCostBeanList));
    }



    private void initCostData() {

        for (int i = 0; i < 5; i++) {
            CostBean c  = new CostBean();
            c.costTitle = "222";
            c.costDate = "222";
            c.costMoney = "222";
            mCostBeanList.add(c);
        }

    }
}
