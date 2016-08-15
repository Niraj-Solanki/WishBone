package layout;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;

import com.gainstudy.wishbone.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class PostType2 extends Fragment {

ImageView message;
    public View root;
    public PostType2() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        root= inflater.inflate(R.layout.fragment_post_type2, container, false);
        message=(ImageView)root.findViewById(R.id.message);
        message.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getActivity().getApplicationContext(),"Clicked",Toast.LENGTH_LONG).show();
            }
        });
        return root;
    }

}
