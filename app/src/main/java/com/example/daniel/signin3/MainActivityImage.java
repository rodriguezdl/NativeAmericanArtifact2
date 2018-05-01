package com.example.daniel.signin3;


import android.app.ProgressDialog;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;
import com.squareup.picasso.Picasso;

import java.util.Objects;


public class MainActivityImage extends AppCompatActivity {
    private StorageReference mStorageRef;
    private Button mSelectImage;
    private static final int GALLERY_INTENT = 2;
    private ProgressDialog mProgressDialog;
    private StorageReference mStorageRef2;
    private Button uploadButton;
    private ImageView mImageView;
    private static final int CAMERA_REQUEST_CODE = 1;
    private ProgressDialog mProgressDialog2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_image);
        mSelectImage = (Button) findViewById(R.id.selectimage);
        mStorageRef = FirebaseStorage.getInstance().getReference();
        mProgressDialog = new ProgressDialog(this);
        uploadButton = (Button) findViewById(R.id.button2);
        mImageView = (ImageView) findViewById(R.id.imageView);
        mProgressDialog2 = new ProgressDialog(this);
        mStorageRef2 = FirebaseStorage.getInstance().getReference();




        uploadButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent2 = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                startActivityForResult(intent2, CAMERA_REQUEST_CODE);
            }
        });

        mSelectImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_PICK);
                intent.setType("image/*");
                startActivityForResult(intent,GALLERY_INTENT);

            }
        });
    }



    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);


        if(resultCode == RESULT_OK){
            if(requestCode == GALLERY_INTENT){
                mProgressDialog.setMessage("Uploading Image");
                mProgressDialog.show();
                Uri uri = data.getData();
                StorageReference fileRef = null;
                if (null != uri) {
                    fileRef = mStorageRef.child("Photos").child(uri.getLastPathSegment());
                }
                if (null != fileRef) {
                    fileRef.putFile(uri).addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
                        @Override
                        public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {
                            //mProgressDialog.dismiss();

                            Uri downloadUri = taskSnapshot.getDownloadUrl();
                            //Picasso.get().load("http://i.imgur.com/DvpvklR.png").into(mImageView);
                            Picasso.get().load(downloadUri).fit().centerCrop().into(mImageView);
                            Toast.makeText(MainActivityImage.this, "Uploaded Image", Toast.LENGTH_LONG).show();
                            mProgressDialog.dismiss();
                        }
                    });
                }
            }

            if(requestCode == CAMERA_REQUEST_CODE){
                mProgressDialog2.setMessage("Uploading the captured Image");
                mProgressDialog2.show();
                Uri uri2 = data.getData();
                StorageReference fileRef2 = mStorageRef2;
                fileRef2.child("Photos2");
                fileRef2.child(Objects.<Uri>requireNonNull(uri2).getLastPathSegment());
                fileRef2.putFile(uri2).addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
                    @Override
                    public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {
                        mProgressDialog2.dismiss();
                        Uri downloadUri = taskSnapshot.getDownloadUrl();
                        //Picasso.get().load("http://i.imgur.com/DvpvklR.png").into(mImageView);
                        Picasso.get().load(downloadUri).fit().centerCrop().into(mImageView);
                        //Picasso.with.(MainActivityImage.this).load(downloadUri).fit().centerCrop().into(mImageView);
                        Toast.makeText(MainActivityImage.this, "Uploaded Image after capture", Toast.LENGTH_LONG).show();
                    }
                });
            }
        }



    }





}
