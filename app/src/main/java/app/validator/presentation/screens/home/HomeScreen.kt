package app.validator.presentation.screens.home

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowColumn
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import app.validator.R
import app.validator.presentation.ui.components.util.CustomTopBar

@OptIn(ExperimentalMaterial3Api::class)
@Composable
internal fun HomeScreen(
    openDrawer:()->Unit,
    navigateToSetUpCamera :()->Unit,
) {
    Scaffold(
        topBar = {
            CustomTopBar(
                actions = {
                    IconButton(onClick = { openDrawer() }) {
                        Icon(
                            painter = painterResource(id = R.drawable.baseline_menu_24),
                            contentDescription = stringResource(id = R.string.menu)
                        )
                    }
                },
                title = {
                    Text(text = stringResource(id = R.string.capture))
                })
        }
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = 10.dp)
                .padding(paddingValues)
        ) {


            Card(
                onClick = { navigateToSetUpCamera() },
                modifier = Modifier.fillMaxWidth(0.5f)
            ) {
                Column(
                    modifier = Modifier.padding(horizontal = 10.dp,vertical = 15.dp).fillMaxWidth(),
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Image(painter = painterResource(id = R.drawable.baseline_camera_alt_24),
                        contentDescription = stringResource(id = R.string.record_video))
                    Text(
                        text = stringResource(id = R.string.record_video),
                        style = MaterialTheme.typography.titleMedium
                    )
                }
            }
        }
    }
}