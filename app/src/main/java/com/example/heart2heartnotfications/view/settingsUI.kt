package com.example.heart2heartnotfications.view

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
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

    Column(modifier = Modifier.fillMaxSize(),Arrangement.Top, Alignment.CenterHorizontally) {
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

    Card(modifier = Modifier.fillMaxWidth().padding(16.dp), shape = RoundedCornerShape(20.dp), border = BorderStroke(1.5.dp,pink), colors = CardDefaults.cardColors(containerColor = Color.White)) {
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