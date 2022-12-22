package com.example.supplychain17dec;

public class Order {
    public static boolean placeOrder(String customerEmail,Product products){
        Database_Connection databaseConnection=new Database_Connection();
        String query=String.format("insert into orders(customer_id,product_id) values ((select customer_id from customer where EmailId='%s'),%s)",customerEmail,products.getId());
        int rowCount=0;
        try {
            rowCount=databaseConnection.executeUpdateQuery(query);
        }catch (Exception e)
        {
            e.printStackTrace();
        }

        return rowCount!=0;
    }
}
