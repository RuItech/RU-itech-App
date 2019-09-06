package com.example.ru_itech.adapter;





import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.example.ru_itech.fragments.Home;
import com.example.ru_itech.fragments.Notification;
import com.example.ru_itech.fragments.PostFragment;
import com.example.ru_itech.fragments.Projects;
import com.example.ru_itech.fragments.RuStack;



public class PageAdapter extends FragmentPagerAdapter {




    public PageAdapter(FragmentManager fm) {
        super(fm);

    }

    @Override
    public Fragment getItem(int i) {

        switch (i){
            case 0 :
                return  new Home();
            case 1:
                return  new PostFragment();
            case 2:
                return new  Notification() ;
            case 3:
                return new Projects();
            case 4:
                return new RuStack();
            default:
                return  new Home();

        }


    }

    @Override
    public int getCount() {
        return 5;
    }
}
