package com.ankita.androidmainproject.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.ankita.androidmainproject.DataBaseModel.Comments;
import com.ankita.androidmainproject.R;

import java.util.List;

public class ItemCommentAdapter extends RecyclerView.Adapter<ItemCommentAdapter.ViewHolder> {
    private List<Comments> comment;
    private LayoutInflater mInflater;

   public ItemCommentAdapter(Context context, List<Comments> comment) {
        this.mInflater = LayoutInflater.from(context);
        this.comment = comment;
    }


    @NonNull
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = mInflater.inflate(R.layout.item_usercomment, parent, false);
        return new ViewHolder(view);
    }

    // binds the data to the TextView in each row
    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.myTextView.setText(comment.get(position).getComment());
    }

    @Override
    public int getItemCount() {
        return comment.size();
    }


    class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        TextView myTextView;

        ViewHolder(View itemView) {
            super(itemView);
            myTextView = itemView.findViewById(R.id.tvComment);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
        }
    }
}


