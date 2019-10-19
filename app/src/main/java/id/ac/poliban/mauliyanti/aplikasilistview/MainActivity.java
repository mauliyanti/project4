package id.ac.poliban.mauliyanti.aplikasilistview;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private ListView listView;

    //fungsinya buat menampung data item list yang bertipe Array
    private ArrayList<String> data = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //isi dari listviewkita
        data.add("Banjarmasin");
        data.add("Banjarbaru");
        data.add("Martapura");
        data.add("Rantau");
        data.add("Kandangan");
        data.add("Barabai");
        data.add("Tanjung");
        data.add("BatuLicin");
        data.add("Kotabaru");
        data.add("Alabio");
        data.add("Amuntai");
        data.add("Mandastanaa");
        data.add("Pelaihari");


        //hubungkan objeknya
        listView = findViewById(R.id.ListView);
        ArrayAdapter adapter = new ArrayAdapter(this,
                R.layout.support_simple_spinner_dropdown_item, data);

        //set adapter
        listView.setAdapter(adapter);

        //buat handling event
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                String s = "Anda Memilih : " + data.get(i);
                Toast.makeText(MainActivity.this, s, Toast.LENGTH_SHORT).show();
            }
        });
        listView.setOnItemLongClickListener(((adapterView, view, i, l) -> {
            data.remove(i);
            adapter.notifyDataSetChanged();
            return true;
        }));
    }
}
