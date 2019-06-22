package id.erwinka.madesubmission1.listfilm

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide
import id.erwinka.madesubmission1.R

class ListFilmAdapter(
    private val context: Context,
    private val dataSource: List<ListFilmModel>,
    private val onClickListener: (ListFilmModel) -> Unit
) : BaseAdapter() {

    private val inflater: LayoutInflater = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        val rowView = inflater.inflate(R.layout.list_item, parent, false)

        val title = rowView.findViewById<TextView>(R.id.tv_film_title)
        val poster = rowView.findViewById<ImageView>(R.id.iv_film_poster)

        title.text = dataSource[position].title
        Glide.with(context).load(dataSource[position].poster).into(poster)

        rowView.setOnClickListener {
            onClickListener(dataSource[position])
        }

        return rowView
    }

    override fun getItem(position: Int): Any {
        return dataSource[position]
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getCount(): Int {
        return dataSource.size
    }
}