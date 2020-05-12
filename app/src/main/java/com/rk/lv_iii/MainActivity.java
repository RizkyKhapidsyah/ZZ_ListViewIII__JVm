package com.rk.lv_iii;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    ListView IDJAVA_ListView;

    String[] ListNegara = {"Arab Saudi", "Indonesia", "Inggris", "Iraq", "Perancis", "Turki", "Turkmenistan"};
    Integer[] Bendera = {
            R.drawable.arab_saudi,
            R.drawable.indonesia,
            R.drawable.inggris,
            R.drawable.iraq,
            R.drawable.perancis,
            R.drawable.turki,
            R.drawable.turkmenistan
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /* Call the CustomAdapter cusntructor and pass the values you want to be shown in the listview */
        CustomAdapter Pencocok = new CustomAdapter(MainActivity.this, ListNegara, Bendera);

        IDJAVA_ListView = findViewById(R.id.IDXML_ListView);
        IDJAVA_ListView.setAdapter(Pencocok);
        IDJAVA_ListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String itemValue = (String) IDJAVA_ListView.getItemAtPosition(position);
                Toast.makeText(MainActivity.this, itemValue, Toast.LENGTH_SHORT).show();
            }
        });
    }
}

/* Create a separate ArrayAdapter class for your specific layout design for the listview */
class CustomAdapter extends ArrayAdapter<String> {
    private final Context Konteks;
    private final String[] Items;
    private final Integer[] Bendera;

    /* The constructor gets the values to be shown on the listview */
    public CustomAdapter(Context Konteks, String[] Items, Integer[] Bendera) {
        super(Konteks, R.layout.custom_layout, Items);
        this.Konteks = Konteks;
        this.Bendera = Bendera;
        this.Items = Items;
    }

    /*
        getView method inflates the values given from the mainactivity on the custom degisn layout for listview and return the layout with
        inflated values in it
     */

    @Override
    public View getView(int Posisi, View Tampil, ViewGroup IndukLihat) {
        LayoutInflater LI = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View TampilRow = LI.inflate(R.layout.custom_layout, null, true);

        /* Initialize the TextView and ImageView declared  in the custom_list.xml file */

        TextView IDJAVA_Text = TampilRow.findViewById(R.id.IDXML_Text);
        ImageView IDJAVA_Image = TampilRow.findViewById(R.id.IDXML_Image);

        IDJAVA_Text.setText(Items[Posisi]);
        IDJAVA_Image.setImageResource(Bendera[Posisi]);

        return TampilRow;
    }
}
