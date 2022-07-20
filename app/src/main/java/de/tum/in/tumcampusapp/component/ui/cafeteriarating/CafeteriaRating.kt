package de.tum.`in`.tumcampusapp.component.ui.cafeteriarating

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import de.tum.`in`.tumcampusapp.R
import de.tum.`in`.tumcampusapp.component.other.generic.activity.BaseActivity
import de.tum.`in`.tumcampusapp.component.ui.cafeteria.fragment.CafeteriaFragment
import de.tum.`in`.tumcampusapp.component.ui.cafeteria.fragment.CafeteriaFragment.Companion.newInstance


class CafeteriaRating : BaseActivity(R.layout.activity_cafeteria_rating) {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        if (savedInstanceState == null) {
            supportFragmentManager
                    .beginTransaction()
                    .replace(R.id.contentFrame, CafeteriaRatingFragment.newInstance())
                    .commit()
        }
    }
}