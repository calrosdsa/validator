package app.validator.util

import android.content.ContentResolver
import android.content.ContentValues
import android.provider.MediaStore
import java.io.File
import java.io.FileInputStream
import java.io.IOException

object FileSingleton {
    var file: File? = null

    fun getCurrentFile(): File? {
        return file
    }

    fun setCurrentFile(f: File) {
        val n = f
        file = n
    }


    fun addFileToMediaStore(contentResolver: ContentResolver, file: File, mimeType: String) {
//        val path =  "Files/"
        val contentValues = ContentValues().apply {
            put(MediaStore.MediaColumns.DISPLAY_NAME, file.name)
            put(MediaStore.MediaColumns.MIME_TYPE, mimeType)
            put(MediaStore.MediaColumns.SIZE, file.length())
//            put(MediaStore.MediaColumns.RELATIVE_PATH, path)
            // Add other metadata if needed
        }

        try {
//            val videoCollection = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.Q) {
//                MediaStore.Audio.Media.getContentUri(
//                    MediaStore.VOLUME_EXTERNAL_PRIMARY
//                )
//            } else {
//                MediaStore.Audio.Media.EXTERNAL_CONTENT_URI
//            }

//            val videoCollection =  path.toUri()
            val uri = contentResolver.insert(MediaStore.Files.getContentUri("external"), contentValues)
//            val uri = contentResolver.insert(videoCollection, contentValues)

            uri?.let { insertedUri ->
                val outputStream = contentResolver.openOutputStream(insertedUri)
                val inputStream = FileInputStream(file)

                outputStream?.use { os ->
                    inputStream.use { input ->
                        input.copyTo(os)
                    }
                }
            }
        } catch (e: IOException) {
            e.printStackTrace()
        }
    }
}