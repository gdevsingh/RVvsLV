package co.google.rvvslv;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;

import Adapters.LVAdapter;

public class LVActivity extends AppCompatActivity {
    private ListView lvList;
    private LVAdapter lvAdapter;
    private int mNumItems;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lv);
        mNumItems = getIntent().getIntExtra(MainActivity.LIST_SIZE_KEY, MainActivity.LIST_SIZE_DEFAULT);

        lvList = (ListView) findViewById(R.id.lv_list);
        lvAdapter = new LVAdapter(this, mNumItems);
        lvList.setAdapter(lvAdapter);
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.rv_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int itemID = item.getItemId();
        switch (itemID) {
            case R.id.rvReset:
                lvAdapter = new LVAdapter(this, mNumItems);
                lvList.setAdapter(lvAdapter);
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}