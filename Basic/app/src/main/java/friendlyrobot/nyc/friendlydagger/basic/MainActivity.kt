package friendlyrobot.nyc.friendlydagger.basic

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.ProgressBar
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.SearchView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import friendlyrobot.nyc.friendlydagger.basic.ui.BookAdapter
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import javax.inject.Inject

class MainActivity : AppCompatActivity() {

    private val bookAdapter: BookAdapter = BookAdapter()
    protected lateinit var recyclerView: RecyclerView
    protected lateinit var indeterminateBar: ProgressBar
    protected lateinit var searchView: SearchView

    @Inject
    protected lateinit var bookService: BookService

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        (applicationContext as BookApplication).applicationComponent.inject(this)
        //bookService = (applicationContext as BookApplication).applicationComponent.bookService()

        searchView = findViewById(R.id.searchView)
        searchView.isIconified = false
        searchView.callOnClick()
        searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {

            override fun onQueryTextSubmit(query: String?): Boolean {
                showLoading()
                query?.let{queryBooks(it)}
                return false
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                return false
            }
        })
        recyclerView = findViewById(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = bookAdapter

        indeterminateBar = findViewById(R.id.indeterminateBar)
    }

    fun queryBooks(value: String) {
        bookService.search(value).enqueue(
            object : Callback<BookResponse> {
                override fun onFailure(call: Call<BookResponse>, t: Throwable) {
                    Log.e("Error", "Failure: ${t.localizedMessage}", t)
                }

                override fun onResponse(
                    call: Call<BookResponse>,
                    response: Response<BookResponse>
                ) {
                    Log.e("onResponse", "NumFount: ${response.body()?.numFound}")
                    response.body()?.docs?.map { it.toBook() }?.toList()?.let { bookAdapter.add(it) }
                    hideLoading()
                }

            }
        )
    }

    fun showLoading() {
        recyclerView.visibility = View.GONE
        indeterminateBar.visibility = View.VISIBLE
    }

    fun hideLoading() {
        recyclerView.visibility = View.VISIBLE
        indeterminateBar.visibility = View.GONE
    }
}
