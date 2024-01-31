package pl.edu.pw.mchtr.ipr.store;

import pl.edu.pw.mchtr.ipr.game.GameService;
import pl.edu.pw.mchtr.ipr.game.RankingService;
import pl.edu.pw.mchtr.ipr.game.UserGameController;
import pl.edu.pw.mchtr.ipr.game.UsersGames;

import java.io.File;
import java.util.List;

public class UsersStoreController implements StoreController{

    private static StoreService storeService;
    private static ProductSaver productSaver;

    public UsersStoreController() {
        this(StoreService.getInstance(), ProductSaver.getInstance());
    }

    protected UsersStoreController(StoreService storeService, ProductSaver productSaver) {
        UsersStoreController.storeService = storeService;
        UsersStoreController.productSaver = productSaver;
    }

    @Override
    public boolean checkParameters(String name, String description, List<File> photos, double price) {
        return true;
    }

    @Override
    public boolean addProduct(String name, String description, List<File> photos, double price) {
        if (!checkParameters(name, description, photos, price)) {
            return false;
        }
        Product product = new Product(name, description, photos, price);
        productSaver.saveProduct(product);
        return true;
    }
}
