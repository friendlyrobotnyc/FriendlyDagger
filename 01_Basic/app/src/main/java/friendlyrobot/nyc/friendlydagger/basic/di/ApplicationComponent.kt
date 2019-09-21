package friendlyrobot.nyc.friendlydagger.basic.di

import dagger.BindsInstance
import dagger.Component
import friendlyrobot.nyc.friendlydagger.basic.BookService
import friendlyrobot.nyc.friendlydagger.basic.MainActivity
import javax.inject.Singleton

@Singleton
@Component(modules = [ApplicationModule::class])
interface ApplicationComponent {

    @Component.Builder
    interface Builder {
        // convenience method to help us build the component
        fun build() : ApplicationComponent

        // we pass in our endpoint url to make it available to the module
        @BindsInstance
        fun endpoint(endpointUrl: String) : Builder
    }

    fun inject(mainActivity: MainActivity)

    // we don't have to use inject() above, we can
    // get the BookService this way as well
    fun bookService() : BookService
}