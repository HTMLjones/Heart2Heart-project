package com.example.heart2heartnotfications.view

import android.R.attr.text
import android.widget.Space
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Preview
@Composable
fun settingsTitle() {
    //Pink farve
    val pink = Color(0xFFFF77B7)

    Column(modifier = Modifier.fillMaxWidth(),Arrangement.Top, Alignment.CenterHorizontally) {
        Spacer(Modifier.height(50.dp))
        Text(text = "Settings", fontSize = 34.sp, color=pink)
    }
}
@Preview
@Composable
fun profileSection() {
    //Pink farve
    val pink = Color(0xFFFF77B7)

    //Grå farve
    val gray = Color(0xFF7E7E7E)

    Card(modifier = Modifier.fillMaxWidth().padding(horizontal = 20.dp, vertical = 8.dp), shape = RoundedCornerShape(20.dp), border = BorderStroke(1.5.dp,pink), colors = CardDefaults.cardColors(containerColor = Color.White)) {
        Column(modifier = Modifier.padding(16.dp)) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                Arrangement.SpaceBetween,
                Alignment.CenterVertically
            )
            {
                Text("User", color = gray, fontSize = 14.sp)
                Icon(Icons.Default.Edit, contentDescription = "Edit", tint=Color.Gray)
            }

            ProfileRow(label="First Name", value= "Annette")
            ProfileRow(label = "Last Name", value = "Sørensen")

            Spacer(Modifier.height(8.dp))

        }
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text("Log in", color = Color.Gray, fontSize = 14.sp)
            Icon(Icons.Default.Edit, contentDescription = "Edit", tint = Color.Gray)
        }

        ProfileRow(label = "E-mail", value = "Anette.Sørensen@gmail.com")
        ProfileRow(label = "Phone number", value = "+45 56 78 29 10")
    }

    }



@Composable
fun ProfileRow(label: String, value: String) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 6.dp),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Text(text = label, fontWeight = FontWeight.Bold, fontSize = 15.sp)
        Text(text = value, fontSize = 15.sp)
    }

}



@Preview
@Composable
fun premiumNotification() {
    //Pink farve
    val pink = Color(0xFFFF77B7)

    //Grå farve
    val gray = Color(0xFF7E7E7E)



    Card(modifier = Modifier.fillMaxWidth().padding(horizontal = 20.dp, vertical = 8.dp), shape = RoundedCornerShape(20.dp), border = BorderStroke(1.5.dp, pink), colors = CardDefaults.cardColors(containerColor = Color.White)) {
        Column(modifier = Modifier.padding(16.dp)) {
            Row(modifier = Modifier.fillMaxWidth(),Arrangement.SpaceBetween,Alignment.CenterVertically) {
                Text(text= "Change Notification", color=gray, fontSize = 14.sp)

            }

            Spacer(Modifier.height(12.dp))

            Column(modifier = Modifier.fillMaxWidth(), verticalArrangement = Arrangement.SpaceBetween, horizontalAlignment = Alignment.Start) {
                Message("Level 1", standardText = "Jeg føler mig utryg!")
                Message("Level 2", standardText = "Jeg føler mig forfulgt!")
                Message("Level 3", standardText = "Ring 112!")
            }
        }
    }
}

@Composable
fun Message(label: String, standardText: String) {
    var newText by remember { mutableStateOf(standardText) }
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 9.dp),
            Arrangement.SpaceBetween,
            Alignment.Start
    ) {
        Text(text = label, fontWeight = FontWeight.Bold, fontSize = 15.sp)

        Spacer(Modifier.height(6.dp))

        TextField(
            value = newText,
            onValueChange = { newText = it },
            singleLine = true,
            modifier = Modifier.width(300.dp),
            colors = TextFieldDefaults.colors(
                unfocusedContainerColor = Color(0xFFF0F0F0),
                focusedContainerColor = Color(0xFFFFE8F4),
                focusedIndicatorColor = Color(0xFFF0F0F0),
                unfocusedIndicatorColor = Color.Transparent
            ),
            shape = RoundedCornerShape(100.dp),

        )
    }
}

@Preview
@Composable
fun setup() {
    Column() {
        Spacer(Modifier.height(50.dp))
        settingsTitle()
        Spacer(Modifier.height(16.dp))
        profileSection()
        Spacer(Modifier.height(16.dp))
        premiumNotification()
    }
}