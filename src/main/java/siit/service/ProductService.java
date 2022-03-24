package siit.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import siit.db.ProductDao;
import siit.model.OrderProduct;
import siit.model.Product;

import java.util.List;

@Service
public class ProductService {

    @Autowired
    private ProductDao productDao;

    public static OrderProduct save(OrderProduct product) {
        return product;
    }

    public Product getBy(Integer productId) {
        return productDao.getBy(productId);
    }

    public List<Product> getBySearchTerm(String searchString) {
        return productDao.getLike(searchString);
    }

    public long findById(long l) {
        return l;
    }

}