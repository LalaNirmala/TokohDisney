package com.example.tokohdisney;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";
    private String title = "Mode List";
    final String STATE_TITLE = "state_string";
    final String STATE_MODE = "state_mode";
    int mode;

    private ArrayList<String> NamaTokoh = new ArrayList<>();
    private ArrayList<String> PeranTokoh = new ArrayList<>();
    private ArrayList<String> LinkGambar = new ArrayList<>();
    private ArrayList<String> DetailTokoh = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d(TAG, "onCreate:started.");
        initImageBitmaps();

        if (savedInstanceState == null) {
            setActionBarTitle("Tokoh Disney Terkenal Di Dunia");
            showRecyleList();
            mode = R.id.action_list;
        } else {
            String stateTitle = savedInstanceState.getString(STATE_TITLE);
            int stateMode = savedInstanceState.getInt(STATE_MODE);
            setActionBarTitle(stateTitle);
            setMode(stateMode);
        }
    }

    private void initImageBitmaps() {
        LinkGambar.add("https://i.pinimg.com/originals/b4/ee/3f/b4ee3f42af28717437a97da6266e43f5.png");
        NamaTokoh.add("Ariel Mermaid");
        PeranTokoh.add("Tokoh Disney Film The Little Mermaid");
        DetailTokoh.add("Disney menayangkan kartun The Little Mermaid ke layar kaca pada tahun 1889. Mengambil gambaran putri duyung, Ariel digambarkan dengan rambut merah yang panjang, bermata biru, dan ekor duyung. Karakter utama dari film The Little Mermaid ini bahkan mau mengorbankan kehidupannya sebagai putri duyung dan dia juga mengorbankan suara indahnya hanya untuk bersama orang yang dia cintai.");

        LinkGambar.add("https://sitejerk.com/images/turn-a-white-background-transparent-5.png");
        NamaTokoh.add("Putri Salju");
        PeranTokoh.add("Tokoh Disney Film Snow White");
        DetailTokoh.add("Kisah dongeng Putri Tidur dan 7 Kurcaci adalah dongeng terkenal di abad ke-19. Aslinya, dongeng Snow White ini merupakan dongeng asli asal Jerman yang dipublish oleh The Brothers Grimm pada tahun 1812. Karakter Putri Salju dalam dongeng Snow White memiliki karakter yang sama dengan putri-putri Disney lainnya yaitu memiliki hati yang baik. Karena memakan buah apel yang telah diberi racun, Putri Tidur harus tidur sepanjang hidupnya sampai akhirnya ada seorang pangeran yang mencium dan membangunkannya. ");

        LinkGambar.add("https://i.pinimg.com/originals/64/16/96/64169674f7afcdf877b316748438ba0b.png");
        NamaTokoh.add("Belle");
        PeranTokoh.add("Tokoh Disney Film Beauty and The Beast");
        DetailTokoh.add("Beauty and The Beast mengisahkan kisah cinta antara Belle dan pangeran yang dikutuk menjadi si buruk rupa. Belle memiliki karakter yang baik. Selain pemberani, Belle juga mau berkorban untuk orang yang dia cintai, yaitu ayahnya. Bahkan dia rela dikurung agar ayahnya bisa bebas. Selain itu, Belle tidak memandang orang lain dari fisik. Bahkan dia memberikan kesempatan kepada Beast yang buruk rupa bak monster. Dia bahkan mau berteman dan akhirnya jatuh cinta pada beast walaupun awalnya sifat Beast sangat buruk.");

        LinkGambar.add("https://stickeroid.com/uploads/pic/full-pngmart/ec3bc8f97f546f98a17dc57fd41865d4a414f1aa.png");
        NamaTokoh.add("Jasmine");
        PeranTokoh.add("Tokoh Disney Film Aladdin");
        DetailTokoh.add("Jasmine adalah seorang putri di kerajaan fiksi daerah Timur Tengah. Walaupun dia adalah seorang putri kerajaan, dia tidak memandang orang lain dari hartanya. Dia tidak memandang rendah orang lain. Dia selalu menolak lamaran seorang pangeran tampan dan sangat kaya. Bahkan saat Aladdin berubah menjadi seorang raja, dia tidak menyukainya sampai akhirnya dia sadar bahwa itu adalah Aladdin.");

        LinkGambar.add("https://i.pinimg.com/originals/43/46/c3/4346c374b634f757bbb67e0560dc74c6.png");
        NamaTokoh.add("Cinderella");
        PeranTokoh.add("Tokoh Disney Film Cinderella");
        DetailTokoh.add("Cinderella selalu terlihat cantik karena ia tidak pernah membiarkan kesedihan atau kemarahan menguasai dirinya. Dia selalu baik hati kepada siapa pun, tetapi tidak naif atau kekanak-kanakan. Dia sangat dewasa dan bisa melalui berbagai rintangan sekalipun tanpa bantuan sihir. Dia juga memiliki sedikit sisi sarkastis (terlihat di komentar-komentarnya terhadap keluarga tirinya, tetapi ia selalu menyimpannya sendiri). Ia juga sangat kalem dan sabar. Cintanya terhadap sang Pangeran sangat kuat, tetapi mencari atau menikahi pangeran bukanlah prioritas hidupnya yang utama )sebelum bertemu sang Pangeran). Cinderella menginginkan kehidupan yang lebih baik dan kabur dari hidupnya yang menderita akibat perlakuan dari keluarga tirinya.");

        LinkGambar.add("https://i.pinimg.com/originals/01/80/16/0180167a47a36cc88088ab280340e1d8.png");
        NamaTokoh.add("Aurora");
        PeranTokoh.add("Tokoh Disney Film Sleeping Beauty");
        DetailTokoh.add("Aurora memiliki paras yang cantik dia dilahirkan dengan diiringi kebahagiaan dari seluruh kerajaan . Banyak peri-peri yang memberinya hadiah sebuah mantra namun tiba-tiba ada seorang penyihir datang tanpa diundang dan dia merasa tersinggung karena hanya dia yang tidak diundang. Akhirnya ia memberi kutukan kepada Putri Aurora pada umur ke-17 nya dia akan mati tertusuk jarum . Kemudian sang penyihir pun pergi meninggalkan kerjaan sang Raja dan Ratu serta para rakyat pun gelisah kemudian peri terakhir segera menyampaikan hadiah mantranya agar Putri Aurora tidak akan mati saat tertusuk jarum namun dia akan tertidur panjang sampai ada Pangeran gagah berani yang mampu menciumnya dan menghilangkan kutukan tersebut.");

        LinkGambar.add("https://sitejerk.com/images/rapunzel-transparent-background-18.png");
        NamaTokoh.add("Rapunzel");
        PeranTokoh.add("Tokoh Disney Film Tangled");
        DetailTokoh.add("Tangled menceritakan kisah seorang gadis cantik berambut emas yang panjang. Ia tinggal bersama penyihir tua karena dahulu ayahnya mencuri bunga ajaib di rumah penyihir tua itu untuk menyelamatkan ibunya yang sedang jatuh sakit saat mengandungnya sehingga syaratnya Rapunzel harus tinggal bersama penyihir tua tersebut di sebuah menara yang tinggi kemudian suatu ketika datanglah seorang pria yang menyelamatkannya.");

        LinkGambar.add("https://i.dlpng.com/static/png/479748_thumb.png");
        NamaTokoh.add("Elsa");
        PeranTokoh.add("Tokoh Disney Film Frozen");
        DetailTokoh.add(" Elsa memiliki kekuatan magis untuk membuat dan memanipulasi es dan salju. Ia tidak sengaja mengirimkan Arendelle ke dalam musim dingin abadi pada malam penobatan. Sepanjang film, dia berjuang dari awal untuk mengendalikan dan menyembunyikan kemampuannya dan kemudian dengan membebaskan diri dari rasa takutnya tidak sengaja melukai orang lain, terutama adiknya.");

        LinkGambar.add("https://data.whicdn.com/images/206839966/large.png");
        NamaTokoh.add("Pocahontas");
        PeranTokoh.add("Tokoh Disney Film Pocahontas");
        DetailTokoh.add("Pocahontas seorang anak kepala suku dari Indian. Karakter Pocahontas adalah dia tidak menilai orang lain dari sukunya. Buktinya dia mau berteman dengan John Smith yang berasal dari Inggris, yang tentunya dibenci oleh suku-suku orang Indian. Selain hal itu, Pocahontas juga memiliki jiwa nasionalisme yang sangat tinggi. Walaupun dia mencintai John Smith dan ingin bersama dengan pria itu, namun dia memilih tetap tinggal di tanah kelahirannya. Dia yakin kalau dia masih dibutuhkan disana, sehingga dia tidak mau meninggalkan tanahnya dan memutuskan untuk berpisah dengan pria yang dia cintai.");

        LinkGambar.add("http://pluspng.com/img-png/mulan-png-hd-mulan-3-png-1685.png");
        NamaTokoh.add("Mulan");
        PeranTokoh.add("Tokoh Disney Film Mulan");
        DetailTokoh.add("Mulan adalah seorang pahlawan dari China yang pemberani. Mulan adalah orang yang sangat menyayangi keluarganya, ketika saat ayahnya yang sudah cacat dan tua diminta untuk pergi berperang, dia memutuskan untuk pergi menggantikan ayahnya dan menyamar menjadi laki-laki. Selain itu, Mulan adalah seorang pekerja keras dan tidak mudah menyerah. Tentu saja hal ini bisa kita lihat pada usaha kerasnya pada saat di tempat pelatihan. Dan juga Mulan memiliki jiwa nasionalisme yang tinggi. Walaupun dia diusir, dia tetap berjuang karena ingin mempertahankan negaranya.");

        showRecyleList();

    }

    private void initRecyclerView() {
        RecyclerView recyclerView = findViewById(R.id.recyclerv_view);
        recyclerView.setHasFixedSize(false);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        RecycleViewAdapter adapter = new RecycleViewAdapter(this, NamaTokoh, LinkGambar, PeranTokoh, DetailTokoh);
        recyclerView.setAdapter(adapter);
    }

    private void showRecyleList() {
        RecyclerView recyclerView = findViewById(R.id.recyclerv_view);
        recyclerView.setHasFixedSize(false);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        ListView adapter = new ListView(this, NamaTokoh, LinkGambar, PeranTokoh, DetailTokoh);
        recyclerView.setAdapter(adapter);

    }

    private void showRecyclerGrid() {
        RecyclerView recyclerView = findViewById(R.id.recyclerv_view);
        recyclerView.setHasFixedSize(false);
        recyclerView.setLayoutManager(new GridLayoutManager(this, 2));
        GridView adapter = new GridView(this, NamaTokoh, LinkGambar, PeranTokoh, DetailTokoh);
        recyclerView.setAdapter(adapter);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return super.onCreateOptionsMenu(menu);
    }

    private void setActionBarTitle(String title) {
        getSupportActionBar().setTitle(title);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        setMode(item.getItemId());

        return super.onOptionsItemSelected(item);
    }

    public void setMode(int selectedMode) {
        String title = null;
        switch (selectedMode) {
            case R.id.action_list:
                title = "Mode List";
                showRecyleList();
                break;

            case R.id.action_grid:
                title = "Mode Grid";
                showRecyclerGrid();
                break;

            case R.id.action_cardview:
                title = "Mode CardView";
                initRecyclerView();
                break;
        }
        mode = selectedMode;
        setActionBarTitle(title);
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putString(STATE_TITLE, getSupportActionBar().getTitle().toString());
        outState.putInt(STATE_MODE, mode);
    }
}
