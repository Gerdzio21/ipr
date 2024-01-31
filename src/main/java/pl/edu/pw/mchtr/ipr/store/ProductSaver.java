package pl.edu.pw.mchtr.ipr.store;

import pl.edu.pw.mchtr.ipr.game.GameService;

import java.util.List;

public final class ProductSaver {
    private static ProductSaver instance;

    private ProductSaver() {

    }

    public static ProductSaver getInstance() {
        if (instance == null) {
            instance = new ProductSaver();
        }
        return instance;
    }

    public void saveProduct(Product product) {

    }
}
