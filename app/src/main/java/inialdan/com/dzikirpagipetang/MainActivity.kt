package inialdan.com.dzikirpagipetang

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.content.ContextCompat.startActivity
import inialdan.com.dzikirpagipetang.presentation.ui.CustomToolbar
import inialdan.com.dzikirpagipetang.ui.theme.AppTheme

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            AppTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                ) {
                    MainScreen()
                }
            }
        }
    }
}


@Preview(showSystemUi = true, showBackground = true)
@Composable
fun GreetingPreview() {
    AppTheme {
        Surface(
            modifier = Modifier.fillMaxSize(),
        ) {
            MainScreen()
        }
    }
}

@Composable
fun MainScreen() {
    Scaffold(
        topBar = { CustomToolbar(stringResource(id = R.string.app_name)) }
    ) { paddingValues ->
        CardColumn(
            modifier = Modifier
                .padding(paddingValues)
                .padding(vertical = 8.dp, horizontal = 18.dp)
        )
    }
}

@Composable
fun CardColumn(modifier: Modifier = Modifier) {
    val context = LocalContext.current

    Column(
        modifier = modifier
    ) {
        CustomCard(
            title = stringResource(id = R.string.dzikir_sholat),
            content = stringResource(id = R.string.dzikir_sholat_total_read),
            background = R.drawable.ic_pray_vector,
        ) {
            val intent = Intent(context, DzikirSholatActivity::class.java)
            startActivity(context, intent, null)
        }
        CustomCard(
            title = stringResource(id = R.string.dzikir_pagi),
            content = stringResource(id = R.string.dzikir_pagi_total_read),
            background = R.drawable.ic_sunrise,
        ) {
            val intent = Intent(context, DzikirPagiActivity::class.java)
            startActivity(context, intent, null)
        }
        CustomCard(
            title = stringResource(id = R.string.dzikir_petang),
            content = stringResource(id = R.string.dzikir_petang_total_read),
            background = R.drawable.ic_sunset,
        ) {
            val intent = Intent(context, DzikirPetangActivity::class.java)
            startActivity(context, intent, null)
        }
    }
}

@Composable
fun CustomCard(title: String, content: String, @DrawableRes background: Int, onClick: () -> Unit) {
    Card(
        modifier = Modifier
            .padding(vertical = 8.dp)
            .fillMaxWidth()
            .height(200.dp)
            .clickable(onClick = onClick),
        colors = CardDefaults.cardColors(containerColor = Color.Transparent),
        elevation = CardDefaults.cardElevation(12.dp)
    ) {
        Box(
            modifier = Modifier
                .fillMaxSize()
        ) {
            Image(
                painter = painterResource(id = background),
                contentDescription = null,
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .matchParentSize()
                    .clip(RoundedCornerShape(18.dp))
            )
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(18.dp)
            ) {
                Text(
                    text = title,
                    fontSize = 24.sp,
                    style = MaterialTheme.typography.titleMedium,
                    color = Color.White
                )
                Text(
                    text = content,
                    style = MaterialTheme.typography.bodyMedium,
                    fontSize = 18.sp,
                    color = Color.White
                )
            }
        }
    }
}