package de.tum.`in`.tumcampusapp.component.ui.cafeteriarating

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.annotation.NonNull
import androidx.recyclerview.widget.RecyclerView
import de.tum.`in`.tumcampusapp.R
import de.tum.`in`.tumcampusapp.component.ui.cafeteria.CafeteriaNotificationSettingsAdapter

class CreateTagRatingAdapter(private var itemsList: List<TagRatingElement>) :
RecyclerView.Adapter<CreateTagRatingAdapter.ViewHolder>() {


    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        var itemTextView: TextView = view.findViewById(R.id.tagItemLabel)
    }

    @NonNull
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val itemView = LayoutInflater.from(parent.context)
            .inflate(R.layout.list_item_rating_tag_large, parent, false)
        return ViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = itemsList[position]
        holder.itemTextView.text = item.tagLabel
    }

    override fun getItemCount(): Int {
        return itemsList.size
    }
}