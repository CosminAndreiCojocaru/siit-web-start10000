package siit.model;


public class Product {
    private Integer id;
    private String name;
    private Double weight;
    private Double price;
    private String url;

    public Product(Integer id, String name, Double weight, Double price) {
        this.id = id;
        this.name = name;
        this.weight = weight;
        this.price = price;
        this.url = "";


    }

    public Product() {

    }


    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", weight=" + weight +
                ", price=" + price +
                ", url='" + url + '\'' +
                '}';
    }

    public Double getWeight() {
        return weight;
    }

    public Double getPrice() {
        return price;
    }
}