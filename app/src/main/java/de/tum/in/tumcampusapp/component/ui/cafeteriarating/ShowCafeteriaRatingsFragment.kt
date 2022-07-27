package de.tum.`in`.tumcampusapp.component.ui.cafeteriarating

import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import androidx.recyclerview.widget.LinearLayoutManager
import com.zhuinden.fragmentviewbindingdelegatekt.viewBinding
import de.tum.`in`.tumcampusapp.R
import de.tum.`in`.tumcampusapp.component.other.generic.fragment.FragmentForAccessingTumCabe
import de.tum.`in`.tumcampusapp.databinding.FragmentShowCafeteriaRatingsBinding


class ShowCafeteriaRatingsFragment : FragmentForAccessingTumCabe<List<String>>(
    R.layout.fragment_show_cafeteria_ratings,
    R.string.view_cafeteria_rating
), AdapterView.OnItemSelectedListener {


    private val binding by viewBinding(FragmentShowCafeteriaRatingsBinding::bind)


    private val itemsList = ArrayList<TagRatingElement>()
    private lateinit var showTagRatingAdapter: ShowRatingAdapter

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val cafeterias = arrayOf("Mensa Garching", "mensa leopoldstrasse")
        val meals = arrayOf("Only The Cafeteria", "Pizza Margeritha")
        //  binding.pickCafeteriaSpinner;
        //  val spinner = findViewById(R.id.pickCafeteriaSpinner)
        if (binding.pickCafeteriaShowSpinner != null) {
            val adapter = ArrayAdapter(
                requireContext(),
                android.R.layout.simple_spinner_dropdown_item, cafeterias
            )
            binding.pickCafeteriaShowSpinner.adapter = adapter
        }

        if (binding.pickDishShowSpinner != null) {
            val adapter = ArrayAdapter(
                requireContext(),
                android.R.layout.simple_spinner_dropdown_item, meals
            )
            binding.pickDishShowSpinner.adapter = adapter
        }
        prepareItems()

        // val recyclerView: RecyclerView = findViewById(R.id.recyclerView)
        showTagRatingAdapter = ShowRatingAdapter(itemsList)
        val layoutManager = LinearLayoutManager(requireContext())
        binding.showSingleRatingsRecyclerView.layoutManager = layoutManager
        binding.showSingleRatingsRecyclerView.adapter = showTagRatingAdapter
    }



    private fun prepareItems() {
        itemsList.add(TagRatingElement("Waiting time"))
        itemsList.add(TagRatingElement("Variety General"))
        itemsList.add(TagRatingElement("Variety Vegetarian"))
        itemsList.add(TagRatingElement("Variety Vegan"))
        itemsList.add(TagRatingElement("Enough free tables"))
    }



    override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
//todo toast mit id
    }

    override fun onNothingSelected(adapterView: AdapterView<*>?) = Unit


    companion object {

        private const val NONE_SELECTED = -1

        @JvmStatic
        fun newInstance() = CreateCafeteriaRatingFragment()
    }

}