package com.example.colcom.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.colcom.R;
import com.example.colcom.models.modelgroupchat;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class adaptergrpcht extends RecyclerView.Adapter<adaptergrpcht.Holdergroupchat> {
    private static final int MSG_TYPE_LEFT=0;
    private static final int MSG_TYPE_RIGHT=1;
    private ArrayList<modelgroupchat> modelgroupchatArrayList;
    private Context context;

    private FirebaseAuth auth;
   public  adaptergrpcht(Context context,ArrayList<modelgroupchat> modelgroupchatArrayList){
       this.context=context;
       this.modelgroupchatArrayList=modelgroupchatArrayList;
       auth=FirebaseAuth.getInstance();
   }

    @NonNull
    @Override
    public Holdergroupchat onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
       if(viewType==MSG_TYPE_RIGHT){
           View view=LayoutInflater.from(context).inflate(R.layout.new_groupchat_right,parent,false);
           return new Holdergroupchat(view);
       }
       else{
           View view=LayoutInflater.from(context).inflate(R.layout.new_groupchat,parent,false);
           return new Holdergroupchat(view);
       }

    }

    @Override
    public void onBindViewHolder(@NonNull Holdergroupchat holder, int position) {
modelgroupchat model=modelgroupchatArrayList.get(position);
String message=model.getMessage();
String senderuid=model.getSendar();
String Times=model.getTimestamp();
holder.mestv.setText(message);
setusername(model,holder);
    }

    private void setusername(modelgroupchat model, final Holdergroupchat holder) {
        DatabaseReference ref= FirebaseDatabase.getInstance().getReference("users");
        ref.orderByChild("uid").equalTo(model.getSendar())
                .addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                        for(DataSnapshot ds: dataSnapshot.getChildren()){
                            String a=""+ds.child("name").getValue();
                            holder.nametv.setText(a);
                        }
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {

                    }
                });
    }


    @Override
    public int getItemCount() {
        return modelgroupchatArrayList.size();
    }

    @Override
    public int getItemViewType(int position) {
        if(modelgroupchatArrayList.get(position).getSendar().equals(auth.getUid())){
            return MSG_TYPE_RIGHT;
        }
        else{
            return MSG_TYPE_LEFT;
        }
    }

    class Holdergroupchat extends RecyclerView.ViewHolder{
private TextView nametv,mestv,timetv;
       public Holdergroupchat(@NonNull View itemView) {

           super(itemView);
           nametv=itemView.findViewById(R.id.nametv);
           mestv=itemView.findViewById(R.id.messagetv);
           timetv=itemView.findViewById(R.id.timetv);
       }
   }

    }






