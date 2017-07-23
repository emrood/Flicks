package emrood.emmanuelroodly.flicksapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import com.google.android.youtube.player.YouTubeBaseActivity;
import com.google.android.youtube.player.YouTubeInitializationResult;
import com.google.android.youtube.player.YouTubePlayer;
import com.google.android.youtube.player.YouTubePlayerView;
import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.JsonHttpResponseHandler;

import org.json.JSONObject;

import cz.msebera.android.httpclient.Header;

public class YoutubeActivity extends YouTubeBaseActivity {
    String videoKey;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_youtube);
        YouTubePlayerView  myPlayer = (YouTubePlayerView) findViewById(R.id.myPlayer);
        //getVideoId();
        myPlayer.initialize("AIzaSyDD1wWveHzVSAqFf9uCb3RwkS1yAsKVr_E", new YouTubePlayer.OnInitializedListener() {
            @Override
            public void onInitializationSuccess(YouTubePlayer.Provider provider, YouTubePlayer youTubePlayer, boolean b) {
                youTubePlayer.cueVideo("QtxvPRev3I8");
            }

            @Override
            public void onInitializationFailure(YouTubePlayer.Provider provider, YouTubeInitializationResult youTubeInitializationResult) {

            }
        });

    }
    /*
    public String getVideoId(){
        AsyncHttpClient client2 = new AsyncHttpClient();

        //String url2 = "https://api.themoviedb.org/3/movie/" + Films.getMovieId() + "/videos?api_key=AIzaSyCAqCSOu46rdDj3MFvh8LvHJNgruPuTee4";
        String url2 = "https://api.themoviedb.org/3/movie/209112/videos?api_key=a07e22bc18f5cb106bfe4cc1f83ad8ed";
        client2.get(url2, new JsonHttpResponseHandler(){
            @Override
            public void onSuccess(int statusCode, Header[] headers, JSONObject response) {
                super.onSuccess(statusCode, headers, response);
                Toast.makeText(YoutubeActivity.this, "video initial", Toast.LENGTH_SHORT).show();
                videoKey = "a1b567";
            }

        });
        return videoKey;
    }*/
}
