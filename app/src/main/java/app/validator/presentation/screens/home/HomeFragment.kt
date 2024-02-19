package app.validator.presentation.screens.home

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.material3.Button
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.Text
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.platform.ViewCompositionStrategy
import androidx.core.view.ViewCompat
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import app.validator.R
import app.validator.databinding.FragmentComposeBinding
import app.validator.presentation.ui.CaptureTheme
import app.validator.presentation.ui.components.NavigationDrawer
import app.validator.util.Inflate
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

//@AndroidEntryPoint
class HomeFragment: Fragment() {
    //    private val binding: FragmentHomeBinding by Inflate(R.layout.fragment_home)
    private val homeViewModel: HomeViewModel by activityViewModels()
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
        ViewCompat.setTranslationZ(view, 100f)
//        Log.d("DEBUG_APP_FRAG",homeViewModel.getDataString())
        val navController = findNavController()

        binding?.lifecycleOwner = viewLifecycleOwner
        binding?.composeView?.apply {
            setViewCompositionStrategy(ViewCompositionStrategy.DisposeOnViewTreeLifecycleDestroyed)
            setContent {
                val coroutineScope = rememberCoroutineScope()
                val drawerState = rememberDrawerState(initialValue = DrawerValue.Closed)
                CaptureTheme {
                    NavigationDrawer(
                        drawerState = drawerState
                    ) {
                        HomeScreen(
                            openDrawer = {
                                coroutineScope.launch {
                                    drawerState.open()
                                }
                            },
                            navigateToSetUpCamera = {
                                navController.navigate(HomeFragmentDirections.actionHomeFragmentToSetupCameraFragment())
                            }
                        )
                    }
                }
            }
        }
    }
}