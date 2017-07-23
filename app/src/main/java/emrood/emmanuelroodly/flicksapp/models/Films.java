package emrood.emmanuelroodly.flicksapp.models;

import android.util.Log;
import android.widget.AdapterView;
import android.widget.Toast;

import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.JsonHttpResponseHandler;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.Serializable;
import java.util.ArrayList;

import cz.msebera.android.httpclient.Header;
import emrood.emmanuelroodly.flicksapp.MainActivity;

/**
 * Created by Emmanuel Roodly on 19/07/2017.
 */
public class Films implements Serializable{
    public static int i = 0;
    public String getPosterPath() {
        return String.format("https://image.tmdb.org/t/p/w342/%s", posterPath);
    }

    public String getOriginalTitle() {
        return originalTitle;
    }

    public String getOverview() {
        return overview;
    }

    String posterPath;
    String originalTitle;
    String overview;
    String backdropPath;



    String movieKey;
    double populaire;
    public static int movieId;

    public String getMovieKey() {
        return movieKey;
    }

    public void setMovieKey(String movieKey) {
        this.movieKey = movieKey;
    }

    public double getPopulaire() {
        return populaire;
    }



    public static int getMovieId() {
        return movieId;
    }



    public float getRating() {
        return this.rating;
    }

    float rating;

    public String getReleaseDate() {
        return releaseDate;
    }

    String releaseDate;

    public String getBackdropPath() {
        return String.format("https://image.tmdb.org/t/p/w1280/%s", backdropPath);
    }



    public Films(JSONObject j) throws JSONException {
        this.posterPath = j.getString("poster_path");
        this.originalTitle = j.getString("original_title");
        this.overview = j.getString("overview");
        this.backdropPath = j.getString("backdrop_path");
        this.releaseDate = j.getString("release_date");
        this.rating = Float.parseFloat(j.getString("vote_average"));
        this.movieId = j.getInt("id");
        this.populaire = Double.parseDouble(j.getString("popularity"));
        //this.movieKey = j.getString("key");
    }

    public static ArrayList<Films> fromJSONArray(JSONArray b){
        ArrayList<Films> results = new ArrayList<>();
        for(i = 0; i < b.length(); i++){
            try{
                results.add(new Films(b.getJSONObject(i)));
            } catch (JSONException e){
                e.printStackTrace();
            }

        }
        return results;
    }

}
