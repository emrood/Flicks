package emrood.emmanuelroodly.flicksapp.adapters;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.List;

import emrood.emmanuelroodly.flicksapp.MainActivity;
import emrood.emmanuelroodly.flicksapp.R;
import emrood.emmanuelroodly.flicksapp.models.Films;
import jp.wasabeef.picasso.transformations.RoundedCornersTransformation;

/**
 * Created by Emmanuel Roodly on 19/07/2017.
 */
public class filmsAdapterL extends ArrayAdapter<Films>{
    public filmsAdapterL(Context context, List<Films> films) {
        super(context, android.R.layout.simple_list_item_1, films);

    }
    Resources plh = getPlh();

    public Resources getPlh() {
        return plh;
    }

    private static class ViewHolder {
        TextView tvTitle;
        TextView tvOverview;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        //pran donnee yo selon position yo
        Films movie = getItem(position);
        ViewHolder viewHolder;
        //tcheke reutilisation
        if(convertView == null){
            LayoutInflater inflater = LayoutInflater.from(getContext());
            convertView = inflater.inflate(R.layout.item_movie, parent, false);

            viewHolder = new ViewHolder();
            viewHolder.tvTitle = (TextView) convertView.findViewById(R.id.tvTitle);
            viewHolder.tvOverview = (TextView) convertView.findViewById(R.id.tvOverview);
            convertView.setTag(viewHolder);

        }
        else{
            viewHolder = (ViewHolder) convertView.getTag();
        }
        ImageView ivFilms = (ImageView) convertView.findViewById(R.id.ivFilms);
        ivFilms.setImageResource(0);
        TextView tvTitle = (TextView) convertView.findViewById(R.id.tvTitle);
        TextView tvOverview = (TextView) convertView.findViewById(R.id.tvOverview);

        viewHolder.tvTitle.setText("Film title");
        viewHolder.tvOverview.setText("FIlm overview");

        tvTitle.setText(movie.getOriginalTitle());
        tvOverview.setText(movie.getOverview());
        /*
        Configuration _newConfig = new Configuration();
        if(_newConfig.orientation == Configuration.ORIENTATION_PORTRAIT){
            Picasso.with(getContext()).load(movie.getPosterPath()).transform(new RoundedCornersTransformation(30, 30)).placeholder(R.drawable.plh).into(ivFilms);
        }
        else{
            Picasso.with(getContext()).load(movie.getBackdropPath()).transform(new RoundedCornersTransformation(5, 5)).placeholder(R.drawable.plh).into(ivFilms);
        }*/
        Picasso.with(getContext()).load(movie.getBackdropPath()).transform(new RoundedCornersTransformation(30,30)).placeholder(R.drawable.plh).into(ivFilms);
        //Picasso.with(getContext()).load(movie.getPosterPath()).transform(new RoundedCornersTransformation(30, 30)).placeholder(R.drawable.plh).into(ivFilms);
        return convertView;
    }

}