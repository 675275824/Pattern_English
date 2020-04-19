package recommend_listview;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.a67527.pattern_english.R;
import Fragment_home.*;

import java.util.List;

import static android.provider.Settings.System.getString;

public class Recommend_Adpter extends BaseAdapter {
    private List<CardListView> data;
    private LayoutInflater layoutInflater;
    private Context context;
    private int selectedPositon=0;

    public Recommend_Adpter(Context context, List<CardListView> data){
        this.context=context;
        this.data=data;
        this.layoutInflater=LayoutInflater.from(context);
    }

    public void selectedItemPosition(int position) {
        this.selectedPositon = position;
    }
    //设点单个listview
    public final class Part{
        public ImageView imageView;
        public TextView litlle;
        public TextView time_item;
        public TextView include;

    }

    @Override
    public int getCount() {
        return data.size();
    }

    @Override
    public Object getItem(int position) {
        return data.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Part part=null;
        if(convertView==null){
            part = new Part();

            convertView=layoutInflater.inflate(R.layout.recommend_item,null);
            part.imageView=convertView.findViewById(R.id.avatar);
            part.litlle = convertView.findViewById(R.id.city);
            part.time_item = convertView.findViewById(R.id.date);
            part.include = convertView.findViewById(R.id.description);
            convertView.setTag(part);
        }else {
            part=(Part)convertView.getTag();
        }
        if(position==selectedPositon){
            convertView.setBackgroundColor(Color.parseColor("#ffffff"));
        }else{
            convertView.setBackgroundColor(Color.parseColor("#fffaf0"));
        }
        part.imageView.setImageResource(data.get(position).getImageId());
        part.litlle.setText(data.get(position).getLittle_title());
        part.time_item.setText(data.get(position).getTime_item());
        part.include.setText(data.get(position).getInclude());

       return convertView;
    }
}
