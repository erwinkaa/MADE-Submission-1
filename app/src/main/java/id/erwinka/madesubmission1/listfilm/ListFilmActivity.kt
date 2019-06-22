package id.erwinka.madesubmission1.listfilm

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import id.erwinka.madesubmission1.R
import id.erwinka.madesubmission1.detailfilm.DetailFilmActivity
import kotlinx.android.synthetic.main.activity_list_film.*
import org.jetbrains.anko.startActivity

class ListFilmActivity : AppCompatActivity() {

    private var listFilms: MutableList<ListFilmModel> = mutableListOf()

    companion object {
        const val INTENT_KEY = "data"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list_film)

        initData()
        listview.adapter = ListFilmAdapter(applicationContext, listFilms) {
            startActivity<DetailFilmActivity>(INTENT_KEY to it)
        }

    }

    private fun initData() {
        val titles = resources.getStringArray(R.array.film_titles)
        val descriptions = resources.getStringArray(R.array.film_descriptions)
        val posters = resources.obtainTypedArray(R.array.film_posters)
        val releaseDates = resources.getStringArray(R.array.film_releasedate)
        val runningTimes = resources.getStringArray(R.array.film_runningtimes)
        val distributedBy = resources.getStringArray(R.array.film_distributedby)
        listFilms.clear()
        for (i in titles.indices) {
            listFilms.add(
                ListFilmModel(
                    titles[i],
                    descriptions[i],
                    posters.getResourceId(i, 0),
                    releaseDates[i],
                    runningTimes[i],
                    distributedBy[i]
                )
            )
        }
        posters.recycle()
    }
}
