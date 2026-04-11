package BaiTapSS18;

public class ProductService {

    public void validate(Product p) throws Exception {

        if (p.getName() == null || p.getName().isEmpty())
            throw new Exception("Name invalid");

        if (p.getPrice() <= 0)
            throw new Exception("Price must > 0");

        if (p.getCatalog() == null || p.getCatalog().isEmpty())
            throw new Exception("Catalog required");

        if (p.getTitle() == null || p.getTitle().isEmpty())
            throw new Exception("Title required");
    }
}