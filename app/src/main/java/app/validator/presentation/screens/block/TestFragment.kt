package app.validator.presentation.screens.block

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.ViewCompat
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import app.validator.R
import app.validator.databinding.FragmentTestBinding
import app.validator.presentation.screens.home.HomeViewModel

class TestFragment:Fragment(R.layout.fragment_test) {
    private val homeViewModel: HomeViewModel by activityViewModels()
    private var binding: FragmentTestBinding? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
//        Log.d("DEBUG_APP_FRAG",homeViewModel.getDataString())

//        val binding: FragmentHomeBinding? = activity?.let { DataBindingUtil.setContentView(it,R.layout.fragment_home) }
        binding = FragmentTestBinding.inflate(inflater, container, false)
        return binding!!.root
        // Here we go -- the profile resource is shown to the UI
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        ViewCompat.setTranslationZ(view,100f)
//        Log.d("DEBUG_APP_FRAG",homeViewModel.getDataString())
        val navController = findNavController()

        binding?.lifecycleOwner = viewLifecycleOwner
        binding?.viewModel = homeViewModel
        binding?.buttonMain?.setOnClickListener {
            navController.navigate(R.id.action_homeFragment_to_testFragment)
        }
        binding?.textMain?.text = "dmaskmd aksmd kasm dksa"
    }
}