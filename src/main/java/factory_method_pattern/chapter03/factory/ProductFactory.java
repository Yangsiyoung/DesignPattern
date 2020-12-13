package factory_method_pattern.chapter03.factory;

import factory_method_pattern.chapter03.product.LGProduct;
import factory_method_pattern.chapter03.product.Product;
import factory_method_pattern.chapter03.product.SamsungProduct;

public class ProductFactory extends Factory{
    @Override
    public Product createProduct(String modelType) {
        switch (modelType) {
            case Factory.SAMSUNG:
                return new SamsungProduct();
            case Factory.LG:
                return new LGProduct();
            default:
                return new SamsungProduct();
        }
    }
}
