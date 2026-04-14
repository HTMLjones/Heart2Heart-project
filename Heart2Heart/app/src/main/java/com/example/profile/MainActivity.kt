package com.example.profile

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.*

/* ---------- DATA ---------- */

data class Profile(
    val name: String,
    val imageRes: Int
)

val profiles = listOf(
    Profile("Søren", R.drawable.soren),
    Profile("Tobias", R.drawable.tobias),
    Profile("Emma", R.drawable.emma)
)


/* ---------- MAIN ---------- */

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            val navController = rememberNavController()

            NavHost(navController = navController, startDestination = "home") {

                composable("home") {
                    HomeScreen {
                        navController.navigate("profile/Søren")
                    }
                }

                composable("profile/{name}") { backStackEntry ->
                    val name = backStackEntry.arguments?.getString("name") ?: "Søren"

                    ProfileScreen(
                        name = name,
                        navController = navController,
                        goBack = { navController.popBackStack() }
                    )
                }

                composable("connect") {
                    Box(
                        modifier = Modifier.fillMaxSize(),
                        contentAlignment = Alignment.Center
                    ) {
                        Text("Connect Screen")
                    }
                }
            }
        }
    }
}







/* -------------------------------------------- HOME skærm ------------------------------------------------------ */

@Composable
fun HomeScreen(goToProfile: () -> Unit) {
    Box(Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
        Button(onClick = goToProfile) {
            Text("Go to profile")
        }
    }
}











/* ---------------------------------------- PROFILE SCREEN -------------------------------------------------- */

@Composable
fun ProfileScreen(
    name: String,
    navController: NavController,
    goBack: () -> Unit
) {
    val currentProfile = profiles.find { it.name == name } ?: profiles[0]
    var expanded by remember { mutableStateOf(false) }
    var showDialog by remember { mutableStateOf(false) }
    var selectedProfiles by remember { mutableStateOf(setOf<String>()) }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
    ) {

        // -------------------------------------Dropdown knap
        Box(
            modifier = Modifier
                .align(Alignment.TopCenter)
                .padding(top = 14.dp)
        ) {
            Button(
                onClick = { expanded = true },
                shape = RoundedCornerShape(30.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = Pink,
                    contentColor = White
                )
            ) {
                Text(currentProfile.name)
                Icon(Icons.Default.ArrowDropDown, contentDescription = null)
            }

            DropdownMenu(
                expanded = expanded,
                onDismissRequest = { expanded = false }
            ) {
                profiles.forEach {
                    DropdownMenuItem(
                        text = { Text(it.name) },
                        onClick = {
                            expanded = false
                            navController.navigate("profile/${it.name}")
                        }
                    )
                }
            }
            // -------------------------Send hearbeat og location
            if (showDialog) {

                val otherProfiles = profiles.filter { it.name != currentProfile.name }

                AlertDialog(
                    onDismissRequest = { showDialog = false },

                    title = {
                        Text("Vælg modtagere")
                    },

                    text = {
                        Column {
                            otherProfiles.forEach { profile ->

                                Row(
                                    verticalAlignment = Alignment.CenterVertically
                                ) {

                                    Checkbox(
                                        checked = selectedProfiles.contains(profile.name),
                                        onCheckedChange = { checked ->
                                            selectedProfiles = if (checked) {
                                                selectedProfiles + profile.name
                                            } else {
                                                selectedProfiles - profile.name
                                            }
                                        }
                                    )

                                    Text(profile.name)
                                }
                            }
                        }
                    },

                    confirmButton = {
                        Button(
                            onClick = {
                                showDialog = false

                                println("Sender til: $selectedProfiles")
                            }
                        ) {
                            Text("Send")
                        }
                    },

                    dismissButton = {
                        Button(
                            onClick = { showDialog = false }
                        ) {
                            Text("Annuller")
                        }
                    }
                )
            }
        }

        // -----------------------------------Back knap
        Button(
            onClick = goBack,
            shape = RoundedCornerShape(30.dp),
            colors = ButtonDefaults.buttonColors(
                containerColor = Pink,
                contentColor = White
            ),
            modifier = Modifier
                .align(Alignment.TopStart)
                .padding(14.dp)
        ) {
            Text("Back")
        }

        // ---------------------------Midterste indhold
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .align(Alignment.TopCenter)
                .padding(top = 200.dp),
            verticalArrangement = Arrangement.spacedBy(24.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            Image(
                painter = painterResource(currentProfile.imageRes),
                contentDescription = null,
                modifier = Modifier
                    .size(250.dp)
                    .clip(CircleShape),
                contentScale = ContentScale.Crop
            )

            Text("${currentProfile.name} Kofoed", fontSize = 20.sp, color = Black)

            Button(
                onClick = { showDialog = true },
                colors = ButtonDefaults.buttonColors(
                    containerColor = Pink,
                    contentColor = White
                ),
                modifier = Modifier
                    .fillMaxWidth(0.8f)
                    .height(60.dp)
            ) {
                Text("Send heartbeat")
            }

            Button(
                onClick = { showDialog = true },
                colors = ButtonDefaults.buttonColors(
                    containerColor = Pink,
                    contentColor = White
                ),
                modifier = Modifier
                    .fillMaxWidth(0.8f)
                    .height(60.dp)
            ) {
                Text("Request location")
            }
        }

        //----------------------------------- Navbar
        BottomNavBarSimple(
            navController = navController,
            modifier = Modifier.align(Alignment.BottomCenter)
        )
    }
}







/* --------------------------------------------------- NAVBAR ------------------------------------------------ */

@Composable
fun BottomNavBarSimple(
    navController: NavController,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
            .fillMaxWidth()
            .background(Color.White)
    ) {

        Divider(color = Color.Black, thickness = 1.dp)

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .height(56.dp),
            horizontalArrangement = Arrangement.SpaceEvenly,
            verticalAlignment = Alignment.CenterVertically
        ) {

            Image(
                painter = painterResource(R.drawable.vector1),
                contentDescription = "Connect",
                modifier = Modifier
                    .size(24.dp)
                    .clickable {
                        navController.navigate("connect")
                    }
            )

            Image(
                painter = painterResource(R.drawable.home),
                contentDescription = "Home",
                modifier = Modifier
                    .size(24.dp)
                    .clickable {
                        navController.navigate("home") {
                            popUpTo("home") { inclusive = true }
                        }
                    }
            )

            Image(
                painter = painterResource(R.drawable.contacts),
                contentDescription = "Profile",
                modifier = Modifier
                    .size(24.dp)
                    .clickable {
                        navController.navigate("profile/Søren")
                    }
            )
        }
    }
}
