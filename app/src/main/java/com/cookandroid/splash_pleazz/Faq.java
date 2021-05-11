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
        array_Faq.add("Q2) 곽두팔 앱은 어떻게 사용하나요?");
        array_Faq.add("Q3) 코딩 너무 어려워요!!!!");
        array_Faq.add("Q4) 코딩 너무 어려워요!!!!");
        array_Faq.add("Q5) 코딩 너무 어려워요!!!!");
        array_Faq.add("Q6) 코딩 너무 어려워요!!!!");
        array_Faq.add("Q7) 코딩 너무 어려워요!!!!");
        array_Faq.add("Q8) 코딩 너무 어려워요!!!!");
        array_Faq.add("Q9) 코딩 너무 어려워요!!!!");
        array_Faq.add("Q10) 코딩 너무 어려워요!!!!");
        array_Faq.add("Q11) 코딩 너무 어려워요!!!!");
        array_Faq.add("Q12) 코딩 너무 어려워요!!!!");
        array_Faq.add("Q13) 코딩 너무 어려워요!!!!");

        mFaqAdapter = new FaqAdapter(mContext,array_Faq);
        mListView.setAdapter(mFaqAdapter);
    }
}