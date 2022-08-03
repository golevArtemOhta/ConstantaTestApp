package com.example.constantatestapp

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.recyclerview.widget.RecyclerView
import com.example.constantatestapp.databinding.FilmItemBinding

class FilmAdapter : RecyclerView.Adapter<FilmAdapter.FilmsHolder>() {
    val filmsList = ArrayList<Item>()


    class FilmsHolder(item: View) : RecyclerView.ViewHolder(item) {
        val binding = FilmItemBinding.bind(item)


        @SuppressLint("SetTextI18n")
        fun bind(film: Item) = with(binding) {
            tvNameAndYear.text = "${film.title} ${film.releaseYear}"
            val listFromDirectorName = film.directorName.split(" ")
            val surname = listFromDirectorName[2]
            val initials = "${listFromDirectorName[0][0]}. ${listFromDirectorName[1][0]}."
            tvDirectorName.text = "Режиссер: $surname $initials"
            val actors = film.actors.map { it.actorName }.toSet()
            tvActors.text = "В ролях: ${actors.joinToString(", ")}"

            itemView.setOnClickListener {
                val builder = itemView.context.let { AlertDialog.Builder(it) }
                builder.setTitle("Фильм ${film.title} был нажат")
                builder.setPositiveButton("Ок"){dialogInterface, i->
                    //TODO
                }
                builder.show()
            }

        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FilmsHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.film_item, parent, false)
        return FilmsHolder(view)
    }

    override fun onBindViewHolder(holder: FilmsHolder, position: Int) {
        holder.bind(filmsList[position])
    }

    override fun getItemCount(): Int {
        return filmsList.size
    }

    fun getFilmsData(films: List<Item>) {
        filmsList.addAll(films)
        filmsList.sortBy { it.releaseYear }
    }





}