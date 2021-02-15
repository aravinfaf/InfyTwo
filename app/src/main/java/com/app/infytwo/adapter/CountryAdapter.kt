package com.app.infytwo.adapter

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.app.infytwo.BR
import com.app.infytwo.R
import com.app.infytwo.data.CountryModel
import com.app.infytwo.databinding.AdapterLayoutBinding
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.adapter_layout.view.*

class CountryAdapter(private val countrylist: ArrayList<CountryModel>) :
    RecyclerView.Adapter<CountryAdapter.CountryViewHolder>() {

    class CountryViewHolder(val binding: AdapterLayoutBinding) : RecyclerView.ViewHolder(binding.root) {

        fun bind(data: Any) {

            binding.setVariable(BR.country,data)
            binding.executePendingBindings()

//            if (countryModel.title != null) {
//                itemView.textViewTitle.text = countryModel.title
//                itemView.textViewDescription.text = countryModel.description
//
//            Log.e("Ss",countryModel.imageHref.toString())
//                Glide
//                    .with(itemView.context)
//                    .load(countryModel.imageHref)
//                    .fitCenter()
////                    .error(R.drawable.ic_launcher_background)
//                    .into(itemView.imageViewAvatar);
//                  }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) : CountryViewHolder {
       val layoutInflater : LayoutInflater = LayoutInflater.from(parent.context)
        val binding : AdapterLayoutBinding = DataBindingUtil.inflate(layoutInflater,R.layout.adapter_layout,parent,false)
        return CountryViewHolder(binding)
    }

    override fun getItemCount(): Int = countrylist.size

    override fun onBindViewHolder(holder: CountryViewHolder, position: Int) {
        holder.bind(countrylist[position])
    }
}