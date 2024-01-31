package pl.edu.pw.mchtr.ipr.store;

import java.util.List;

public final class StoreService {
    private static StoreService instance;

    private StoreService() {

    }

    public static StoreService getInstance() {
        if (instance == null) {
            instance = new StoreService();
        }
        return instance;
    }

    public void update() {

    }
    public Product getProduct(int id) {
        return null;
    }
    public Product findProduct(int id) {
        return null;
    }
    public List<Integer> getSonSaleProducts(){
        return null;
    }

}
