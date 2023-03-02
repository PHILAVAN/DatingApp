package com.quintus.labs.datingapp.Matched;

import android.content.Context;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.LinearLayout;

import com.ittianyu.bottomnavigationviewex.BottomNavigationViewEx;
import com.quintus.labs.datingapp.R;
import com.quintus.labs.datingapp.Utils.TopNavigationViewHelper;
import com.quintus.labs.datingapp.Utils.User;

import java.util.ArrayList;
import java.util.List;

public class Matched_Activity extends AppCompatActivity {

    private static final String TAG = "Matched_Activity";
    private static final int ACTIVITY_NUM = 2;
    List<Users> matchList = new ArrayList<>();
    List<User> copyList = new ArrayList<>();
    private Context mContext = Matched_Activity.this;
    private String userId, userSex, lookforSex;
    private double latitude = 37.349642;
    private double longtitude = -121.938987;
    private EditText search;
    private List<Users> usersList = new ArrayList<>();
    private RecyclerView recyclerView, mRecyclerView;
    private ActiveUserAdapter adapter;
    private MatchUserAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_matched);

        setupTopNavigationView();
        searchFunc();


        recyclerView = findViewById(R.id.active_recycler_view);
        mRecyclerView = findViewById(R.id.matche_recycler_view);

        adapter = new ActiveUserAdapter(usersList, getApplicationContext());
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(this, RecyclerView.HORIZONTAL, false);
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(adapter);
        prepareActiveData();

        mAdapter = new MatchUserAdapter(matchList, getApplicationContext());
        RecyclerView.LayoutManager mLayoutManager1 = new LinearLayoutManager(getApplicationContext());
        mRecyclerView.setLayoutManager(mLayoutManager1);
        mRecyclerView.setItemAnimator(new DefaultItemAnimator());
        mRecyclerView.setAdapter(mAdapter);

        prepareMatchData();


    }

    private void prepareActiveData() {
        Users users = new Users("1", "Angelina Jolie", 21, "https://worldwideinterweb.com/wp-content/uploads/2015/01/2016-most-beautiful-woman.jpg", "Simple and beautiful Girl", "Acting", 200);
        usersList.add(users);
        users = new Users("2", "Bella Hadid", 20, "https://worldwideinterweb.com/wp-content/uploads/2015/01/the-20-most-beautiful-women-in-the-world-according-to-google-5.jpg.webp", "cool Minded Girl", "Dancing", 800);
        usersList.add(users);
        users = new Users("3", "Blake Lively", 22, "https://worldwideinterweb.com/wp-content/uploads/2015/01/the-20-most-beautiful-women-in-the-world-according-to-google-7.jpg.webp", "Simple and beautiful Girl", "Singing", 400);
        usersList.add(users);
        users = new Users("7", "Aishwarya Rai", 19, "https://worldwideinterweb.com/wp-content/uploads/2015/01/25-most-beautiful-women-in-the-world-according-to-google-9.jpg", "Cool and beautiful", "Drawing", 1200);
        usersList.add(users);

        adapter.notifyDataSetChanged();
    }

    private void prepareMatchData() {
        Users users = new Users("1", "Angelina Jolie", 21, "https://worldwideinterweb.com/wp-content/uploads/2015/01/2016-most-beautiful-woman.jpg", "Simple and beautiful Girl", "Acting", 200);
        matchList.add(users);
        users = new Users("2", "Bella Hadid", 20, "https://worldwideinterweb.com/wp-content/uploads/2015/01/the-20-most-beautiful-women-in-the-world-according-to-google-5.jpg.webp", "cool Minded Girl", "Dancing", 800);
        matchList.add(users);
        users = new Users("3", "Blake Lively", 22, "https://worldwideinterweb.com/wp-content/uploads/2015/01/the-20-most-beautiful-women-in-the-world-according-to-google-7.jpg.webp", "Simple and beautiful Girl", "Singing", 400);
        matchList.add(users);
        users = new Users("4", "Beyonce Knowles", 19, "https://worldwideinterweb.com/wp-content/uploads/2015/01/25-most-beautiful-women-in-the-world-according-to-google-11.jpg", "dashing girl", "Swimming", 1308);
        matchList.add(users);
        users = new Users("5", "Aishwarya Rai", 20, "https://worldwideinterweb.com/wp-content/uploads/2015/01/25-most-beautiful-women-in-the-world-according-to-google-9.jpg", "Cool and beautiful", "Drawing", 1200);
        matchList.add(users);
        users = new Users("6", "Jessica Alba", 21, "https://worldwideinterweb.com/wp-content/uploads/2015/01/25-most-beautiful-women-in-the-world-according-to-google-6.jpg", "Simple and beautiful Girl", "Model", 700);
        matchList.add(users);
        users = new Users("7", "Eva Mendes", 19, "https://worldwideinterweb.com/wp-content/uploads/2015/01/25-most-beautiful-women-in-the-world-according-to-google-20.jpg.webp", "Cool and beautiful", "Art", 5000);
        matchList.add(users);

        mAdapter.notifyDataSetChanged();
    }

    private void searchFunc() {
    }
    private void setupTopNavigationView() {
        Log.d(TAG, "setupTopNavigationView: setting up TopNavigationView");
        BottomNavigationViewEx tvEx = findViewById(R.id.topNavViewBar);
        TopNavigationViewHelper.setupTopNavigationView(tvEx);
        TopNavigationViewHelper.enableNavigation(mContext, tvEx);
        Menu menu = tvEx.getMenu();
        MenuItem menuItem = menu.getItem(ACTIVITY_NUM);
        menuItem.setChecked(true);
    }


}
