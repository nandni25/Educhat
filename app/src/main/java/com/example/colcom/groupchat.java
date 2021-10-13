package com.example.colcom;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.Toolbar;

import com.example.colcom.Adapter.adaptergrpcht;
import com.example.colcom.models.modelgroupchat;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.HashMap;

public class groupchat extends AppCompatActivity {
    private FirebaseAuth auth;
private String groupid;
private Toolbar toolbar;
private TextView grouptitle;
private ImageButton atch;
private EditText type;
private ImageButton send;
private RecyclerView rv;
private ArrayList<modelgroupchat> groupchatlist;
private adaptergrpcht adp;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_groupchat);
        toolbar=findViewById(R.id.tool);
        grouptitle=findViewById(R.id.grptlt);
        atch=findViewById(R.id.atchbtn);
        type=findViewById(R.id.msget);
        send=findViewById(R.id.sendbt);
        auth=FirebaseAuth.getInstance();
        rv=findViewById(R.id.chatrv);
        loadgrpinfo();
        loadgroupmessage();
        send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String messaage=type.getText().toString().trim();
                if(TextUtils.isEmpty(messaage)){
                    Toast.makeText(groupchat.this,"cant send empty message",Toast.LENGTH_SHORT).show();
                }
                else{
                    sendmsg(messaage);
                }
            }
        });
    }

    private void loadgroupmessage() {
        groupchatlist=new ArrayList<>();
        DatabaseReference reff=FirebaseDatabase.getInstance().getReference("groups");
        reff.child(groupid).child("messages").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                groupchatlist.clear();
                for(DataSnapshot ds: dataSnapshot.getChildren()){
                    modelgroupchat model=  ds.getValue(modelgroupchat.class);
                    groupchatlist.add(model);
                }
                adp=new adaptergrpcht(groupchat.this,groupchatlist);
                rv.setAdapter(adp);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }

    private void sendmsg(final String messaage) {
        String timestamp=" "+System.currentTimeMillis();
        HashMap<String, Object> has=new HashMap<>();
        has.put("sender"," "+auth.getUid());
        has.put("message"," "+messaage);
        has.put("timesTamp",""+timestamp);
        has.put("type",""+"text");
        DatabaseReference ref= FirebaseDatabase.getInstance().getReference("Groups");
        ref.child(groupid).child("messages").child(timestamp)
                .setValue(has)
                .addOnSuccessListener(new OnSuccessListener<Void>() {
                    @Override
                    public void onSuccess(Void aVoid) {
              type.setText("");
                    }
                })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Toast.makeText(groupchat.this,""+e.getMessage(),Toast.LENGTH_SHORT).show();
                    }
                });

    }

    private void loadgrpinfo() {
        DatabaseReference ref= FirebaseDatabase.getInstance().getReference("Groups");
        ref.orderByChild("groupid").equalTo(groupid).addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                for(DataSnapshot ds: dataSnapshot.getChildren()){
                    String groupt= ""+ds.child("groupti").getValue();
                    String groupdis= ""+ds.child("groupdis").getValue();
                    grouptitle.setText(groupt);

                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

    }
}