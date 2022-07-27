package de.tum.`in`.tumcampusapp.component.ui.cafeteriarating

import android.os.Bundle
import de.tum.`in`.tumcampusapp.R
import de.tum.`in`.tumcampusapp.component.other.generic.activity.BaseActivity


class CreateCafeteriaRatingActivity : BaseActivity(R.layout.activity_cafeteria_rating) {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        if (savedInstanceState == null) {
            supportFragmentManager
                    .beginTransaction()
                    .replace(R.id.contentFrame, CreateCafeteriaRatingFragment.newInstance())
                    .commit()
        }
    }
}