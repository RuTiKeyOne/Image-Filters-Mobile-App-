package com.mobiledev.imagefilters.Adapter;

import android.view.View;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.mobiledev.imagefilters.databinding.ItemContainerFilterBinding;

public class FilterViewAdapter {

    class FilterViewHolder extends RecyclerView.ViewHolder{

        private ItemContainerFilterBinding itemFilterBinding;

        public FilterViewHolder(@NonNull ItemContainerFilterBinding itemFilterBinding) {
            super(itemFilterBinding.getRoot());
            this.itemFilterBinding = itemFilterBinding;
        }

        public void bindFilter(){

        }
    }

}
