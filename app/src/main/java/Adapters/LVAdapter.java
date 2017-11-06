package Adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import Utils.ColorUtils;
import co.google.rvvslv.R;

public class LVAdapter extends ArrayAdapter<Integer> {
    private int mNumItems;
    private static int viewHolderCount;
    public LVAdapter(@NonNull Context context, int numItems) {
        super(context,-1);
        mNumItems = numItems;
        viewHolderCount = 0;
    }

    @Override
    public int getCount() {
        return mNumItems;
    }

    @Override
    public View getView(int position, View convertView,@NonNull ViewGroup parent) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View listItemView = inflater.inflate(R.layout.list_item, parent, false);
        listItemView.setBackgroundColor(ColorUtils.
                getViewHolderBackgroundColorFromInstance(parent.getContext(), viewHolderCount));

        TextView itemNumberView = (TextView) listItemView.findViewById(R.id.tv_item_number);
        TextView viewHolderCountView = (TextView) listItemView.findViewById(R.id.tv_view_holder_instance);
        itemNumberView.setText(String.valueOf(position));
        viewHolderCountView.setText("View Holder Instance: " + viewHolderCount);

        viewHolderCount++;
        return listItemView;
    }
}
