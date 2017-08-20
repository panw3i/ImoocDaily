package com.diabin.imoocdaily;

import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.ListViewCompat;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private List<CostBean> mCostBeanList;
    private DatabaseHelper mDatabaseHelper;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ListView costList = (ListView) findViewById(R.id.lv_main);

        mCostBeanList  = new ArrayList<>();


        // 创建DatabaseHelper对象
        mDatabaseHelper = new DatabaseHelper(this);

        // 初始化一些数据
        initCostData();



        // 适配器
        costList.setAdapter(new CostlistAdapter(MainActivity.this,mCostBeanList));
    }



    private void initCostData() {

        for (int i = 0; i < 50; i++) {
            CostBean c  = new CostBean();
            c.costTitle = "333";
            c.costDate = "3333";
            c.costMoney = "55555555";

            mDatabaseHelper.insertCost(c);

        }

        Cursor cursor = mDatabaseHelper.getAllCostData();

        if (cursor!=null){
            while (cursor.moveToNext()){
                CostBean costBean  = new CostBean();
                costBean.costTitle = cursor.getString(cursor.getColumnIndex("cost_title"));
                costBean.costDate = cursor.getString(cursor.getColumnIndex("cost_date"));
                costBean.costMoney = cursor.getString(cursor.getColumnIndex("cost_money"));

                mCostBeanList.add(costBean);

            }

            cursor.close();
        }

    }
}
