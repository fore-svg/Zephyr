
package com.zephyr.vpn

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
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

private val bg = Color(0xFF080D17)
private val panel = Color(0xFF121C2C)
private val blue = Color(0xFF45B6FF)

@Composable
fun ZephyrApp() {
    var selectedServer by remember { mutableStateOf("Нидерланды 🇳🇱") }

    MaterialTheme {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(bg)
                .padding(24.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Spacer(Modifier.height(24.dp))

            Text(
                "ZEPHYR",
                fontSize = 30.sp,
                color = Color.White
            )

            Text(
                "VPN  •  FREE",
                color = blue,
                fontSize = 13.sp
            )

            Spacer(Modifier.height(42.dp))

            Text("VPN STATUS", color = Color.Gray)

            Spacer(Modifier.height(10.dp))

            Text(
                "Not connected",
                color = Color.White,
                fontSize = 24.sp
            )

            Spacer(Modifier.height(35.dp))

            Box(
                modifier = Modifier
                    .size(210.dp)
                    .background(Color(0xFF122A43), CircleShape),
                contentAlignment = Alignment.Center
            ) {
                Box(
                    modifier = Modifier
                        .size(170.dp)
                        .background(Color(0xFF183D60), CircleShape),
                    contentAlignment = Alignment.Center
                ) {
                    Text("Z", color = blue, fontSize = 72.sp)
                }
            }

            Spacer(Modifier.height(16.dp))

            Text(
                "VPN tunnel not configured",
                color = Color(0xFFFFC66D),
                fontSize = 12.sp
            )

            Spacer(Modifier.height(35.dp))

            Card(
                colors = CardDefaults.cardColors(
                    containerColor = panel
                ),
                shape = RoundedCornerShape(18.dp),
                modifier = Modifier.fillMaxWidth()
            ) {
                Column(Modifier.padding(18.dp)) {
                    Text(
                        "SERVER LOCATION",
                        color = Color.Gray,
                        fontSize = 12.sp
                    )

                    Spacer(Modifier.height(12.dp))

                    var expanded by remember { mutableStateOf(false) }

                    Box {
                        TextButton(onClick = { expanded = true }) {
                            Text(
                                selectedServer,
                                color = Color.White,
                                fontSize = 18.sp
                            )
                        }

                        DropdownMenu(
                            expanded = expanded,
                            onDismissRequest = { expanded = false }
                        ) {
                            listOf(
                                "Нидерланды 🇳🇱",
                                "Германия 🇩🇪",
                                "Франция 🇫🇷",
                                "Финляндия 🇫🇮"
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
                }
            }

            Spacer(Modifier.height(20.dp))

            Card(
                colors = CardDefaults.cardColors(
                    containerColor = panel
                ),
                shape = RoundedCornerShape(18.dp),
                modifier = Modifier.fillMaxWidth()
            ) {
                Column(Modifier.padding(18.dp)) {
                    Text("CONNECTION", color = Color.Gray, fontSize = 12.sp)
                    Spacer(Modifier.height(6.dp))
                    Text("No active tunnel", color = Color.White)
                }
            }

            Spacer(Modifier.weight(1f))

            Text(
                "ZEPHYR VPN  •  VERSION 1.0",
                color = Color.Gray,
                fontSize = 11.sp
            )
        }
    }
}
