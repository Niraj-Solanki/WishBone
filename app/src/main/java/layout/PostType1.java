package layout;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.gainstudy.wishbone.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class PostType1 extends Fragment {

public View root;
    public PostType1() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        root= inflater.inflate(R.layout.fragment_post_type1, container, false);
//        Display display = getActivity().getWindowManager().getDefaultDisplay();
//        ImageView iv = (ImageView) root.findViewById(R.id.postimage);
//        int width = display.getWidth(); // ((display.getWidth()*20)/100)
//        int height = display.getHeight();// ((display.getHeight()*30)/100)
//        LinearLayout.LayoutParams parms = new LinearLayout.LayoutParams(width,height);
//        iv.setLayoutParams(parms);
        return root;
    }

}
