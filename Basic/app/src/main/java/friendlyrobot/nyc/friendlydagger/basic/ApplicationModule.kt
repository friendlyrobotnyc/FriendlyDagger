package friendlyrobot.nyc.friendlydagger.basic

import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import javax.inject.Singleton

@Module
object ApplicationModule {

    @JvmStatic
    @Provides
    @Singleton
    fun provideRetrofit(url: String) = Retrofit.Builder()
        .addConverterFactory(MoshiConverterFactory.create())
        .baseUrl(url)
        .build()

    @JvmStatic
    @Provides
    @Singleton
    fun provideBookService(retrofit: Retrofit) : BookService {
        return retrofit.create(BookService::class.java)
    }
}