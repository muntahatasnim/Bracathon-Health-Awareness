package com.csedu.bracathon;

import android.app.Dialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class GridActivity extends AppCompatActivity {
    GridView gridView;
    private ImageView imageView;

    String[] Options = {"Training","Exam","Notification","Guide","Settings","Profile"};
    int[] OptionImage = {R.drawable.seminar,R.drawable.test,R.drawable.bell,R.drawable.books,R.drawable.settings,R.drawable.man};
    int cnt = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_grid);

        //finding listview
        gridView = findViewById(R.id.gridview);

        CustomAdapter customAdapter = new CustomAdapter();
        gridView.setAdapter(customAdapter);
        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                if(i == 0) {
                    Intent intent = new Intent(getApplicationContext(), TrainingActivity.class);
                    startActivity(intent);
                }
                else if (i == 1) {
                    Intent intent = new Intent(getApplicationContext(), Quiz_main_activity.class);
                    startActivity(intent);
                }
                else if (i == 2) {
                    Intent intent = new Intent(getApplicationContext(), NotificationActivity.class);
                    startActivity(intent);

                }
                else if (i == 3) {
                    Intent intent = new Intent(getApplicationContext(), GuideActivity.class);
                    startActivity(intent);

                }
                else if (i == 4) {
                    Intent intent = new Intent(getApplicationContext(), SettingsActivity.class);
                    startActivity(intent);

                }

                else {
                    Intent intent = new Intent(getApplicationContext(), ProfileActivity.class);
                    startActivity(intent);
                }
            }
        });


    }

    private class CustomAdapter extends BaseAdapter {
        @Override
        public int getCount() {
            return OptionImage.length;
        }

        @Override
        public Object getItem(int i) {
            return null;
        }

        @Override
        public long getItemId(int i) {
            return 0;
        }

        @Override
        public View getView(int i, View view, ViewGroup viewGroup) {
            View view1 = getLayoutInflater().inflate(R.layout.row_data,null);
            //getting view in row_data
            TextView name = view1.findViewById(R.id.fruits);
            ImageView image = view1.findViewById(R.id.images);

            name.setText(Options[i]);
            image.setImageResource(OptionImage[i]);
            return view1;



        }
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the main_menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch(item.getItemId()) {
            case R.id.item1:
                 MyAlertDialog();
                break;
            default:
                return super.onOptionsItemSelected(item);
        }

        return true;
    }
    public void MyAlertDialog(){
        final Dialog myDialog = new Dialog(this);
        myDialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        myDialog.setContentView(R.layout.activity_demo_dialog);
        myDialog.setTitle("App Demo");
        imageView = findViewById(R.id.imageView);

        Button skip = findViewById(R.id.skipp);
        Button next = findViewById(R.id.nextt);

        assert skip != null;


        skip.setEnabled(true);
        next.setEnabled(true);


        skip.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myDialog.cancel();
            }
        });

        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(cnt>5)myDialog.cancel();
                imageView.setImageResource(OptionImage[cnt]);
                cnt++;
            }
        });
        myDialog.show();
    }
}
