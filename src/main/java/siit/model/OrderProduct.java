package siit.model;

public class OrderProduct {
    private Integer id;
    private Integer orderId;
    private Integer productId;
    private Double quantity;
    private Product product;
    private Double value;

    public OrderProduct(Integer id, Integer orderId, Integer productId, Double quantity) {
        this.id = id;
        this.orderId = orderId;
        this.productId = productId;
        this.quantity = quantity;
        this.value = 0.0D;
    }

    public Product getProduct() {
        return this.product;
    }

    public Double getValue() {
        return this.value;
    }

    public Integer getProductId() {
        return this.productId;
    }

    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getOrderId() {
        return this.orderId;
    }

    public Double getQuantity() {
        return this.quantity;
    }

    public void setValue(Double value) {
        this.value = value;
    }

    public void setProduct(Product product) {
        if (product != null) {
            this.product = product;
            this.value = this.getQuantity() * product.getPrice();
        }

    }

    public void setQuantity(Double quantity) {
        this.quantity = quantity;
        if (this.product != null) {
            this.setValue(this.quantity * this.product.getPrice());
        }

    }
}
