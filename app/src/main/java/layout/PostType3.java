package layout;


import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.gainstudy.wishbone.Home;
import com.gainstudy.wishbone.R;
import com.pixelcan.inkpageindicator.InkPageIndicator;

/**
 * A simple {@link Fragment} subclass.
 */
public class PostType3 extends Fragment {

    ViewPager viewPager;
    public int[] GalImages = new int[]{
            R.drawable.kabali1,
            R.drawable.profile,
            R.drawable.userprofile
    };
    public int[] Answer = new int[]{
            R.drawable.correct,
            R.drawable.wrong,
    };
    ImageView swipeLeft, swipeRight, answer;
    TextView votes, answerMessage, ansSubtitle;
    LinearLayout layer2;
    InkPageIndicator mIndicator;
    public View root;

    private TextView[] dots;

    public PostType3() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        root = inflater.inflate(R.layout.fragment_post_type3, container, false);

        swipeLeft = (ImageView) root.findViewById(R.id.swipeleft);
        swipeRight = (ImageView) root.findViewById(R.id.swiperight);
        answer = (ImageView) root.findViewById(R.id.answer);
        votes = (TextView) root.findViewById(R.id.votes);
        answerMessage = (TextView) root.findViewById(R.id.answerMessage);
        ansSubtitle = (TextView) root.findViewById(R.id.ansSubtitle);

        layer2 = (LinearLayout) root.findViewById(R.id.layer2);

        viewPager = (ViewPager) root.findViewById(R.id.view_pager);
        ImageAdapter adapter = new ImageAdapter(getActivity());
        viewPager.setAdapter(adapter);
        mIndicator = (InkPageIndicator) root.findViewById(R.id.indicator);
        mIndicator.setViewPager(viewPager);
        return root;
    }

    public void controlVisible() {
        swipeLeft.setVisibility(View.VISIBLE);
        swipeRight.setVisibility(View.VISIBLE);
        votes.setVisibility(View.VISIBLE);
        layer2.setVisibility(View.VISIBLE);
        answer.setVisibility(View.VISIBLE);
        answerMessage.setVisibility(View.VISIBLE);
        ansSubtitle.setVisibility(View.VISIBLE);
    }

    public void controlGone() {
        swipeLeft.setVisibility(View.GONE);
        swipeRight.setVisibility(View.GONE);
        votes.setVisibility(View.GONE);
        layer2.setVisibility(View.GONE);
        answer.setVisibility(View.GONE);
        answerMessage.setVisibility(View.GONE);
        ansSubtitle.setVisibility(View.GONE);
        answer.setImageResource(Answer[1]);
        answerMessage.setText("You're Wrong");
        ansSubtitle.setText("Slide to know right answer");
    }

    public class ImageAdapter extends PagerAdapter {
        Context context;

        ImageAdapter(Context context) {
            this.context = context;
        }

        @Override
        public int getCount() {
            return GalImages.length;
        }

        @Override
        public boolean isViewFromObject(View view, Object object) {
            return view == ((ImageView) object);
        }

        @Override
        public Object instantiateItem(final ViewGroup container, final int position) {
            controlGone();
            final ImageView imageView = new ImageView(context);
            imageView.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
            imageView.setImageResource(GalImages[position]);

            ((ViewPager) container).addView(imageView, 0);
            imageView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (position == 0) {
                        controlVisible();
                        imageView.setAlpha(0.2f);
                        answer.setImageResource(Answer[0]);
                        answerMessage.setText("You're Right");
                        ansSubtitle.setText("You've earned +10 Coins");

                    } else {
                        controlVisible();
                        imageView.setAlpha(0.2f);
                    }


                }
            });
            return imageView;
        }

        @Override
        public void destroyItem(ViewGroup container, int position, Object object) {
            ((ViewPager) container).removeView((ImageView) object);
        }
    }
}
