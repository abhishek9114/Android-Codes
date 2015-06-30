package com.example.androiddatabase;

import android.app.Activity;
import android.content.ContentResolver;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.provider.ContactsContract.PhoneLookup;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

public class ReadContactActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_read_contact);
		TextView t = (TextView) findViewById(R.id.contacts);
		ContentResolver cr = getContentResolver();
		Uri uri = ContactsContract.Contacts.CONTENT_URI;
		Cursor cbr = cr.query(uri, null, null, null, null);
		while(cbr.moveToNext())
		{
			int ni = cbr.getColumnIndex(PhoneLookup.DISPLAY_NAME);
			String name  = cbr.getString(ni);
			t.append("\n"+name);
		}
	}
}
