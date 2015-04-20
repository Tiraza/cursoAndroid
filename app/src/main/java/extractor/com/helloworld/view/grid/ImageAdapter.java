package extractor.com.helloworld.view.grid;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;

import extractor.com.helloworld.R;

public class ImageAdapter extends BaseAdapter {

    private Context context;
    public Integer[] mThumbIds = {
            R.drawable.and_1, R.drawable.and_2, R.drawable.and_3, R.drawable.and_4,
            R.drawable.and_5, R.drawable.and_6, R.drawable.and_7, R.drawable.and_1,
            R.drawable.and_2, R.drawable.and_3, R.drawable.and_4, R.drawable.and_5,
            R.drawable.and_6, R.drawable.and_7, R.drawable.and_1, R.drawable.and_2,
            R.drawable.and_3, R.drawable.and_4, R.drawable.and_5, R.drawable.and_6,
            R.drawable.and_7, R.drawable.and_1, R.drawable.and_2, R.drawable.and_3,
            R.drawable.and_4, R.drawable.and_5, R.drawable.and_6, R.drawable.and_7
    };

    public ImageAdapter (Context ctx){
        this.context = ctx;
    }

    @Override
    public int getCount() {
        return mThumbIds.length;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ImageView imageView;
        if(convertView == null){
            imageView = new ImageView(context);
            imageView.setLayoutParams(new GridView.LayoutParams(85, 85));
            imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
            imageView.setPadding(4,4,4,4);
        } else {
            imageView = (ImageView) convertView;
        }
        imageView.setImageResource(mThumbIds[position]);
        return imageView;
    }

}
