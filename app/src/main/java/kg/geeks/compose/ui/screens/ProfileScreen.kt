package kg.geeks.compose.ui.screens

import android.widget.Toast
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import kg.geeks.compose.R
import kg.geeks.compose.ui.components.EditDialog
import kg.geeks.compose.ui.components.ProfileImage
import kg.geeks.compose.ui.components.ProfileInfoItem


@Composable
fun ProfileScreen() {
    var name by remember { mutableStateOf("Рысбек Жолчуев") }
    var email by remember { mutableStateOf("glavnyi_geroi@example.com") }
    var phone by remember { mutableStateOf("+996 220 08 78 97") }
    var hobbies by remember { mutableStateOf("Футбол, Баскетбол, Волейбол") }

    var showDialog by remember { mutableStateOf(false) }
    var editingField by remember { mutableStateOf("") }
    var editingValue by remember { mutableStateOf("") }

    val context = LocalContext.current

    if (showDialog) {
        EditDialog(
            title = "Редактировать $editingField",
            value = editingValue,
            onValueChange = { editingValue = it },
            onDismiss = { showDialog = false },
            onSave = {
                when (editingField) {
                    "Имя" -> name = editingValue
                    "Email" -> email = editingValue
                    "Телефон" -> phone = editingValue
                    "Хобби" -> hobbies = editingValue
                }
                showDialog = false
                Toast.makeText(context, "$editingField обновлено!", Toast.LENGTH_SHORT).show()
            }
        )
    }

    Column(
        modifier = Modifier.fillMaxSize().padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        ProfileImage(painterResource(R.drawable.gg))

        Spacer(modifier = Modifier.height(16.dp))

        ProfileInfoItem("Имя", name) {
            editingField = "Имя"
            editingValue = name
            showDialog = true
        }
        ProfileInfoItem("Хобби", hobbies) {
            editingField = "Хобби"
            editingValue = hobbies
            showDialog = true
        }

        ProfileInfoItem("Email", email) {
            editingField = "Email"
            editingValue = email
            showDialog = true
        }

        ProfileInfoItem("Телефон", phone) {
            editingField = "Телефон"
            editingValue = phone
            showDialog = true
        }
    }
}