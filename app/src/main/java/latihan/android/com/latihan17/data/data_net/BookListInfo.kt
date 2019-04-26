package latihan.android.com.latihan17.data.data_net

import latihan.android.com.latihan17.data.data_model.Book

class BookListInfo {
    companion object {
        var bookList = initBooklist()

        private fun initBooklist(): MutableList<Book>{
            var po_book = mutableListOf<Book>()
            po_book.add(
                Book(
                    "Buku 1",
                    "syahril",
                    "test",
                    1
                ))
            po_book.add(
                Book(
                    "Buku 2",
                    "syahril",
                    "test",
                    2
                ))
            return po_book
        }
    }
}