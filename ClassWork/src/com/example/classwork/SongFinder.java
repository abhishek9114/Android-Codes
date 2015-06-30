package com.example.classwork;

import java.io.File;
import java.io.FilenameFilter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import android.app.Activity;
import android.os.Bundle;
import android.os.Environment;
import android.widget.TextView;
import android.widget.Toast;

public class SongFinder extends Activity{
	  ArrayList<HashMap<String, String>> songsList = new ArrayList<HashMap<String, String>>();
	 String mp3Pattern = ".mp3";
	 String MEDIA_PATH;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.testing);
		File root = Environment.getExternalStorageDirectory();
		Map<String, File> externalLocations = ExternalStorage.getAllStorageLocations();
		File sdCard = externalLocations.get(ExternalStorage.SD_CARD);
		File externalSdCard = externalLocations.get(ExternalStorage.EXTERNAL_SD_CARD);
	 MEDIA_PATH = externalSdCard.getAbsolutePath()+"/";

		   // System.out.println(MEDIA_PATH);
		     if (MEDIA_PATH != null) {
		        File home = new File(MEDIA_PATH);
		        File[] listFiles = home.listFiles();
		        if (listFiles != null && listFiles.length > 0) {
		            for (File file : listFiles) {
		                if (file.isDirectory()) {
		                	//Toast.makeText(this,file.getAbsolutePath() , 1000).show();
		                    scanDirectory(file);
		                } else {
		                    addSongToList(file);
		                }
		            }
		        }

	}
	}
	// return songs list array
	public void scanDirectory(File directory) {
		// TODO Auto-generated method stub
		   if (directory != null) {
		        File[] listFiles = directory.listFiles();
		        if (listFiles != null && listFiles.length > 0) {
		            for (File file : listFiles) {
		                if (file.isDirectory()) {
		                	//Toast.makeText(this,file.getAbsolutePath() , 1000).show();
		                    scanDirectory(file);
		                } else {
		                    addSongToList(file);
		                }

		            }
		        }
		    }
	}
		    public void addSongToList(File song) {
				// TODO Auto-generated method stub
				    	 if (song.getName().endsWith(mp3Pattern)) {
				    		 Toast.makeText(this,song.getAbsolutePath() , 1000).show();
						        HashMap<String, String> songMap = new HashMap<String, String>();
						        songMap.put("songTitle",
						                song.getName().substring(0, (song.getName().length() - 4)));
						        songMap.put("songPath", song.getPath());

						        // Adding each song to SongList
						        songsList.add(songMap);
						    }
						}
	
}