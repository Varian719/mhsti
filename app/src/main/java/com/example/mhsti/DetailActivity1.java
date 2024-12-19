package com.example.mhsti;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
public class DetailActivity1 extends AppCompatActivity {
    public static final String NIM= "nim";
    public static final String NAMA = "nama";
    public static final String KELAS = "kelas";
    public static final String PRODI = "prodi";
    public static final String FOTOMHS = "fotomhs";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail1);
        ImageView imageView = findViewById(R.id.img_item_photo);
        String fotomhs = getIntent().getStringExtra(FOTOMHS);
        Glide.with(this)
                .load(fotomhs)
                .apply(new RequestOptions().override(200, 200))
                .into(imageView);
        TextView txtnim = findViewById(R.id.tv_item_name);
        String nim ="nim: "+ getIntent().getStringExtra(NIM);
        txtnim.setText(nim);
        TextView txtnama = findViewById(R.id.tv_item_from);
        String nama ="nama: "+getIntent().getStringExtra(NAMA);
        txtnama.setText(nama);
        TextView txtkelas = findViewById(R.id.tv_item_description);
        String kelas = "kelas: "+ getIntent().getStringExtra(KELAS);
        txtkelas.setText(kelas);
        TextView txtprodi = findViewById(R.id.tv_item_stadium);
        String prodi = "prodi: " + getIntent().getStringExtra(PRODI);
        txtprodi.setText(prodi);

    }
}