package app.validator.di

import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent
import dagger.hilt.android.components.ActivityRetainedComponent
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.components.SingletonComponent
import javax.inject.Inject

interface AnalyticsService {
    fun analyticsMethods():String
    fun isActive():Boolean
}

// Constructor-injected, because Hilt needs to know how to
// provide instances of AnalyticsServiceImpl, too.
class AnalyticsServiceImpl @Inject constructor(
) : AnalyticsService {
    override fun analyticsMethods():String {
        return "HELLO WORLD"
    }

    override fun isActive(): Boolean {
        return true
    }

}

@Module
@InstallIn(SingletonComponent::class)
abstract class AnalyticsModule {

    @Binds
    abstract fun bindAnalyticsService(
        analyticsServiceImpl: AnalyticsServiceImpl
    ): AnalyticsService

//    @Provides
//        fun provideIsActive():AnalyticsService{
//        return AnalyticsServiceImpl()
//    }
}

class IsActivo(){

}