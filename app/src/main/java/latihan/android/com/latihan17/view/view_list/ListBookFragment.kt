package latihan.android.com.latihan17.view.view_list

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.findNavController
import kotlinx.android.synthetic.main.fragment_for_list_book.*
import latihan.android.com.latihan17.R
import latihan.android.com.latihan17.data.data_model.Book

class ListBookFragment: Fragment(), ListBookAdapter.OnItemClickListener {

    private lateinit var viewModel: ListBookViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(ListBookViewModel::class.java)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_for_list_book, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        addFab.setOnClickListener {
            view.findNavController().navigate(R.id.action_listBookFragment_to_fragmentAddBook)
        }
        viewModel.getBookList().observe(this, Observer<List<Book>>{
            book-> book?.let {
            populateBookList(book)

        }
        })
    }


    override fun onItemClick(book: Book, itemView: View) {
        val detailBundle = Bundle().apply {
            putInt(getString(R.string.book_id), book.id)
        }
        view?.findNavController()?.navigate(R.id.action_listBookFragment_to_detailFragment, detailBundle)
    }
    private fun populateBookList(bookList: List<Book>){
        peopleRecyclerView.adapter = ListBookAdapter(bookList, this)
    }
}