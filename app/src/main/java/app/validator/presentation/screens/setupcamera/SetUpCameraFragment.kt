package app.validator.presentation.screens.setupcamera

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.platform.ViewCompositionStrategy
import androidx.core.view.ViewCompat
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import app.validator.databinding.FragmentComposeBinding
import app.validator.presentation.screens.home.HomeScreen
import app.validator.presentation.ui.CaptureTheme
import app.validator.presentation.ui.components.NavigationDrawer
import kotlinx.coroutines.launch

class SetUpCameraFragment:Fragment() {
    private var binding: FragmentComposeBinding? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
//        Log.d("DEBUG_APP_FRAG",homeViewModel.getDataString())

//        val binding: FragmentHomeBinding? = activity?.let { DataBindingUtil.setContentView(it,R.layout.fragment_home) }
        binding = FragmentComposeBinding.inflate(inflater, container, false)
        return binding!!.root
        // Here we go -- the profile resource is shown to the UI
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
//        ViewCompat.setTranslationZ(view, 100f)
//        Log.d("DEBUG_APP_FRAG",homeViewModel.getDataString())
        val navController = findNavController()

        binding?.lifecycleOwner = viewLifecycleOwner
        binding?.composeView?.apply {
            setViewCompositionStrategy(ViewCompositionStrategy.DisposeOnViewTreeLifecycleDestroyed)
            setContent {
                CaptureTheme {
                    SetUpCameraScreen()
                }
            }
        }
    }

}