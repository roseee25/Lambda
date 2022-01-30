package Lambda;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

public class C02_Lambda {
	
    public static void main(String[] args) {
    	
        List<Integer> list = new ArrayList<>(Arrays.asList(12, -3, 65, 3, 7, 34, 22, -60, 42, 15));
        
        ciftKareMax(list);
        System.out.println();
        System.out.println(" *** ");
        toplaEl1(list);
        System.out.println();
        System.out.println(" *** ");
        carpCiftEl1(list);
        System.out.println();
        System.out.println(" *** ");
        carpCiftEl2(list);
        System.out.println();
        System.out.println(" *** ");
        min1(list);
        System.out.println();
        System.out.println(" *** ");
        min2(list);
        System.out.println();
        System.out.println(" *** ");
        min3(list);
        System.out.println();
        System.out.println(" *** ");
        min4(list);
        System.out.println();
        System.out.println(" *** ");
        onbestenBuyukKucukTekSayi(list);
        System.out.println();
        System.out.println(" *** ");
        ciftKareKucukBuyuk(list);
        System.out.println();
        System.out.println(" *** ");
        ciftKareBuyukKucuk(list);
        
    }

     // List'in cift olan elemanlarin karelerini aliniz ve en buyugunu yazdiriniz
    
    public static void ciftKareMax(List<Integer> list) {
    	
     // Optional<Integer> maxEl = list.stream().filter(C01_Lambda::ciftBul).map(t -> t * t).reduce(Integer::max);
    	
        Optional<Integer> maxEl = list.stream().filter(C01_Lambda::ciftBul).map(t -> t * t).reduce(Math::max);
        
     // Reduce(Math::max) da kullanilabilir ancak reduce(Integer::max); daha specific  oldugu icin hzili calisir

     // int maxEl = list.stream().filter(Lambda01::ciftBul).map(t -> t * t).reduce(Integer::max);
     // Reduce() returne edilen elelman null yada int 'den buyuk olur ihtimali icin Java guvenlik olarak handle ederek
     // Optional class' sart kosuyor
        
        System.out.println(maxEl);
    }

    // List'teki tum elemanlarin toplamini yazdiriniz.
    // Lambda Expression...
    
    public static void toplaEl1(List<Integer> list) {
    	
        int toplam = list.stream().reduce(0, (x, y) -> x + y);
      /*
        x  her zaman ilk degerini atanan degerden (0) alýr
        y her zaman degerini list.stream()'den alýr(akis)
        x ilk degerden sonraki degerlerini islemden alir
       */
        
        System.out.println(toplam);
        
    // System.out.println(list.stream().reduce(0,(x, y) -> x + y));
    }

    // List'teki tum elemanlarin toplamini yazdiriniz.
    // Method Reference...
    
    public static void toplaEl2(List<Integer> list) {
    	
        Optional<Integer> toplam = list.stream().reduce(Math::addExact);
        
     // Optional<Integer> toplam = list.stream().reduce(Integer::sum);

      /*
        x  her zaman ilk degerini atanan degerden (0) alýr
        y her zaman degerini list.stream()'den alýr(akis)
        x ilk degerden sonraki degerlerini islemden alir
       */
        
        System.out.println(toplam);
        
    // System.out.println(list.stream().reduce(0,(x, y) -> x + y));
    }

    // List'teki cift elemanlarin carpimini  yazdiriniz.
    // Method Reference...
    
    public static void carpCiftEl1(List<Integer> list) {
    	
        Optional<Integer> carp = list.stream().filter(C01_Lambda::ciftBul).reduce(Math::multiplyExact);
        System.out.println(carp);
    }

    // List'teki cift elemanlarin carpimini yazdiriniz.
    // Lambda expression...
    
    public static void carpCiftEl2(List<Integer> list) {
    	
        Integer carp = list.stream().filter(C01_Lambda::ciftBul).reduce(1, (x, y) -> (x * y));
        //pozitif deger uretiniz
        
        Integer carpPoz = list.stream().filter(C01_Lambda::ciftBul).reduce(-1, (x, y) -> (x * y));
        System.out.println(carp);
        System.out.println(carpPoz);
    }

    // List'teki elemanlardan en kucugunu 4 farklý yontem ile yazdiriniz
    
    // 1. Yontem Method Reference --> Integer class
    
    public static void min1(List<Integer> list) {
        Optional<Integer> min = list.stream().reduce(Integer::min);
        System.out.println(min);
    }

    // 2. Yontem Method Reference --> Math class
    
    public static void min2(List<Integer> list) {
    	
        Optional<Integer> min = list.stream().reduce(Math::min);
        System.out.println(min);
    }

    // 3. Yontem Method Reference --> Haluk class

    public static int minBul(int x, int y) {
        return x<y ?x:y;//ternary

    }
    public static void min3(List<Integer> list) {
    	
        Optional<Integer> min = list.stream().reduce(C02_Lambda::minBul);
        System.out.println(min);
    }
    
    // 4. Yontem Lambda Expression
    
    public static void min4(List<Integer> list) {
    	
      Integer  min = list.stream().reduce(Integer.MAX_VALUE,(x,y)->x<y?x:y);
        System.out.println(min);
    }

    // List'teki 15'ten buyuk en kucvuk tek sayiyi yazdiriniz
    
    public static void onbestenBuyukKucukTekSayi(List<Integer> list) {
    	
    // list.stream().filter(t->t % 2 == 1).filter(t->t>15).reduce(Integer::min);
    	
    	System.out.println(list.
    			stream().// Akýþa girdi
    			filter(t->t % 2 == 1 & t>15).// Tek ve 15'den Buyuk Sarti
    			reduce(Integer::min)); // Min Deger Reduce Edildi
    }
    
    // list'in cift  elemanlarinin kareleri ni kucukten buyuge yazdiriniz
       
        public static void ciftKareKucukBuyuk(List<Integer> list) {
        	
        	 list.
             stream().
             filter(C01_Lambda::ciftBul).
             map(t->t*t).
             sorted().//akýsa giren elelmanlar naturel order'e gore siralanir
             forEach(C01_Lambda::printEl); // 144 484 1156 1764 3600
        }

     // list'in tek  elemanlarinin kareleri ni buykten kucuge  yazdiriniz
        
        public static void ciftKareBuyukKucuk(List<Integer> list) {
        	
        	 list.
            stream().
            filter(t->t%2!=0).
            map(t->t*t).
            sorted(Comparator.reverseOrder()). // Akisa giren elemanlar ters siralanir
            forEach(C01_Lambda::printEl); // 4225 225 49 9 9 
        }
        
        
}

