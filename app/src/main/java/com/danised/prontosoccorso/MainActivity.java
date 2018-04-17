package com.danised.prontosoccorso;

import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.widget.TextView;

import com.danised.prontosoccorso.ambulance.AmbulanceFragment;
import com.danised.prontosoccorso.hospital.HospitalFragment;
import com.danised.prontosoccorso.statistics.StatisticsFragment;

public class MainActivity extends AppCompatActivity implements AmbulanceFragment.OnFragmentInteractionListener, StatisticsFragment.OnFragmentInteractionListener, HospitalFragment.OnFragmentInteractionListener {

    private TextView mTextMessage;
    private BottomNavigationView bottomNavigation;
    private Fragment fragment;
    private FragmentManager fragmentManager;

//    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
//            = new BottomNavigationView.OnNavigationItemSelectedListener() {
//
//        @Override
//        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
//            switch (item.getItemId()) {
//                case R.id.navigation_home:
//                    mTextMessage.setText(R.string.title_home);
//                    return true;
//                case R.id.navigation_dashboard:
//                    mTextMessage.setText(R.string.title_missions);
//                    return true;
//                case R.id.navigation_notifications:
//                    mTextMessage.setText(R.string.title_statistics);
//                    return true;
//            }
//            return false;
//        }
//    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bottomNavigation = findViewById(R.id.navigation);
//        bottomNavigation.inflateMenu(R.menu.navigation);
        fragmentManager = getSupportFragmentManager();
        bottomNavigation.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                int id = item.getItemId();
                switch (id) {
                    case R.id.navigation_hospital:
                        fragment = HospitalFragment.newInstance("", "");
                        break;
                    case R.id.navigation_ambulance:
                        fragment = AmbulanceFragment.newInstance("", "");
                        break;
                    case R.id.navigation_statistics:
                        fragment = StatisticsFragment.newInstance("", "");
                        break;
                }
                final FragmentTransaction transaction = fragmentManager.beginTransaction();
                transaction.replace(R.id.main_container, fragment).commit();
                return true;
            }
        });

    }

    @Override
    public void onFragmentInteraction(Uri uri) {

    }
}

