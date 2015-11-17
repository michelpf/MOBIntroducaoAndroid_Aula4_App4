package br.com.fiap.mobintroducaoandroid_aula4_app4;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

/**
 * Created by michelfernandes on 07/08/15.
 */
public class MyAdapterAcoes extends BaseAdapter {

    private Context context;
    private List<MyItemAcoes> itens;


    private class ViewInternas {

        ImageView imgIcon;
        TextView txtTitle;
        CheckBox chkBox;
        EditText edtText;

    }

    public MyAdapterAcoes(Context context, List<MyItemAcoes> itens){
        this.context=context;
        this.itens=itens;
    }

    @Override
    public int getCount() {
        return itens.size();
    }

    @Override
    public Object getItem(int position) {
        return itens.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        final ViewInternas v;

        if (convertView == null){

            convertView = LayoutInflater.from(context).inflate(R.layout.myadapteracoes,null);
            v = new ViewInternas();
            v.txtTitle=((TextView) convertView.findViewById(R.id.text));
            v.imgIcon=((ImageView) convertView.findViewById(R.id.image));
            v.chkBox=((CheckBox) convertView.findViewById(R.id.checkBox));
            v.edtText=((EditText) convertView.findViewById(R.id.editText));
            convertView.setTag(v);
        }
        else
        {
            v = (ViewInternas) convertView.getTag();
        }

        final MyItemAcoes item = itens.get(position);

        v.txtTitle.setText(item.getNome());
        v.imgIcon.setImageResource(item.getStatus());
        v.edtText.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v2, boolean hasFocus) {
                if (!v.edtText.getText().toString().equals("")) {
                    item.setValor(Integer.valueOf(v.edtText.getText().toString()));
                }
            }
        });
        v.chkBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                v.edtText.setEnabled(v.chkBox.isChecked());
            }
        });

        return convertView;
    }

}
