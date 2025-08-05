public class Main {
    public static void main(String[] args) {
        MyList<Integer> liste = new MyList<>();

        // İlk durum
        System.out.println("Dizinin Kapasitesi : " + liste.getCapacity());
        System.out.println("Dizideki Eleman Sayısı : " + liste.size());

        // Eleman ekleme
        liste.add(10);
        liste.add(20);
        liste.add(30);
        liste.add(40);
        System.out.println("Dizideki Eleman Sayısı : " + liste.size());
        System.out.println("Dizinin Kapasitesi : " + liste.getCapacity());

        // Kapasite aşımı
        liste.add(50);
        liste.add(60);
        liste.add(70);
        liste.add(80);
        liste.add(90);
        liste.add(100);
        liste.add(110);
        System.out.println("Dizideki Eleman Sayısı : " + liste.size());
        System.out.println("Dizinin Kapasitesi : " + liste.getCapacity());

        // Get, Set, Remove örnekleri
        System.out.println("2. indisteki değer : " + liste.get(2));
        liste.remove(2);
        liste.add(40);
        liste.set(0, 100);
        System.out.println("2. indisteki değer : " + liste.get(2));
        System.out.println(liste.toString());

        // Diğer fonksiyonlar
        System.out.println("Liste Durumu : " + (liste.isEmpty() ? "Boş" : "Dolu"));
        System.out.println("Indeks : " + liste.indexOf(20));
        System.out.println("Indeks : " + liste.indexOf(1000));
        System.out.println("Son indeks : " + liste.lastIndexOf(40));
        Object[] dizi = liste.toArray();
        System.out.println("Dizinin ilk elemanı : " + dizi[0]);

        MyList<Integer> altListe = liste.subList(0, 3);
        System.out.println("Alt Liste : " + altListe.toString());

        System.out.println("20 içeriyor mu? " + liste.contains(20));
        System.out.println("999 içeriyor mu? " + liste.contains(999));

        liste.clear();
        System.out.println("Temizlendikten sonra: " + liste.toString());
    }
}
