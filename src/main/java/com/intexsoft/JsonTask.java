package com.intexsoft;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class JsonTask {
    List<Orders> jsonOrders = new ArrayList<>();
    Customer customer;
    Orders orders;

    public static void main(String[] argv) throws IOException {
        JsonTask jsonTask = new JsonTask();
        jsonTask.fileReader("G:/second/selfstudy/justforfan/src/main/java/com/intexsoft/Order.json");
    }

    public void fileReader(String fileName) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(fileName));
        String rl;
        while ((rl = reader.readLine()) != null) {
            if (rl.contains("orders")) {
                orders = new Orders();
            }

            if (rl.contains("orderno")) {
                orders.setOrderno(Float.parseFloat(rl.substring((rl.indexOf(':'))).split("\"")[1]));
            }

            if (rl.contains("customer")) {
                customer = new Customer();
                orders.setCustomer(customer);
            }

            if (rl.contains("custid")) {
                customer.setCustid(Integer.parseInt(rl.substring((rl.indexOf(':'))).split("\"")[1]));
            }

            if (rl.contains("fname")) {
                customer.setfname(rl.substring((rl.indexOf(':'))).split("\"")[1]);
            }
        }
    }
}
