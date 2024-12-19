package com.example.mhsti;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;



import static com.example.mhsti.R.id.rv_teams;

import android.content.Intent;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mhsti.Model.Responsemhs;
import com.example.mhsti.Model.DataItem;

import com.example.mhsti.httpclient.ApiInterface;
import com.example.mhsti.httpclient.ApiClient;


import java.util.ArrayList;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
public class MainActivity extends AppCompatActivity {
    private String title = "Mode List";
    private RecyclerView rvTeams;
    private ArrayList<DataItem> datalist = new ArrayList<>();

    private final String STATE_TITLE = "state_string";
    private final String STATE_LIST = "state_list";
    private final String STATE_MODE = "state_mode";
    private int mode;
    private ApiInterface apiInterface;



    @Override
    protected void onStart() {
        super.onStart();
        Log.d("MainActivity", "onStart called");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d("MainActivity", "onResume called");
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        rvTeams = findViewById(rv_teams);
        rvTeams.setHasFixedSize(true);

        apiInterface = ApiClient.getApiClient().create(ApiInterface.class);

        if (savedInstanceState == null) {
            setActionBarTitle(title);
            fetchStudentData();
            mode = R.id.action_list;
        } else {
            title = savedInstanceState.getString(STATE_TITLE);
            ArrayList<DataItem> stateList = savedInstanceState.getParcelableArrayList(STATE_LIST);
            int stateMode = savedInstanceState.getInt(STATE_MODE);
            setActionBarTitle(title);
            if (stateList != null) {
                datalist.addAll(stateList);
            }
            setMode(stateMode);
        }
    }

    private void fetchStudentData() {
        Call<Responsemhs> call = apiInterface.getData();
        call.enqueue(new Callback<Responsemhs>() {
            @Override
            public void onResponse(Call<Responsemhs> call, Response<Responsemhs> response) {
                if (response.isSuccessful() && response.body() != null) {
                    datalist.addAll(response.body().getOEMDt95HH8834CFYpR9().getData().getData()); // Assuming getTeams() returns List<TeamsItem>
                    showRecyclerList(); // Show list once data is fetched
                } else {
                    Toast.makeText(MainActivity.this, "Failed to load data", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<Responsemhs> call, Throwable t) {
                Toast.makeText(MainActivity.this, "Error: " + t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }


    private void showRecyclerList() {
        rvTeams.setLayoutManager(new LinearLayoutManager(this));
        ListBallsAdapter listBallsAdapter = new ListBallsAdapter(datalist);
        rvTeams.setAdapter(listBallsAdapter);

        listBallsAdapter.setOnItemClickCallback(new ListBallsAdapter.OnItemClickCallBack() {
            @Override
            public void onItemClicked(DataItem data) {
                showSelectedTeam(data);
            }
        });
    }

    private void showRecyclerGrid() {
        rvTeams.setLayoutManager(new GridLayoutManager(this, 2));
        GridBallsAdapter gridBallsAdapter = new GridBallsAdapter(datalist);
        rvTeams.setAdapter(gridBallsAdapter);

        gridBallsAdapter.setOnItemClickCallback(new GridBallsAdapter.OnItemClickCallBack() {
            @Override
            public void onItemClicked(DataItem data) {
                showSelectedCountry(data);
            }
        });
    }
    private void showAbout() {
        Intent aboutIntent = new Intent(MainActivity.this, About.class);
        startActivity(aboutIntent);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        setMode(item.getItemId());
        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putString(STATE_TITLE, title);
        outState.putParcelableArrayList(STATE_LIST, datalist);

        // Ensure TeamsItem & CountriesItemis Parcelable
        outState.putInt(STATE_MODE, mode);
    }


    public void setMode(int selectedMode) {
        if (selectedMode == R.id.action_list) {
            title = "Mode List";
            showRecyclerList();
        } else if (selectedMode == R.id.action_grid) {
            title = "Mode Grid";
            showRecyclerGrid();
        }else if (selectedMode == R.id.action_about) {
            title = "About";
            showAbout();
        }
        mode = selectedMode;
        setActionBarTitle(title);
    }

    private void setActionBarTitle(String title) {
        if (getSupportActionBar() != null) {
            getSupportActionBar().setTitle(title);
        }
    }

    private void showSelectedTeam(DataItem data) {
        // Mengirim data ke DetailActivity
        Intent intent = new Intent(MainActivity.this, DetailActivity1.class);
        intent.putExtra(DetailActivity1.NIM, data.getNim());
        intent.putExtra(DetailActivity1.NAMA, data.getNama());
        intent.putExtra(DetailActivity1.KELAS, data.getKelas()); // Mengirim deskripsi
        intent.putExtra(DetailActivity1.PRODI, data.getProdi());
         intent.putExtra(DetailActivity1.FOTOMHS, data.getFotomhs()); // Mengirim URL badge
        // Mulai DetailActivity
        startActivity(intent);
    }
    private void showSelectedCountry(DataItem data) {
        Intent intent = new Intent(MainActivity.this, DetailActivity1.class);
        intent.putExtra(DetailActivity1.NIM, data.getNim());
        intent.putExtra(DetailActivity1.NAMA, data.getNama());
        intent.putExtra(DetailActivity1.KELAS, data.getKelas()); // Mengirim deskripsi
        intent.putExtra(DetailActivity1.PRODI, data.getProdi());
        intent.putExtra(DetailActivity1.FOTOMHS, data.getFotomhs()); // Mengirim URL badge
        // Mulai DetailActivity
        startActivity(intent);
    }
}