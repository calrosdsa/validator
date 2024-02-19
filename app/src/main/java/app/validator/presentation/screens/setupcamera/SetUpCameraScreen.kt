package app.validator.presentation.screens.setupcamera

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import app.validator.presentation.ui.components.util.CustomTopBar
import app.validator.R;

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SetUpCameraScreen() {
    Scaffold(
        modifier = Modifier.fillMaxSize(),
        topBar = { CustomTopBar(
            title = {
                Text(text = stringResource(id = R.string.set_up_camera))
            }
        )}
    ) { paddingValues ->
        Column(modifier = Modifier
            .padding(paddingValues)
            .padding(horizontal = 10.dp)) {
            Text(text = "Setup camera")
        }
    }
}