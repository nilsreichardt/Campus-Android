package de.tum.`in`.tumcampusapp.component.ui.cafeteriarating


import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import androidx.recyclerview.widget.LinearLayoutManager
import com.zhuinden.fragmentviewbindingdelegatekt.viewBinding
import de.tum.`in`.tumcampusapp.R
import de.tum.`in`.tumcampusapp.component.other.generic.fragment.FragmentForAccessingTumCabe
import de.tum.`in`.tumcampusapp.databinding.FragmentCafeteriaRatingBinding


class CreateCafeteriaRatingFragment : FragmentForAccessingTumCabe<List<String>>(
    R.layout.fragment_cafeteria_rating,
    R.string.create_cafeteria_rating
), AdapterView.OnItemSelectedListener {


    private val binding by viewBinding(FragmentCafeteriaRatingBinding::bind)


    private val itemsList = ArrayList<TagRatingElement>()
    private lateinit var createTagRatingAdapter: CreateRatingAdapter

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val cafeterias = arrayOf("Mensa Garching", "mensa leopoldstrasse")
        val meals = arrayOf("Only The Cafeteria", "Pizza Margeritha")
        //  binding.pickCafeteriaSpinner;
        //  val spinner = findViewById(R.id.pickCafeteriaSpinner)
        if (binding.pickCafeteriaCreateSpinner != null) {
            val adapter = ArrayAdapter(
                requireContext(),
                android.R.layout.simple_spinner_dropdown_item, cafeterias
            )
            binding.pickCafeteriaCreateSpinner.adapter = adapter
        }

        if (binding.pickDishCreateSpinner != null) {
            val adapter = ArrayAdapter(
                requireContext(),
                android.R.layout.simple_spinner_dropdown_item, meals
            )
            binding.pickDishCreateSpinner.adapter = adapter
        }
        prepareItems()

        // val recyclerView: RecyclerView = findViewById(R.id.recyclerView)
        createTagRatingAdapter = CreateRatingAdapter(itemsList)
        val layoutManager = LinearLayoutManager(requireContext())
        binding.tagOptionListRecyclerView.layoutManager = layoutManager
        binding.tagOptionListRecyclerView.adapter = createTagRatingAdapter


    }

    private fun prepareItems() {
        itemsList.add(TagRatingElement("Waiting time"))
        itemsList.add(TagRatingElement("Variety General"))
        itemsList.add(TagRatingElement("Variety Vegetarian"))
        itemsList.add(TagRatingElement("Variety Vegan"))
        itemsList.add (TagRatingElement("Enough free tables"))




        //createTagRatingAdapter.notifyDataSetChanged()
    }
    //  val cafeterias = arrayOf("mensa garching", "mensa leopoldstrasse")

    // Drop-down navigation
/*    private val selectCafeteriasSpinner: Spinner
        get() {

            val groupAdapter = object : ArrayAdapter<String>(
                    context!!,
                    android.R.layout.simple_spinner_dropdown_item,
                    android.R.id.text1,
                    cafeterias
            ) {
                val inflater = LayoutInflater.from(context)

                override fun getDropDownView(pos: Int, ignored: View?, parent: ViewGroup): View {
                    val v = inflater.inflate(android.R.layout.simple_spinner_dropdown_item, parent, false)
                    val studyRoomGroup = getItem(pos) ?: return v
                    val nameTextView = v.findViewById<TextView>(android.R.id.text1)
                    nameTextView.text = studyRoomGroup
                    return v
                }
            }

            groupAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
            return binding.pickCafeteriaSpinner.apply {
                adapter = groupAdapter
                onItemSelectedListener = this@CafeteriaRatingFragment
            }
        }*/

    override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
//todo toast mit id
    }

    override fun onNothingSelected(adapterView: AdapterView<*>?) = Unit

    /*override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val rootView: View = inflater.inflate(de.tum.`in`.tumcampusapp.R.layout.activity_cafeteria_rating, container, false)
        displayCafeterias()
        return rootView
    }*/

//    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
//        super.onViewCreated(view, savedInstanceState)
//
//    }


    /*  private fun displayCafeterias() {
          selectCurrentSpinnerItem()
          // binding.spinnerContainer.visibility = View.VISIBLE
          //  showLoadingEnded()
      }

      private fun selectCurrentSpinnerItem() {
          cafeterias.forEachIndexed { i, a ->

            //  selectCafeteriasSpinner.setSelection(i)

          }
      }
  */
    companion object {

        private const val NONE_SELECTED = -1

        @JvmStatic
        fun newInstance() = CreateCafeteriaRatingFragment()
    }

}