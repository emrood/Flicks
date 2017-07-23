package emrood.emmanuelroodly.flicksapp;


import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.Toast;
import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.JsonHttpResponseHandler;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;


import cz.msebera.android.httpclient.Header;
import emrood.emmanuelroodly.flicksapp.adapters.filmsAdapter;
import emrood.emmanuelroodly.flicksapp.adapters.filmsAdapterL;
import emrood.emmanuelroodly.flicksapp.models.Films;

public class MainActivity extends AppCompatActivity {

    ArrayList<Films> films;
    filmsAdapter myAdapter;
    ListView lvFilms;
    filmsAdapterL myAdapter2;
    JSONObject j;
    int ot;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        lvFilms = (ListView) findViewById(R.id.lvFilms);
        films = new ArrayList<>();
        myAdapter = new filmsAdapter(this, films);
        myAdapter2 = new filmsAdapterL(this, films);
        ot = getResources().getConfiguration().orientation;
        if(ot == 1){
            lvFilms.setAdapter(myAdapter);
        }
        if(ot == 2){
            lvFilms.setAdapter(myAdapter2);
        }


        //lvFilms.setAdapter(myAdapter);
        lvFilms.setOnItemClickListener(new ListView.OnItemClickListener(){
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                Films movie = (Films) lvFilms.getItemAtPosition(position);
                Intent detail = new Intent(MainActivity.this, DetailActivity.class);
                detail.putExtra("films", movie);
                startActivity(detail);

            }
        });

        fetchMoviewAsync();
        //getVideoId();

    }

    public void fetchMoviewAsync() {
        String url = "https://api.themoviedb.org/3/movie/now_playing?api_key=a07e22bc18f5cb106bfe4cc1f83ad8ed";

        AsyncHttpClient client = new AsyncHttpClient();
        client.get(url, new JsonHttpResponseHandler(){
            @Override
            public void onSuccess(int statusCode, Header[] headers, JSONObject response) {
                //super.onSuccess(statusCode, headers, response);
                JSONArray filmJSONResults = null;
                try {
                    filmJSONResults = response.getJSONArray("results");
                    myAdapter.notifyDataSetChanged();
                    myAdapter2.notifyDataSetChanged();
                    films.addAll(Films.fromJSONArray(filmJSONResults));
                    Log.d("DEBUG", films.toString());
                    Toast.makeText(MainActivity.this, "Connection", Toast.LENGTH_SHORT).show();

                } catch (JSONException e) {
                    e.printStackTrace();
                    Toast.makeText(MainActivity.this, "erreur", Toast.LENGTH_SHORT).show();
                }

                Log.d("debug", "connection succed");
            }

            @Override
            public void onFailure(int statusCode, Header[] headers, String responseString, Throwable throwable) {
                super.onFailure(statusCode, headers, responseString, throwable);
                Log.d("debug", "connection failed");
                Toast.makeText(MainActivity.this, "Connection echoue", Toast.LENGTH_SHORT).show();
            }
        });

    }
    /*
    String videoKey;
    public String getVideoId(){
        AsyncHttpClient client = new AsyncHttpClient();

        //String url2 = "https://api.themoviedb.org/3/movie/" + Films.getMovieId() + "/videos?api_key=AIzaSyCAqCSOu46rdDj3MFvh8LvHJNgruPuTee4";
        String url2 = "https://api.themoviedb.org/3/movie/209112/videos?api_key=a07e22bc18f5cb106bfe4cc1f83ad8ed";
        client.get(url2, new JsonHttpResponseHandler(){
            @Override
            public void onSuccess(int statusCode, Header[] headers, JSONObject response) {
                super.onSuccess(statusCode, headers, response);
                Toast.makeText(MainActivity.this, "video initial", Toast.LENGTH_SHORT).show();
                videoKey = "a1b567";
            }

        });
        return videoKey;
    }
    */
}
