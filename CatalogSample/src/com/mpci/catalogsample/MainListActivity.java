package com.mpci.catalogsample;


import java.util.ArrayList;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ListView;

/**
 * This activity is used to put images and text in array
 * 
 * @authors Lilit & Serine
 */
 
public class MainListActivity extends ListActivity {
    
   
    private ArrayList<ListData> catalog;
    /* 
     * This are names array
     */
    String[] names = { "Hovik Beglaryan", "Serine Bejanyan", "Lilit Antonyan",
            "Artush Markosyan", "Artak Niazyan", "Roza Martirosyan"};
      /*
       *This are ages array                      
       */
    int[] age={30,21,20,22,24,22};
    /*
     *This are images array                      
     */
    
    int[] img={R.drawable.hov,R.drawable.ser,R.drawable.lil,
                    R.drawable.art,R.drawable.artk,R.drawable.roz}; 
    
    int a=10;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_list);
        /*
         *Create an array of objects ListData and fill them with data                  
         */
        Log.i("aa",String.valueOf(img[0]));
        catalog = new ArrayList<ListData>();
        for (int i = 0; i <names.length ; i++) 
        {
        	
        		 catalog.add(new ListData(names[i], age[i], img[i]));
            		
        }
 
        /*
         * Create a data adapter
         */
        CatalogAdapter catalogAdapter;
        catalogAdapter = new CatalogAdapter(this, catalog);
        setListAdapter(catalogAdapter);
    }    
    
    public void onListItemClick(ListView parent, View v, int position, long id){
    	
        Intent intent = new Intent(this, ChatRoomActivity.class);            
        intent.putExtra(ChatRoomActivity.EXT_TextToShow, catalog.get(position).name);
        intent.putExtra(ChatRoomActivity.EXT_ImageToShow, catalog.get(position).image);
        startActivity(intent);
    }
}
