package Classes;

public class Product {
    private String name;
    private String id;
    private String price;
    private String year;
    private int qty;
    private boolean isIphone = false;
    private boolean isIwatch = false;
    private boolean isIpad = false;
    private boolean isAirpods = false;
    private boolean isMac = false;

    public Product() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public int getQty() {
        return qty;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }

    public boolean isIphone() {
        return isIphone;
    }

    public void setIphone(boolean iphone) {
        isIphone = iphone;
    }

    public boolean isIwatch() {
        return isIwatch;
    }

    public void setIwatch(boolean iwatch) {
        isIwatch = iwatch;
    }

    public boolean isIpad() {
        return isIpad;
    }

    public void setIpad(boolean ipad) {
        isIpad = ipad;
    }

    public boolean isAirpods() {
        return isAirpods;
    }

    public void setAirpods(boolean airpods) {
        isAirpods = airpods;
    }

    public boolean isMac() {
        return isMac;
    }

    public void setMac(boolean mac) {
        isMac = mac;
    }
}
