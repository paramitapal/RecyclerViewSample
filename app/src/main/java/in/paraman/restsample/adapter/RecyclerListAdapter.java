package in.paraman.restsample.adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

import in.paraman.restsample.R;
import in.paraman.restsample.model.Sample;

public class RecyclerListAdapter extends RecyclerView.Adapter<RecyclerListAdapter.SampleViewHolder> {

    private ArrayList<Sample> mData;
    private RowClickListener mRowClickListener;
    public RecyclerListAdapter(ArrayList<Sample> data)
    {
        mData = data;
    }
    @Override
    public void onBindViewHolder(@NonNull final RecyclerListAdapter.SampleViewHolder holder, final int position) {
        holder.text.setText(mData.get(position).getText());
        holder.text.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mRowClickListener.onClick(holder.text,position);
            }
        });

    }

    @NonNull
    @Override
    public RecyclerListAdapter.SampleViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.row_view,parent,false);
        return new SampleViewHolder(view);
    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    class SampleViewHolder extends RecyclerView.ViewHolder{

        TextView text;
        ImageView image;
        SampleViewHolder(View itemView)
        {
            super(itemView);
            text = itemView.findViewById(R.id.text);
            image = itemView.findViewById(R.id.image);
        }
    }

    public void setListener(RowClickListener rowClickListener)
    {
        mRowClickListener = rowClickListener;
    }
    public interface RowClickListener
    {
        void onClick(View view, int position);
    }
}
