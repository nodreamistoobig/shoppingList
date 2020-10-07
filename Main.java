package com.company;

import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;
import java.util.TreeMap;

public class Main {

    public static void main(String[] args) {
        TreeMap<String, Integer> products = new TreeMap<String, Integer>();
        TreeMap<String, TreeMap<String, Integer>> customers = new TreeMap<String, TreeMap<String, Integer>>();
        try(FileReader reader = new FileReader("list.txt"))
        {
            String name;
            String product;
            int num;
            Scanner sc = new Scanner(reader);
            while (sc.hasNext()){
                name = sc.next();
                product = sc.next();
                num = sc.nextInt();
                TreeMap<String, Integer> prod = new TreeMap<>();
                customers.put(name, prod);
                if (customers.get(name).isEmpty()){
                    prod.put(product, num);
                    customers.put(name, prod);
                }
                else{
                    TreeMap<String, Integer> prod1 = customers.get(name);
                    prod1.put(product, num);
                    customers.put(name, prod1);
                }
                System.out.println(customers);
            }
        }
        catch(IOException ex){

            System.out.println(ex.getMessage());
        }
        System.out.println(customers);
    }
}
