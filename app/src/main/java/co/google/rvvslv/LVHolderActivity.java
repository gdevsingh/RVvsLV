package co.google.rvvslv;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;

import Adapters.LVHolderAdapter;

public class LVHolderActivity extends AppCompatActivity {

    private ListView lvHolderList;
    private LVHolderAdapter lvHolderAdapter;
    private int mNumItems;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lvholder);
        mNumItems = getIntent().getIntExtra(MainActivity.LIST_SIZE_KEY, MainActivity.LIST_SIZE_DEFAULT);

        lvHolderList = (ListView) findViewById(R.id.lv_holder_list);
        lvHolderAdapter = new LVHolderAdapter(this, mNumItems);
        lvHolderList.setAdapter(lvHolderAdapter);
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
                lvHolderAdapter = new LVHolderAdapter(this, mNumItems);
                lvHolderList.setAdapter(lvHolderAdapter);
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}
