package siit.model;

import java.util.Locale;

public class OrderProduct {
    private Integer id;
    private Integer orderId;
    private Integer productId;
    private Double quantity;
    private Product product;
    private String product1;

    public void setValue(Double value) {
        this.value = value;
    }

    private Double value;

    public void setQuantity(Double quantity) {
        this.quantity = quantity;
        if ( product != null ) {
            setValue(this.quantity * product.getPrice());
        }
    }

    public String getProduct1(Locale.Category category) {
        return product1;
    }

    public void setProduct1(String product1) {
        this.product1 = product1;
    }

    public OrderProduct(Product product1) {
        this.product1 = String.valueOf(product1);
    }


    public OrderProduct(Integer id, Integer orderId, Integer productId, Double quantity) {
        this.id = id;
        this.orderId = orderId;
        this.productId = productId;
        this.quantity = quantity;
        this.value = 0.0;
    }

    public OrderProduct() {

    }


    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        if ( product != null ) {
            this.product = product;
            this.value = getQuantity() * product.getPrice();
        }
    }

    public Double getValue() {
        return value;
    }

    public Integer getProductId() {
        return productId;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getOrderId() {
        return orderId;
    }

    public Double getQuantity() {
        return quantity;
    }


    public void save(OrderProduct p) {
    }
}
