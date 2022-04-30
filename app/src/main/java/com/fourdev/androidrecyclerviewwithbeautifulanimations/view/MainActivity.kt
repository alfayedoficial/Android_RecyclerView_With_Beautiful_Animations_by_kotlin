package com.fourdev.androidrecyclerviewwithbeautifulanimations.view

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.alfayedoficial.kotlinutils.kuInitLinearLayoutManager
import com.fourdev.androidrecyclerviewwithbeautifulanimations.R
import com.fourdev.androidrecyclerviewwithbeautifulanimations.adapter.PersonRvAdapter
import com.fourdev.androidrecyclerviewwithbeautifulanimations.core.utils.InsertDataHelper.createList
import com.fourdev.androidrecyclerviewwithbeautifulanimations.databinding.ActivityMainBinding
import com.fourdev.androidrecyclerviewwithbeautifulanimations.model.Person


class MainActivity : AppCompatActivity() {

    private val personsList: MutableList<Person> by lazy { ArrayList() }
    private val adapterPersonRv by lazy { PersonRvAdapter() }

    private fun init() {
        createList(personsList)
        createList(personsList)
        createList(personsList)
        createList(personsList)
        createList(personsList)
        createList(personsList)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // dataBinding inflate activity_main.xml
        ActivityMainBinding.inflate(layoutInflater).apply {
            setContentView(root)

            init()

            adapterPersonRv.apply {
                setDataList(personsList)
            }

            rvPersons.recyclerviewBase.apply {
                kuInitLinearLayoutManager(LinearLayoutManager.VERTICAL , adapterPersonRv)
            }
        }
    }


    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.choose_menu, menu)
        return  true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId) {
            R.id.action_fadeInAnimation -> {
                adapterPersonRv.getSetAnimation(0)
                return true
            }
            R.id.action_leftToRightAnimation-> {
                adapterPersonRv.getSetAnimation(1)
                return true
            }

            R.id.action_rightToLeftAnimation-> {
                adapterPersonRv.getSetAnimation(2)
                return true
            }

            else -> {
                return super.onOptionsItemSelected(item)
            }
        }
    }

}