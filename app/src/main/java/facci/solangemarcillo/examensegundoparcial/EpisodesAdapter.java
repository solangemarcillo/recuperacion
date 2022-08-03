package facci.solangemarcillo.examensegundoparcial;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class EpisodesAdapter extends RecyclerView.Adapter<EpisodesAdapter.UsersHolder> {

    private Context context;
    private List<Episodes> usersList;

    public EpisodesAdapter(Context context, List<Episodes> users){
        this.context=context;
        usersList=users;
    }

    @NonNull
    @Override
    public  UsersHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType){
        View view = LayoutInflater.from(context).inflate(R.layout.item, parent, false);
        return new UsersHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull UsersHolder holder, int position) {
        Episodes users = usersList.get(position);
        holder.title.setText(users.getTitle());
        holder.episode.setText(users.getSeason());
        holder.series.setText(users.getSeries());
        holder.air_date.setText(users.getAir_date());

        holder.constraintLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context , DetailActivity.class);

                Bundle bundle = new Bundle();
                bundle.putString("series" , users.getSeries());
                bundle.putString("title" , users.getTitle());
                bundle.putString("episode" , users.getEpisode());
                bundle.putString("season", users.getSeason());
                bundle.putString("air_date", users.getAir_date());

                intent.putExtras(bundle);

                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() { return usersList.size();
    }

    public class UsersHolder extends RecyclerView.ViewHolder{


        TextView series, title , episode, air_date;
        ConstraintLayout constraintLayout;

        public UsersHolder(@NonNull View itemView) {
            super(itemView);

            series = itemView.findViewById(R.id.series_episode);
            title = itemView.findViewById(R.id.title_episode);
            episode = itemView.findViewById(R.id.episode_episode);
            air_date =  itemView.findViewById(R.id.air_date_episode);
            constraintLayout = itemView.findViewById(R.id.main_layout);
        }


    }
}

