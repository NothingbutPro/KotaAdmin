package com.ics.admin.MainAdapters;


import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.graphics.Typeface;
import android.os.AsyncTask;
import android.os.StrictMode;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.ArrayAdapter;
import android.widget.BaseExpandableListAdapter;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ToggleButton;

import com.ics.admin.Models.MenuPermisssion;
import com.ics.admin.Models.SubMenuPermissions;
import com.ics.admin.R;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;

import javax.net.ssl.HttpsURLConnection;

public class MenuExpandableAdapter extends RecyclerView.Adapter<MenuExpandableAdapter.MyViewHolder> {
    public static ArrayList<String> Myproducttiles = new ArrayList<>();
    public List<SubMenuPermissions> menuPermisssionList;
//    public List<SubMenuPermissions> subMenuPermisssionsList = new ArrayList<>();
    SubPermissionAdapter subPermissionAdapter;
    int pos_try;
    StrictMode.VmPolicy.Builder builder = new StrictMode.VmPolicy.Builder();
    private Context mContext;
    private SubMenuPermissions menuPermisssion;
    private RecyclerView subrec;

    public MenuExpandableAdapter(Context context, ArrayList<SubMenuPermissions> menuPermisssion) {
        mContext = context;
        this.menuPermisssionList = menuPermisssion;
        setHasStableIds(true);
    }

    @Override
    public MenuExpandableAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.subpermissionexpand, parent, false);
        return new MenuExpandableAdapter.MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final MenuExpandableAdapter.MyViewHolder holder, final int position) {
        menuPermisssion = menuPermisssionList.get(position);
        this.pos_try = position;
        holder.namestff.setText(menuPermisssionList.get(position).getMenu_name());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        StrictMode.setVmPolicy(builder.build());

    }

    @Override
    public int getItemCount() {
        return menuPermisssionList.size();
    }

    @Override
    public long getItemId(int position) {
//        return super.getItemId(position);
        return position;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        ImageView stffimg;
        TextView namestff, emailstff, stffid;
        ToggleButton maintoggel;

        public MyViewHolder(View itemView) {
            super(itemView);
            //   mname = (TextView) itemView.findViewById(R.id.mname);
            // manu_img =  itemView.findViewById(R.id.manu_img);
            namestff = itemView.findViewById(R.id.lblListHeader);
            maintoggel = itemView.findViewById(R.id.maintoggel);

            //     adddes =  itemView.findViewById(R.id.adddes);


        }
    }



  
}
