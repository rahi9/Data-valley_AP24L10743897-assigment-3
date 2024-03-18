import java.io.*;

class Product implements Serializable {
    private static final long serialVersionUID = 1L;
    private int id;
    private String name;
    private String category;
    private double price;

    public Product(int id, String name, String category, double price) {
        this.id = id;
        this.name = name;
        this.category = category;
        this.price = price;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", category='" + category + '\'' +
                ", price=" + price +
                '}';
    }
}

public class serialization {
    public static void main(String[] args) {
       
        Product product = new Product(1, "mobile", "Electronics", 999.99);
        try {
            FileOutputStream fileOut = new FileOutputStream("product.ser");
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            out.writeObject(product);
            out.close();
            fileOut.close();
            System.out.println("Serialized data is saved in product.ser");
        } catch (IOException i) {
            i.printStackTrace();
        }

       
        Product deserializedProduct = null;
        try {
            FileInputStream fileIn = new FileInputStream("product.ser");
            ObjectInputStream in = new ObjectInputStream(fileIn);
            deserializedProduct = (Product) in.readObject();
            in.close();
            fileIn.close();
        } catch (IOException | ClassNotFoundException i) {
            i.printStackTrace();
            return;
        }

        System.out.println("Deserialized Product:");
        System.out.println(deserializedProduct);
    }
}