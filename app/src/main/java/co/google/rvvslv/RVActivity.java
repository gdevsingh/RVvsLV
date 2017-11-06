package co.google.rvvslv;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuItem;

import Adapters.RVAdapter;

public class RVActivity extends AppCompatActivity {
    private RecyclerView rvList;
    private RVAdapter rvAdapter;
    private int mNumItems;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rv);

        mNumItems = getIntent().getIntExtra(MainActivity.LIST_SIZE_KEY, MainActivity.LIST_SIZE_DEFAULT);

        rvList = (RecyclerView) findViewById(R.id.rvList);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        rvList.setLayoutManager(linearLayoutManager);

        rvList.setHasFixedSize(true);

        rvAdapter = new RVAdapter(mNumItems);
        rvList.setAdapter(rvAdapter);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.rv_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int itemID = item.getItemId();
        switch(itemID){
            case R.id.rvReset:
                rvAdapter = new RVAdapter(mNumItems);
                rvList.setAdapter(rvAdapter);
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}
