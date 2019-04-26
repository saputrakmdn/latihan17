package latihan.android.com.latihan17.view.view_detail

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.fragment_detail.*
import latihan.android.com.latihan17.R
import latihan.android.com.latihan17.data.data_model.Book

class DetailFragment: Fragment(){
    private lateinit var viewModel : BookDetailViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(BookDetailViewModel::class.java)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_detail, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val bookId = arguments?.getInt(getString(R.string.book_id))
        bookId?.let {
            viewModel.getBookDetails(bookId).observe(this, Observer {bookDetail->
                populateBookDetail(bookDetail)

            })
        }
    }
    private fun populateBookDetail(book: Book?){
        textViewJudul.text = book?.judul
        textViewPengarang.text = book?.pengarang
        textViewDeskripsi.text = book?.deskripsi
    }
}