import java.lang.Math;
import java.text.DecimalFormat;

public class StickerPrinter {
    private static final DecimalFormat df = new DecimalFormat("0.00");
    String[][] ProductList;

    public StickerPrinter(String[][] productList){
        ProductList = productList;
    }
    private boolean check (String[][] productList, String name){
        for( int i =0; i < productList.length; i++){
            if(productList[i][0] == name){
                return true;
            }
        }
        return false;
    }
    public String createSticker(String name){
        int price = 0;
        double tax = 0;
        if(check(ProductList, name) == false){
            return "INVALID_PRODUCT_NAME";
        }
        for( int i =0; i < ProductList.length; i++){
            if(ProductList[i][0] == name){
                try {
                    price = Integer.parseInt(ProductList[i][1]);
                    tax = Double.parseDouble(ProductList[i][2]);
//                    System.out.println(price);
//                    System.out.println(tax);
                }
                catch (Exception e){
                    return name + " INVALID_PRICE";
                }
            }
        }
        if(price < 0 || tax < 0){
            return name + " INVALID_PRICE";
        }
        double result = Math.round((price + (price * tax))*100.0)/100.0;
        return((name + " " + df.format(result)).replaceAll(",","\\."));

    }
}
