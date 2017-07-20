package emrood.emmanuelroodly.flicksapp;


import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.util.Log;
import android.widget.ListView;
import android.widget.Toast;
import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.JsonHttpResponseHandler;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;


import cz.msebera.android.httpclient.Header;
import emrood.emmanuelroodly.flicksapp.adapters.filmsAdapter;
import emrood.emmanuelroodly.flicksapp.models.Films;

public class MainActivity extends AppCompatActivity {

    ArrayList<Films> films;
    filmsAdapter myAdapter;
    ListView lvFilms;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        lvFilms = (ListView) findViewById(R.id.lvFilms);
        films = new ArrayList<>();
        myAdapter = new filmsAdapter(this, films);
        lvFilms.setAdapter(myAdapter);
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
}
