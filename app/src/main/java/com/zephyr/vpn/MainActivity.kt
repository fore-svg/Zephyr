package com.zephyr.vpn

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ZephyrApp()
        }
    }
}

@Composable
fun ZephyrApp() {
    var connected by remember { mutableStateOf(false) }
    var selectedServer by remember { mutableStateOf("Netherlands") }
    var expanded by remember { mutableStateOf(false) }

    val bg = Color(0xFF080D17)
    val panel = Color(0xFF121C2C)
    val blue = Color(0xFF45B6FF)

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(bg)
            .padding(24.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Spacer(modifier = Modifier.height(45.dp))

        Text(
            "ZEPHYR",
            fontSize = 32.sp,
            color = Color.White
        )

        Text(
            "SECURE CONNECTION",
            fontSize = 12.sp,
            color = blue
        )

        Spacer(modifier = Modifier.height(50.dp))

        Box(
            modifier = Modifier
                .size(190.dp)
                .background(panel, RoundedCornerShape(100.dp)),
            contentAlignment = Alignment.Center
        ) {
            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                Text(
                    if (connected) "CONNECTED" else "DISCONNECTED",
                    color = if (connected) Color.Green else Color.LightGray,
                    fontSize = 14.sp
                )

                Spacer(modifier = Modifier.height(12.dp))

                Text(
                    if (connected) "✓" else "⏻",
                    fontSize = 60.sp,
                    color = blue
                )
            }
        }

        Spacer(modifier = Modifier.height(30.dp))

        Button(
            onClick = { connected = !connected },
            colors = ButtonDefaults.buttonColors(
                containerColor = blue
            ),
            modifier = Modifier
                .fillMaxWidth()
                .height(55.dp),
            shape = RoundedCornerShape(15.dp)
        ) {
            Text(
                if (connected) "DISCONNECT" else "CONNECT",
                color = Color.Black
            )
        }

        Spacer(modifier = Modifier.height(35.dp))

        Text("SERVER LOCATION", color = Color.Gray)

        Spacer(modifier = Modifier.height(10.dp))

        Box {
            Button(
                onClick = { expanded = true },
                colors = ButtonDefaults.buttonColors(
                    containerColor = panel
                ),
                modifier = Modifier.fillMaxWidth()
            ) {
                Text(selectedServer, color = Color.White)
                Text("  ▼", color = blue)
            }

            DropdownMenu(
                expanded = expanded,
                onDismissRequest = { expanded = false }
            ) {
                listOf(
                    "Netherlands",
                    "Germany",
                    "France",
                    "Finland"
                ).forEach { server ->
                    DropdownMenuItem(
                        text = { Text(server) },
                        onClick = {
                            selectedServer = server
                            expanded = false
                        }
                    )
                }
            }
        }

        Spacer(modifier = Modifier.weight(1f))

        Text(
            "Zephyr VPN",
            color = Color.Gray,
            fontSize = 12.sp
        )

        Text(
            "Privacy • Security • Freedom",
            color = blue,
            fontSize = 11.sp
        )

        Spacer(modifier = Modifier.height(15.dp))
    }
}
