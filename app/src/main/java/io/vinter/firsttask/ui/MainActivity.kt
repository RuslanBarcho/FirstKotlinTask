package io.vinter.firsttask.ui

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import io.vinter.firsttask.R
import io.vinter.firsttask.utils.RecyclerAdapter
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val list = ArrayList<Int>()
        val adapter = RecyclerAdapter(list, this)
        val recycler = main_recycler
        for (i in 1..1000000) {
            list.add(i)
        }
        recycler.layoutManager = LinearLayoutManager(this)
        recycler.adapter = adapter
    }
}
