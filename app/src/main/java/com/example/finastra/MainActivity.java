package com.example.finastra;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.widget.ProgressBar;

import com.example.finastra.apicall.NasaApiCall;
import com.example.finastra.helper.ImageData;
import com.example.finastra.helper.PaginationScrollListener;
import com.example.finastra.model.NasaResponse;
import com.example.finastra.model.latestphotos.LatestPhotos;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {
    private static final String BASE_URL = "https://api.nasa.gov/mars-photos/api/v1/rovers/curiosity/";
    private static final String TAG = "MainActivity";
    String image, name, launch, land;
    NasaAdapter adapter;
    private static final int page_start = 1;
    private boolean isLoading = false;
    private boolean isLastPage = false;
    RecyclerView recyclerView;
    SwipeRefreshLayout swipeRefreshLayout;
    LinearLayoutManager layoutManager;
    int currentPage = page_start;
    private final int totalPage = 100;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = findViewById(R.id.recyclerView);
        adapter = new NasaAdapter(getApplicationContext(), new ArrayList<>());
        recyclerView.setHasFixedSize(true);
        layoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(adapter);
        swipeRefreshLayout = findViewById(R.id.swiper);
        //to make use of infinite scrolling. per page will have 25 images
        recyclerView.addOnScrollListener(new PaginationScrollListener(layoutManager) {
            @Override
            protected void loadMoreItems() {
                isLoading = true;
                currentPage += 1;
                loadData(currentPage);
            }

            @Override
            public boolean isLastPage() {
                return isLastPage;
            }

            @Override
            public boolean isLoading() {
                return isLoading;
            }
        });
        loadData(currentPage);
        swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                adapter.clear();
                currentPage += 1;
                loadData(currentPage);
                adapter.notifyDataSetChanged();
                swipeRefreshLayout.setRefreshing(false);
            }
        });
    }

    private void loadData(int currentPage) {
        final int finalCurrent = currentPage;
        //network call to load data. retrofit library library being used to load the data
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                final Retrofit retrofit = new Retrofit.Builder()
                        .baseUrl(BASE_URL)
                        .addConverterFactory(GsonConverterFactory.create())
                        .build();
                final NasaApiCall yinzCamApi = retrofit.create(NasaApiCall.class);
                Call<NasaResponse> call = yinzCamApi.getScheduleJson(finalCurrent, 25);
                call.enqueue(new Callback<NasaResponse>() {
                    @Override
                    public void onResponse(Call<NasaResponse> call, Response<NasaResponse> response) {
                        final ArrayList<ImageData> matchArrayList = new ArrayList<>();
                        Log.d(TAG, "onResponse Server Response: " + response.toString());
                        Log.d(TAG, "onResponse received Information: " + response.body().toString());
                        ArrayList<LatestPhotos> game = response.body().getLatestPhotos();
                        for (int i = 0; i < game.size(); i++) {
                            Log.d(TAG, "onResponse \n" +
                                    "image:" + game.get(i).getImg_src() + "\n" +
                                    "roverName:" + game.get(i).getRover().getName() + "\n" +
                                    "roverLaunch:" + game.get(i).getRover().getLaunch_date() + "\n" +
                                    "roverLand:" + game.get(i).getRover().getLanding_date() + "\n");
                            image = game.get(i).getImg_src();
                            launch = game.get(i).getRover().getLaunch_date();
                            land = game.get(i).getRover().getLanding_date();
                            name = game.get(i).getRover().getName();
                            ImageData imageData = new ImageData(image, name, launch, land);
                            matchArrayList.add(imageData);
                        }
                        //updating the adapter
                        adapter.addItems(matchArrayList);
                        isLoading = false;
                    }

                    @Override
                    public void onFailure(Call<NasaResponse> call, Throwable t) {
                        Log.d("ERROR TAG", "Something went wrong" + t.getMessage());

                    }
                });
            }

        }, 1500);
    }
}