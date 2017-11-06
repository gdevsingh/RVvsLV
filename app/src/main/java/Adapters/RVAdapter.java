package Adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import Utils.ColorUtils;
import co.google.rvvslv.R;

public class RVAdapter extends RecyclerView.Adapter<RVAdapter.RVViewHolder>{
    //final private RVListItemClickListener mRVListItemClickListener;

    private int mNumItems;
    private static int viewHolderCount;
    /*
    public interface RVListItemClickListener{
        void onRVListItemClick(int itemIndex);
    }
    */

    public RVAdapter(int numItems/*, RVListItemClickListener rvListItemClickListener*/){
        mNumItems = numItems;
        //mRVListItemClickListener = rvListItemClickListener;
        viewHolderCount = 0;
    }
    @Override
    public RVViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        Context context = viewGroup.getContext();
        int layoutIdForListItem = R.layout.list_item;
        LayoutInflater inflater = LayoutInflater.from(context);
        boolean shouldAttachToParentImmediately = false;

        View view = inflater.inflate(layoutIdForListItem, viewGroup, shouldAttachToParentImmediately);
        RVViewHolder viewHolder = new RVViewHolder(view);

        viewHolder.viewHolderNumberView.setText("ViewHolder index: " + viewHolderCount);

        int backgroundColorForViewHolder = ColorUtils
                .getViewHolderBackgroundColorFromInstance(context, viewHolderCount);
        viewHolder.itemView.setBackgroundColor(backgroundColorForViewHolder);

        viewHolderCount++;
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(RVViewHolder holder, int position) {
        holder.bind(position);
    }

    @Override
    public int getItemCount() {
        return mNumItems;
    }

    public class RVViewHolder extends RecyclerView.ViewHolder {
        TextView listItemNumberView;
        TextView viewHolderNumberView;

        public RVViewHolder(View itemView) {
            super(itemView);
            listItemNumberView = (TextView) itemView.findViewById(R.id.tv_item_number);
            viewHolderNumberView = (TextView) itemView.findViewById(R.id.tv_view_holder_instance);
        }
        void bind(int position){
            this.listItemNumberView.setText(String.valueOf(position));
        }
    }
}
