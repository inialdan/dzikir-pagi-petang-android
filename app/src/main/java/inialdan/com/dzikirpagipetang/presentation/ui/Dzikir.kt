package inialdan.com.dzikirpagipetang.presentation.ui


import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import inialdan.com.dzikirpagipetang.data.remote.DzikirResponseItem

@Composable
fun DzikirListSample(modifier: Modifier = Modifier) {
    val sampleItems = getSampleDzikirItems()
    DzikirList(modifier, sampleItems)
}

@Composable
fun DzikirList(modifier: Modifier = Modifier, data: List<DzikirResponseItem>) {
    Column(
        modifier = modifier
    ) {
        LazyColumn {
            items(data) { data ->
                DzikirListItem(data)
            }
        }
    }
}

@Composable
fun DzikirListItem(data: DzikirResponseItem) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight()
            .padding(vertical = 9.dp, horizontal = 18.dp),
        shape = RoundedCornerShape(21.dp),
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.primary,
        ),
        elevation = CardDefaults.cardElevation(10.dp)
    ) {
        Box(
            modifier = Modifier
                .fillMaxSize()
        ) {
            Column(
                modifier = Modifier
                    .padding(20.dp)
                    .fillMaxWidth()
            ) {
                Spacer(modifier = Modifier.width(8.dp))
                data.arabic?.let {
                    Text(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(top = 5.dp),
                        text = it,
                        style = MaterialTheme.typography.bodyMedium.copy(letterSpacing = 1.sp),
                        lineHeight = 50.sp,
                        fontSize = 30.sp,
                        color = MaterialTheme.colorScheme.onPrimary,
                        textAlign = TextAlign.End,
                    )
                }

                data.latin?.let {
                    Text(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(top = 15.dp),
                        text = it,
                        fontSize = 16.sp,
                        color = MaterialTheme.colorScheme.onPrimary,
                        textAlign = TextAlign.Start,
                        style = TextStyle(fontStyle = FontStyle.Italic)
                    )
                }

                data.translation?.let {
                    val translationText = buildAnnotatedString {
                        withStyle(style = SpanStyle(fontWeight = FontWeight.Bold)) {
                            append("Artinya: ")
                        }
                        append(it)
                        append(" [")
                        withStyle(style = SpanStyle(fontWeight = FontWeight.Bold)) {
                            append(data.read)
                        }
                        append("]")
                    }
                    Text(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(top = 5.dp),
                        text = translationText,
                        style = MaterialTheme.typography.bodyMedium,
                        fontSize = 16.sp,
                        color = MaterialTheme.colorScheme.onPrimary,
                        textAlign = TextAlign.Start,
                    )
                }
                data.benefit?.let {
                    val benefitText = buildAnnotatedString {
                        withStyle(style = SpanStyle(fontWeight = FontWeight.Bold)) {
                            append("Faidah: ")
                        }
                        append(it)
                    }
                    Text(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(top = 5.dp),
                        text = benefitText,
                        style = MaterialTheme.typography.bodyMedium,
                        fontSize = 16.sp,
                        color = MaterialTheme.colorScheme.onPrimary,
                        textAlign = TextAlign.Start,
                    )
                }
                data.source?.let {
                    val sourceText = buildAnnotatedString {
                        withStyle(style = SpanStyle(fontWeight = FontWeight.Bold)) {
                            append("Shahih: ")
                        }
                        append(it)
                    }
                    Text(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(top = 5.dp),
                        text = sourceText,
                        style = MaterialTheme.typography.bodyMedium,
                        fontSize = 16.sp,
                        color = MaterialTheme.colorScheme.onPrimary,
                        textAlign = TextAlign.Start,
                    )
                }
            }
        }
    }
}

fun getSampleDzikirItems(): List<DzikirResponseItem> {
    return listOf(
        DzikirResponseItem(
            id = 1,
            arabic = "اللَّهُ لاَ إِلَهَ إِلاَّ هُوَ الْحَيُّ الْقَيُّومُ ٠ لاَ تَأْخُذُهُ سِنَةٌ وَلاَ نَوْمٌ ٠ لَهُ مَا فِي السَّمَاوَاتِ وَمَا فِي الْأَرْضِ ٠ مَنْ ذَا الَّذِي يَشْفَعُ عِنْدَهُ إِلاَّ بِإِذْنِهِ ٠ يَعْلَمُ مَا بَيْنَ أَيْدِيهِمْ وَمَا خَلْفَهُمْ ٠ وَلَا يُحِيطُونَ بِشَيْءٍ مِنْ عِلْمِهِ إِلاَّ بِمَا شَاءَ ٠ وَسِعَ كُرْسِيُّهُ السَّمَاوَاتِ وَالْأَرْضَ ٠ وَلَا يَئُودُهُ حِفْظُهُمَا ٠ وَهُوَ الْعَلِيُّ الْعَظِيمُ",
            translation = "“Allah, tidak ada ilah (yang berhak disembah) melainkan Dia, yang hidup kekal lagi terus menerus mengurus (makhluk-Nya). Dia tidak mengantuk dan tidak tidur. Kepunyaan-Nya apa yang di langit dan di bumi. Tiada yang dapat memberi syafa’at di sisi-Nya tanpa seizin-Nya. Dia mengetahui apa-apa yang di hadapan mereka dan di belakang mereka. Mereka tidak mengetahui apa-apa dari ilmu Allah melainkan apa yang dikehendaki-Nya. Kursi Allah meliputi langit dan bumi. Dia tidak merasa berat memelihara keduanya. Dan Dia Maha Tinggi lagi Maha besar.” (QS. Al Baqarah: 255)",
            source = "HR. Al Hakim (1: 562)",
            read = "Dibaca 1x",
            benefit = "Siapa yang membacanya ketika petang, maka ia akan dilindungi (oleh Allah dari berbagai gangguan) hingga pagi. Siapa yang membacanya ketika pagi, maka ia akan dilindungi hingga petang. "
        ),
    )
}
