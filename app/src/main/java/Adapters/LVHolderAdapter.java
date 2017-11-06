package Adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import Utils.ColorUtils;
import co.google.rvvslv.R;

public class LVHolderAdapter extends ArrayAdapter<Integer> {
    private int mNumItems;
    private static int viewHolderCount;
    public LVHolderAdapter(@NonNull Context context, int numItems) {
        super(context,-1);
        mNumItems = numItems;
        viewHolderCount = 0;
    }

    @Override
    public int getCount() {
        return mNumItems;
    }

    @Override
    public View getView(int position, View convertView, @NonNull ViewGroup parent) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        ViewHolder holder;
        if(convertView == null) {
            convertView = inflater.inflate(R.layout.list_item, parent, false);

            convertView.setBackgroundColor(ColorUtils.
                    getViewHolderBackgroundColorFromInstance(parent.getContext(), viewHolderCount));

            holder = new ViewHolder();
            holder.itemNumberView = (TextView) convertView.findViewById(R.id.tv_item_number);
            holder.viewHolderCountView = (TextView) convertView.findViewById(R.id.tv_view_holder_instance);
            holder.viewHolderCountView.setText("View Holder Instance: " + viewHolderCount);

            viewHolderCount++;
            convertView.setTag(holder);
        }
        else{
            holder = (ViewHolder) convertView.getTag();
        }
        holder.itemNumberView.setText(String.valueOf(position));


        return convertView;
    }

    static class ViewHolder {
        private TextView itemNumberView;
        private TextView viewHolderCountView;
    }
}
