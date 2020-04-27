package com.example.ess;

import android.content.res.ColorStateList;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;

import com.darwindeveloper.horizontalscrollmenulibrary.custom_views.HorizontalScrollMenuView;

public class Dashboard extends AppCompatActivity {

    HorizontalScrollMenuView scrollableMenuBar1;
    HorizontalScrollMenuView scrollableMenuBar2;

    ViewPager firstViewPager;
    LinearLayout sliderDotsPanel;
    ViewPager secondViewPager;
    LinearLayout sliderDotsPanel2;

    ProgressBar annualDaysProgressBar;
    private int dotsCount;
    private ImageView[] dots;
    private int dotsCount2;
    private ImageView[] dots2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);

        scrollableMenuBar1 = (HorizontalScrollMenuView) findViewById(R.id.scrollable_menu_1);
        scrollableMenuBar2 = (HorizontalScrollMenuView) findViewById(R.id.scrollable_menu_2);


        firstViewPager = (ViewPager) findViewById(R.id.firstViewPager);
        sliderDotsPanel =(LinearLayout) findViewById(R.id.SliderDots);
        secondViewPager = (ViewPager) findViewById(R.id.secondViewPager);
        sliderDotsPanel2 =(LinearLayout) findViewById(R.id.secondViewPagerDots);
        annualDaysProgressBar = (ProgressBar) findViewById(R.id.annual_days_progressBar);

        //to change progress bar color
        int colorInt = getResources().getColor(R.color.nav_drawer_ic_color);
        annualDaysProgressBar.setProgressTintList(ColorStateList.valueOf(colorInt));

        ViewPagerAdapter viewPagerAdapter = new ViewPagerAdapter(this);
        firstViewPager.setAdapter(viewPagerAdapter);
        //for second viewpager
        Dashboard2ndViewPagerAdapter dashboard2ndViewPagerAdapter = new Dashboard2ndViewPagerAdapter(this);
        secondViewPager.setAdapter(dashboard2ndViewPagerAdapter);

        dotsCount = viewPagerAdapter.getCount();
        dots = new ImageView[dotsCount];
        //for second viewpager
        dotsCount2 = dashboard2ndViewPagerAdapter.getCount();
        dots2 = new ImageView[dotsCount2];



        //To generate the number of dots
        for (int i = 0; i < dotsCount; i++){
            dots[i] = new ImageView(this);
            dots[i].setImageDrawable(ContextCompat.getDrawable(getApplicationContext(), R.drawable.nonactive_dot));

            LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);

            params.setMargins(8,0,8,0);

            sliderDotsPanel.addView(dots[i], params);

        }

        //for secondviewpager
        for (int i = 0; i < dotsCount2; i++){
            dots2[i] = new ImageView(this);
            dots2[i].setImageDrawable(ContextCompat.getDrawable(getApplicationContext(), R.drawable.nonactive_dot));

            LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);

            params.setMargins(8,0,8,0);

            sliderDotsPanel2.addView(dots2[i], params);

        }

        dots[0].setImageDrawable(ContextCompat.getDrawable(getApplicationContext(), R.drawable.active_dot));
        dots2[0].setImageDrawable(ContextCompat.getDrawable(getApplicationContext(), R.drawable.active_dot));


        firstViewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int i, float v, int i1) {

            }

            @Override
            public void onPageSelected(int position) {
                for(int i = 0 ; i < dotsCount; i++){
                    dots[i].setImageDrawable(ContextCompat.getDrawable(getApplicationContext(), R.drawable.nonactive_dot));
                }

                dots[position].setImageDrawable(ContextCompat.getDrawable(getApplicationContext(), R.drawable.active_dot));
            }

            @Override
            public void onPageScrollStateChanged(int i) {

            }
        });

        secondViewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int i, float v, int i1) {

            }

            @Override
            public void onPageSelected(int position) {
                for(int i = 0 ; i < dotsCount2; i++){
                    dots2[i].setImageDrawable(ContextCompat.getDrawable(getApplicationContext(), R.drawable.nonactive_dot));
                }

                dots2[position].setImageDrawable(ContextCompat.getDrawable(getApplicationContext(), R.drawable.active_dot));
            }

            @Override
            public void onPageScrollStateChanged(int i) {

            }
        });

        initScrollableMenu();
    }

    private void initScrollableMenu(){
        //first scrollable menu
        scrollableMenuBar1.addItem("Attendance", R.drawable.ic_home);
        scrollableMenuBar1.addItem("Payslip", R.drawable.ic_home);
        scrollableMenuBar1.addItem("Reach HR", R.drawable.ic_reach_hr);
        scrollableMenuBar1.addItem("Notice board", R.drawable.ic_home);
        scrollableMenuBar1.addItem("Something", R.drawable.ic_home);

        //second scrollable
        scrollableMenuBar2.addItem("Claims", R.drawable.ic_claims);
        scrollableMenuBar2.addItem("Calender", R.drawable.ic_calendar);
        scrollableMenuBar2.addItem("Documents", R.drawable.ic_documents);
        scrollableMenuBar2.addItem("Assessments", R.drawable.ic_assessments);
        scrollableMenuBar2.addItem("Others", R.drawable.ic_other);
    }
}
