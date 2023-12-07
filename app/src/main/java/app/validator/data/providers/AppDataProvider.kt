package app.validator.data.providers

import android.content.Context
import android.content.Intent
import android.content.pm.PackageManager
import android.content.pm.ResolveInfo
import android.graphics.drawable.Drawable
import android.os.Build
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import java.util.ArrayList
import javax.inject.Inject


class AppDataProvider @Inject constructor(
    @ApplicationContext private val context:Context,
){
    fun testFunction():String{
        return "TEST DATA"
    }

    @Suppress("DEPRECATION")
    fun fetchInstalledAppList():Flow<List<AppData>>{
        return flow {
            val mainIntent = Intent(Intent.ACTION_MAIN, null)
            mainIntent.addCategory(Intent.CATEGORY_LAUNCHER)
            if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU){
            val resolveInfoList: List<ResolveInfo> = context.packageManager.queryIntentActivities(mainIntent, PackageManager.ResolveInfoFlags.of(0))
                val appDataList: ArrayList<AppData> = arrayListOf()
                resolveInfoList.forEach { resolveInfo ->
                    with(resolveInfo) {
                        if (activityInfo.packageName != context.packageName) {
                            val mainActivityName = activityInfo.name.substring(activityInfo.name.lastIndexOf(".") + 1)
                            val appData = AppData(
                                appName = loadLabel(context.packageManager) as String,
                                packageName = "${activityInfo.packageName}/$mainActivityName",
                                appIconDrawable = loadIcon(context.packageManager)
                            )
                            appDataList.add(appData)
                        }
                    }
                }
                emit(appDataList)
            }else{
                val resolveInfoList: List<ResolveInfo> = context.packageManager.queryIntentActivities(mainIntent, 0)
                val appDataList: ArrayList<AppData> = arrayListOf()
                resolveInfoList.forEach { resolveInfo ->
                    with(resolveInfo) {
                        if (activityInfo.packageName != context.packageName) {
                            val mainActivityName = activityInfo.name.substring(activityInfo.name.lastIndexOf(".") + 1)
                            val appData = AppData(
                                appName = loadLabel(context.packageManager) as String,
                                packageName = "${activityInfo.packageName}/$mainActivityName",
                                appIconDrawable = loadIcon(context.packageManager)
                            )
                            appDataList.add(appData)
                        }
                    }
                }

                emit(appDataList)

            }

        }
    }

}


data class AppData(val appName: String, val packageName: String, val appIconDrawable: Drawable) {

    fun parsePackageName() : String{
        return packageName.substring(0, packageName.indexOf("/"))
    }

//    fun toEntity(): LockedAppEntity {
//        return LockedAppEntity(packageName = packageName)
//    }
}