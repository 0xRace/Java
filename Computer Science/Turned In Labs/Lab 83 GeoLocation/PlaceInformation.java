// this class stores information about a place. Places are specified using 
// a name, tag, address, and geolocation
//this class includes a method for computing the distance between two places
public class PlaceInformation
{
    private String name,address,tag;
    private GeoLocation location;
    
    //constructs a place object with the given name, address, tag, and location
    public PlaceInformation(String n, String a, String t,double lat, double lon)
    {
        name=n;
        address=a;
        tag=t;
        location= new GeoLocation(lat,lon);
    }
    //returns the name of this place
    public String getName(){return name;}
    //returns the address of this place
    public String getAddress(){return address;}
    //returns the tag of this place
    public String getTag(){return tag;}
    //returns a string representation of this place
    public String toString(){return name+ "("+address+", "+tag+", "+location+")";}
    //returns the GeoLocation of this place
    public GeoLocation getLocation(){return location;}

    //returns the distance in miles between this place and another place
    public double distanceFrom(GeoLocation spot)
    {
        return location.distanceFrom(spot);
    }

}
