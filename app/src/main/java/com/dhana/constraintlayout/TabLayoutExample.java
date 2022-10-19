package com.dhana.constraintlayout;

import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.tabs.TabLayout;

public class TabLayoutExample  extends AppCompatActivity {
    TabLayout tabLayouts;
    LinearLayout chatsLayout;
    LinearLayout statusLayout;
    LinearLayout callsLayout;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_tab_example);
        tabLayouts = (TabLayout)findViewById(R.id.tabsLayout);// initlaized
        chatsLayout  = (LinearLayout)findViewById(R.id.chatsLayout);
        statusLayout  = (LinearLayout)findViewById(R.id.statusLayout);
        callsLayout  = (LinearLayout)findViewById(R.id.callsLayout);
        tabLayouts.addTab(tabLayouts.newTab().setText("Chats"));//0
        tabLayouts.addTab(tabLayouts.newTab().setText("Status"));//1
        tabLayouts.addTab(tabLayouts.newTab().setText("Calls"));//2
        tabLayouts.setTabGravity(TabLayout.GRAVITY_FILL);
        tabLayouts.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                switch (tab.getPosition())
                {
                    case 0:
                    {
                        setVisibilty(chatsLayout,statusLayout,callsLayout);
                        break;
                    }
                    case 1:
                    {
                        setVisibilty(statusLayout,chatsLayout,callsLayout);
                        break;
                    }
                    case 2:
                    {
                        setVisibilty(callsLayout,chatsLayout,statusLayout);
                        break;
                    }
                }
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

    }

    private void setVisibilty(LinearLayout chatsLayout, LinearLayout statusLayout, LinearLayout callsLayout) {
        chatsLayout.setVisibility(View.VISIBLE);
        statusLayout.setVisibility(View.GONE);
        callsLayout.setVisibility(View.GONE);
    }
}
