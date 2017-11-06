package co.google.rvvslv;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

public class MainActivity extends AppCompatActivity
implements AdapterView.OnItemSelectedListener{

    public static final int LIST_SIZE_DEFAULT = 100;
    public static final String LIST_SIZE_KEY = "list_size";
    private int mNumItems = LIST_SIZE_DEFAULT;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Spinner listSizeSpinner = (Spinner) findViewById(R.id.list_size_spinner);
        listSizeSpinner.setOnItemSelectedListener(this);

        ArrayAdapter<CharSequence> listSizeApapter = ArrayAdapter.createFromResource
                (this, R.array.list_sizes, R.layout.support_simple_spinner_dropdown_item);
        listSizeSpinner.setAdapter(listSizeApapter);
    }

    public void onClick(View v) {
        int viewID = v.getId();
        Intent listIntent = new Intent();

        switch (viewID){
            case R.id.bt_lvList:
                listIntent.setClass(this, LVActivity.class);
                listIntent.putExtra(LIST_SIZE_KEY, mNumItems);
                startActivity(listIntent);

                break;
            case R.id.bt_rvList:
                listIntent.setClass(this, RVActivity.class);
                listIntent.putExtra(LIST_SIZE_KEY, mNumItems);
                startActivity(listIntent);
                break;
            case R.id.bt_lvHolderList:
                listIntent.setClass(this, LVHolderActivity.class);
                listIntent.putExtra(LIST_SIZE_KEY, mNumItems);
                startActivity(listIntent);
                break;
        }
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        mNumItems = Integer.valueOf(parent.getItemAtPosition(position).toString());
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}
