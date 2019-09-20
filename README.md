# FriendlyDagger

Let's see how we can set up [Dagger](https://github.com/google/dagger), what are the different configurations we can choose from and what will each offer. I wanted a sandbox to help myself and hopefully others. Please let me know if I can improve something or add an additional setup :) thank you for checking this out!

First things first!

### Why use a Dependency Injection Framework?

* it abstracts how we construct our dependencies
* constructor injection forces us to write better code that is testable
* scoping of our dependencies 


## 01_Basic

The most basic dagger configuration comprising of just an application graph that provides a retrofit service.

Check out the [DI Package](../master/01_Basic/app/src/main/java/friendlyrobot/nyc/friendlydagger/basic/di). There you will see the [Application Component](../master/01_Basic/app/src/main/java/friendlyrobot/nyc/friendlydagger/basic/di/ApplicationComponent.kt) and the [Application Module](../master/01_Basic/app/src/main/java/friendlyrobot/nyc/friendlydagger/basic/di/ApplicationModule.kt)

Here is a basic Component that gives us our dependencies, a retrofit services, a convenience method for building, and a way to pass in parameters to our dependencies

```kotlin

@Singleton
@Component(modules = [ApplicationModule::class])
interface ApplicationComponent {

    @Component.Builder
    interface Builder {
        fun build() : ApplicationComponent // convenience method to help us build the component

        @BindsInstance // we pass in our endpoint url to make it available to the module
        fun endpoint(endpointUrl: String) : Builder
    }

    fun inject(mainActivity: MainActivity)

    fun bookService() : BookService // we don't have to use inject() above, we can
                                    // get the BookService this way as well
}

```

We provide our dependencies, in this case a retrofit service, from the module

```kotlin

@Module
object ApplicationModule {

    @@JvmStatic
    @Provides
    @Singleton
    fun provideRetrofit(openLibraryUrl: String) : BookService = Retrofit.Builder()
        .addConverterFactory(MoshiConverterFactory.create())
        .baseUrl(openLibraryUrl)
        .build()
        .create(BookService::class.java)
}

```

Building the Application Component 

```kotlin
class BookApplication : Application() {

    lateinit var applicationComponent: ApplicationComponent

    override fun onCreate() {
        super.onCreate()
        applicationComponent = DaggerApplicationComponent.builder()
            .endpoint("https://openlibrary.org/")
            .build()
    }
}

```

Accessing the Application Component 

```kotlin

(applicationContext as BookApplication).applicationComponent.inject(this)

```

or 

```kotlin

val bookService = (applicationContext as BookApplication).applicationComponent.bookService()

```

