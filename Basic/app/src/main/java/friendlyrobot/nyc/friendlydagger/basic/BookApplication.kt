package friendlyrobot.nyc.friendlydagger.basic

import android.app.Application
import friendlyrobot.nyc.friendlydagger.basic.di.ApplicationComponent
import friendlyrobot.nyc.friendlydagger.basic.di.DaggerApplicationComponent

class BookApplication : Application() {

    lateinit var applicationComponent: ApplicationComponent

    override fun onCreate() {
        super.onCreate()
        applicationComponent = DaggerApplicationComponent.builder()
            .endpoint("https://openlibrary.org/")
            .build()
    }
}