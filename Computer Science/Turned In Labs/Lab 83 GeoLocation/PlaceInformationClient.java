// This program constructs several PlaceInformation objects and prints
// information about them and the distances between them and two locations
// (Bryn Mawr and Gilman).  It is intended to be used to test whether the
// PlaceInformation class is implemented correctly.

public class PlaceInformationClient {
    public static void main(String[] args) {
        PlaceInformation[] data =
            {new PlaceInformation("Ravens Stadium", "1101 Russell St., Baltimore",
                    "football", 39.27736, -76.62302),
                new PlaceInformation("XFINITY Center", "2001 Paint Branch Dr., College Park",
                    "basketball", 38.99557, -76.94124),
                new PlaceInformation("Navy-Marine Corps Memorial Stadium", "550 Taylor Ave., Annapolis",
                    "football, lacrosse", 38.98571, -76.50806)};

        GeoLocation brynmawr = new GeoLocation(39.36446, -76.63014);
        GeoLocation gilman = new GeoLocation(39.36159, -76.63390);

        for (PlaceInformation info : data) {
            System.out.println("name      : " + info.getName());
            System.out.println("address   : " + info.getAddress());
            System.out.println("tags      : " + info.getTag());
            System.out.println("toString  : " + info);
            System.out.println("Bryn Mawr : " + info.distanceFrom(brynmawr) + " miles");
            System.out.println("Gilman    : " + info.distanceFrom(gilman) + " miles");
            System.out.println();
        }
    }
}