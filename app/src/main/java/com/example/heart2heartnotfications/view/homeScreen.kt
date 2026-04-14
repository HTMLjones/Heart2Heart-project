package com.example.heart2heartnotifications.view

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons

import androidx.compose.material.icons.outlined.FavoriteBorder
import androidx.compose.material.icons.outlined.Person
import androidx.compose.material.icons.outlined.Settings
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.heart2heartnotifications.R
import com.example.heart2heartnotifications.ui.theme.Background
import com.example.heart2heartnotifications.ui.theme.PrimaryPink
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
@Composable
fun HomeScreen(
    name: String,
    onScreen2ButtonClick: () -> Unit,
    onScreen3ButtonClick: () -> Unit,
    onScreen4ButtonClick: () -> Unit,
    onScreen5ButtonClick: () -> Unit
) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Background)
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = 24.dp, vertical = 20.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Spacer(modifier = Modifier.height(90.dp))

            Text(
                text = "Your Heart2Heart",
                color = PrimaryPink,
                fontSize = 30.sp
            )

            Spacer(modifier = Modifier.height(50.dp))

            HeartSection()

            Spacer(modifier = Modifier.height(60.dp))

            StatusSection()

            Spacer(modifier = Modifier.weight(1f))

            BottomNavBar(
                onHeartClick = onScreen2ButtonClick,
                onProfileClick = onScreen3ButtonClick,
                onSettingsClick = onScreen4ButtonClick,
                onContactsClick = onScreen5ButtonClick
            )
        }
    }
}

@Composable
fun HeartSection() {
    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier.size(290.dp)
    ) {
        Image(
            painter = painterResource(id = R.drawable.pink_heart),
            contentDescription = "Heart pendant",
            modifier = Modifier.size(270.dp)
        )
    }
}

@Composable
fun StatusSection() {
    Row(
        verticalAlignment = Alignment.CenterVertically
    ) {
        Box(
            modifier = Modifier
                .size(18.dp)
                .background(Color(0xFF32CD32), CircleShape)
        )

        Spacer(modifier = Modifier.width(12.dp))

        Text(
            text = "Connected | 52%",
            color = PrimaryPink,
            fontSize = 20.sp
        )

        Spacer(modifier = Modifier.width(10.dp))

        Text(
            text = "▱",
            color = PrimaryPink,
            fontSize = 22.sp
        )
    }
}

@Composable
fun BottomNavBar(
    onHeartClick: () -> Unit,
    onProfileClick: () -> Unit,
    onSettingsClick: () -> Unit,
    onContactsClick: () -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .navigationBarsPadding()
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(1.dp)
                .background(Color.Gray.copy(alpha = 0.3f))
        )

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 14.dp),
            horizontalArrangement = Arrangement.SpaceEvenly,
            verticalAlignment = Alignment.CenterVertically
        ) {
            NavItem(
                icon = {
                    Icon(
                        imageVector = Icons.Outlined.FavoriteBorder,
                        contentDescription = "Connect",
                        tint = PrimaryPink,
                        modifier = Modifier.size(34.dp)
                    )
                },
                label = "Connect",
                labelColor = PrimaryPink,
                onClick = onHeartClick
            )

            NavItem(
                icon = {
                    Icon(
                        imageVector = Icons.Outlined.Person,
                        contentDescription = "Profile",
                        tint = Color.Gray,
                        modifier = Modifier.size(34.dp)
                    )
                },
                label = "Profile",
                labelColor = Color.Gray,
                onClick = onProfileClick
            )
            NavItem(
                icon = {
                    Icon(
                        imageVector = ImageVector.vectorResource(id = R.drawable.ic_contacts),
                        contentDescription = "Contacts",
                        tint = Color.Gray,
                        modifier = Modifier.size(34.dp)
                    )
                },
                label = "Contacts",
                labelColor = Color.Gray,
                onClick = onContactsClick
            )
            NavItem(
                icon = {
                    Icon(
                        imageVector = Icons.Outlined.Settings,
                        contentDescription = "Settings",
                        tint = Color.Gray,
                        modifier = Modifier.size(34.dp)
                    )
                },
                label = "Settings",
                labelColor = Color.Gray,
                onClick = onSettingsClick
            )


        }
    }
}

@Composable
fun NavItem(
    icon: @Composable () -> Unit,
    label: String,
    labelColor: Color,
    onClick: () -> Unit
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        IconButton(onClick = onClick) {
            icon()
        }

        Text(
            text = label,
            color = labelColor,
            fontSize = 14.sp
        )
    }
}

@Composable
fun Screen2(onBackButtonClick: () -> Unit) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Background),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(text = "Connect Screen", fontSize = 32.sp)

        Spacer(modifier = Modifier.height(20.dp))

        Button(onClick = onBackButtonClick) {
            Text("Back")
        }
    }
}

@Composable
fun Screen3(onBackButtonClick: () -> Unit) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Background),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(text = "Profile Screen", fontSize = 32.sp)

        Spacer(modifier = Modifier.height(20.dp))

        Button(onClick = onBackButtonClick) {
            Text("Back")
        }
    }
}

@Composable
fun Screen4(onBackButtonClick: () -> Unit) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Background),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(text = "Settings Screen", fontSize = 32.sp)

        Spacer(modifier = Modifier.height(20.dp))

        Button(onClick = onBackButtonClick) {
            Text("Back")
        }
    }
}

@Composable
fun Screen5(onBackButtonClick: () -> Unit) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Background),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(text = "Contacts Screen", fontSize = 32.sp)

        Spacer(modifier = Modifier.height(20.dp))

        Button(onClick = onBackButtonClick) {
            Text("Back")
        }
    }
}