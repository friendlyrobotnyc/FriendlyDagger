package friendlyrobot.nyc.friendlydagger.basic.di

import dagger.Module
import dagger.Provides
import friendlyrobot.nyc.friendlydagger.basic.BookService
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import javax.inject.Singleton

@Module
object ApplicationModule {

    @JvmStatic
    @Provides
    @Singleton
    fun provideRetrofit(openLibraryUrl: String) : BookService = Retrofit.Builder()
        .addConverterFactory(MoshiConverterFactory.create())
        .baseUrl(openLibraryUrl)
        .build()
        .create(BookService::class.java)
}