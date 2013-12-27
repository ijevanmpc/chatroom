package com.mpci.catalogsample;

import java.util.ArrayList;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
 
/*
 * In this activity, we're creating an adapter.
 * 
 * @authors Lilit & Serine
 */
 
public class CatalogAdapter extends BaseAdapter{
      private Context cont;                //Context object
      private LayoutInflater lInflater;    //Layout Inflater object
      private ArrayList<ListData> objects; //Create object of ArrayList
 /*
  * This is constructor
  */
      CatalogAdapter(Context context, ArrayList<ListData> mylist) {
              cont = context;
            objects = mylist;
            lInflater = (LayoutInflater) cont.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
          }
 /*
  * Returns the number of rows in the data array
  */
      public int getCount() {
        return objects.size();
      }
 /*
  * Returns an array of data that is at the position
  * @param position - element of the array data
  */
      public Object getItem(int position) {
            return objects.get(position);
      }
 /*
  * Returns the identifier of the data array element that is at the position
  * @param position - element of the array data
  */
      public long getItemId(int position) {
            return position;
     }
 /*
  * Forms for the position to position View,
  * responsible for displaying the string in the list. 
  * This method is the template elements are assigned specific values ​​of the dataset. 
  */
      public View getView(int position, View convertView, ViewGroup parent) {
        
        View view = convertView;
        if (view == null) {
          
          view = lInflater.inflate(R.layout.my_item, parent, false);
        }
 
        ListData p = ((ListData) getItem(position));
 
         //View fill in the list item data
        ((TextView) view.findViewById(R.id.textView1)).setText(p.name);
        ((TextView) view.findViewById(R.id.textView2)).setText("Age :" + p.age + "                ");
        ((ImageView) view.findViewById(R.id.imageView1)).setImageResource(p.image);
        return view;
      }      
}