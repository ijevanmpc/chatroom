package com.mpci.catalogsample;

import java.util.ArrayList;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

/**
 * This activity is used to open Chat Room
 * 
 * @authors Lilit & Serine
 */
public class ChatRoomActivity extends Activity {
	private EditText editText;
	private Button mSend;
	private TextView mText;
	private ImageView mImg;
	public static final String EXT_TextToShow = "text";
	public static final String EXT_ImageToShow = "aaaa";

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.chat);

		//Getting data from MainListActivity
		Intent intent = getIntent();
		final String cells = intent.getStringExtra(EXT_TextToShow);
		final int img = intent.getIntExtra(EXT_ImageToShow, 7);
		
		//Connecting with chat.xml views
		mText = (TextView) findViewById(R.id.textView1);
		mText.setText(cells);
		
		mImg = (ImageView)findViewById(R.id.imageView);
		mImg.setImageResource(img);
		
		//Creating listview widget where we put messages
		ListView listView = (ListView) findViewById(R.id.list);
		editText = (EditText) findViewById(R.id.editText1);

		//Creating message array
		final ArrayList<String> masseges = new ArrayList<String>();

		//Creating adapter for listview
		final ArrayAdapter<String> adapter;
		adapter = new ArrayAdapter<String>(this,
				android.R.layout.simple_list_item_1, masseges);

		listView.setAdapter(adapter);

		mSend = (Button) findViewById(R.id.button2);

		//Listener for Send button which add messages to array
		mSend.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {
				String msg = editText.getText().toString();
				masseges.add(cells + ":    " + msg);
				adapter.notifyDataSetChanged();
				editText.setText("");
			}
		});
	}

}