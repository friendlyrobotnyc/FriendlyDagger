package friendlyrobot.nyc.friendlydagger.basic

import android.app.Application

class BookApplication : Application() {

    lateinit var applicationComponent: ApplicationComponent

    override fun onCreate() {
        super.onCreate()
        applicationComponent = DaggerApplicationComponent.builder()
            .endpoint("https://openlibrary.org/")
            .application(this)
            .build()
    }
}