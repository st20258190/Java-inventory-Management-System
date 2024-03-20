package Common;

import Classes.Product;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Search {

    public Search() {

    }

    public List<Product> searchByPrice(String price) throws IOException {
        FileHandler fileHandler = new FileHandler();
        List<Product> productList = new ArrayList<>(fileHandler.readProducts());
        List<Product> newProductsList = new ArrayList<>();

        for (Product product : productList) {
            if (product.getPrice().equals(price))
            {
                newProductsList.add(product);
            }
        }
        return newProductsList;
    }

    public List<Product> searchByName(String name) throws IOException {
        FileHandler fileHandler = new FileHandler();
        List<Product> productList = new ArrayList<>(fileHandler.readProducts());
        List<Product> newProductsList = new ArrayList<>();

        for (Product product : productList) {
            if (product.getName().equals(name))
            {
                newProductsList.add(product);
            }
        }
        return newProductsList;
    }

    public List<Product> searchByCategory(String category) throws IOException {
        FileHandler fileHandler = new FileHandler();
        List<Product> productList = new ArrayList<>(fileHandler.readProducts());
        List<Product> newProductsList = new ArrayList<>();

        String type = null;

        for (Product product : productList) {
            if (product.isIphone()) {
                type = "iphone";
            }
            if (product.isIwatch()) {
                type = "iwatch";
            }
            if (product.isIpad()) {
                type = "ipad";
            }
            if (product.isAirpods()) {
                type = "airpods";
            }
            if (product.isMac()) {
                type = "mac";
            }
            if (category.toLowerCase().equals(type)) {
                newProductsList.add(product);
            }
        }
        return newProductsList;
    }

    public ArrayList<String> makeNameList(List<Product> productList) {
        ArrayList<String> nameList = new ArrayList<>();
        for (Product product : productList){
            nameList.add(product.getName());
        }
        return nameList;
    }
    public ArrayList<String> makePriceList(List<Product> productList) {
        ArrayList<String> priceList = new ArrayList<>();
        for (Product product : productList){
            priceList.add(product.getPrice());
        }
        return priceList;
    }
    public ArrayList<String> makeQuantityList(List<Product> productList) {
        ArrayList<String> quantityList = new ArrayList<>();
        for (Product product : productList){
            quantityList.add(String.valueOf(product.getQty()));
        }
        return quantityList;
    }
    public ArrayList<String> makeYearList(List<Product> productList) {
        ArrayList<String> yearList = new ArrayList<>();
        for (Product product : productList){
            yearList.add(product.getYear());
        }
        return yearList;
    }
}
