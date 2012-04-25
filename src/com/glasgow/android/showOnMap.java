package com.glasgow.android;

import java.util.List;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;

import com.glasgow.android1.R;
import com.google.android.maps.GeoPoint;
import com.google.android.maps.MapActivity;
import com.google.android.maps.MapController;
import com.google.android.maps.MapView;
import com.google.android.maps.Overlay;
import com.google.android.maps.OverlayItem;

public class showOnMap extends MapActivity implements LocationListener {
	
	MapController mc;
	MapView mapView;
	
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
	   super.onCreate(savedInstanceState);
	   setContentView(R.layout.maps);
	   mapView = (MapView) findViewById(R.id.mapview);
	   mc = mapView.getController();
	   mapView.setBuiltInZoomControls(true);
	   
	   LocationManager lm = (LocationManager)getSystemService(Context.LOCATION_SERVICE);
	   lm.requestLocationUpdates(LocationManager.GPS_PROVIDER, 1000L, 500.0f, this);
	   
	   List<Overlay> mapOverlays = mapView.getOverlays();
	   
	   Drawable drawable = this.getResources().getDrawable(R.drawable.ic_launcher);
	   
	   overlayItems itemizedoverlay = new overlayItems(drawable, this);
	   float lat = 55.86035f;
	   float lng = -4.25467f;
	   GeoPoint point = new GeoPoint((int)(lat * 1E6), (int)(lng * 1E6));
	   OverlayItem overlayitem = new OverlayItem(point, "Glasgow Android", "Address:‎ " + "\n" + "9 Gordon St Glasgow," + "\n" + "Glasgow City G1 3PL, UK");   
	   mc.setCenter(point);
	   mc.setZoom(16);
	   mapOverlays.add(itemizedoverlay);
	   itemizedoverlay.addOverlay(overlayitem);

	}
	
	@Override
	protected boolean isRouteDisplayed() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void onLocationChanged(Location location) {
		// TODO Auto-generated method stub
		if (location != null) {
			double lat = location.getLatitude();
			double lng = location.getLongitude();
			GeoPoint p = new GeoPoint((int) lat * 1000000, (int) lng * 1000000);
			mc.animateTo(p);
		}
	}

	@Override
	public void onProviderDisabled(String provider) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onProviderEnabled(String provider) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onStatusChanged(String provider, int status, Bundle extras) {
		// TODO Auto-generated method stub
		
	}

}
