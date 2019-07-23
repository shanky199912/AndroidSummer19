package com.example.imdbclone.adapter

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.imdbclone.PersonDetailActivity
import com.example.imdbclone.R
import com.example.imdbclone.networking.movies.CastItem
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.rcviewcast.view.*

class CastAdapter(private val context: Context, private val listCast: ArrayList<CastItem?>?) :
    RecyclerView.Adapter<CastViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CastViewHolder {
        return CastViewHolder(LayoutInflater.from(context).inflate(R.layout.rcviewcast, parent, false))
    }

    override fun getItemCount(): Int {
        return listCast!!.size //To change body of created functions use File | Settings | File Templates.
    }

    override fun onBindViewHolder(holder: CastViewHolder, position: Int) {
        val cast = listCast?.get(position)
        cast?.let { holder.bind(it) }

    }

}

class CastViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    fun bind(cast: CastItem) {

        Picasso.get()
            .load("https://image.tmdb.org/t/p/original" + cast.profilePath)
            .fit()
            .centerCrop()
            .into(itemView.cast_image)

        if (itemView.cast_nametv.text != null) {

            itemView.cast_nametv.text = cast.name
        } else
            itemView.cast_nametv.text = ""

        if (itemView.cast_nametv.text != null) {
            itemView.cast_character.text = cast.character
        } else {
            itemView.cast_character.text = ""
        }

        itemView.crdviewCast.setOnClickListener {

            val intent = Intent(itemView.context, PersonDetailActivity::class.java)
            intent.putExtra("PersonId", cast.id)
            itemView.context.startActivity(intent)
        }
    }
}