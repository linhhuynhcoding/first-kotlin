import android.provider.CalendarContract.Colors
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.input.TextFieldLineLimits
import androidx.compose.foundation.text.input.rememberTextFieldState
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.automirrored.filled.List
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.LocalTextStyle
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldColors
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.myapplication.Avatar
import com.example.myapplication.Profile

@Preview(showBackground = true)
@Composable
fun TH2Screen() {
    val names = listOf("Linh", "Jack", "Thiên An", "Sol");
    var text by remember { mutableStateOf("") }
    var error by remember { mutableStateOf("") }


    Scaffold(
        modifier = Modifier.fillMaxSize(),
        containerColor = Color.White,

        ) { innerPadding ->
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding),
            contentAlignment = Alignment.Center
        ) {
            Column(
                modifier = Modifier
//                .fillMaxSize()
                    .padding(innerPadding)
                    .width(240.dp),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.spacedBy(
                    12.dp,
                    alignment = Alignment.CenterVertically
                ),
            ) {
                Text(
                    text = "Thực hành 2",
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Bold,
                )
                TextField(
                    value = text,
                    onValueChange = { newText ->
                        text = newText
                    },
                    modifier = Modifier
                        .clip(shape = RoundedCornerShape(percent = 25))
                        .background(color = Color.White)
                        .fillMaxWidth()
                        .border(
                            width = 0.5.dp,
                            color = Color.Gray,
                            shape = RoundedCornerShape(percent = 25)
                        ),
                    textStyle = LocalTextStyle.current.copy(
                        fontSize = 12.sp,
                        fontWeight = FontWeight.Medium
                    ),
                    placeholder = { Text(text = "Điền Email", color = Color.Gray) },
                    colors = TextFieldDefaults.colors(
                        focusedIndicatorColor = Color.Blue,
                        unfocusedIndicatorColor = Color.White,
                        disabledIndicatorColor = Color.LightGray,
                        focusedContainerColor = Color.Transparent,
                        unfocusedContainerColor = Color.Transparent,
                        disabledContainerColor = Color.Transparent,
                    ),
                )
                if (error != "") {
                    Text(
                        text = error,
                        fontSize = 14.sp,
                        color = Color.Red
                    )
                }
                Button(
                    modifier = Modifier.width(300.dp),
                    shape = RoundedCornerShape(percent = 25),
                    onClick = {
                        error = ""
                        if (text == "") {
                            error = "Email không hợp lệ"

                        }
                        else if (!text.contains('@')) {
                            error = "Email không đúng định dạng"
                        }
                    },
                ) {
                    Text("Kiểm tra")
                }
            }
        }

    }
}
