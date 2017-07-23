package emrood.emmanuelroodly.flicksapp;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.graphics.drawable.LayerDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;

import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.JsonHttpResponseHandler;
import com.squareup.picasso.Picasso;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

import cz.msebera.android.httpclient.Header;
import emrood.emmanuelroodly.flicksapp.models.Films;
import jp.wasabeef.picasso.transformations.RoundedCornersTransformation;

public class DetailActivity extends AppCompatActivity {

    TextView tvNom;
    TextView tvDate;
    TextView tvOver;
    TextView tvPop;
    ImageView ivPoster;
    RatingBar myRating;
    ArrayList<Films> films;
    Films u;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        tvNom = (TextView) findViewById(R.id.tvNom);
        tvDate = (TextView) findViewById(R.id.tvDate);
        tvOver = (TextView) findViewById(R.id.tvO2);
        ivPoster = (ImageView) findViewById(R.id.ivPoster);
        tvPop = (TextView) findViewById(R.id.tvPop);
        myRating = (RatingBar) findViewById(R.id.myRating);
        myRating.setEnabled(false);
        u = (Films) getIntent().getSerializableExtra("films");
        LayerDrawable etoiles = (LayerDrawable) myRating.getProgressDrawable();
        etoiles.getDrawable(2).setColorFilter(Color.YELLOW, PorterDuff.Mode.SRC_ATOP);
        tvNom.setText(u.getOriginalTitle());
        tvDate.setText(u.getReleaseDate());
        tvPop.setText("Popularity: " + String.valueOf(u.getPopulaire()));
        tvOver.setText(u.getOverview());
        myRating.setRating(u.getRating() / 2);
        Toast.makeText(DetailActivity.this, String.valueOf(myRating.getRating()), Toast.LENGTH_SHORT).show();
        Picasso.with(this).load(u.getBackdropPath()).transform(new RoundedCornersTransformation(30, 30)).placeholder(R.drawable.plh).into(ivPoster);




        ivPoster.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Toast.makeText(DetailActivity.this, "image click", Toast.LENGTH_SHORT).show();
                Intent youtube = new Intent(DetailActivity.this, YoutubeActivity.class);
                youtube.putExtra("flms", u);
                startActivity(youtube);

            }
        });

    }

}
