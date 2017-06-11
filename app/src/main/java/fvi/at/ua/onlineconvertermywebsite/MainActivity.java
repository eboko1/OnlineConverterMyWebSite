package fvi.at.ua.onlineconvertermywebsite;


import android.app.SearchManager;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.view.MenuItemCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.SearchView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
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
                Toast.makeText(MainActivity.this,"Завантаження... " + getString(R.string.video),Toast.LENGTH_LONG).show();
               break;

            case R.id.ZNO_set:
                myWebView.loadUrl("http://fvi.at.ua/index/zno/0-124");
                Toast.makeText(MainActivity.this, getString(R.string.ZNO),Toast.LENGTH_LONG).show();
               break;

            case R.id.mail:
                Intent intent = new Intent(Intent.ACTION_SENDTO);
                intent.setData(Uri.parse("mailto: " + getString(R.string.address_mail)));
                intent.putExtra(Intent.EXTRA_TEXT,"Write your message here");
                startActivity(Intent.createChooser(intent, "Send Email"));
                break;

            case R.id.search:

                break;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onResume() {
        super.onResume();

    }
}
