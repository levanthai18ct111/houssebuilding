package housebuilding.example.housebuilding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class WebAdapter extends RecyclerView.Adapter<WebAdapter.ViewHolder> {
    List<WebModel> modelList = new ArrayList<>();
    OnWebListener onWebListener;

    int select = -1;
    int preSelect = -1;




    // lúc nhâns thì cái imtem sẽ đc bôi đen -> tạo hiệu ứng
    public void setSelect(int i){
        preSelect = select;
        select = i;

        notifyItemChanged(preSelect);
        notifyItemChanged(select);
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_item, parent, false);
        return new ViewHolder(view);

    }


    @Override
    public void onBindViewHolder(@NonNull @org.jetbrains.annotations.NotNull WebAdapter.ViewHolder holder, int position) {
        WebModel webModel = modelList.get(position);

        holder.tvTitle.setText(webModel.getTitle());
        holder.tvLink.setText(webModel.getUrl());
        holder.img.setImageResource(webModel.getImg());

        holder.itemView.setOnClickListener(v -> {
            if(onWebListener != null){
                onWebListener.onWebClick(webModel, position);
            }
        });

        if(position == select){
            holder.mask.setVisibility(View.VISIBLE);
        }else {
            holder.mask.setVisibility(View.GONE);
        }
    }



    @Override
    public int getItemCount() {
        return modelList.size();
    }
    public void setOnWebListener(OnWebListener listener){
        onWebListener = listener;
    }

    public void setDate(List<WebModel> data){
        this.modelList = data;
        notifyDataSetChanged();
    }

    public interface OnWebListener{
        void onWebClick(WebModel webModel, int post);
    }

    public class ViewHolder  extends RecyclerView.ViewHolder{

        TextView tvTitle, tvLink;
        View mask;
        ImageView img;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tvTitle = itemView.findViewById(R.id.txtTitle);
            tvLink = itemView.findViewById(R.id.txtUrl);
            mask = itemView.findViewById(R.id.mask);
            img = itemView.findViewById(R.id.img);




        }
    }
}
