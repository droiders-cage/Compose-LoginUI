package com.steve.logincompose

import android.content.Context
import android.net.Uri
import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.bumptech.glide.Glide
import com.steve.logincompose.ui.theme.Shapes
import com.steve.logincompose.ui.theme.LoginComposeTheme




class RegisterActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LoginComposeTheme{
                Surface(color = MaterialTheme.colors.background) {
                    RegisterScreen(mContext = this@RegisterActivity)
//                    PhotoSelector()
                }
            }
        }
    }

}

@Composable
fun RegisterScreen(mContext: Context) {
    Column(modifier = Modifier.padding(16.dp)) {
        HeadRegisterText()
//      Spacer(modifier = Modifier.height(34.dp))
        Spacer(modifier = Modifier.height(64.dp))
        UsernameTextField()
        Spacer(modifier = Modifier.height(4.dp))
        EmailTextField()
        Spacer(modifier = Modifier.height(4.dp))
        PasswordTextField()
        Spacer(modifier = Modifier.height(64.dp))
        ButtonToRegister()
        Spacer(modifier = Modifier.height(16.dp))
        ButtonFBRegister()
        Spacer(modifier = Modifier.height(40.dp))
        ButtonToLogin(onClick = {
            mContext.startActivity(android.content.Intent(mContext, MainActivity::class.java))
        })
    }
}




@Composable
private fun HeadRegisterText() {
    Text(
        text = "Create Account",
        fontWeight = FontWeight.Bold,
        fontSize = 32.sp,
    )
    androidx.compose.material.Text(
        text = "Sign in to get started",
        fontWeight = FontWeight.Bold,
        color = Color.Gray
    )
}
@Composable
private fun UsernameTextField() {
    var username by remember { androidx.compose.runtime.mutableStateOf("") }

    OutlinedTextField(
        value = username,
        onValueChange = { username = it },
        label = { androidx.compose.material.Text(text = "Username") },
        modifier = Modifier.fillMaxWidth()
    )

}
@Composable
private fun EmailTextField() {
    var email by remember { androidx.compose.runtime.mutableStateOf("") }

    OutlinedTextField(
        value = email,
        onValueChange = { email = it },
        label = { androidx.compose.material.Text(text = "Email") },
        modifier = Modifier.fillMaxWidth(),
        visualTransformation = PasswordVisualTransformation(),
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email)
    )

}
@Composable
private fun PasswordTextField() {
    var password by remember { androidx.compose.runtime.mutableStateOf("") }
    OutlinedTextField(
        value = password,
        onValueChange = { password = it },
        label = { androidx.compose.material.Text(text = "Password") },
        modifier = Modifier.fillMaxWidth(),
        visualTransformation = PasswordVisualTransformation(),
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password)
    )

}
@Composable
private fun ButtonToRegister(){
    androidx.compose.material.Button(
        onClick = { /*TODO*/ },
        modifier = Modifier.fillMaxWidth(),
        contentPadding = PaddingValues(
            vertical = 16.dp,
            horizontal = 16.dp
        )
    ) {

        androidx.compose.material.Text(text = "Register")
    }
}

@Composable
private fun ButtonFBRegister(){
    androidx.compose.material.Button(
        onClick = { /*TODO*/ },
        modifier = Modifier.fillMaxWidth(),
        contentPadding = PaddingValues(
            vertical = 16.dp,
            horizontal = 16.dp
        ),
        elevation = ButtonDefaults.elevation(16.dp),
        colors = ButtonDefaults.buttonColors(backgroundColor = Color.LightGray),
        shape = Shapes.large
    ) {

        Row(verticalAlignment = androidx.compose.ui.Alignment.CenterVertically) {
            androidx.compose.foundation.Image(
                painter = painterResource(id = R.drawable.facebok),
                contentDescription = ""
            )
            androidx.compose.material.Text(
                text = "Connect to facebook",
                color = Color.Blue
            )

        }
    }
}
@Composable
private fun ButtonToLogin(onClick: () -> Unit){
    androidx.compose.foundation.layout.Row(
        horizontalArrangement = Arrangement.Center,
        modifier = Modifier.fillMaxWidth()
    ) {

        androidx.compose.material.Text(text = "Don't have an account")
        androidx.compose.material.Text(
            text = "Sign Up",
            color = MaterialTheme.colors.primary,
            fontWeight = FontWeight.SemiBold,
            modifier = Modifier.clickable(onClick = onClick)
        )

    }

}



