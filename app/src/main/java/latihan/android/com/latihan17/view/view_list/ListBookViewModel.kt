package latihan.android.com.latihan17.view.view_list

import android.app.Application
import android.arch.lifecycle.AndroidViewModel
import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MediatorLiveData
import latihan.android.com.latihan17.StartApp
import latihan.android.com.latihan17.data.data_model.Book

class ListBookViewModel(application: Application): AndroidViewModel(application) {
    private val bookRepo = getApplication<StartApp>().getBookRepo()
    private val bookList = MediatorLiveData<List<Book>>()

    init {
        getAllBook()
    }
    fun getBookList (): LiveData<List<Book>>{
        return bookList
    }
    fun getAllBook(){
        bookList.addSource(bookRepo.getAllBook()){
            book -> bookList.postValue(book)
        }
    }
}