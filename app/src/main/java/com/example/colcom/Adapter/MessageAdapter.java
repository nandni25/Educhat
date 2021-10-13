package com.example.colcom.Adapter;

import android.content.Context;
import android.graphics.Color;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.colcom.R;
import com.example.colcom.models.AllMethods;
import com.example.colcom.models.Message;
import com.google.firebase.database.DatabaseReference;

import java.util.List;

public class MessageAdapter extends RecyclerView.Adapter<MessageAdapter.MessageAdapterViewHolder> {
    Context context;
    List<Message> mess;
    DatabaseReference dr;

    public MessageAdapter(Context context,List<Message> mess,DatabaseReference dr){
        this.context=context;
        this.mess=mess;
        this.dr=dr;
    }
    public MessageAdapterViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(context).inflate(R.layout.item_message,parent,false);
        return new MessageAdapterViewHolder(view);

    }

    @Override
    public void onBindViewHolder(@NonNull MessageAdapterViewHolder holder, int position) {
Message message=mess.get(position);
if(message.getName().equals(AllMethods.name)){
    holder.txt.setText("you"+message.getMessage());
    holder.txt.setGravity(Gravity.START);

}
else{
    holder.txt.setText(message.getName()+ " "+message.getMessage());
    holder.ibtn.setVisibility(View.GONE);

}
    }

    @Override
    public int getItemCount() {
        return mess.size();
    }

    public class MessageAdapterViewHolder extends RecyclerView.ViewHolder{
TextView txt;
ImageButton ibtn;
LinearLayout li;
        public MessageAdapterViewHolder(@NonNull View itemView) {
            super(itemView);
            txt=(TextView) itemView.findViewById(R.id.tvtitle);
            ibtn=(ImageButton) itemView.findViewById(R.id.del);
            li=(LinearLayout) itemView.findViewById(R.id.l1msg) ;

            ibtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    dr.child(mess.get(getAdapterPosition()).getKey()).removeValue();

                }
            });
        }
    }
}
