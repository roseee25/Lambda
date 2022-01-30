package Lambda;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Stream;

public class C03_Lambda {

	public static void main(String[] args) {
		
		List<String> list = new ArrayList<>(Arrays.asList("Mehmet","Emre","Nilgun","Yildiz",
				"Kader","Emine","Ýslam","Ýslam","Kokorec"));
	
		buyukHarfTekrarsizSira(list);
		System.out.println();
        System.out.println(" *** ");
        karakterSayisiTekrarsizResSirali(list);
        System.out.println();
        System.out.println(" *** ");
        karakterSayisiSiraliEl(list);
        System.out.println();
        System.out.println(" *** ");
        sonHarfTersSiraliEl(list);
        System.out.println();
        System.out.println(" *** ");
        ciftKareTekrasizTersSira(list);
        System.out.println();
        System.out.println(" *** ");
        harfSayisi7Kontrol(list);
        System.out.println();
        System.out.println(" *** ");
        wBaslamaKontrol(list);
        System.out.println();
        System.out.println(" *** ");       
        xBitmeKontrol(list);
        System.out.println();
        System.out.println(" *** "); 
        karakteriEnBuyukEl(list);
        System.out.println();
        System.out.println(" *** "); 
        karakteriEnBuyukEl2(list);
        System.out.println();
        System.out.println(" *** "); 
        ilkElemanHaricSonHarfSirali(list);
	}
	
	// List elemanlarini alafabetik buyuk harf ve  tekrarsiz yazdiriniz
	
	public static void buyukHarfTekrarsizSira(List<String> list) {
		
		list.
		stream().// Akisa girdi
		// map(t->t.toUpperCase()).// Elemanlar buyuk harf update edildi
		map(String::toUpperCase).
		sorted().// Elemanlar buyuk harf update edildi
		distinct().// Tekrarsiz yapildi.............. cooook onemli 
        forEach(t->System.out.print(t + " "));//yazdirilidi //  EMRE EMÝNE KADER MEHMET NÝLGUN YILDIZ ÝSLAM		
	}
   
	// list elelmanlarinin character sayisini ters sirali olarak tekrarsiz yazdiriniz
	
	public static void karakterSayisiTekrarsizResSirali(List<String> list) {
		
		list.
		stream().
		map(t->t.length()).// String data character sayisina update edildi
		sorted(Comparator.reverseOrder()).// Ters sira
		distinct().// Tekrarsiz
		forEach(C01_Lambda::printEl);// Yazdirildi // 6 5 4 
		
	}
	
	// List elemanlarini character sayisina gore kucukten buyuge gore yazdiriniz.
	
	public static void karakterSayisiSiraliEl(List<String> list) {
		
		list.
		stream().
		sorted(Comparator.comparing(t->t.length())).// Eleman character sayisina göre ozel siralama yapildi
		forEach(t->System.out.print(t + " ")); // Emre Emre Kader Emine Ýslam Ýslam Mehmet Nilgun Yýldýz 
		
	}
	
	// list elelmanlarinin son harfine gore ters sirali yazdiriniz
	
     public static void sonHarfTersSiraliEl(List<String> list) {
		
		list.
		stream().
		sorted(Comparator.
				comparing(t->t.toString().
				         charAt(t.toString().length()-1)).// Elemanin length()-1 --> son index'inin karekterini alir
		reversed()).// Elemanin length()-1 --> son index'inin karekterini ters siralar z->a
		forEach(t->System.out.print(t + " ")); // Yýldýz Mehmet Kader Nilgun Ýslam Ýslam Emre Emine Emre 
     }	
     
     // List'in elemanlarin karakterlerinin cift sayili karakterlerini  hesaplayan, ve karelerini tekrarsiz buyukten kucuge sirali  yaziniz.
    
     
     public static void ciftKareTekrasizTersSira(List<String> list) {
 		
 		list.
 		stream().
 		// filter(t->t.length()% 2 == 0).
 		map(t->t.length()*t.length()).// String elemanlar character sayisina cevirildi
 		filter(C01_Lambda::ciftBul).// Cift sarti calisti
 		distinct().// Tekrarsiz
 		sorted(Comparator.reverseOrder()).// Ters sira b->k
 		forEach(C01_Lambda::printEl); // Yazdirildi // 36 16 
 		
     }
     
     // List elelmmalarinin karakter sayisini 7 ve 7 'den az olma durumunu kontrol ediniz
     
     public static void harfSayisi7Kontrol(List<String> list) {
  		
  		/*
  		 boolean kontrol = list.
  		
  		 stream().
  		allMatch(t->t.length()<=7); // Herbir elemani harf sayisini <=7 ye eslesmesine bakti
  		if (kontrol) {
  			System.out.println("List Elemanlari 7 Harften BUYUK Degil");
			
		}else {
			System.out.println("List Elemanlari 7 Harften Buyuk ");
		}
  		System.out.println(kontrol); // true 
  		*/
  		
     System.out.println(list.stream().allMatch(t-> t.length() <= 7)?"List Elemanlari 7 Harften BUYUK Degil"
    		 :"List Elemanlari 7 Harften Buyuk ");
    
	}
     
     // List elelmanlarinin "W" ile baslamasýný kontrol ediniz
     
     public static void wBaslamaKontrol(List<String> list) {
  		
    	 System.out.println(list.
    			 stream().
    			 noneMatch(t-> t.startsWith("w"))?"w ile Baslayan Ýsim Kimse Ayaga Kalksin"
        		 :"AGAM w ile Baslayan Ýsim Olurmu ");
  	
     }
     
     // List elelmanlarinin "x" ile biten en az bir elemani kontrol ediniz
     
     public static void xBitmeKontrol(List<String> list) {
   		
    	 System.out.println(list.
    			 stream().
    			 noneMatch(t-> t.endsWith("x"))?"x ile Baslayan Ýsim Kimse Ayaga Kalksin"
        		 :"AGAM x ile Baslayan Ýsim Olurmu ");
    	 
    	// anyMatch() --> enaz bir eleman sarti saglarsa true aksi durumda false return eder
    	// allMatch() --> tum  elemanlar sarti saglarsa true en az bir eleman sarti saglamazsa false return eder.
    	// noneMatch() --> hic bir sarti SAGLAMAZSA true en az bir eleman sarti SAGLARSA false return eder.    	 
     
     }
     
     // Karakter sayisi en buyuk elemani yazdiriniz
     
     public static void karakteriEnBuyukEl(List<String> list) {
    	 
     System.out.println( list.
  		stream().
  		sorted(Comparator.comparing(t->t.toString().length()).// Lenght karakter uzunluga gore siraladi k->b
  		reversed()).// Ters siraladi b->k
  	    findFirst());// Ýlk elemani aldi // Optional[Kokorec]
  		
     }
    
     public static void karakteriEnBuyukEl2(List<String> list) {
    	 
      Stream<String> sonIsim = list.
      		stream().
      		sorted(Comparator.comparing(t->t.toString().length()).// Lenght karakter uzunluga gore siraladi k->b
      		reversed()).// Ters siraladi b->k
      	    // findFirst());// Ýlk elemani aldi // Optional[Kokorec]
      		limit(1);// Limit(a) akýþtan cikan elemanlari a parametresine gore ilk a elemani alýr
      		System.out.println(Arrays.toString(sonIsim.toArray())); // [Kokorec]
     }
     
     // list elemanlarini son harfine göre siralayýp ilk eleman hariç kalan elemanlari yazdiniz
     
     public static void ilkElemanHaricSonHarfSirali(List<String> list) {
    	 
            list.
         		stream().
         		sorted(Comparator.comparing(t -> t.toString().charAt(t.length() - 1))).
         		skip(1).
         		forEach(t-> System.out.print(t + " "));
     }       		
}
