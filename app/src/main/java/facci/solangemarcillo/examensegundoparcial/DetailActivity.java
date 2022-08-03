package facci.solangemarcillo.examensegundoparcial;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class DetailActivity extends AppCompatActivity{

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);


        TextView title_episode = findViewById(R.id.mtitle);
        TextView episode_episode = findViewById(R.id.mepisode);
        TextView season_episode = findViewById(R.id.mseason);



        Bundle bundle = getIntent().getExtras();

        String mtitle = bundle.getString("title");
        String mepisode = bundle.getString("episode");
        String mseason = bundle.getString("season");


        title_episode.setText(mtitle);
        episode_episode.setText(mepisode);
        season_episode.setText(mseason);
    }

}
