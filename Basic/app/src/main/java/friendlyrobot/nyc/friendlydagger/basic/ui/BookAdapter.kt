package friendlyrobot.nyc.friendlydagger.basic.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import friendlyrobot.nyc.friendlydagger.basic.Book
import friendlyrobot.nyc.friendlydagger.basic.R
import kotlinx.android.synthetic.main.item_book.view.*

class BookAdapter : RecyclerView.Adapter<BookViewHolder>() {

    private val books = mutableListOf<Book>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) : BookViewHolder {
        val inflater = LayoutInflater.from(parent.context)

        return BookViewHolder(
            inflater.inflate(
                R.layout.item_book,
                parent,
                false
            )
        )
    }

    override fun getItemCount() = books.size

    override fun onBindViewHolder(holder: BookViewHolder, position: Int) {
        books.getOrNull(position)?.let { holder.bind(it) }
    }

    fun add(booksToAdd: List<Book>) {
        books.clear()
        books.addAll(booksToAdd)
        notifyDataSetChanged()
    }
}

class BookViewHolder(bookView: View) : RecyclerView.ViewHolder(bookView) {
    fun bind (book: Book) {
        itemView.bookTitle.text = book.title
    }
}