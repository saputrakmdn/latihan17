package latihan.android.com.latihan17.data.db_only

import android.app.Application
import android.arch.persistence.db.SupportSQLiteDatabase
import android.arch.persistence.room.Database
import android.arch.persistence.room.Room
import android.arch.persistence.room.RoomDatabase
import android.os.AsyncTask
import latihan.android.com.latihan17.data.data_model.Book
import latihan.android.com.latihan17.data.data_net.BookListInfo


@Database(entities = [Book::class], version = 1)
abstract class BookDb: RoomDatabase() {
    abstract fun bookDao() : BookDao

    companion object {
        private val lock = Any()
        private const val DB_NAME = "book.db"
        private var INSTANCE: BookDb? = null

        fun getInstance (application: Application): BookDb{
            synchronized(lock){
                if(BookDb.INSTANCE == null){
                    BookDb.INSTANCE = Room.databaseBuilder(application, BookDb::class.java, BookDb.DB_NAME).allowMainThreadQueries().addCallback(object : RoomDatabase.Callback(){
                        override fun onCreate(db: SupportSQLiteDatabase) {
                            super.onCreate(db)
                            BookDb.INSTANCE?.let{
                                BookDb.prePolated(it, BookListInfo.bookList)
                            }
                        }
                    }).build()

                }
                return INSTANCE!!
            }
        }
        fun prePolated(database: BookDb, bookList: List<Book>){
            for (book in bookList){
                AsyncTask.execute{database.bookDao().insert(book)}
            }
        }

    }
}