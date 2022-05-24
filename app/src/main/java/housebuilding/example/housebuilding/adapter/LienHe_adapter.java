package housebuilding.example.housebuilding.adapter;

import android.app.Activity;
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
import housebuilding.example.housebuilding.model.LienHe;

public class LienHe_adapter extends ArrayAdapter<LienHe> {
    Activity context;
    int resource;
    List<LienHe> objects;
    public LienHe_adapter(@NonNull Activity context, int resource, @NonNull List<LienHe> objects) {
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
        TextView email = row.findViewById(R.id.txt_email_lh);
        TextView chude = row.findViewById(R.id.txt_chude);
        TextView date = row.findViewById(R.id.txt_date_lh);

        LienHe lienHe = this.objects.get(position);

        email.setText(lienHe.getEmail());
        chude.setText(lienHe.getChude());
        date.setText(lienHe.getDate());
        return row;
    }
}
