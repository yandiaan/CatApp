package id.utdi.catapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import id.utdi.catapp.ui.theme.CatAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            // Theme utama aplikasi
            CatAppTheme {
                // Komponen utama, menempati seluruh layar
                Surface(modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background) {
                    // Memanggil komponen CatScreen
                    CatScreen()
                }
            }
        }
    }
}

@Composable
fun CatScreen(modifier: Modifier = Modifier) {
    // Gambar kucing yang akan ditampilkan
    val firstCat = R.drawable.cat_1
    val secondCat = R.drawable.cat_2
    val thirdCat = R.drawable.cat_3
    val fourthCat = R.drawable.cat_4
    val fifthCat = R.drawable.cat_5

    // State untuk menyimpan data kucing saat ini
    var name by remember { mutableStateOf(R.string.cat_1_name) }
    var type by remember { mutableStateOf(R.string.cat_1_type) }
    var age by remember { mutableStateOf(R.string.cat_1_age) }
    var currentCat by remember { mutableStateOf(firstCat) }

    // Komponen utama, berisi tampilan kucing, informasi, dan tombol navigasi
    Column(
        modifier = modifier
            .fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        // Menampilkan gambar kucing
        CatDisplay(currentCat = currentCat)
        Spacer(modifier = modifier.size(16.dp))
        // Menampilkan informasi kucing
        CatInfo(name = name, type = type, age = age)
        Spacer(modifier = modifier.size(25.dp))
        // Tombol navigasi sebelumnya dan berikutnya
        Row(
            modifier = modifier
                .padding(horizontal = 16.dp)
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(16.dp, Alignment.CenterHorizontally)
        ) {
            // Tombol Sebelumnya
            Button(
                onClick = {
                    // Logika untuk menampilkan kucing sebelumnya
                    when (currentCat) {
                        firstCat -> {
                            currentCat = fifthCat
                            name = R.string.cat_5_name
                            type = R.string.cat_5_type
                            age = R.string.cat_5_age
                        }
                        secondCat -> {
                            currentCat = firstCat
                            name = R.string.cat_1_name
                            type = R.string.cat_1_type
                            age = R.string.cat_1_age
                        }
                        thirdCat -> {
                            currentCat = secondCat
                            name = R.string.cat_2_name
                            type = R.string.cat_2_type
                            age = R.string.cat_2_age
                        }
                        fourthCat -> {
                            currentCat = thirdCat
                            name = R.string.cat_3_name
                            type = R.string.cat_3_type
                            age = R.string.cat_3_age
                        }
                        else -> {
                            currentCat = fourthCat
                            name = R.string.cat_4_name
                            type = R.string.cat_4_type
                            age = R.string.cat_4_age
                        }
                    }
                },
                modifier = Modifier
                    .weight(1f)
                    .height(48.dp)
                    .clip(MaterialTheme.shapes.medium),
                colors = ButtonDefaults.buttonColors(containerColor = colorResource(id = R.color.teal_700)),
                elevation = ButtonDefaults.elevatedButtonElevation(
                    defaultElevation = 4.dp,
                    pressedElevation = 0.dp,
                    focusedElevation = 0.dp
                )
            ) {
                // Teks pada tombol Sebelumnya
                Text(
                    text = "Sebelumnya",
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Medium,
                    color = colorResource(id = R.color.white)
                )
            }

            // Tombol Berikutnya
            Button(
                onClick = {
                    // Logika untuk menampilkan kucing berikutnya
                    when (currentCat) {
                        firstCat -> {
                            currentCat = secondCat
                            name = R.string.cat_2_name
                            type = R.string.cat_2_type
                            age = R.string.cat_2_age
                        }
                        secondCat -> {
                            currentCat = thirdCat
                            name = R.string.cat_3_name
                            type = R.string.cat_3_type
                            age = R.string.cat_3_age
                        }
                        thirdCat -> {
                            currentCat = fourthCat
                            name = R.string.cat_4_name
                            type = R.string.cat_4_type
                            age = R.string.cat_4_age
                        }
                        fourthCat -> {
                            currentCat = fifthCat
                            name = R.string.cat_5_name
                            type = R.string.cat_5_type
                            age = R.string.cat_5_age
                        }
                        else -> {
                            currentCat = firstCat
                            name = R.string.cat_1_name
                            type = R.string.cat_1_type
                            age = R.string.cat_1_age
                        }
                    }
                },
                modifier = Modifier
                    .weight(1f)
                    .height(48.dp)
                    .clip(MaterialTheme.shapes.medium),
                colors = ButtonDefaults.buttonColors(
                    containerColor = colorResource(id = R.color.teal_700)
                ),
                elevation = ButtonDefaults.elevatedButtonElevation(
                    defaultElevation = 4.dp,
                    pressedElevation = 0.dp,
                    focusedElevation = 0.dp
                )
            ) {
                // Teks pada tombol Berikutnya
                Text(
                    text = "Berikutnya",
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Medium,
                    color = colorResource(id = R.color.white)
                )
            }
        }
    }
}

@Composable
fun CatDisplay(
    modifier: Modifier = Modifier,
    @DrawableRes currentCat: Int
) {
    // Menampilkan gambar kucing
    Image(
        painter = painterResource(currentCat),
        contentDescription = stringResource(id = R.string.cat_1_name),
        modifier = modifier.fillMaxWidth(),
        contentScale = ContentScale.FillWidth
    )
}

@Composable
fun CatInfo(
    @StringRes name: Int,
    @StringRes type: Int,
    @StringRes age: Int
) {
    // Menampilkan informasi kucing seperti nama, tipe, dan usia
    Column (
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        // Nama kucing dengan format teks bold
        Text(
            text = stringResource(id = name),
            fontWeight = FontWeight.Bold,
            color = colorResource(id = R.color.teal_200),
            fontSize = 32.sp
        )

        // Tipe kucing dengan format teks medium
        Text(
            text = stringResource(id = type),
            fontSize = 16.sp,
            fontWeight = FontWeight.Medium,
            color = colorResource(id = R.color.purple_500)
        )

        // Usia kucing dengan format teks medium dan menggunakan em dash sebagai pemisah
        Text(
            text = "— ${stringResource(id = age)} —",
            fontSize = 16.sp,
            fontWeight = FontWeight.Medium,
            color = colorResource(id = R.color.purple_500)
        )
    }
}

@Preview(showBackground = true)
@Composable
fun CatPreview() {
    // Menampilkan tampilan preview dengan tema aplikasi
    CatAppTheme {
        // Memanggil komponen CatScreen untuk ditampilkan dalam preview
        CatScreen()
    }
}
