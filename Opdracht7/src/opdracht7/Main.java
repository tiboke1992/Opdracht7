/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package opdracht7;

import entitys.Person;
import entitys.PersonFacadeLocal;
import entitys.PlacedOrder;
import entitys.PlacedOrderFacadeLocal;
import entitys.Product;
import entitys.ProductFacadeLocal;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

/**
 *
 * @author stinson
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {
            Context c = new InitialContext();
            ProductFacadeLocal productenDB = (ProductFacadeLocal) c.lookup("java:global/Opdracht7EJB/ProductFacade");
            PersonFacadeLocal personDB = (PersonFacadeLocal) c.lookup("java:global/Opdracht7EJB/PersonFacade");
            PlacedOrderFacadeLocal orderDB = (PlacedOrderFacadeLocal) c.lookup("java:global/Opdracht7EJB/PlacedOrderFacade");
              //Producten toevoegen
            Product p1 = new Product();
            Product p2 = new Product();
            Product p3 = new Product();
            Product p4 = new Product();
            Product p5 = new Product();
            p1.setNaam("jersey");
            p1.setPrijs(200);
            p1.setAantalInVooraad(50);
            p2.setNaam("broek");
            p2.setPrijs(50);
            p2.setAantalInVooraad(20);
            p3.setNaam("jas");
            p3.setPrijs(133);
            p3.setAantalInVooraad(22);
            p4.setNaam("kousen");
            p4.setPrijs(10);
            p4.setAantalInVooraad(240);
            p5.setNaam("schoenen");
            p5.setPrijs(230);
            p5.setAantalInVooraad(10);
            p1 = (Product) productenDB.create(p1);
            p2 = (Product) productenDB.create(p2);
            p3 = (Product) productenDB.create(p3);
            p4 = (Product) productenDB.create(p4);
            p5 = (Product) productenDB.create(p5);
            //Einde producten toevoegen
 
            //Personen toevoegen
            Person per1 = new Person();
            Person per2 = new Person();
            Person per3 = new Person();
            Person per4 = new Person();
            per1.setName("Tibo");
            per1.setLastName("Hulens");
            per1.setAge(20);
            per2.setName("Joske");
            per2.setLastName("VErmeulen");
            per2.setAge(22);
            per3.setName("Tom");
            per3.setLastName("vw");
            per3.setAge(20);
            per4.setName("Else");
            per4.setLastName("Vanoven");
            per4.setAge(30);
            per1 = (Person) personDB.create(per1);
            per2 = (Person) personDB.create(per2);
            per3 = (Person) personDB.create(per3);
            per4 = (Person) personDB.create(per4);
            //Einde personen toevoegen
 
            //Orders toevoegen
            PlacedOrder o1 = new PlacedOrder();
            PlacedOrder o2 = new PlacedOrder();
            PlacedOrder o3 = new PlacedOrder();
            PlacedOrder o4 = new PlacedOrder();
            PlacedOrder o5 = new PlacedOrder();
            o1.setDatum("12");
            o2.setDatum("12");
            o3.setDatum("14");
            o4.setDatum("15");
            o5.setDatum("16");
            o1 = (PlacedOrder)orderDB.create(o1);
            o2 = (PlacedOrder)orderDB.create(o2);
            o3 = (PlacedOrder)orderDB.create(o3);
            o4 = (PlacedOrder)orderDB.create(o4);
            o5 = (PlacedOrder)orderDB.create(o5);
            //Einde orders toevoegen
           
            //aan de personen een lijst van orders meegeven aan persoon1
            List<PlacedOrder> l1 = new ArrayList<PlacedOrder>();
            l1.add(o1);
            l1.add(o2);
            per1.setOrders(l1);
            o1.setOwner(per1);
            o2.setOwner(per1);
            List<Product>prodList = new ArrayList<Product>();
            prodList.add(p1);
            prodList.add(p2);
            List<Product>prodList2 = new ArrayList<Product>();
            prodList2.add(p1);
            prodList2.add(p3);
            o1.setProducten(prodList);
            o2.setProducten(prodList2);
            o1 = (PlacedOrder)orderDB.edit(o1);
            o2 = (PlacedOrder)orderDB.edit(o2);
            per1 = (Person)personDB.edit(per1);
           
           
            //uitprinten iedereen da order heeft daarvan de order uitprinten
            List<Person> persoonlijst = personDB.findAll();
            StringBuilder str = new StringBuilder();
            for(Person x : persoonlijst){
                str.append("Persoon:");
                str.append(x.getName());
                str.append(" ");
                str.append(x.getLastName());
                str.append(" Age:");
                str.append(x.getAge());
                str.append("\n");
                str.append("Bestelling:");
                if(x.getOrders().isEmpty()){
                    str.append("Nog geen orders geplaatst!");
                    str.append("\n");
                }else{
                    List<PlacedOrder> orders = x.getOrders();
                    str.append("Al: ");
                    str.append(x.getOrders().size());
                    str.append(" Orders geplaatst namelijk : \n");
                    for(PlacedOrder s : orders){
                        str.append("Order: op den");
                        str.append(s.getDatum());
                        str.append("\n");
                        List<Product>prls = s.getProducten();
                        for(Product k : prls){
                            str.append("Product: ");
                            str.append(k.getNaam());
                            str.append("\n");
                        }
                    }
                }
            }
            System.out.println(str);
        } catch (NamingException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
}
