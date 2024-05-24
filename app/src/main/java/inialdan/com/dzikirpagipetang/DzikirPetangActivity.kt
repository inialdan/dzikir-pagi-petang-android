package inialdan.com.dzikirpagipetang

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import inialdan.com.dzikirpagipetang.data.api.KtorApiClient
import inialdan.com.dzikirpagipetang.data.repository.DzikirPetangRepository
import inialdan.com.dzikirpagipetang.presentation.ui.CustomToolbar
import inialdan.com.dzikirpagipetang.presentation.ui.DzikirList
import inialdan.com.dzikirpagipetang.presentation.ui.DzikirListSample
import inialdan.com.dzikirpagipetang.presentation.viewmodel.DzikirPetangViewModel
import inialdan.com.dzikirpagipetang.presentation.viewmodel.DzikirPetangViewModelFactory
import inialdan.com.dzikirpagipetang.ui.theme.AppTheme

class DzikirPetangActivity : ComponentActivity() {

    private val dzikirPetangViewModel: DzikirPetangViewModel by viewModels {
        DzikirPetangViewModelFactory(DzikirPetangRepository(KtorApiClient()))
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            AppTheme {
            Scaffold(
                topBar = { CustomToolbar(stringResource(id = R.string.dzikir_petang)) }
            ) { paddingValues ->
                val data by dzikirPetangViewModel.dzikirPetang.collectAsState()
                val isLoading by dzikirPetangViewModel.isLoading.collectAsState()
                if (isLoading) {
                    Box(
                        modifier = Modifier.fillMaxSize(),
                        contentAlignment = Alignment.Center
                    ) {
                        CircularProgressIndicator(
                            modifier = Modifier.size(48.dp)
                        )
                    }
                } else {
                    DzikirList(
                        modifier = Modifier
                            .padding(paddingValues),
                        data
                    )
                }
            }
                }
        }
    }
}

@Preview(showSystemUi = true, showBackground = true)
@Composable
fun PreviewDzikirPetang() {
    AppTheme {
        Scaffold(
            topBar = { CustomToolbar(stringResource(id = R.string.dzikir_petang)) }
        ) { paddingValues ->
            DzikirListSample(
                modifier = Modifier
                    .padding(paddingValues)
            )
        }
    }
}