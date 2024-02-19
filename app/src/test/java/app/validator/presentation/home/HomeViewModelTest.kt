package app.validator.presentation.home

import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import androidx.test.ext.junit.runners.AndroidJUnit4
import app.validator.di.AnalyticsService
import app.validator.presentation.screens.home.HomeViewModel
import dagger.hilt.android.AndroidEntryPoint
import dagger.hilt.android.testing.HiltAndroidRule
import dagger.hilt.android.testing.HiltAndroidTest
import dagger.hilt.android.testing.HiltTestApplication
import org.junit.Assert.assertTrue
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.RobolectricTestRunner
import org.robolectric.annotation.Config
import javax.inject.Inject


//@HiltAndroidTest
@HiltAndroidTest
//@RunWith(AndroidJUnit4::class)
@RunWith(RobolectricTestRunner::class)
@Config(
    manifest = Config.NONE,
    sdk = [Build.VERSION_CODES.O_MR1],
    application = HiltTestApplication::class
)
internal class HomeViewModelTest {

    @get:Rule
    val hiltAndroidRule = HiltAndroidRule(this)
    lateinit var homeViewModel: HomeViewModel
    @Inject
    lateinit var analitycService:AnalyticsService

    @Before
    fun setUp(){
        hiltAndroidRule.inject()
        homeViewModel = HomeViewModel(analitycService)
    }

    @Test
    fun testIsActive1() {
//        val viewModel = HomeViewModel(analitycService)
        assertTrue(homeViewModel.isActive())
    }
}