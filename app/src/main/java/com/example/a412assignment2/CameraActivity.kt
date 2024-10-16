package com.example.a412assignment2

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.a412assignment2.ui.theme._412Assignment2Theme
import android.content.Intent
import android.graphics.Bitmap
import android.provider.MediaStore
import android.view.View
import android.widget.Button
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.ui.platform.LocalContext


class CameraActivity : ComponentActivity() {
    // Define the button and imageview type variable
    private lateinit var cameraOpenId: Button
    private lateinit var backButtonId: Button
    lateinit var clickImageId: ImageView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_camera)

        // By ID we can get each component which id is assigned in XML file get Buttons and imageview.
        cameraOpenId = findViewById(R.id.camera_button)
        clickImageId = findViewById(R.id.click_image)
        backButtonId = findViewById(R.id.back_button)

        // Camera_open button is for open the camera and add the setOnClickListener in this button
        cameraOpenId.setOnClickListener(View.OnClickListener { v: View? ->
            // Create the camera_intent ACTION_IMAGE_CAPTURE it will open the camera for capture the image
            val cameraIntent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
            // Start the activity with camera_intent, and request pic id
            startActivityForResult(cameraIntent, pic_id)
        })

        backButtonId.setOnClickListener(View.OnClickListener { v: View? ->
            // Create the camera_intent ACTION_IMAGE_CAPTURE it will open the camera for capture the image
            val cameraIntent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
            val intent = Intent(this@CameraActivity, MainActivity::class.java)
            this@CameraActivity.startActivity(intent)
            // Start the activity with camera_intent, and request pic id

        })

    }

    // This method will help to retrieve the image
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        // Match the request 'pic id with requestCode
        if (requestCode == pic_id) {
            // BitMap is data structure of image file which store the image in memory
            val photo = data!!.extras!!["data"] as Bitmap?
            // Set the image in imageview for display
            clickImageId.setImageBitmap(photo)
        }
    }

    companion object {
        // Define the pic id
        private const val pic_id = 123
    }
}

