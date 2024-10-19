package com.example.movies;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class ReviewAdapter extends RecyclerView.Adapter<ReviewAdapter.ReviewViewHolder> {
    private List<Review> reviews = new ArrayList<>();
    private static final String TYPE_POSITIVE = "Позитивный";
    private static final String TYPE_NEGATIVE = "Негативный";


    public void setReviews(List<Review> reviews) {
        this.reviews = reviews;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public ReviewViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(
                R.layout.review_item,
                parent,
                false
        );
        return new ReviewViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ReviewViewHolder holder, int position) {
        Review review = reviews.get(position);
        holder.textViewAuthorName.setText(review.getAuthor());
        holder.textViewReviewText.setText(review.getReview());
        int colorResId;
        String reviewType = review.getType();
        switch (reviewType){
            case TYPE_POSITIVE:
                colorResId = android.R.color.holo_green_light;
                break;
            case TYPE_NEGATIVE:
                colorResId = android.R.color.holo_red_light;
                break;
            default:
                colorResId = android.R.color.holo_orange_light;
        }
        int color = ContextCompat.getColor(holder.itemView.getContext(),colorResId);
        holder.linerLayoutContainer.setBackgroundColor(color);


    }

    @Override
    public int getItemCount() {
        return reviews.size();
    }

    static class ReviewViewHolder extends RecyclerView.ViewHolder {
        private final TextView textViewAuthorName;
        private final TextView textViewReviewText;
        private final LinearLayout linerLayoutContainer;

        public ReviewViewHolder(@NonNull View itemView) {
            super(itemView);
            linerLayoutContainer = itemView.findViewById(R.id.linerLayoutContainer);
            textViewAuthorName = itemView.findViewById(R.id.textViewAuthorName);
            textViewReviewText = itemView.findViewById(R.id.textViewReviewText);
        }


    }

}
