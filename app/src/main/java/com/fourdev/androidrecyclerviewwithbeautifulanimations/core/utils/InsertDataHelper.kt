package com.fourdev.androidrecyclerviewwithbeautifulanimations.core.utils

import android.content.Context
import com.fourdev.androidrecyclerviewwithbeautifulanimations.R
import com.fourdev.androidrecyclerviewwithbeautifulanimations.model.Person

/**
 * Created by ( Eng Ali Al Fayed)
 * Class do : ( Insert Data Helper )
 * Date 4/30/2022 - 2:37 PM
 */
object InsertDataHelper {

    // fun to create a new list of Person Class
    fun Context.createList(persons:  MutableList<Person>): List<Person> {
        val imagesArray = resources.obtainTypedArray(R.array.people_images)
        val names = resources.getStringArray(R.array.people_names)

        for (i in 0 until imagesArray.length()) {
            val person = Person()
            person.name = names[i]
            person.description = getString(R.string.loremIpsum)
            person.image = imagesArray.getResourceId(i, -1)
            persons.add(person)
        }
        persons.shuffle()
        return persons
    }

}