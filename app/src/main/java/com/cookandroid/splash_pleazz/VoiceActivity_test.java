package com.cookandroid.splash_pleazz;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;

public class VoiceActivity_test extends AppCompatActivity {

    //firebaseStorage 인스턴스 생성
    //하나의 Storage와 연동되어 있는 경우, getInstance()의 파라미터는 공백으로 두어도 됨
    //하나의 앱이 두개 이상의 Storage와 연동이 되어있 경우, 원하는 저장소의 스킴을 입력
    //getInstance()의 파라미터는 firebase console에서 확인 가능('gs:// ... ')
    FirebaseStorage storage = FirebaseStorage.getInstance("gs://project-1252226275473945869.appspot.com/");

    //생성된 FirebaseStorage를 참조하는 storage 생성
    StorageReference storageRef = storage.getReference();

    //Storage 내부의 images 폴더 안의 image.jpg 파일명을 가리키는 참조 생성
    StorageReference pathReference = storageRef.child("doopal.PNG");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.voice_test);

        FirebaseAuth mAuth = FirebaseAuth.getInstance();

        Button btn_home = (Button)findViewById(R.id.btn_home);
        Button btn_download = (Button)findViewById(R.id.btn_download);

        btn_home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),taxi.class);
                startActivity(intent);
            }
        });
        btn_download.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View v) {
                final long ONE_MEGABYTE = 1024 * 1024;
                pathReference.getBytes(ONE_MEGABYTE).addOnSuccessListener(new OnSuccessListener<byte[]>() {
                    @Override
                    public void onSuccess(byte[] bytes) {
                        // Data for "images/island.jpg" is returns, use this as needed
                    }
                }).addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception exception) {
                        // Handle any errors
                    }

                });
            }
        });

    }

}