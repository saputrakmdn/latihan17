package latihan.android.com.latihan17.data

import android.app.Application
import android.arch.lifecycle.LiveData
import latihan.android.com.latihan17.data.data_model.Book
import latihan.android.com.latihan17.data.db_only.BookDao
import latihan.android.com.latihan17.data.db_only.BookDb

class BookRepo(application: Application) {
    private val bookDao: BookDao
    init {
        val bookDatabase = BookDb.getInstance(application)
        bookDao = bookDatabase.bookDao()
    }

    //mengambil semua db
    fun getAllBook(): LiveData<List<Book>>{
        return bookDao.getAll()
    }

    //inserbook
    fun insertBook(book: Book){
        bookDao.insert(book)
    }

    //find by id
    fun findBook(id : Int): LiveData<Book>{
        return bookDao.find(id)
    }

}