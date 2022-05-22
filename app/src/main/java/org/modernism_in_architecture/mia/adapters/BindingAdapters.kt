package org.modernism_in_architecture.mia

import android.view.View
import android.widget.ImageView
import androidx.core.net.toUri
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import coil.load
import org.modernism_in_architecture.mia.adapters.BuildingGridAdapter
import org.modernism_in_architecture.mia.models.MiaApiStatus

import org.modernism_in_architecture.mia.network.Building


@BindingAdapter("listData")
fun bindRecyclerView(recyclerView: RecyclerView, data: List<Building>?) {
    val adapter = recyclerView.adapter as BuildingGridAdapter
    adapter.submitList(data)
}

@BindingAdapter("imageUrl")
fun bindImage(imgView: ImageView, imgUrl: String?) {
    imgUrl?.let {
        val imgUri = imgUrl.toUri().buildUpon().scheme("https").build()
        imgView.load(imgUri) {
            placeholder(R.drawable.loading_animation)
            error(R.drawable.ic_broken_image)
        }
    }
}

@BindingAdapter("miaApiStatus")
fun bindStatus(statusImageView: ImageView, status: MiaApiStatus?) {
    when (status) {
        MiaApiStatus.LOADING -> {
            statusImageView.visibility = View.VISIBLE
            statusImageView.setImageResource(R.drawable.loading_animation)
        }
        MiaApiStatus.ERROR -> {
            statusImageView.visibility = View.VISIBLE
            statusImageView.setImageResource(R.drawable.ic_connection_error)
        }
        MiaApiStatus.DONE -> {
            statusImageView.visibility = View.GONE
        }
    }
}

