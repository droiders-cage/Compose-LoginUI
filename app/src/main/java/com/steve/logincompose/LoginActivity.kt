package com.steve.logincompose

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
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
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.steve.logincompose.ui.theme.LoginComposeTheme
import com.steve.logincompose.ui.theme.Shapes

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LoginComposeTheme {
                // A surface container using the 'background' color from the theme
                Surface(color = MaterialTheme.colors.background) {
                    LoginScreen(mContext = this@MainActivity)
                }
            }
        }
    }
}



@Composable
fun LoginScreen(mContext: Context){
    Column(modifier = Modifier.padding(16.dp)) {
        HeaderText()
        Spacer(modifier = Modifier.height(120.dp))
        EmailTextField()
        Spacer(modifier = Modifier.height(4.dp))
        PasswordTextField()
        Spacer(modifier = Modifier.height(64.dp))
        ButtonLogin()
        Spacer(modifier = Modifier.height(16.dp))
        ButtonFBLogin()
        Spacer(modifier = Modifier.height(120.dp))
        ButtonRegister(onClick = {
            mContext.startActivity(Intent(mContext, HomeActivity::class.java))
        })

    }
}

@Composable
fun HeaderText() {
    Text(text = "Welcome", fontWeight = FontWeight.Bold, fontSize = 12.sp)
    Text(text = "Sign in to continue", fontWeight = FontWeight.Bold, color = Color.Gray)
}
@Composable
private fun EmailTextField() {
    var email by remember { mutableStateOf("") }

    OutlinedTextField(value = email,
        onValueChange = {email=it},
        label = {Text(text = "Email")},
        modifier = Modifier.fillMaxWidth(),
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email)
    )

}
@Composable
private fun PasswordTextField() {
    var password by remember { mutableStateOf("") }

    OutlinedTextField(value = password,
        onValueChange = {password=it},
        label = {Text(text = "Password")},
        modifier = Modifier.fillMaxWidth(),
        visualTransformation = PasswordVisualTransformation(),
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password)
    )

}
@Composable
private fun ButtonLogin(){
    Button(onClick = { /*TODO*/ },
        modifier = Modifier.fillMaxWidth(),
        contentPadding = PaddingValues(vertical = 16.dp,horizontal = 16.dp)
    ) {

        Text(text = "Login")
    }
}

@Composable
private fun ButtonFBLogin(){
    Button(onClick = { /*TODO*/ },
        modifier = Modifier.fillMaxWidth(),
        contentPadding = PaddingValues(vertical = 16.dp,horizontal = 16.dp),
        elevation = ButtonDefaults.elevation(16.dp),
        colors = ButtonDefaults.buttonColors(backgroundColor = Color.LightGray),
        shape = Shapes.large

    ) {

        Row(verticalAlignment = Alignment.CenterVertically){
            Image(painter = painterResource(id = R.drawable.facebok),
                contentDescription = "")
            Text(text = "Connect to facebook",color= Color.Blue)

        }
    }
}
@Composable
private fun ButtonRegister(onClick: () -> Unit){
    Row(horizontalArrangement = Arrangement.Center,modifier = Modifier.fillMaxWidth()) {

        Text(text = "Don't have an account")
        Text(text = "Sign Up",
            color=MaterialTheme.colors.primary,
            fontWeight = FontWeight.SemiBold,
            modifier = Modifier.clickable (onClick = onClick))

    }

}

@Preview
@Composable
fun PreviewLoginScreen(){
    LoginComposeTheme {

    }
}



