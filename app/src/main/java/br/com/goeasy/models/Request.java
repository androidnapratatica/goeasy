package br.com.goeasy.models;

import android.location.Location;

import com.parse.ParseClassName;
import com.parse.ParseGeoPoint;
import com.parse.ParseObject;

/**
 * Created by biliboss on 07/03/2015.
 */
@ParseClassName("Request")
public class Request extends ParseObject {
    public Location getLocation(){
        ParseGeoPoint geoPoint = getParseGeoPoint("location");
        Location location = new Location("");
        location.setLatitude(geoPoint.getLatitude());
        location.setLongitude(geoPoint.getLongitude());
        return location;
    }

    public Request setLocation(Location value){
        put("location", new ParseGeoPoint(value.getLatitude(), value.getLongitude()));
        return this;
    }
}
