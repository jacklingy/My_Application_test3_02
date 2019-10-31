package edu.ncu.myapplication_test3_02;

        import java.util.ArrayList;
        import java.util.List;
        import java.util.Random;

        import com.google.android.material.floatingactionbutton.FloatingActionButton;

        import android.os.Bundle;
        import android.view.Menu;
        import android.view.MenuInflater;
        import android.view.MenuItem;
        import android.view.View;
        import android.widget.ListView;
        import android.widget.Toast;

        import androidx.annotation.NonNull;
        import androidx.appcompat.app.AppCompatActivity;
        import androidx.recyclerview.widget.LinearLayoutManager;
        import androidx.recyclerview.widget.RecyclerView;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;

    private LinearLayoutManager layoutManager;

    private MovieAdapter adapter;

    private FloatingActionButton floatingActionButton;

    private List<Movie> movieList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initMovie();
        recyclerView = (RecyclerView)findViewById(R.id.recyclerView);
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        adapter = new MovieAdapter(movieList);
        recyclerView.setAdapter(adapter);

        // 悬浮按钮
        floatingActionButton = findViewById(R.id.fab);
        floatingActionButton.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v) {
                adapter.moveToTop(recyclerView);
            }
        });
    }

    public void initMovie() {
        Movie m1 = new Movie("肖申克的救赎", "希望让人自由。", R.drawable.a1);
        movieList.add(m1);
        Movie m2 = new Movie("霸王别姬", "风华绝代。", R.drawable.a2);
        movieList.add(m2);
        Movie m3 = new Movie("阿甘正传", "一部美国近现代史。", R.drawable.a3);
        movieList.add(m3);
        Movie m4 = new Movie("这个杀手不太冷", "怪蜀黍和小萝莉不得不说的故事。", R.drawable.a4);
        movieList.add(m4);
        Movie m5 = new Movie("美丽人生", "最美的谎言", R.drawable.a5);
        movieList.add(m5);
        Movie m6 = new Movie("泰坦尼克号", "失去的才是永恒的。", R.drawable.a6);
        movieList.add(m6);
        Movie m7 = new Movie("千与千寻", "最好的宫崎骏，最好的久石让。", R.drawable.a7);
        movieList.add(m7);
        Movie m8 = new Movie("辛德勒的名单", "拯救一个人，就是拯救整个世界。", R.drawable.a8);
        movieList.add(m8);
        Movie m9 = new Movie("盗梦空间", "诺兰给了我们一场无法盗取的梦。", R.drawable.a9);
        movieList.add(m9);
        Movie m10 = new Movie("movieName10", "movieDescription9", R.drawable.aa);
        movieList.add(m10);
        Movie m11 = new Movie("movieName11", "movieDescription9", R.drawable.aa);
        movieList.add(m11);
        Movie m12 = new Movie("movieName12", "movieDescription9", R.drawable.aa);
        movieList.add(m12);
        Movie m13 = new Movie("movieName13", "movieDescription9", R.drawable.aa);
        movieList.add(m13);
    }

    // 创建菜单

    @Override
    public boolean onCreatePanelMenu(int featureId, Menu menu) {
        MenuInflater menuInflater = new MenuInflater(this);
        menuInflater.inflate(R.menu.menu, menu);
        return super.onCreatePanelMenu(featureId, menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.menuAdd:

                // 随机添加一个电影
                Random random = new Random();
                int m = random.nextInt(movieList.size());
                Movie newMovie = movieList.get(m);
                adapter.addData(m, newMovie);
                Toast.makeText(getApplicationContext(), "已随机添加一部电影!\n" + newMovie.getName(), Toast.LENGTH_LONG).show();
                break;
            case R.id.menuDecline:
                Random random2 = new Random();
                int m2 = random2.nextInt(movieList.size());
                if (movieList.size() > 1)
                    adapter.removeData(m2);
                else
                    Toast.makeText(getApplicationContext(), "已随机删除一部电影!", Toast.LENGTH_LONG).show();
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}
