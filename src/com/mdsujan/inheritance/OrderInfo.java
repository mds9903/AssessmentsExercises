package com.mdsujan.inheritance;
//"Define an abstract class.
// Let them provide a concrete implementation.
// Ex: GetOrderInfoUserExit with getOrderInfo abstract method
// Provide 2 impl
// 1 to get from static list etc.
// 2. from API Call - can be dummy impl
// Read the impl to be used from the property file.
// Let programme dynamically use the configured impl."

import java.io.*;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class OrderInfo extends GetOrderInfoUserExit{
    static List<Order> orders = new ArrayList<>();

    public static void main(String[] args) {
        OrderInfo obj = new OrderInfo();
        String propsFile = "src/com.mdsujan.Inheritance/config.properties";
        try {
            FileInputStream file = new FileInputStream(propsFile);
            Properties properties = new Properties();
            properties.load(file);
//            System.out.println((String) properties.get("Implementation_GetOrderInfo"));
            String methodName = (String) properties.get("Implementation_GetOrderInfo");
            Method method = obj.getClass().getDeclaredMethod(methodName);
            method.invoke(obj);

//            // get the properties file contents
//            String contents = getFileContents(file);

        } catch (Exception e) {
            System.out.println(e);
        }
    }

    private static String getFileContents(FileInputStream file) throws IOException {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(file));
        String line = "";
        StringBuilder contents = new StringBuilder();
        while((line = buffer.readLine()) != null){
//            System.out.println(line);
            contents.append("|\n").append(line);
        }
        return contents.toString();
    }

    @Override
    void getOrderInfo() {
        System.out.println("From static list of orders");
        System.out.println(orders);
    }

    void myAPI(Order order){
        System.out.println("From myAPI");
        System.out.println(order.toString());
    }
}
