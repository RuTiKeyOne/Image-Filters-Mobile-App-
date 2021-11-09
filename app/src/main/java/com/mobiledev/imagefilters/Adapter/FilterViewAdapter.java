package com.mobiledev.imagefilters.Adapter;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.mobiledev.imagefilters.Interfaces.FilterListener;
import com.mobiledev.imagefilters.Model.Filter;
import com.mobiledev.imagefilters.R;
import com.mobiledev.imagefilters.databinding.ItemContainerFilterBinding;

import java.util.List;

public class FilterViewAdapter extends RecyclerView.Adapter<FilterViewAdapter.FilterViewHolder> {

    private FilterListener filterListener;
    private List<Filter> filters;
    private LayoutInflater layoutInflater;

    public FilterViewAdapter(@NonNull FilterListener filterListener, @NonNull List<Filter> filters) {
        this.filterListener = filterListener;
        this.filters = filters;
    }

    @NonNull
    @Override
    public FilterViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        if(layoutInflater == null){
            layoutInflater =  LayoutInflater.from(parent.getContext());
        }

        ItemContainerFilterBinding filterBinding = DataBindingUtil.inflate(
                layoutInflater, R.layout.item_container_filter, parent, false);
        return new FilterViewHolder(filterBinding);
    }

    @Override
    public void onBindViewHolder(@NonNull FilterViewHolder holder, int position) {
        holder.bindFilter(filters.get(position));
    }

    @Override
    public int getItemCount() {
        return filters.size();
    }

    class FilterViewHolder extends RecyclerView.ViewHolder{

        private ItemContainerFilterBinding itemFilterBinding;

        public FilterViewHolder(@NonNull ItemContainerFilterBinding itemFilterBinding) {
            super(itemFilterBinding.getRoot());
            this.itemFilterBinding = itemFilterBinding;
        }

        public void bindFilter(Filter filter){
            itemFilterBinding.setName(filter.getName());
            itemFilterBinding.imageFilterPreview.setImageResource(filter.getImageId());
            itemFilterBinding.getRoot().setOnClickListener(v -> filterListener.onFilterSelected(filter.getPhotoFilter()));
        }
    }

}
