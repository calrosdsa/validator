package app.validator.presentation.screens.setupcamera

import android.hardware.camera2.CameraCharacteristics
import android.util.Size
import javax.annotation.concurrent.Immutable

@Immutable
data class SetUpCameraState(
    val videoCameras:List<CameraInfo> = emptyList()
)

data class CameraInfo(
    val name: String,
    val cameraId: String,
    val size: Size,
    val fps: Int
    )

internal fun lensOrientationString(value: Int) = when (value) {
    CameraCharacteristics.LENS_FACING_BACK -> "Back"
    CameraCharacteristics.LENS_FACING_FRONT -> "Front"
    CameraCharacteristics.LENS_FACING_EXTERNAL -> "External"
    else -> "Unknown"
}