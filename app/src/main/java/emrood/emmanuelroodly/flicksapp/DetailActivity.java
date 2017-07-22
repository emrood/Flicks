package emrood.emmanuelroodly.flicksapp;

import android.graphics.Color;
import android.graphics.PorterDuff;
import android.graphics.drawable.LayerDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import emrood.emmanuelroodly.flicksapp.models.Films;
import jp.wasabeef.picasso.transformations.RoundedCornersTransformation;

public class DetailActivity extends AppCompatActivity {

    TextView tvNom;
    TextView tvDate;
    RatingBar rbFilms;
    TextView tvOver;
    ImageView ivPoster;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        tvNom = (TextView) findViewById(R.id.tvNom);
        tvDate = (TextView) findViewById(R.id.tvDate);
        rbFilms = (RatingBar) findViewById(R.id.rbFilms);
        tvOver = (TextView) findViewById(R.id.tvO2);
        ivPoster = (ImageView) findViewById(R.id.ivPoster);
        rbFilms.setNumStars(5);
        rbFilms.setRating((float) 2.4);
        LayerDrawable stars = (LayerDrawable) rbFilms.getProgressDrawable();
        stars.getDrawable(2).setColorFilter(Color.YELLOW, PorterDuff.Mode.SRC_ATOP);
        /*Films u = (Films) getIntent().getSerializableExtra("films");
        tvNom.setText(u.getOriginalTitle());
        tvDate.setText(u.getReleaseDate());
        tvOver.setText(u.getOverview());*/
        //Picasso.with(getContext()).load(u.getBackdropPath()).transform(new RoundedCornersTransformation(30, 30)).placeholder(R.drawable.plh).into(ivPoster);

    }
}
