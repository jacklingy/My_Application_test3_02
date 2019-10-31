package edu.ncu.myapplication_test3_02;

import java.util.List;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

public class MovieAdapter extends RecyclerView.Adapter<MovieAdapter.ViewHolder> {
    private List<Movie> movieList;
    
    static class ViewHolder extends RecyclerView.ViewHolder {
        ImageView movieImage;
        
        TextView movieName;
        
        TextView movieDescription;
        
        public ViewHolder(View view) {
            super(view);
            movieImage = (ImageView)view.findViewById(R.id.movieImage);
            movieName = (TextView)view.findViewById(R.id.movieName);
            movieDescription = (TextView)view.findViewById(R.id.movieDescription);
        }
    }
    
    public MovieAdapter(List<Movie> mList) {
        movieList = mList;
    }
    
    @Override
    
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.movie_item, parent, false);
        ViewHolder holder = new ViewHolder(view);
        return holder;
    }
    
    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        
        Movie movie = movieList.get(position);
        holder.movieImage.setImageResource(movie.getCoverId());
        holder.movieName.setText(movie.getName());
        holder.movieDescription.setText(movie.getDescription());
    }
    
    @Override
    public int getItemCount() {
        return movieList.size();
    }
    
    // 添加数据
    public void addData(int position, Movie movie) {
        // 在list中添加数据，并通知条目加入一条
        movieList.add(position, movie);
        // 添加动画
        notifyItemInserted(position);
    }
    
    // 删除数据
    public void removeData(int position) {
        movieList.remove(position);
        // 删除动画
        notifyItemRemoved(position);
    }
    
    public void moveToTop(RecyclerView recyclerView) {
        recyclerView.smoothScrollToPosition(0);
    }
}
