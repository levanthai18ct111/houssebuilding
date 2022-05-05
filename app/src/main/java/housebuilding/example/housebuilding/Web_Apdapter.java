package housebuilding.example.housebuilding;

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

import java.util.ArrayList;
import java.util.List;
import java.util.zip.Inflater;

public class Web_Apdapter extends ArrayAdapter<congTy> {
    Activity context;
    int resource;
    List<congTy> objects;
    public Web_Apdapter(@NonNull Activity context, int resource, @NonNull List<congTy> objects) {
        super(context, resource, objects);
        this.context=context;
        this.objects = objects;
        this.resource = resource;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View row, @NonNull ViewGroup parent) {
        LayoutInflater inflater = this.context.getLayoutInflater();
        row = inflater.inflate(this.resource, null);
        congTy ct = this.objects.get(position);

        ImageView img_ = row.findViewById(R.id.img);
        TextView ten_ = row.findViewById(R.id.txtTitle);
        TextView url = row.findViewById(R.id.txtUrl);

        img_.setImageResource(ct.getImg());
        ten_.setText(ct.getTen());
        url.setText(ct.getUrl());

        return row;
    }
}
