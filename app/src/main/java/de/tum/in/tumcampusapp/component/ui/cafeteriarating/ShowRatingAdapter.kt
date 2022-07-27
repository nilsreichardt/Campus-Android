package de.tum.`in`.tumcampusapp.component.ui.cafeteriarating

import android.content.Context
import android.content.res.ColorStateList
import android.opengl.Visibility
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.RatingBar
import android.widget.TextView
import android.widget.Toast
import androidx.annotation.NonNull
import androidx.cardview.widget.CardView
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.chip.Chip
import com.google.android.material.chip.ChipGroup
import de.tum.`in`.tumcampusapp.R

class ShowRatingAdapter(private var itemsList: List<ShowRatingAverage>) :
    RecyclerView.Adapter<ShowRatingAdapter.ViewHolder>() {


    private lateinit var context: Context

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        var chipGroup: ChipGroup = view.findViewById(R.id.chipGroup)
        var ratingCommentTextView: TextView = view.findViewById(R.id.ratingCommentTextView)
        var showRatingImageViewHolder: CardView = view.findViewById(R.id.showRatingImageViewHolder)
        var singleRatingPointsRatingBar: RatingBar =
            view.findViewById(R.id.singleRatingPointsRatingBar)

        //  var ratingResultNumberTextView: TextView = view.findViewById(R.id.ratingResultNumberTextView)
        var listItemHolderCardView: LinearLayout = view.findViewById(R.id.listItemHolderCardView)

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
        //todo set visibilities according to values
        //todo after chip was clicked -> more informationn in another textvview below, or chaning the chip text itself
        if (item.img) {
            holder.showRatingImageViewHolder.visibility = View.VISIBLE
        }
        if (item.comment.length > 0) {
            holder.ratingCommentTextView.visibility = View.VISIBLE
            holder.ratingCommentTextView.text = item.comment
        }

        if (item.points == 1) {
            holder.listItemHolderCardView.setBackgroundColor(ContextCompat.getColor(context, R.color.rating_1))
        } else if (item.points == 2) {
            holder.listItemHolderCardView.setBackgroundColor(ContextCompat.getColor(context, R.color.rating_2))
        } else if (item.points == 3) {
            holder.listItemHolderCardView.setBackgroundColor(ContextCompat.getColor(context, R.color.rating_3))
        } else if (item.points == 4) {
            holder.listItemHolderCardView.setBackgroundColor(ContextCompat.getColor(context, R.color.rating_4))
        } else {
            holder.listItemHolderCardView.setBackgroundColor(ContextCompat.getColor(context, R.color.rating_5))
        }

        holder.singleRatingPointsRatingBar.rating = item.points.toFloat()
        //   holder.ratingResultNumberTextView.text=item.points.toString()
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
        // chip.setBackgroundColor(R.color.grade_1_0)
        chip.chipBackgroundColor = ColorStateList.valueOf(
            ContextCompat.getColor(
                context,
                R.color.grade_1_0
            )
        )//getColorStateList("R.color.grade_1_0");
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