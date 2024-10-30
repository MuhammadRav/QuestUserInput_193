package com.example.minggu4userinput

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Preview(showBackground = true)
@Composable
fun LatihanUserInput(modifier: Modifier = Modifier){
    var nama by remember { mutableStateOf("") }
    var email by remember { mutableStateOf("") }
    var nomorHp by remember { mutableStateOf("") }
    var alamat by remember { mutableStateOf("") }

    var datanama by remember { mutableStateOf("") }
    var dataemail by remember { mutableStateOf("") }
    var datanomorHp by remember { mutableStateOf("") }
    var dataalamat by remember { mutableStateOf("") }

    var jenisK by remember { mutableStateOf("") }
    var datajenisk by remember { mutableStateOf("") }
    val datajk = listOf("Laki-Laki", "Perempuan")



    Column {
        Column (modifier = Modifier.fillMaxSize().padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally) {
            Text(
                "BIODATA",
                fontWeight = FontWeight.Bold,
                fontSize = 28.sp
            )
            Spacer(modifier = Modifier.padding(20.dp))

            TextField(
                value = nama,
                onValueChange = { nama = it },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(5.dp),
                label = { Text("Nama") },
                placeholder = {
                    Text("Masukkan Nama Anda", color = Color.Gray)
                }
            )

            Row {
                datajk.forEach { selectedJK ->
                    Row (verticalAlignment = Alignment.CenterVertically){
                        RadioButton(
                            selected = jenisK == selectedJK,
                            onClick = {
                                jenisK = selectedJK
                            })
                        Text(selectedJK)
                    }
                }
            }
            TextField(
                value = email,
                onValueChange = { email  = it },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(5.dp),
                label = { Text("Email") },
                placeholder = {
                    Text("Masukkan Email Anda", color = Color.Gray)
                },
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email)
            )
            TextField(
                value = nomorHp,
                onValueChange = { nomorHp = it },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(5.dp),
                label = { Text("Nomor Hp") },
                placeholder = {
                    Text("Masukkan Nomor Hp Anda", color = Color.Gray)
                },
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
            )
            TextField(
                value = alamat,
                onValueChange = { alamat = it },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(5.dp),
                label = { Text("Alamat") },
                placeholder = {
                    Text("Masukkan Alamat Anda", color = Color.Gray)
                }
            )
            Button(onClick = {
                datanama = nama
                datajenisk = jenisK
                dataemail = email
                datanomorHp = nomorHp
                dataalamat = alamat}, modifier = Modifier.padding(vertical = 10.dp)) {
                Text("Submit")
            }
            Card(modifier = Modifier.fillMaxSize().padding(16.dp)) {
                Column {
                    TampilData(
                        judul = "Nama",
                        isinya = datanama
                    )
                    TampilData(
                        judul = "Jenis Kelamin",
                        isinya = datajenisk
                    )
                    TampilData(
                        judul = "Email",
                        isinya = dataemail
                    )
                    TampilData(
                        judul = "Nomor Hp",
                        isinya = datanomorHp
                    )
                    TampilData(
                        judul = "Alamat",
                        isinya = dataalamat
                    )
                }
            }
        }
    }
}


@Composable
fun TampilData(
    judul:String,
    isinya:String
){
    Row(modifier = Modifier
        .fillMaxWidth()
        .padding(16.dp),
        horizontalArrangement = Arrangement.SpaceBetween) {
        Text(judul, modifier = Modifier.weight(0.8f))
        Text(":", modifier = Modifier.weight(0.2f))
        Text(isinya,
            modifier = Modifier.weight(2f))
    }
}
