package com.example.appholamundo1;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class SpinnerAdapter extends ArrayAdapter<ItemDataSpinner> {

    int groupId;

    Activity Context;
    ArrayList<ItemDataSpinner> list;

    LayoutInflater inflater;

    public SpinnerAdapter(Activity Context, int groupId, int id, ArrayList<ItemDataSpinner> list){
        super(Context, id, list);
        this.list = list;
        inflater = (LayoutInflater) Context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        this.groupId = groupId;
    }

    public View getView(int posicion, View converView, ViewGroup parent){
        View itemView = inflater.inflate(groupId, parent, false);

        ImageView imagen = (ImageView) itemView.findViewById(R.id.imgCategoria);
        imagen.setImageResource(list.get(posicion).getImageId());

        TextView textCategoria = (TextView) itemView.findViewById(R.id.lblCategorias);
        textCategoria.setText(list.get(posicion).getTextCategoria());

        TextView textDescripcion = (TextView) itemView.findViewById(R.id.lblDescripcion);
        textDescripcion.setText(list.get(posicion).getTextDescripcion());

        return itemView;
    }

    public View getDropDownView(int position,View convertView, ViewGroup parent){
        return getView(position, convertView, parent);
    }




}
