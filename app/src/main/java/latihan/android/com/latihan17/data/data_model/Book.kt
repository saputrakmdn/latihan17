package latihan.android.com.latihan17.data.data_model

import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey


@Entity
class Book (
    var judul : String = "",
    var pengarang : String = "",
    var deskripsi : String = "",
    @PrimaryKey(autoGenerate = true) var id : Int = 0
)