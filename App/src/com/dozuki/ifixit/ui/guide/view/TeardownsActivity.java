package com.dozuki.ifixit.ui.guide.view;

import android.os.Bundle;
import com.dozuki.ifixit.MainApplication;
import com.dozuki.ifixit.R;
import com.dozuki.ifixit.util.APICall;
import com.dozuki.ifixit.util.APIEvent;
import com.dozuki.ifixit.util.APIService;
import com.google.analytics.tracking.android.Fields;
import com.google.analytics.tracking.android.MapBuilder;
import com.squareup.otto.Subscribe;

public class TeardownsActivity extends GuideListActivity {

   @Override
   public void onCreate(Bundle state) {
      super.onCreate(state);

      MainApplication.getGaTracker().set(Fields.SCREEN_NAME, "/guides/teardowns");
      MainApplication.getGaTracker().send(MapBuilder.createAppView().build());
   }

   @Override
   protected int getGuideListTitle() {
      return R.string.teardowns;
   }

   @Override
   protected APICall getApiCall(int limit, int offset) {
      return APIService.getTeardowns(limit, offset);
   }

   @Subscribe
   public void onGuides(APIEvent.Guides event) {
      setGuides(event);
   }
}
