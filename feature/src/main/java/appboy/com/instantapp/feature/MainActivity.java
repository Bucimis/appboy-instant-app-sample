package appboy.com.instantapp.feature;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.appboy.Appboy;
import com.appboy.AppboyLifecycleCallbackListener;
import com.appboy.models.InAppMessageSlideup;
import com.appboy.ui.AppboyNavigator;
import com.appboy.ui.actions.NewsfeedAction;
import com.appboy.ui.inappmessage.AppboyInAppMessageManager;

public class MainActivity extends AppCompatActivity {

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    getApplication().registerActivityLifecycleCallbacks(new AppboyLifecycleCallbackListener());
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
  }

  public void goToFeed(View view) {
    AppboyNavigator.getAppboyNavigator().gotoNewsFeed(getApplicationContext(), new NewsfeedAction(null, null));
  }

  public void showInApp(View view) {
    InAppMessageSlideup slideup = new InAppMessageSlideup();
    slideup.setMessage("hey");
    slideup.setImageUrl("https://www.ana-cooljapan.com/destinations/img/kagawa/teshima-islandlivingandcafes/035-02.jpg");
    AppboyInAppMessageManager.getInstance().addInAppMessage(slideup);
  }

  public void logCustomEvent(View view) {
    Appboy.getInstance(getApplicationContext()).logCustomEvent("jamz");
  }

  public void setCustomAttribute(View view) {
    Appboy.getInstance(getApplicationContext()).getCurrentUser().setCustomUserAttribute("hungry", true);
  }

  public void changeUser(View view) {
    Appboy.getInstance(getApplicationContext()).changeUser("jamz");
  }

  public void requestFlush(View view) {
    Appboy.getInstance(getApplicationContext()).requestImmediateDataFlush();
  }
}
