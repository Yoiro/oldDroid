package degreve.ui;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

import be.helha.degreve.la141353.degreve.R;
import degreve.entities.Editeur;

/**
 * Created by Simon on 11-12-16.
 */
public class Editor_Ui_Adapter extends ArrayAdapter<Editeur>{
    private Context context;
    private int tuile_layout;
    private List<Editeur> editeurList;

    public Editor_Ui_Adapter(Context context, int resource, List<Editeur> list){
        super(context,resource,list);
        this.context=context;
        tuile_layout=resource;
        editeurList=list;
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent){
        Editeur current=editeurList.get(position);
        LayoutInflater inflater=(LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View tuile=inflater.inflate(this.tuile_layout,parent, false);
        TextView tvName=(TextView) tuile.findViewById(R.id.lvGetAll_nameEditor);
        tvName.setText(current.getNom());
        return tuile;
    }

}
