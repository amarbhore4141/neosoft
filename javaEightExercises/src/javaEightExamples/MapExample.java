package javaEightExamples;

import java.util.*;
import java.util.stream.Collectors;

public class MapExample {
    public static void main(String[] args) {
        Map<Integer,String> banks=new HashMap<>();
        banks.put(1,"SBI");
        banks.put(2,"IDBI");
        banks.put(3,"SARASWAT BK");
        banks.put(4,"ICICI");
        banks.put(6,"Duestch BK");

        Set<Integer> keySet =banks.keySet();
        //first way
        for(Integer i:keySet){
            System.out.println(banks.get(i));
        }

        System.out.println("=======================iterator===========================");
        //By iterator
        Iterator<Integer> iterator =keySet.iterator();
        while(iterator.hasNext()){
            System.out.println(banks.get(iterator.next()));
        }

        //EntrySet
        System.out.println("======================EntrySet================================");
        Set<Map.Entry<Integer, String>> bnk=banks.entrySet();
        Iterator<Map.Entry<Integer,String>> iterator1=bnk.iterator();
        while(iterator1.hasNext()){
            System.out.println(iterator1.next());
        }

        //by java 8
        System.out.println("==============JAVA8->keySet==================");
        Set<Integer> abc=banks.keySet();
        abc.stream().forEach(n->System.out.println(banks.get(n)));

        System.out.println("==============JAVA8->entrySet==================");
        Set<Map.Entry<Integer,String>> df=banks.entrySet();
        df.stream().forEach(n->System.out.println(n));

        //filter values ending with I
        List<Map.Entry<Integer,String>> list=df.stream().filter(n->n.getValue().endsWith("I")).collect(Collectors.toList());
        System.out.println(list);

    }
}
