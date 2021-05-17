package com.cookandroid.splash_pleazz;

import android.app.DownloadManager;
import android.content.Context;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;

import java.io.IOException;

public class StreamingActivity extends AppCompatActivity {

    private Button btn_play,btn_download,btn_local;
    FirebaseStorage firebaseStorage;
    StorageReference storageReference,ref;
    MediaPlayer mediaPlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.streaming_page);

        btn_play = findViewById(R.id.btn_play);
        btn_download = findViewById(R.id.btn_download);
        btn_local = findViewById(R.id.btn_local);

        btn_play.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                play_Song();
            }
        });

        btn_download.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                download();
            }
        });

        btn_local.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                local();
            }
        });
    }

    public void play_Song(){
        mediaPlayer = new MediaPlayer();
        try {
            mediaPlayer.setDataSource("https://firebasestorage.googleapis.com/v0/b/project-1252226275473945869.appspot.com/o/Audio1.m4a?alt=media&token=7111f393-d7e7-4305-bdc2-b2b2467ccfca");
            mediaPlayer.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
                @Override
                public void onPrepared(MediaPlayer mp) {
                    mp.start();
                }
            });

            mediaPlayer.prepare();
        }catch (IOException e){
            e.printStackTrace();
        }

    }

    public void download(){
        storageReference = firebaseStorage.getInstance().getReference();
        ref = storageReference.child("Audio3.m4a");
        ref.getDownloadUrl().addOnSuccessListener(new OnSuccessListener<Uri>() {
            @Override
            public void onSuccess(Uri uri) {
                String url = uri.toString();
                downloadFiles(StreamingActivity.this,"Audio3","m4a", Environment.DIRECTORY_DOWNLOADS,url);
            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {

            }
        });
    }

    public void local(){
        mediaPlayer = MediaPlayer.create(StreamingActivity.this, Uri.parse("/sdcard/Android/data/com.cookandroid.splash_pleazz/files/Download/Audio3.m4a"));
        mediaPlayer.start();

    }

    public void downloadFiles(Context context, String fileName, String fileExtension, String destinationDirectory, String url){
        DownloadManager downloadManager = (DownloadManager) context.getSystemService(Context.DOWNLOAD_SERVICE);
        Uri uri = Uri.parse(url);
        DownloadManager.Request request = new DownloadManager.Request(uri);
        request.setNotificationVisibility(DownloadManager.Request.VISIBILITY_VISIBLE_NOTIFY_COMPLETED);
        request.setDestinationInExternalFilesDir(context,destinationDirectory,fileName+'.'+fileExtension);
//        request.setDestinationInExternalFilesDir(context,"/doopal_downloads",fileName+fileExtension);
        downloadManager.enqueue(request);
    }
}