package latihan.android.com.latihan17.view.view_add

import android.app.Application
import android.arch.lifecycle.AndroidViewModel
import latihan.android.com.latihan17.StartApp
import latihan.android.com.latihan17.data.data_model.Book

class AddBookViewModel(application : Application): AndroidViewModel(application) {
    private val bookRepository = getApplication<StartApp>().getBookRepo()

    fun addBook(book: Book){
        bookRepository.insertBook(book)

    }
}