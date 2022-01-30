package Lambda;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.OptionalDouble;
import java.util.OptionalInt;
import java.util.stream.Collectors;

public class C04_Lambda {



	public static void main(String[] args) {
		
		TechPro trGunduz = new TechPro("yaz","TR gunduz",97,124);
		TechPro engGunduz = new TechPro("kis","ENG gunduz",95,131);
		TechPro trGece = new TechPro("bahar","TR gece",98,143);
		TechPro engGece = new TechPro("sonbahar","ENG gece",93,151);

	List<TechPro> list = new ArrayList<>(Arrays.asList(trGunduz,engGunduz,trGece,engGece));
	
	// Bu class'da agirlikli return type calisacagiz
	
	
	System.out.println(batchOrt92Byk(list));
	System.out.println();
    System.out.println(" *** ");
	System.out.println(ogrcSayisi110Az(list));
	System.out.println();
    System.out.println(" *** ");
	System.out.println(herhangiBirBaharKontrol(list));
	System.out.println();
    System.out.println(" *** ");
    System.out.println(ogrSayisiTersSiraliBatch(list));
    System.out.println();
    System.out.println(" *** ");
    System.out.println(batchOrtTersSiraliBatch(list));
    System.out.println();
    System.out.println(" *** ");
    System.out.println(ogrcSayisiEnAz2Batch(list));
    System.out.println();
    System.out.println(" *** ");
    System.out.println(ogrcOrt95BuyukOgrcSayisi(list));
    System.out.println();
    System.out.println(" *** ");
    System.out.println(batchOrt95BuyukOgrcSayisi1(list));
    System.out.println();
    System.out.println(" *** ");
    System.out.println(ogrcSayisi130BuyukBatchOrt(list));
    System.out.println();
    System.out.println(" *** ");
    System.out.println(gunduzBatchSayisi(list));
    System.out.println();
    System.out.println(" *** ");
    System.out.println(ogrcSayisi130FazlaEnBykBatch(list));
    System.out.println();
    System.out.println(" *** ");
    System.out.println(ogrcSayisi150AzEnKckBatch(list));
}
	  // task 01--> batch ort'larinin 92 den buyuk oldg kontrol eden pr create ediniz.
	
      public static boolean batchOrt92Byk(List<TechPro> list) {
    
    	return list.
    	  stream().
    	  allMatch(t->t.getBatchOrt()>92); // Akistaki her eleman batchOrt field'a gore eslesmesi kontrol edildi
    	// true
      }	 
      
      // task 02-->ogrc sayilarinin hic birinin  110 den az olmadigini  kontrol eden pr create ediniz.
      
      public static boolean ogrcSayisi110Az(List<TechPro> list) {
      
     return list.
      stream().
      noneMatch(t->t.getOgrcSayisi()<110);// true
      }
      
      // task 03-->batch'lerde herhangi birinde "bahar" olup olmadigini  kontrol eden pr create ediniz.
      
     public static boolean herhangiBirBaharKontrol(List<TechPro> list) {
    	 
    	 return list.
    			 stream().
    			 anyMatch(t->t.getBatch().equals("bahar"));// true
     }
     
      // task 04-->batch'leri ogr sayilarina gore b->k siralayiniz.
     
      public static List<TechPro> ogrSayisiTersSiraliBatch(List<TechPro> list) {
    	 
    	return list.
    			 stream().
    			 sorted(Comparator.comparing(TechPro::getOgrcSayisi).
    			 reversed()).// OgrcSayisi parametresine gore ters siraladi
    			 collect(Collectors.toList());//collect()->akýsdaki elamanlarý istenen sarta gore toplar
    	                                      //Collectors.toList()->collect'e toplanan elemanlarilist'e cevirir
      }
      
      // task 05-->batch'leri batch ort gore  b->k siralayip ilk3 'unu yazdiriniz.
      
      public static List<TechPro> batchOrtTersSiraliBatch(List<TechPro> list) {
     	 
      	return list.
      			 stream().
      			 sorted(Comparator.comparing(TechPro::getBatchOrt).
      			 reversed()).
      			 limit(3). // Akistaki elemanlarin ilk ucu alindi     		
      			 collect(Collectors.toList()); // collect()->akýsdaki elamanlarý istenen sarta gore toplar
                                               //Collectors.toList()->collect'e toplanan elemanlari list'e cevirir      	
      }
      
       // task 06--> ogrc sayisi en az olan 2. batch'i  yazdiriniz.
      
      public static List<TechPro> ogrcSayisiEnAz2Batch(List<TechPro> list) {
      	 
        	return list.
        			 stream().
        			 sorted(Comparator.comparing(TechPro::getOgrcSayisi)).// ogrcSayisi parametresine gore  siraladi
        			 limit(2).// Ýlk iki eleman alindi
        			 skip(1).// Ýlk eleman atlatildi
        			 collect(Collectors.toList());// collect()->akýsdaki elamanlarý istenen sarta gore toplar 
      }
      
      // task 07--> batch ort 95 'den buyuk olan batch'lerin ogrc sayilarini toplamini yazdiriniz
      
      public static int ogrcOrt95BuyukOgrcSayisi(List<TechPro> list) {
       	 
      	 return list.
      			 stream().
      			 filter(t->t.getBatchOrt()>95).
      			 map(t->t.getOgrcSayisi()).
      			 // reduce(0,Integer::sum);// 267
      	         reduce(0,(t,u)->t+u);
      			
      } 
      
      // 
      
      public static int batchOrt95BuyukOgrcSayisi1(List<TechPro> list) {
        	 
       	 return list.
       			 stream().
       			 filter(t->t.getBatchOrt()>95).// 95 den buyuk satri saglandi
       			 mapToInt(t->t.getOgrcSayisi()). // 
       			 
       			 
       			 sum();		 
       			 
      } 
      
      // task 08--> ogrc sayilari 130 dan buyuk olan batch'lerin batch ort bulunuz
      
      public static OptionalDouble ogrcSayisi130BuyukBatchOrt(List<TechPro> list) {
     	 
        	 return list.
        			 stream().
        			 filter(t->t.getOgrcSayisi()>130).
        			 mapToInt(t->t.getBatchOrt()).  
        		     average();// OptionalDouble[95.33333333333333]
        					 
      }   
      
    // task 09-->gunduz batch'lerinin sayisini  yazdiriniz.
      
      public static int gunduzBatchSayisi(List<TechPro> list){
        return (int) list.
                  stream()
                  .filter(t->t.getBatchName().contains("gunduz")).count();

      }
      
    // task 10-->Ogrenci sayilari 130'dan fazla olan batch'lerin en buyuk batch ort'unu bulunuz
      
      public static OptionalInt ogrcSayisi130FazlaEnBykBatch(List<TechPro> list){
          return list.
                  stream()
                  .filter(t->t.getOgrcSayisi()>130).
                  mapToInt(TechPro::getBatchOrt).
                  max();

      }
      
    // task 11-->Ogrenci sayilari 150'dan az olan batch'lerin en kucuk batch ort'unu bulunuz. 
      
      public static int ogrcSayisi150AzEnKckBatch(List<TechPro> list){
          return list.
                  stream()
                  .filter(t->t.getOgrcSayisi()<150).
                  mapToInt(TechPro::getBatchOrt).
                  min().
                  getAsInt();//getAsInt()-->cýktýyý int type olarak return eder

      }
}   
