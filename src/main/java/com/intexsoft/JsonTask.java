package com.intexsoft;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class JsonTask {
    List<List> jsonObjects = new ArrayList<>();
    Customer customer = new Customer();
    Orders orders;

    public static void main(String[] argv) {

    }

    public void fileReader(String fileName) throws IOException {
        StringBuilder sb = new StringBuilder();
        BufferedReader reader = new BufferedReader(new FileReader(fileName));
        String rl;
        while ((rl = reader.readLine()) != null) {
            if (rl.contains("orders")) {
                orders = new Orders();
            }
            if (rl.contains("orderno")) {
                orders.setOrderno(Integer.parseInt((rl.substring(0, rl.indexOf(':')))));
            }
        }
    }
}
