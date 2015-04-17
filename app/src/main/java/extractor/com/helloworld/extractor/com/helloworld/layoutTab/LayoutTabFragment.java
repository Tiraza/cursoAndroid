package extractor.com.helloworld.extractor.com.helloworld.layoutTab;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import extractor.com.helloworld.R;

public class LayoutTabFragment extends Fragment {

    private Integer index;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Bundle data = getArguments();
        index = data.getInt("idx");
    }

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_layout_tab, null);
        TextView txtFragment = (TextView) v.findViewById(R.id.txtFragment);
        txtFragment.setText("Fragment: " + (index +1));
        return v;
    }
}
