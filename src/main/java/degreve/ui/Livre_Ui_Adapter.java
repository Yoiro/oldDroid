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
import degreve.entities.Livre;

/**
 * Created by Simon on 12-12-16.
 */
public class Livre_Ui_Adapter extends ArrayAdapter<Livre>{
    private Context context;
    private int tuile_layout;
    private List<Livre> list;

    public Livre_Ui_Adapter(Context context, int resource, List<Livre> list){
        super(context,resource,list);
        this.context=context;
        tuile_layout=resource;
        this.list=list;
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent){
        Livre current=list.get(position);
        LayoutInflater inflater=(LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View tuile=inflater.inflate(this.tuile_layout,parent, false);
        TextView tvName=(TextView) tuile.findViewById(R.id.lvGetAll_nameLivre);
        tvName.setText(current.getTitre());
        return tuile;
    }
}
