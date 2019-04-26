package latihan.android.com.latihan17.view.view_list




import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import kotlinx.android.synthetic.main.layout_list_item.view.*
import latihan.android.com.latihan17.R
import latihan.android.com.latihan17.data.data_model.Book

class ListBookAdapter(
    private val items : List<Book>,
    private val clickListener: OnItemClickListener
): RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    interface OnItemClickListener{
        fun onItemClick(book: Book, itemView: View)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.layout_list_item, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return items.size
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        (holder as ViewHolder).bind(items[position], clickListener)
    }
    class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        fun bind(book: Book, listener: OnItemClickListener)= with(itemView){
            textjudul.text = book.judul
            textViewPengarang.text = book.pengarang
            setOnClickListener{
                listener.onItemClick(book, it)
            }
        }
    }

}