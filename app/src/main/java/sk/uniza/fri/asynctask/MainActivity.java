package sk.uniza.fri.asynctask;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //Inicializacia RecycleView prvku
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        MyAdapter myAdapter = new MyAdapter(getUrls());
        recyclerView.setAdapter(myAdapter);
    }

    /**
     *
     * @return List vygenerovanych url adries s obrazkami
     */
    private List<String> getUrls() {
        List<String> urls = new ArrayList<>();
        for (int i = 0; i < 50; i++) {
            urls.add("https://fakeimg.pl/350x200/?text=IMG_" + i);
        }
        return urls;
    }
}
