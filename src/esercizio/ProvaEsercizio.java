import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ProvaEsercizio {
    public static void main(String[] args) {


//categoria dei libri
        Prodotto p1 = new Prodotto(35614L , "Twisted Games", "Books", 110);
        Prodotto p2 = new Prodotto(35224L , "Twisted Love", "Books", 20);
        Prodotto p3 = new Prodotto(38614L , "Twisted Hate", "Books", 102);
        Prodotto p3prov = new Prodotto(18314L , "Twisted Lies", "Books", 41);

        //categoria baby
        Prodotto p4 = new Prodotto(35614434L , "Ciuccio", "Baby", 21);
        Prodotto p5 = new Prodotto(15614141L , "Dionasauro", "Baby", 50);
        Prodotto p6 = new Prodotto(35631314L , "Pinguino", "Baby", 37);

        //categoria Boys
        Prodotto p7 = new Prodotto(12235614L , "Maglia", "Boys", 41);
        Prodotto p8 = new Prodotto(24535614L , "Pantaloni", "Boys", 61);
        Prodotto p9 = new Prodotto(97535614L , "Jeans", "Boys", 12);


        Cliente cliente1 = new Cliente(2347474L , "Topo Gigio",2 );
        Cliente cliente2 = new Cliente(4567474L , "Paperino",2 );
        Cliente cliente3 = new Cliente(8348474L , "Mario",1 );
        Cliente cliente4 = new Cliente(1245474L , "Luca",3);
        Cliente cliente5 = new Cliente(6347474L , "Luigi",2);
        Cliente cliente6 = new Cliente(4347474L , "Pierattilio",3);
        Cliente cliente7 = new Cliente(1789744L , "Pippo",3);

        ArrayList<Cliente> clienti= new ArrayList<>(Arrays.asList(cliente1,cliente2,cliente3,cliente4,cliente5,cliente6,cliente7));



        //ESERCIZIO 1
        ArrayList<Prodotto> prodotti = new ArrayList<>(Arrays.asList(p1, p2,p3,p4,p5,p6,p7,p8,p9,p3prov));
        prodotti.stream().filter(p -> p.getCategoria().contains("Books")).filter(p -> p.getPrezzo()>100).forEach(System.out::println);

        //ESERCIZIO2
        ArrayList<Prodotto> op1 = new ArrayList<>(Arrays.asList(p1, p2,p3,p4));
        ArrayList<Prodotto> op2 = new ArrayList<>(Arrays.asList(p4,p5,p6));
        ArrayList<Prodotto> op3 = new ArrayList<>(Arrays.asList(p8,p9));

        Ordine o1= new Ordine(247535L , "In arrivo" , LocalDate.of(2000,3,10), LocalDate.of(2000,3,13), op1,cliente1);
        Ordine o2baby= new Ordine(247535L , "In arrivo" , LocalDate.of(2021,2,3), LocalDate.of(2021,2,11), op2,cliente2);
        Ordine o2baby1= new Ordine(247535L , "In arrivo" , LocalDate.of(1999,4,7), LocalDate.of(1999,2,22), op2,cliente4);
        Ordine o2baby2= new Ordine(247535L , "In arrivo" , LocalDate.of(2010,8,10), LocalDate.of(2010,7,30), op2,cliente3);
        Ordine o3= new Ordine(247535L , "In arrivo" , LocalDate.of(2021,2,18), LocalDate.of(2021,2,22), op3,cliente2);


        ArrayList<Ordine>ordiniProdBaby=new ArrayList<>(Arrays.asList(o2baby1,o2baby,o2baby2,o1,o3));
        System.out.println("_____________________");
        ordiniProdBaby.stream().flatMap(ordine -> ordine.getProdotto().stream()).filter(prodotto -> prodotto.getCategoria().contains("Baby")).forEach(System.out::println);

        //esercizio 3
        System.out.println("_____________________");


        List<Prodotto> prodottiScontati=  prodotti.stream().filter(p -> p.getCategoria().contains("Boys")).map(prodotto -> {prodotto.setPrezzo( prodotto.getPrezzo() *0.9);
            return prodotto;}).toList();

        System.out.println(prodottiScontati);

        //esercizio 4
        System.out.println("_____________________");
        ordiniProdBaby.stream().filter(ordine -> ordine.getCliente().getTier()==2).filter(ordine -> ordine.getOrderDate().isBefore(LocalDate.of(2021,4,1))&& ordine.getOrderDate().isAfter(LocalDate.of(2021,2,1))).flatMap(ordine -> ordine.getProdotto().stream()).forEach(System.out::println);
    }
}