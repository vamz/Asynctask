package sk.uniza.fri.asynctask;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.view.View;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by hudik1 on 24.3.2017.
 */

/**
 * Trieda odvodena od Asynctask. Tato trieda je zodpovedna za stahovanie obrazkov z internetu a ich nasledne vykreslenie do viewholder-a
 */
public class DownloadData extends AsyncTask<MyAdapter.ViewHolder, Integer, Bitmap> {
    int postion;
    MyAdapter.ViewHolder viewHolder;

    /**
     * Metoda vykonana v samostnanom vlakne.
     */
    @Override
    protected Bitmap doInBackground(MyAdapter.ViewHolder... params) {
        this.postion = params[0].position;
        this.viewHolder = params[0];

        publishProgress(0); //Vykreslenie progres baru
        Bitmap image = null;
        try {
            URL url = new URL(params[0].url);
            image = BitmapFactory.decodeStream(url.openConnection().getInputStream());
        } catch (IOException e) {
            System.out.println(e);
        }
        return image;
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();

    }

    @Override
    protected void onPostExecute(Bitmap bitmap) {
        super.onPostExecute(bitmap);
        //Ak viewholder je platny(nebol recyklovany), vykresli sa obrazok
        if (viewHolder.position == this.postion) {
            viewHolder.imageView.setImageBitmap(bitmap);
            viewHolder.progressBar.setVisibility(View.INVISIBLE);
        }
    }

    @Override
    protected void onProgressUpdate(Integer... values) {
        super.onProgressUpdate(values);
        viewHolder.progressBar.setVisibility(View.VISIBLE);

    }
}
