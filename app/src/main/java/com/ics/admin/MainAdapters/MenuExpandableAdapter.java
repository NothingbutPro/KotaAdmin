package com.ics.admin.MainAdapters;

import android.app.Activity;
import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.graphics.Typeface;
import android.os.AsyncTask;
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

public class MenuExpandableAdapter extends BaseExpandableListAdapter {
    private final List<String> _MenuPermisssionslistDataHeader;
    private final ArrayList<MenuPermisssion> menuPermisssionheaderListStrings;
    private final HashMap<String, List<SubMenuPermissions>> _ListHashMaplistDataChild;
    //For Adapters
    Context _context;
    //
    //++++++++++++++++++++++++++++++++++++++++All Initializations++++++++++++++++++++
    Button addmantype, addmorekey, addmrdet, addmorepro, addmore_sub_serpro;
    Spinner spicatpro, spinsubcat;
    EditText Name;
    RecyclerView newkey, addmoredet, addmorepay, showkeys, showmoredeatils, addepros, showpays;
    EditText proname;
    //    RecyclerView showkeys,newkey;
    LayoutInflater infalInflater;
    private View ExpandView;
    private ToggleButton permtoggel;
    private TextView names;

    //++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
    public MenuExpandableAdapter(Context context, ArrayList<MenuPermisssion> menuPermisssionheaderListStrings,List<String> menuPermisssionList,
                                 HashMap<String, List<SubMenuPermissions>> SubMenuListHashMap) {
        this._context = context;
        this._MenuPermisssionslistDataHeader = menuPermisssionList;
        this._ListHashMaplistDataChild = SubMenuListHashMap;
        this.menuPermisssionheaderListStrings = menuPermisssionheaderListStrings;

    }



    @Override
    public Object getChild(int groupPosition, int childPosititon) {
        return this._ListHashMaplistDataChild.get(this._MenuPermisssionslistDataHeader.get(groupPosition))
                .get(childPosititon);
    }

    @Override
    public void onGroupExpanded(int groupPosition) {
        //      Log.e("Expanded view" , "groupPosition"+groupPosition);
//        if(groupPosition)
//        View view1 = ;
//        TextView names = ExpandView.findViewById(R.id.names);
//        names.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Toast.makeText(v.getContext(), "sfsdfsdf", Toast.LENGTH_SHORT).show();
//            }
//        });
        super.onGroupExpanded(groupPosition);
    }

    @Override
    public long getChildId(int groupPosition, int childPosition) {
        return childPosition;
    }

    @Override
    public View getChildView(int groupPosition, final int childPosition,
                             boolean isLastChild, View convertView, ViewGroup parent) {

//      final String childText =  getChild(groupPosition, childPosition);

        final SubMenuPermissions subMenuPermissions = (SubMenuPermissions) getChild(groupPosition, childPosition);
        Log.e("childPosition", "is " + childPosition);
        Log.e("groupPosition", "is groupPosition " + subMenuPermissions.getMenu_id());
        int itemType = getChildType(groupPosition, childPosition);
//        this.infalInflater = LayoutInflater.from(parent.getContext());
//        convertView.re
        LayoutInflater infalInflater = (LayoutInflater) this._context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
//            Toast.makeText(_context, "Basic", Toast.LENGTH_SHORT).show();
            //+++++++++++++++++++++++++++++++++++++++++++++++++++++++
            convertView = infalInflater.inflate(R.layout.subpermission, null);
            convertView.requestFocus();

            //++++++++++++++++++++++All Fields++++++++++++++++++++++++++++++++

            //+++++++++++++++++++++++++End++++++++++++++++++++++++++++++++++++++++++++++++++
//            proname =  convertView.findViewById(R.id.pronames);
            permtoggel = convertView.findViewById(R.id.permtoggel);
        names = convertView.findViewById(R.id.names);
        names.setText(String.valueOf(subMenuPermissions.getMenu_id()));

            return convertView;



    }

    @Override
    public int getChildrenCount(int groupPosition) {
        return this._ListHashMaplistDataChild.get(this._MenuPermisssionslistDataHeader.get(groupPosition))
                .size();
    }

    @Override
    public Object getGroup(int groupPosition) {
        return this._MenuPermisssionslistDataHeader.get(groupPosition);
    }

    @Override
    public int getGroupCount() {
        return this._MenuPermisssionslistDataHeader.size();
    }

    @Override
    public long getGroupId(int groupPosition) {
        return groupPosition;
    }

    @Override
    public View getGroupView(int groupPosition, boolean isExpanded,
                             View convertView, ViewGroup parent) {
        String headerTitle = (String) getGroup(groupPosition);
        this.ExpandView = convertView;
        //   Log.e("groupPosition", "is " + groupPosition);
        if (convertView == null) {
//            if(headerTitle.equals("Basic Information")) {
            Toast.makeText(_context, "BAsic", Toast.LENGTH_SHORT).show();
            LayoutInflater infalInflater = (LayoutInflater) this._context
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = infalInflater.inflate(R.layout.menuinfogroup, null);

        }

        TextView lblListHeader = (TextView) convertView
                .findViewById(R.id.lblListHeader);

        lblListHeader.setTypeface(null, Typeface.BOLD);
        lblListHeader.setText(headerTitle);
        notifyDataSetChanged();
        return convertView;
    }

    @Override
    public boolean hasStableIds() {
        return false;
    }

    @Override
    public boolean isChildSelectable(int groupPosition, int childPosition) {
        return true;
    }



    ////////////////////////////////////////////////////////////////end of/////////////////////////
    //+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
}