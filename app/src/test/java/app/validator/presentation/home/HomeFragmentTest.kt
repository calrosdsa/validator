package app.validator.presentation.home

import android.os.Build
import android.os.Bundle
import androidx.fragment.app.testing.FragmentScenario
import androidx.fragment.app.testing.launchFragmentInContainer
import app.validator.launchFragmentInHiltContainer
import app.validator.presentation.screens.home.HomeFragment
import dagger.hilt.android.testing.HiltAndroidTest
import dagger.hilt.android.testing.HiltTestApplication
import org.junit.Before
import org.junit.jupiter.api.Assertions.*
import org.junit.runner.RunWith
import org.robolectric.RobolectricTestRunner
import org.robolectric.annotation.Config

@HiltAndroidTest
@RunWith(RobolectricTestRunner::class)
@Config(
    manifest = Config.NONE,
    sdk = [Build.VERSION_CODES.O_MR1],
    application = HiltTestApplication::class
)
internal class HomeFragmentTest{
    private lateinit var scenario: FragmentScenario<HomeFragment>
    @Before
    fun setUp() {
        // Prepare fake data for SearchFragment
        // ...
        // Setup the FragmentScenario and attach any required mock data to it
    }
}