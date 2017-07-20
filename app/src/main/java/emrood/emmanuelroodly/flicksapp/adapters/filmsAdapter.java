package emrood.emmanuelroodly.flicksapp.adapters;

import android.content.Context;
import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.List;

import emrood.emmanuelroodly.flicksapp.R;
import emrood.emmanuelroodly.flicksapp.models.Films;
import jp.wasabeef.picasso.transformations.RoundedCornersTransformation;

/**
 * Created by Emmanuel Roodly on 19/07/2017.
 */
public class filmsAdapter extends ArrayAdapter<Films>{
    public filmsAdapter(Context context, List<Films> films) {
        super(context, android.R.layout.simple_list_item_1, films);
    }
    Resources plh = getPlh();

    public Resources getPlh() {
        return plh;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        //pran donnee yo selon position yo
        Films movie = getItem(position);
        //tcheke reutilisation
        if(convertView == null){
            LayoutInflater inflater = LayoutInflater.from(getContext());
            convertView = inflater.inflate(R.layout.item_movie, parent, false);
        }
        ImageView ivFilms = (ImageView) convertView.findViewById(R.id.ivFilms);
        ivFilms.setImageResource(0);
        TextView tvTitle = (TextView) convertView.findViewById(R.id.tvTitle);
        TextView tvOverview = (TextView) convertView.findViewById(R.id.tvOverview);

        tvTitle.setText(movie.getOriginalTitle());
        tvOverview.setText(movie.getOverview());
        Picasso.with(getContext()).load(movie.getPosterPath()).transform(new RoundedCornersTransformation(30, 30)).placeholder(R.drawable.plh).into(ivFilms);
        return convertView;
    }
}
