package friendlyrobot.nyc.friendlydagger.basic

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface BookService {
    @GET("search.json")
    fun search(@Query("q") value: String) : Call<BookResponse>
}