package arthur.beerd;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class ForumPage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forum_page);

        Button home_page = (Button) findViewById (R.id.home_page);
        Button search_again = (Button) findViewById(R.id.search_again);
        Button twitter = (Button) findViewById(R.id.twitter);
        Button facebook = (Button) findViewById(R.id.facebook);
        Button googlemaps = (Button) findViewById(R.id.googlemaps);
    }

    public void buttonOnClickHomePage(View v) {
        Intent GoToHomePage = new Intent(ForumPage.this, HomePage.class);                  //whatever the homepage class is called here
        startActivity(GoToHomePage);
    }

    public void buttonOnClickSearchAgain(View v) {
        Intent GoToSearchPage = new Intent (ForumPage.this, SearchPage.class);            //whatever the searchpage class is called here
        startActivity(GoToSearchPage);
    }

    public void buttonOnClickTwitter(View v) {
        //twitter tingz here
    }

    public void buttonOnClickFacebook(View v) {
        //facebook tingz here
    }

    public void buttonOnClickGoogleMaps(View v) {
        Intent GoToGoogleMaps = new Intent (ForumPage.this, GoogleMaps.class);             //whatever the googlemaps class is called here
        startActivity(GoToGoogleMaps);
    }
}
