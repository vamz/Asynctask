package sk.uniza.fri.asynctask;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;

import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by hudik1 on 24.3.2017.
 */

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder> {

    private List<String> urlImage;

    public MyAdapter(List<String> urlImage) {
        this.urlImage = urlImage;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_list, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.position = position;
        holder.url = urlImage.get(position);
        DownloadData downloadData = new DownloadData();

        //TODO
        // Vyskusajte si spustenie asynctask ulohy s roznymi vykonavacmi Executors

        //Default single thread
        downloadData.execute(holder);

        //ExecutorService executorService = Executors.newFixedThreadPool(4);

        //ExecutorService executorService = Executors.newSingleThreadExecutor();

        //ExecutorService executorService = Executors.newCachedThreadPool();

        //downloadData.executeOnExecutor(executorService,holder);

    }

    @Override
    public int getItemCount() {
        return urlImage.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        ImageView imageView;
        ProgressBar progressBar;
        int position;
        String url;

        public ViewHolder(View itemView) {
            super(itemView);

            imageView = (ImageView) itemView.findViewById(R.id.imageView);

            progressBar = (ProgressBar) itemView.findViewById(R.id.progressBar);
        }
    }

}
