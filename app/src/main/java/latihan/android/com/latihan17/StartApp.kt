package latihan.android.com.latihan17

import android.app.Application
import latihan.android.com.latihan17.data.BookRepo

class StartApp: Application() {
    fun getBookRepo() = BookRepo(this)
}