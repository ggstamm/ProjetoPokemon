package com.example.stamm.projetopokemon.Model;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.stamm.projetopokemon.R;

import java.util.ArrayList;

public class RecyclerViewAdapterHabilidades  extends RecyclerView.Adapter<RecyclerViewAdapterHabilidades.ViewHolder> {

    private ArrayList<Habilidades> mData;
    private LayoutInflater mInflater;
    private RecyclerViewAdapterHabilidades.ItemClickListener mClickListener;
    private Context context;
    private String type;

    public RecyclerViewAdapterHabilidades(Context context, ArrayList<Habilidades> data, String type) {
        this.mInflater = LayoutInflater.from(context);
        this.mData = data;
        this.context = context;
        this.type = type.substring(0,1).toUpperCase() + type.substring(1);
    }

    @Override
    public RecyclerViewAdapterHabilidades.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = mInflater.inflate(R.layout.recyclerview_row_tipos_pokemon, parent, false);

        return new RecyclerViewAdapterHabilidades.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(RecyclerViewAdapterHabilidades.ViewHolder holder, int position) {
        Habilidades habilidades = mData.get(position);
        String nome = habilidades.getAbility().getName().substring(0,1).toUpperCase() + habilidades.getAbility().getName().substring(1);
        holder.mTextView.setText(nome);
        switch (type){
            case "Normal" : holder.mLinearLayout.setBackground(context.getDrawable(R.drawable.rounded_corner_normal));
                break;
            case "Fighting": holder.mLinearLayout.setBackground(context.getDrawable(R.drawable.rounded_corner_fighting));
                break;
            case "Flying" : holder.mLinearLayout.setBackground(context.getDrawable(R.drawable.rounded_corner_flying));
                break;
            case "Poison": holder.mLinearLayout.setBackground(context.getDrawable(R.drawable.rounded_corner_poison));
                break;
            case "Ground" : holder.mLinearLayout.setBackground(context.getDrawable(R.drawable.rounded_corner_ground));
                break;
            case "Rock": holder.mLinearLayout.setBackground(context.getDrawable(R.drawable.rounded_corner_rock));
                break;
            case "Bug" : holder.mLinearLayout.setBackground(context.getDrawable(R.drawable.rounded_corner_bug));
                break;
            case "Ghost": holder.mLinearLayout.setBackground(context.getDrawable(R.drawable.rounded_corner_ghost));
                break;
            case "Steel" : holder.mLinearLayout.setBackground(context.getDrawable(R.drawable.rounded_corner_steel));
                break;
            case "Fire": holder.mLinearLayout.setBackground(context.getDrawable(R.drawable.rounded_corner_fire));
                break;
            case "Water" : holder.mLinearLayout.setBackground(context.getDrawable(R.drawable.rounded_corner_water));
                break;
            case "Grass": holder.mLinearLayout.setBackground(context.getDrawable(R.drawable.rounded_corner_grass));
                break;
            case "Electric" : holder.mLinearLayout.setBackground(context.getDrawable(R.drawable.rounded_corner_eletric));
                break;
            case "Psychic": holder.mLinearLayout.setBackground(context.getDrawable(R.drawable.rounded_corner_psychic));
                break;
            case "Ice" : holder.mLinearLayout.setBackground(context.getDrawable(R.drawable.rounded_corner_ice));
                break;
            case "Dragon": holder.mLinearLayout.setBackground(context.getDrawable(R.drawable.rounded_corner_dragon));
                break;
            case "Dark" : holder.mLinearLayout.setBackground(context.getDrawable(R.drawable.rounded_corner_dark));
                break;
            case "Fairy": holder.mLinearLayout.setBackground(context.getDrawable(R.drawable.rounded_corner_fairy));
                break;
            case "Unknown" : holder.mLinearLayout.setBackground(context.getDrawable(R.drawable.rounded_corner_unknown));
                break;
            case "Shadow": holder.mLinearLayout.setBackground(context.getDrawable(R.drawable.rounded_corner_shadow));
                break;
        }

    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        TextView mTextView;
        LinearLayout mLinearLayout;

        ViewHolder(View itemView) {
            super(itemView);
            mTextView = itemView.findViewById(R.id.tvNomeTipoPokemon);
            mLinearLayout = itemView.findViewById(R.id.linear_layout_recycler_view_row);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            if (mClickListener != null) mClickListener.onItemClick(view, getAdapterPosition());
        }
    }

    public Habilidades getItem(int id) {
        return mData.get(id);
    }

    public void setClickListener(RecyclerViewAdapterHabilidades.ItemClickListener itemClickListener) {
        this.mClickListener = itemClickListener;
    }

    public interface ItemClickListener {
        void onItemClick(View view, int position);
    }


}
