package myhash;

public class MyHash {
    Slot [] hashTable;

    public MyHash(Integer size) {
        this.hashTable = new Slot[size];
    }

    public class Slot {
        String value;

        public Slot(String value) {
            this.value = value;
        }
    }

    public int hashFunc (String key) {
        return key.charAt(0) & this.hashTable.length;
    }

    public boolean saveData(String key, String value) {
        int address = hashFunc(key);

        if(hashTable[address] != null) hashTable[address].value = value;
        else hashTable[address] = new Slot(value);

        return true;
    }

    public String getData (String key) {
        int address = hashFunc(key);

        if(hashTable[address] != null) return hashTable[address].value;
        return null;
    }

    public static void main(String[] args) {
        MyHash myHash = new MyHash(20);
        myHash.saveData("kim", "01082460887");

        String kim = myHash.getData("kim");

        System.out.println("kim = " + kim);
    }
}
