package app.validator.presentation.home

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.ViewCompat
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import app.validator.R
import app.validator.databinding.FragmentHomeBinding
import app.validator.util.Inflate
import dagger.hilt.android.AndroidEntryPoint

//@AndroidEntryPoint
class HomeFragment: Fragment() {
//    private val binding: FragmentHomeBinding by Inflate(R.layout.fragment_home)
    private val homeViewModel:HomeViewModel by activityViewModels()
    private var binding: FragmentHomeBinding? = null


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
//        Log.d("DEBUG_APP_FRAG",homeViewModel.getDataString())

//        val binding: FragmentHomeBinding? = activity?.let { DataBindingUtil.setContentView(it,R.layout.fragment_home) }
        binding = FragmentHomeBinding.inflate(inflater, container, false)
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