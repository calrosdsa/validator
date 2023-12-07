package app.validator.presentation.block

import android.os.Bundle
import android.view.View
import androidx.core.view.ViewCompat
import androidx.fragment.app.Fragment
import app.validator.R

class TestFragment:Fragment(R.layout.fragment_test) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        ViewCompat.setTranslationZ(view,100f)

    }
}