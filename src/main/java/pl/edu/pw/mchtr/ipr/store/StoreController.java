package pl.edu.pw.mchtr.ipr.store;

import java.io.File;
import java.util.List;

public interface StoreController {

    boolean checkParameters(String name, String description, List<File> photos, double price);

    boolean addProduct(String name, String description, List<File> photos, double price);

}
