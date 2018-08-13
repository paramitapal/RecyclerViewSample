package in.paraman.restsample;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import java.util.ArrayList;

import in.paraman.restsample.adapter.RecyclerListAdapter;
import in.paraman.restsample.model.Sample;

public class MainActivity extends AppCompatActivity implements RecyclerListAdapter.RowClickListener{

    private RecyclerView mRecyclerView;
    private RecyclerListAdapter mSampleAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mRecyclerView = findViewById(R.id.listOfData);
        loadJson();
    }

    private void loadJson()
    {

    }
    private void updateRecycleView(ArrayList<Sample> data)
    {
    mRecyclerView.setHasFixedSize(true);
    mSampleAdapter =new RecyclerListAdapter(data);
    RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(MainActivity.this);
    mRecyclerView.setLayoutManager(layoutManager);
    mSampleAdapter.setListener(this);
    mRecyclerView.setAdapter(mSampleAdapter);
    }

    @Override
    public void onClick(View view, int position) {

    }
}
