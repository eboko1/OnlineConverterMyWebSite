package fvi.at.ua.onlineconvertermywebsite;


import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
        private WebView myWebView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        myWebView = (WebView)findViewById(R.id.myWebView);
        WebSettings webSettings = myWebView.getSettings();
        webSettings.setJavaScriptEnabled(true);
        webSettings.setBuiltInZoomControls(true);
        myWebView.loadUrl("http://fvi.at.ua/");
        myWebView.setWebViewClient(new WebViewClient());



    }

    @Override
    public void onBackPressed() {
        if (myWebView.canGoBack()){
            myWebView.goBack();
        } else {
            super.onBackPressed();
        }

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        switch (id){
            case  R.id.olimpia:
            //return true;
                myWebView.loadUrl("http://fvi.at.ua/index/olimpiada/0-167");
                Toast.makeText(MainActivity.this, getString(R.string.olimpia),Toast.LENGTH_LONG).show();
               break;
            case  R.id.test_set:
                myWebView.loadUrl("http://fvi.at.ua/tests/");
                Toast.makeText(MainActivity.this, getString(R.string.test),Toast.LENGTH_LONG).show();
               break;
            case R.id.video_set:
                myWebView.loadUrl("http://fvi.at.ua/video/vic/video");
                Toast.makeText(MainActivity.this,"Завантаження " + getString(R.string.video),Toast.LENGTH_LONG).show();
               break;
            case R.id.ZNO_set:
                myWebView.loadUrl("http://fvi.at.ua/index/zno/0-124");
                Toast.makeText(MainActivity.this, getString(R.string.ZNO),Toast.LENGTH_LONG).show();
               break;

        }

        return super.onOptionsItemSelected(item);
    }
}
