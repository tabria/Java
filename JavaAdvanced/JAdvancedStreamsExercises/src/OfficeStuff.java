import java.util.*;

public class OfficeStuff {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        Map<String, LinkedList<Products>> officeStuff = new HashMap<>();

        int number = Integer.valueOf(scanner.nextLine());
        for (int i = 0; i <number ; i++) {
            String[] companyStuffs = scanner.nextLine().replaceAll("\\|", "").split("\\s*-\\s*");
            addProducts(officeStuff, companyStuffs);
        }

        StringBuilder sb = new StringBuilder();
        officeStuff.entrySet().stream().sorted((a, b) -> a.getKey().compareTo(b.getKey())).forEach(kv -> {
            sb.append(kv.getKey())
                    .append(": ");
            kv.getValue().stream().forEach(prod -> {
                sb.append(prod.getProductName())
                        .append("-")
                        .append(prod.getProductQuantity())
                        .append(", ");
            });
            sb.delete(sb.length()-2, sb.length()-1)
                    .append("\r\n");
        });
        System.out.println(sb.toString());
    }

    private static void addProducts(Map<String, LinkedList<Products>> officeStuff, String[] companyStuffs) {

        String companyName = companyStuffs[0];
        String companyProduct = companyStuffs[2];
        long quant = Long.valueOf(companyStuffs[1]);

        boolean added = false;
        if (officeStuff.containsKey(companyName)) {
            for (Products prod : officeStuff.get(companyName)) {
                if (companyProduct.contains(prod.getProductName())){
                    prod.setProductQuantity(prod.getProductQuantity() + quant);
                    added = true;
                    break;
                }
            }
        } else {
            officeStuff.put(companyName, new LinkedList<>());
        }
        if (!added){
            officeStuff.get(companyName).add(new Products(companyProduct, quant));
        }
    }

}

class Products {

    private String productName;
    private long productQuantity;

    public Products(String productName, long productQuantity) {
        this.productName = productName;
        this.productQuantity = productQuantity;
    }

    public String getProductName() {
        return this.productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public long getProductQuantity() {
        return this.productQuantity;
    }

    public void setProductQuantity(long productQuantity) {
        this.productQuantity = productQuantity;
    }
}