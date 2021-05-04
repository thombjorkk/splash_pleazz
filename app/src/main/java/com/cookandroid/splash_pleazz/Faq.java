package com.cookandroid.splash_pleazz;

import android.content.Context;
import android.os.Bundle;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class Faq extends AppCompatActivity {

    private Context mContext;
    private ListView mListView;
    private ArrayList<String> array_Faq;
    private FaqAdapter mFaqAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_faq);
        this.mContext = getApplicationContext();

        mListView = (ListView)findViewById(R.id.btn_faq);

        array_Faq = new ArrayList<>();
        array_Faq.add("Q1) 곽두팔 앱에 대해서 알려주세요");
        array_Faq.add("Q2");
        array_Faq.add("Q3");
        array_Faq.add("Q4");
        array_Faq.add("Q5");
        array_Faq.add("Q6");
        array_Faq.add("Q7");
        array_Faq.add("Q8");
        array_Faq.add("Q9");
        array_Faq.add("Q10");
        array_Faq.add("Q11");
        array_Faq.add("Q12");
        array_Faq.add("Q13");

        mFaqAdapter = new FaqAdapter(mContext,array_Faq);
        mListView.setAdapter(mFaqAdapter);
    }
}