package app.validator

import android.os.Build
import android.os.Bundle
import android.widget.TextView
import androidx.fragment.app.testing.launchFragmentInContainer
import androidx.lifecycle.Lifecycle
import androidx.test.core.app.ActivityScenario.launch
import androidx.test.ext.junit.runners.AndroidJUnit4
import dagger.hilt.android.testing.HiltAndroidRule
import dagger.hilt.android.testing.HiltAndroidTest
import dagger.hilt.android.testing.HiltTestApplication
import junit.framework.TestCase
import kotlinx.coroutines.delay
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.jupiter.api.Assertions.*
import org.junit.runner.RunWith
import org.junit.runners.JUnit4
import org.robolectric.Robolectric
import org.robolectric.RobolectricTestRunner
import org.robolectric.annotation.Config

@HiltAndroidTest
@RunWith(RobolectricTestRunner::class)
@Config(
    manifest = Config.NONE,
    sdk = [Build.VERSION_CODES.O_MR1],
    application = HiltTestApplication::class
)
class MainActivityTest {
    lateinit var activity: MainActivity

    @get:Rule
    val hiltAndroidRule = HiltAndroidRule(this)

    @Before
    fun setUp(){
        activity = Robolectric.buildActivity(MainActivity::class.java).create().resume().get()
    }

    @Test
    fun testOpenSecondApp() {
        val result = activity.openSecondApp2()
        assertTrue(result)
    }

    @Test
    fun testOpenSecondApp2() {
        val result = activity.openSecondApp2()
        assertFalse(result)
    }


}

//@HiltAndroidTest
//@RunWith(RobolectricTestRunner::class)
//@Config(
//    manifest = Config.NONE,
//    sdk = [Build.VERSION_CODES.O_MR1],
//    application = HiltTestApplication::class
//)
//class BlankFragmentTest {
//    @get:Rule
//    val hiltAndroidRule = HiltAndroidRule(this)
//    @Test
//    fun testMainActivity() {
//        launchFragmentInHiltContainer<HomeFragment>{
//            assert(this.view?.findViewById<TextView>(R.id.text_main)?.text.toString() == "Title")
//
//        }
//        }
//}