package study.shpe.com.shpestudy.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import study.shpe.com.shpestudy.R;
import study.shpe.com.shpestudy.model.ListItem;


/**
 * Created by christian on 5/14/16.
 */
public class DerpAdapter extends RecyclerView.Adapter<DerpAdapter.DerpHolder>{

    private List<ListItem> listData;
    private LayoutInflater inflater;

    private ItemClickCallback itemClickCallback;

    public interface ItemClickCallback {
        void onItemClick(int p);
    }

    public void setItemClickCallback(final ItemClickCallback itemClickCallback) {
        this.itemClickCallback = itemClickCallback;
    }




    public DerpAdapter(List<ListItem> listData, Context c){
        inflater = LayoutInflater.from(c);
        this.listData = listData;
    }

    @Override
    public DerpAdapter.DerpHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.row, parent, false);
        return new DerpHolder(view);
    }

    @Override
    public void onBindViewHolder(DerpHolder holder, int position) {
        ListItem item = listData.get(position);
        holder.name.setText(item.name);
        holder.date.setText(item.date);
        holder.time.setText(item.time);
        holder.place.setText(item.place);

    }


    public void setListData(ArrayList<ListItem> exerciseList) {
        listData = exerciseList;
        notifyDataSetChanged();
    }

    @Override
    public int getItemCount() {
        return listData.size();
    }

    class DerpHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

        TextView name;
        TextView date;
        TextView time;
        TextView place;
        View container;

        public DerpHolder(View itemView) {
            super(itemView);
            name = (TextView)itemView.findViewById(R.id.eventName);
            date = (TextView)itemView.findViewById(R.id.eventDate);
            time = (TextView)itemView.findViewById(R.id.eventTime);
            place = (TextView)itemView.findViewById(R.id.eventLocation);
            container = (View)itemView.findViewById(R.id.cont_item_root);
            container.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            if (v.getId() == R.id.cont_item_root){
                itemClickCallback.onItemClick(getAdapterPosition());
            }
        }
    }
}