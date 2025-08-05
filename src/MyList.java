public class MyList<T> {
    private T[] array;
    private int size = 0;
    private int capacity;

    // Varsayılan kapasite
    private static final int DEFAULT_CAPACITY = 10;

    // Default constructor
    public MyList() {
        this.capacity = DEFAULT_CAPACITY;
        this.array = (T[]) new Object[capacity];
    }

    // Kapasite belirleme constructor'ı
    public MyList(int capacity) {
        this.capacity = capacity;
        this.array = (T[]) new Object[capacity];
    }

    // Eleman ekleme
    public void add(T data) {
        if (size >= capacity) {
            increaseCapacity();
        }
        array[size++] = data;
    }

    // Kapasiteyi 2 katına çıkarma
    private void increaseCapacity() {
        capacity *= 2;
        T[] newArray = (T[]) new Object[capacity];
        for (int i = 0; i < size; i++) {
            newArray[i] = array[i];
        }
        array = newArray;
    }

    // Eleman sayısı
    public int size() {
        return size;
    }

    // Kapasite
    public int getCapacity() {
        return capacity;
    }

    // Belirli bir index'teki elemanı getir
    public T get(int index) {
        if (index < 0 || index >= size) return null;
        return array[index];
    }

    // Belirli bir index'teki elemanı sil
    public T remove(int index) {
        if (index < 0 || index >= size) return null;
        T removed = array[index];
        for (int i = index; i < size - 1; i++) {
            array[i] = array[i + 1];
        }
        array[--size] = null;
        return removed;
    }

    // Belirli bir index'teki elemanı değiştir
    public T set(int index, T data) {
        if (index < 0 || index >= size) return null;
        T old = array[index];
        array[index] = data;
        return old;
    }

    // Listeyi yazdır
    @Override
    public String toString() {
        if (size == 0) return "[]";
        StringBuilder sb = new StringBuilder("[");
        for (int i = 0; i < size; i++) {
            sb.append(array[i]);
            if (i != size - 1) sb.append(",");
        }
        sb.append("]");
        return sb.toString();
    }

    // İlk index
    public int indexOf(T data) {
        for (int i = 0; i < size; i++) {
            if (array[i].equals(data)) return i;
        }
        return -1;
    }

    // Son index
    public int lastIndexOf(T data) {
        for (int i = size - 1; i >= 0; i--) {
            if (array[i].equals(data)) return i;
        }
        return -1;
    }

    // Liste boş mu?
    public boolean isEmpty() {
        return size == 0;
    }

    // Listeyi array olarak döndür
    public T[] toArray() {
        T[] result = (T[]) new Object[size];
        for (int i = 0; i < size; i++) {
            result[i] = array[i];
        }
        return result;
    }

    // Listeyi temizle
    public void clear() {
        this.capacity = DEFAULT_CAPACITY;
        this.array = (T[]) new Object[capacity];
        this.size = 0;
    }

    // Alt liste döndür
    public MyList<T> subList(int start, int finish) {
        if (start < 0 || finish >= size || start > finish) return null;
        MyList<T> subList = new MyList<>(finish - start + 1);
        for (int i = start; i <= finish; i++) {
            subList.add(array[i]);
        }
        return subList;
    }

    // Belirli bir veri var mı?
    public boolean contains(T data) {
        return indexOf(data) != -1;
    }
}
