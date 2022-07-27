package de.tum.`in`.tumcampusapp.component.ui.cafeteriarating

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.annotation.NonNull
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.chip.Chip
import com.google.android.material.chip.ChipGroup
import com.google.android.material.internal.ContextUtils.getActivity
import de.tum.`in`.tumcampusapp.R
import de.tum.`in`.tumcampusapp.databinding.CafeteriaTagChipBinding

class ShowRatingAdapter(private var itemsList: List<TagRatingElement>) :
    RecyclerView.Adapter<ShowRatingAdapter.ViewHolder>() {


    private lateinit var context: Context

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        var chipGroup: ChipGroup = view.findViewById(R.id.chipGroup)
    }

    @NonNull
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val itemView = LayoutInflater.from(parent.context)
            .inflate(R.layout.list_item_rating, parent, false)
        context = parent.context
        return ViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = itemsList[position]
        //holder.itemTextView.text = item.tagLabel
        setupChip(holder.chipGroup)
    }

    override fun getItemCount(): Int {
        return itemsList.size
    }

    //todo wenn ausgewählt, dann in einer liste untendrunter anzeigen -> invertierte Notenfarben verwenden, ab einem bestimmten wert auch die schriftfarbe mit veränder damit besser lesbar
    //todo add click listener -> show number or stars if necessary
    private fun setupChip(chipGroup: ChipGroup) {
        val nameList =
            arrayListOf("Elevator", "Washer / Dryer", "Fireplace", "Wheelchair Access", "Dogs OK")
        for (name in nameList) {
            val chip = createChip(name)

            chipGroup.addView(chip)
        }
    }

    private fun createChip(label: String): Chip {
        val chip = Chip(context)
        chip.setBackgroundColor(R.color.grade_1_0)
        chip.text = label

        //chip.isCloseIconVisible = false
       // chip.setChipIconResource(R.drawable.ic_baseline_android_24)

      //  chip.setOnCloseIconClickListener {
      //      chipGroup.removeView(chip)
      //  }
        chip.setOnClickListener(
            View.OnClickListener {
                Toast.makeText(context, "chip clicked", Toast.LENGTH_SHORT).show()
            }
        )

      //  CafeteriaTagChipBinding.inflate(R.layout.cafeteria_tag_chip)

       // val chip = ChipBinding.inflate(layoutInflater).root
       // chip.text = label
        return chip
    }
}