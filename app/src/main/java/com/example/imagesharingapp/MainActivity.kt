package com.example.imagesharingapp

import android.Manifest
import android.content.Intent
import android.content.pm.PackageManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.MediaStore
import android.widget.Button
import android.widget.ImageView
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat

class MainActivity : AppCompatActivity() {
    lateinit var image : ImageView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        if(ContextCompat.checkSelfPermission(applicationContext,Manifest.permission.CAMERA) == PackageManager.PERMISSION_DENIED)
        {
            ActivityCompat.requestPermissions(this, arrayOf(Manifest.permission.CAMERA),100)
        }

        var capture : Button = findViewById(R.id.Capture)
        var share : Button = findViewById(R.id.Share)

        image = findViewById(R.id.imageView)

        capture.setOnClickListener{
            val captureIntent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
            startActivityForResult(captureIntent,111)
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
    }
}