package telephony;

public class Smartphone implements Callable, Browseble {


    @Override
    public String callPhone(String number) {
        return String.format("Calling... %s", number);
    }

    @Override
    public String browseInternet(String url) {
        return String.format("Browsing: %s!", url);
    }
}
