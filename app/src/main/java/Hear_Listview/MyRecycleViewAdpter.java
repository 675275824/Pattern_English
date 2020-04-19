package Hear_Listview;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.a67527.pattern_english.R;

import java.util.List;

public class MyRecycleViewAdpter extends RecyclerView.Adapter<MyRecycleViewAdpter.ViewHolder> {
    private List<ItemBean> mList;

    static class ViewHolder extends RecyclerView.ViewHolder{
        View myView;
        ImageView imageView;
        TextView title;
        public ViewHolder(View itemView) {
            super(itemView);
            myView = itemView;
            imageView = (ImageView) itemView.findViewById(R.id.iv_image);
            title = (TextView) itemView.findViewById(R.id.tv_title);
        }
    }

    public MyRecycleViewAdpter(List<ItemBean> list){
        this.mList = list;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.hear_item,null);
        final ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(ViewHolder viewHolder, int i) {
        ItemBean bean = mList.get(i);
        viewHolder.imageView.setBackgroundResource(bean.getImageId());
        viewHolder.title.setText(bean.getLittle_title());
    }

    @Override
    public int getItemCount() {
        return mList.size();
    }
    public void add(List<ItemBean> addMessageList) {
        //增加数据
        int position = mList.size();
        mList.addAll(position, addMessageList);
        notifyItemInserted(position);
    }

    public void refresh(List<ItemBean> newList) {
        //刷新数据
        mList.removeAll(mList);
        mList.addAll(newList);
        notifyDataSetChanged();
    }
}
