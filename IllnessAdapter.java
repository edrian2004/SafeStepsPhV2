package com.example.safestepsphv2;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.content.Intent;
import android.widget.Button;
import android.widget.TextView;

import java.util.List;


public class IllnessAdapter extends BaseAdapter {

    private Context context;
    private List<IllnessBean> illnessList;
    private LayoutInflater inflater;

    public IllnessAdapter(Context context, List<IllnessBean> illnessList) {
        this.context = context;
        this.illnessList = illnessList;
        this.inflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return illnessList.size();
    }

    @Override
    public Object getItem(int position) {
        return illnessList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;
        if (convertView == null) {
            convertView = inflater.inflate(R.layout.item_illness, parent, false);
            holder = new ViewHolder();
            holder.btnIllness = convertView.findViewById(R.id.btnIllness);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }

        IllnessBean illness = illnessList.get(position);
        holder.btnIllness.setText(illness.getName());

        // Click on button opens detail activity
        holder.btnIllness.setOnClickListener(v -> {
            Intent intent = new Intent(context, IllnessDetailActivity.class);
            intent.putExtra("name", illness.getName());
            intent.putExtra("description", illness.getDescription());
            intent.putExtra("medicine", illness.getMedicine());
            context.startActivity(intent);
        });

        return convertView;
    }

    static class ViewHolder {
        Button btnIllness;
    }
}

