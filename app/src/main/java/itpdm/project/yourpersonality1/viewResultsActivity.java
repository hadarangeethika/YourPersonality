package itpdm.project.yourpersonality1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

import itpdm.project.yourpersonality1.data.DbHelper;

public class viewResultsActivity extends AppCompatActivity {
    ListView listResults;
    DbHelper dbHelper;
    ArrayList arrayList;
    ArrayAdapter arrayAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_results);

        dbHelper=new DbHelper(viewResultsActivity.this);


        listResults=findViewById(R.id.list_results);


        //Add db values to array list
        arrayList=dbHelper.getAllResults();

        //Initialize array adapter
        arrayAdapter=new ArrayAdapter(viewResultsActivity.this,
                R.layout.list_item,arrayList);

        //Set arraylist
        listResults.setAdapter(arrayAdapter);




        arrayList.clear();
        arrayList.addAll(dbHelper.getAllResults());
        arrayAdapter.notifyDataSetChanged();
        listResults.invalidateViews();
        listResults.refreshDrawableState();

    }

    public void tappedBackToDash(View view) {
        Intent intent = new Intent(viewResultsActivity.this,Dashboard1.class);
        startActivity(intent);
    }
}