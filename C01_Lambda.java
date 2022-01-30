package Lambda;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class C01_Lambda {

	public static void main(String[] args) {
		
		/*
		   1) Lambda "Functional Programming"
		      "Functional Programming" de "Nasil yaparim?" degil "Ne yaparim?" dusunulur.
		   2) "Structured Programming" de "Ne yaparim?" dan cok "Nasil Yaparim?" dusunulur
		   3) "Functional Programming" hiz, code kisaligi, code okunabilirligi
		   ve hatasiz code yazma acilarindan cok faydalidir.
		   4) Lambda sadece collections'larda(List, Queue ve Set) ve array'lerde kullanilabilir ancak map'lerde kullanýlmaz.
		      Lambda kullanmak hatasýz code kullanmaktýr.
		*/
		
		List<Integer> list = new ArrayList<>(Arrays.asList(12,13,65,3,7,34,22,68,42,55));
		
		printElStructured(list);
		System.out.println();
		System.out.println("   *********  ");
		printElfunctional(list);
		System.out.println();
		System.out.println("   *********  ");
		printElfunctional1(list); 
		System.out.println();
		System.out.println("   *********  ");
		printCiftElStuructured(list);
		System.out.println();
		System.out.println("   *********  ");
		printCiftElFunctional1(list);
		System.out.println();
		System.out.println("   *********  ");
		printCiftElFunctional2(list);
		System.out.println();
		System.out.println("   *********  ");
		printCiftAltmisKucuk(list);
		System.out.println();
		System.out.println("   *********  ");
		printtekYirmiBuyuk(list);
		System.out.println();
		System.out.println("   *********  ");
		printKare(list);
		System.out.println();
		System.out.println("   *********  ");
		printKupBirFazlaTekFunctional(list);
		System.out.println();
		System.out.println("   *********  ");
		printKarakokCiftFunctional(list);
		System.out.println();
		System.out.println("   *********  ");
		printMaxElfunction(list);
		}
	
	     // structured Paraming ile list elemanlarin tamamini aralarina bosluk býrakarak yazdiriniz
	
	     public static void printElStructured(List<Integer> list) {
		
		for (Integer w : list) {
			System.out.print(w+" "); // 12 13 65 3 7 34 22 68 42 55 
				
		}		
	}
		 // Functional Paraming ile list elemanlarin tamamini aralarina bosluk býrakarak yazdiriniz
		
		  public static void printElfunctional(List<Integer> list) {
			
			list.stream().forEach(t-> System.out.print(t+" ")); // 12 13 65 3 7 34 22 68 42 55
			
			// strem() : Datalari yukaridan asagiya akis sekline getirir
			// forEach() : Datanin parametresine gore her bir elemani isler
			// t-> : Lambda operatoru
			// Lambda Expression yapisi cok tavsiye edilmez daha cok METHOD REFERENCE kullanilir
	}
		
		    // Method Reference --> kendi create ettigimiz veya java'dan aldigimiz method ile 
		    // ClassName:MethodName --> ez-ber-leeeeee
		
	       public static void printEl(int t) { // Refere edilecek method create edildi
	    	 
	    	 System.out.print(t+" ");
	    	 
	     }
	     
	       public static void  printElfunctional1(List<Integer> list) {
	    	
	    	list.stream().forEach(C01_Lambda::printEl); // 12 13 65 3 7 34 22 68 42 55 
	    		    	
    }
	    
	       // structured Paraming ile list elemanlarin cift elemanlarini ayni satirda  aralarina bosluk býrakarak yazdiriniz
	     
	       public static void printCiftElStuructured(List<Integer> list) {
	    	
	    	for (Integer w : list) {
	    		if (w%2==0) {
					System.out.print(w+" "); // 12 34 22 68 42 
				} 

				}
    }	
	    	// Functional  Paraming ile list elemanlarin cift elemanlarini ayni satirda  aralarina bosluk býrakarak yazdiriniz
				
	    	public static void printCiftElFunctional1(List<Integer> list) {
	    		
	    		list.stream().filter(t-> t%2==0).forEach(C01_Lambda::printEl); // 12 34 22 68 42 	    		
	    		// filter()--> akis icerisindeki elemanlari istenen sarta gore filtreleme yapar
	    	}
	    	
	    	public static boolean ciftBul(int i) { // Refere edilecek tohum method create edildi
	    		
	    		return i%2==0;
	    	}
            public static void printCiftElFunctional2(List<Integer> list) {
	    		
	    		list.stream().filter(C01_Lambda::ciftBul).forEach(C01_Lambda::printEl); // 12 34 22 68 42 
	}
           // Functional  Paraming ile list elemanlarin cift olanlarini 60 dan kucuk olanlarini  ayni satirda  aralarina bosluk býrakarak yazdiriniz
	    
            public static void printCiftAltmisKucuk(List<Integer> list) {
            	
            	list.stream().filter(t->t%2==0 & t<60).forEach(C01_Lambda::printEl); // 12 34 22 42 
            }
            
            // Functional  Paraming ile list elemanlarin tek olanlarini veya 20 den buyuk olanlarini  ayni satirda  aralarina bosluk býrakarak yazdiriniz    
            
            public static void printtekYirmiBuyuk(List<Integer> list) {
            	
            	list.stream().filter(t->t%2==1 || t>20).forEach(C01_Lambda::printEl); // 13 65 3 7 34 22 68 42 55 
            }
            
           // Functional  Paraming ile list elemanlarin cift olanlarini  karelarini  ayni satirda  aralarina bosluk býrakarak yazdiriniz
            
            public static void printKare(List<Integer> list) {
            	
            	list.stream().filter(C01_Lambda::ciftBul).map(t->t*t).forEach(C01_Lambda::printEl); // 144 1156 484 4624 1764
            	
            	// map()--> Bir ara islemde kullanilabilir.Elemanlari istenen isleme gore degistirmek update etmek icin kullanilir
            }
            
            // Functional Programming ile list elemanlarinin  tek olanlarinin
            // kuplerinin bir fazlasini ayni satirda aralarina bosluk birakarak yazdiriniz
            
            public static void printKupBirFazlaTekFunctional(List<Integer> list) {
            	
            	list.stream().filter(t->t%2==1).map(t->(t*t*t)+1).forEach(C01_Lambda::printEl); // 2198 274626 28 344 166376 
            	
            }
            
            //Functional Programming ile list elemanlarinin  cift olanlarinin
            // karekoklerini ayni satirda aralarina bosluk birakarak yazdiriniz
            
            public static void printKarakokCiftFunctional(List<Integer> list) {
            	
            	list.stream().filter(C01_Lambda::ciftBul).map(Math::sqrt).forEach(t->System.out.print(t+" ")); // 3.4641016151377544 5.830951894845301 4.69041575982343 8.246211251235321 6.48074069840786 
            	            	
      }
            
           //list'in en buyuk elemanini yazdiriniz  
            
            public static void printMaxElfunction(List<Integer> list) {
            	
            	Optional<Integer> maxEl = list.stream().reduce(Math::max);
            	System.out.println(maxEl); // Optional[68]
            	
            	// reduce--> Azaltmak ... Bir cok datayi tek bir dataya(max min carp top vs islemlerde) cevirmek icin kullanilir            }



	}

}
