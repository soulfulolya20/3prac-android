package com.example.practical3;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.widget.TableLayout;
import android.widget.Toast;

import com.google.android.material.tabs.TabLayout;

public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        // assigning ID of the toolbar to a variable
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);

        // using toolbar as ActionBar
        setSupportActionBar(toolbar);

        // showing the back button in action bar
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        //get tab
        TabLayout tab = (TabLayout) findViewById(R.id.tab);
        int[] imageResId = {
               com.google.android.material.R.drawable.abc_ic_clear_material,
                com.google.android.material.R.drawable.abc_ic_clear_material,
                com.google.android.material.R.drawable.abc_ic_clear_material
        };

        for (int i = 0; i < imageResId.length; i++) {
            tab.getTabAt(i).setIcon(imageResId[i]);
            tab.getTabAt(i).setText("Счастье");
        }

        SecondActivity secondActivity = this;

        tab.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                switch(tab.getPosition()) {
                    case 0:
                        Toast.makeText(secondActivity, "Это счастье 1", Toast.LENGTH_SHORT).show();
                        break;
                    case 1:
                        Toast.makeText(secondActivity, "Это счастье 2", Toast.LENGTH_SHORT).show();
                        break;
                    case 2:
                        Toast.makeText(secondActivity, "Это счастье 3", Toast.LENGTH_SHORT).show();
                        break;
                }
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {}

            @Override
            public void onTabReselected(TabLayout.Tab tab) {}
        });

    }

    // this event will enable the back
    // function to the button on press
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                this.finish();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }
}