package emrood.emmanuelroodly.flicksapp.models;

import android.widget.AdapterView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

/**
 * Created by Emmanuel Roodly on 19/07/2017.
 */
public class Films {
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

    public double getRating() {
        return rating;
    }

    double rating;

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
        this.rating = j.getDouble("vote_average");
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
