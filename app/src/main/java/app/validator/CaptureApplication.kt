package app.validator

import android.app.Application
import dagger.hilt.android.HiltAndroidApp
import java.io.File

@HiltAndroidApp
class CaptureApplication:Application() {
    companion object {
        var file: File? = null

        fun getCurrentFile(): File?{
            return file
        }

        fun setCurrentFile(f: File) {
            file = f
        }
    }
}