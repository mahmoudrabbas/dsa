package MRA.DSA;

public class HashTable<T> {
    int size;
    Entry<T> [] hashArray;

    public HashTable(int size){
        this.size = size;
        hashArray = new Entry[size];

        for (int i = 0; i < size; i++) {
            hashArray[i] = new Entry<>();
        }
    }


    private int getIndex(int key){
        return key%size;
    }

    //o(n)
    public boolean put(int key, T value){
        if(search(key)){
            return false;
        }
        int index = getIndex(key);
        Entry head = hashArray[index];
        Entry newEntry = new Entry<T>(key, value);
        newEntry.next = head.next;
        head.next = newEntry;
        return true;
    }

    public T get(int key){
        T val = null;
        int index = getIndex(key);
        Entry head = hashArray[index];
        while (head!=null){
            if(head.getKey() == key){
                val = (T)head.getValue();
                break;
            }
            head = head.next;
        }
        return val;
    }

    public boolean search(int key){
        boolean found = false;
        int index = getIndex(key);
        Entry temp = hashArray[index];
        while (temp!=null){
            if(temp.getKey() == key){
                found=true;
            }
            temp = temp.next;
        }
        return found;
    }

    public boolean remove(int key){
        if(!search(key)){
            return false;
        }else {
            int index = getIndex(key);
            Entry current =hashArray[index];
            Entry prev = current;
            while (current.getKey()!=key){
                prev = current;
                current=current.next;
            }

            prev.next = current.next;
            return true;
        }

    }
}




class Entry<T> {
    private int key;
    private T value;
    Entry next;

    public Entry(){
        next = null;
    }

    public Entry(int key, T value){
        this.key = key;
        this.value = value;
        next = null;
    }

    public int getKey() {
        return key;
    }

    public T getValue() {
        return value;
    }
}
