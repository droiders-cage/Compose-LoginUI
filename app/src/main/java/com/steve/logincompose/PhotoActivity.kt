package com.steve.logincompose

import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.steve.logincompose.ui.theme.LoginComposeTheme

class PhotoActivity : AppCompatActivity() {
    private var imageUriState= mutableStateOf<Uri?>(null)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LoginComposeTheme{
                Surface(color = MaterialTheme.colors.background) {
                    RegisterScreen(mContext = this@PhotoActivity)
                    PhotoSelector()
                }
            }
        }

    }
    private val selectImageLauncher=registerForActivityResult(ActivityResultContracts.GetContent()){ uri->
        imageUriState.value=uri

    }

    @Composable
    fun PhotoSelector() {
        Box(contentAlignment = Alignment.Center,modifier = Modifier
            .height(20.dp)
            .width(30.dp)) {
            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                if (imageUriState.value !=null){

//                    GlideImage(data=imageUriState.value)

                }
                Button(onClick = { selectImageLauncher.launch("image/*")},
                    modifier = Modifier.padding(vertical = 8.dp)) {

                    Text(text = "Open Gallery")

                }

            }

        }


    }

}