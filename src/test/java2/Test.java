package test.java2;

public class Test<K> {
    private int StartSize = 101;
    int hash;// пусть пока будет так.
    //private V item;
    private int key;

    int method(K key) {
        return key.hashCode() % size();
    }

    int size() {
        return StartSize;
    }

    public int hashValue(K key) {
        if (key.getClass() == String.class) {
            char temp = 0;
            for (int i = 0; i < ((String) key).length(); i++) {
                temp += ((String) key).charAt(i);
            }
            int hashOfString = temp - temp % ((String) key).length();
            return hashOfString % size();
        }
        Integer t = Integer.valueOf((Integer) key);
        return t % 101;
    }

    //Альтернативная версия метода, более компактная.
    public int hashValue2(K key) {
        String buff = String.valueOf(key);
        char temp = 0;
        for (int i = 0; i < buff.length(); i++) {
            temp += buff.charAt(i);
        }
        //int hashOfString = temp - temp % buff.length();
        return temp % size();


    }

    public static void main(String[] args) {
        Test<Integer> test = new Test<>();
        Test<String> res = new Test<>();
        test.method(8);
        System.out.println(test.method(9));
        System.out.println(res.hashValue2("u79gD") + " i");
        System.out.println(test.hashValue2(77));
    }
}
