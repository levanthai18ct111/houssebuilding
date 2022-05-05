package housebuilding.example.housebuilding.adapter;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.squareup.picasso.Picasso;

import java.util.List;

import housebuilding.example.housebuilding.R;
import housebuilding.example.housebuilding.model.News;

public class New_adapter extends ArrayAdapter<News> {
    Activity context;
    int resource;
    List<News>objects;
    public New_adapter(@NonNull Activity context, int resource, @NonNull List<News> objects) {
        super(context, resource, objects);
        this.context = context;
        this.resource = resource;
        this.objects =objects;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View row, @NonNull ViewGroup parent) {
        LayoutInflater inflater = this.context.getLayoutInflater();
        row = inflater.inflate(this.resource,null);
        ImageView img = row.findViewById(R.id.img_new);
        TextView txt = row.findViewById(R.id.txt_tl);

        News news = this.objects.get(position);

        Picasso.with(context).load(news.getImage()).into(img);
        txt.setText(news.getTitle());
        return row;
    }
}
