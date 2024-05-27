package com.example.mynotes20.Adater;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mynotes20.Models.Notes;
import com.example.mynotes20.NotesCL;
import com.example.mynotes20.R;

import java.util.List;

public class NotesListAdapter extends RecyclerView.Adapter<NotesViewHolder>{
    Context context;
    List<Notes> list;

    NotesCL listener;

    public NotesListAdapter(Context context, java.util.List<Notes> list, NotesCL listener) {
        this.context = context;
        this.list = list;
        this.listener = listener;
    }

    @NonNull
    @Override
    public NotesViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) { //на он креэйт содается новый холдер
        return new NotesViewHolder(LayoutInflater.from(context).inflate(R.layout.notes_list,parent,false));

    }


    @Override
    public void onBindViewHolder(@NonNull NotesViewHolder holder, int position) { //получаем инфо
        holder.tv_title.setText(list.get(position).getTitle());
        holder.tv_title.setSelected(true);

        holder.tv_notes.setText(list.get(position).getNotes());

        holder.tv_date.setText(list.get(position).getDate());
        holder.tv_date.setSelected(true);

        if(list.get(position).isPinned()){
            holder.iv_pin.setImageResource(R.drawable.ic_pin);
        }
        else {
            holder.iv_pin.setImageResource(0);
        }
        holder.notes_container.setCardBackgroundColor(holder.itemView.getResources().getColor(R.color.light_gray,null));


        holder.notes_container.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listener.onClick(list.get(holder.getAdapterPosition()));
            }
        });

        holder.notes_container.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                listener.onLongClick(list.get(holder.getAdapterPosition()),holder.notes_container);
                return true;
            }
        });

    }


    @Override
    public int getItemCount() {
        return list.size();
    }

    public void filterList(List<Notes> filteredList){
        list = filteredList;
        notifyDataSetChanged();
    }
}
class NotesViewHolder extends RecyclerView.ViewHolder{
    CardView notes_container;
    TextView tv_title,tv_notes, tv_date;
    ImageView iv_pin;

    public NotesViewHolder(@NonNull View itemView) { //создаем холдер для отображения списка
        super(itemView);

        notes_container = itemView.findViewById(R.id.notes_container);
        tv_title = itemView.findViewById(R.id.tv_title);
        tv_notes = itemView.findViewById(R.id.tv_notes);
        tv_date = itemView.findViewById(R.id.tv_date);
        iv_pin = itemView.findViewById(R.id.iv_pin);

    }
}
