package myhash;

public class MyHashChaining {
    Slot [] hashTable;

    public MyHashChaining(Integer size) {
        this.hashTable = new Slot[size];
    }

    public class Slot {
        String key;
        String value;
        Slot next;
        public Slot(String key, String value) {
            this.key = key;
            this.value = value;

            this.next = null;
        }
    }

    public int hashFunc (String key) {
        return key.charAt(0) & this.hashTable.length;
    }

    public boolean saveData(String key, String value) {
        int address = hashFunc(key);

        if(hashTable[address] != null) {
            Slot prevSlot = hashTable[address];
            Slot findSlot = hashTable[address];

            while (findSlot !=null){
                if (findSlot.key == key){
                    findSlot.value =value;
                    return true;
                }else {
                    prevSlot = findSlot;
                    findSlot = findSlot.next;
                }
            }

            prevSlot.next = new Slot(key,value);
        } else hashTable[address] = new Slot(key, value);

        return true;
    }

    public String getData (String key) {
        int address = hashFunc(key);

        if(hashTable[address] != null) {
            Slot findNode = hashTable[address];

            while (findNode != null) {
                if (findNode.key == key){
                    return findNode.value;
                }else {
                    findNode= findNode.next;
                }
            }
            return null;
        }
        return null;
    }

    public static void main(String[] args) {
        MyHashChaining myHash = new MyHashChaining(20);

        myHash.saveData("DaveLee", "01022223333");
        myHash.saveData("fun-coding", "01033334444");
        myHash.saveData("David", "01044445555");
        myHash.saveData("Dave", "01055556666");
        String David = myHash.getData("David");

        System.out.println("David = " + David);
    }
}
