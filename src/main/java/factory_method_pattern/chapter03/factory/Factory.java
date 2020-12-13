package factory_method_pattern.chapter03.factory;

import factory_method_pattern.chapter03.product.Product;

public abstract class Factory {
    public static final String SAMSUNG = "samsung";
    public static final String LG = "lg";

    public final Product create(String modelType) {
        return createProduct(modelType);
    }

    public abstract Product createProduct(String modelType);
}
