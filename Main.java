package com.company;

import com.sun.source.tree.Tree;

import java.io.FileReader;
import java.io.IOException;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class Main {

    public static void main(String[] args) {
        TreeMap<String, Integer> products = new TreeMap<>();
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

                if (customers.containsKey(name)){
                    if (customers.get(name).containsKey(product)){
                        int n = customers.get(name).get(product);
                        n+=num;
                        customers.get(name).put(product,n);
                    }
                    else
                        customers.get(name).put(product, num);
                }
                else{
                    customers.put(name, new TreeMap<>());
                    TreeMap<String, Integer> name_prod= customers.get(name);
                    name_prod.put(product, num);
                }
            }
        }
        catch(IOException ex){

            System.out.println(ex.getMessage());
        }

        for (String customer: customers.keySet()) {
            System.out.println(customer + ":");
            for (Map.Entry<String, Integer> product: customers.get(customer).entrySet())
                System.out.println(product.getKey() + " " + product.getValue());
        }
    }
}
