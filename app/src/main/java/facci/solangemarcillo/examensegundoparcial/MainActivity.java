package facci.solangemarcillo.examensegundoparcial;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity{

    private RequestQueue requestQueue;
    private RecyclerView recyclerView;
    private List<Episodes> usersList;


    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recyclerview);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));


        requestQueue = VolleySingleton.getmInstance(this).getRequestQueue();

        usersList = new ArrayList<>();
        obtenerDatosUsers();
    }

    private void obtenerDatosUsers() {

        String url = "https://breakingbadapi.com/api/episodes";

        JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(Request.Method.GET, url, null,
                new Response.Listener<JSONArray>() {
                    @Override
                    public void onResponse(JSONArray response) {

                        for (int i=0; i< response.length();i++){
                            try {
                                JSONObject jsonobject = response.getJSONObject(i);
                                String episode =jsonobject.getString("episode");
                                String title =jsonobject.getString("title");
                                String season =jsonobject.getString("season");
                                String series =jsonobject.getString("series");
                                String air_date =jsonobject.getString("air_date");

                                Episodes users = new Episodes(episode, title, season, series, air_date);
                                usersList.add(users);

                            }catch (JSONException e) {
                                e.printStackTrace();
                            }

                            EpisodesAdapter adapter= new EpisodesAdapter(MainActivity.this, usersList);

                            recyclerView.setAdapter(adapter);

                        }
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(MainActivity.this, error.getMessage(), Toast.LENGTH_SHORT).show();

            }
        });

        requestQueue.add(jsonArrayRequest);
    }


}