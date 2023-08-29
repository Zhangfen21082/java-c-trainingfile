package myHashCode;

public class myHashCode2<K, V>{
    static class Node<K, V>{
        public K key;
        public V val;
        public Node<K, V> next;

        public Node(K key, V val) {
            this.key = key;
            this.val = val;
        }
    }

    public Node<K, V>[] array = (Node<K, V>[])new Node[10];
    public int usedSize;
    public static final float loadFactor = 0.75F; //负载因子

    public Boolean put(K key, V val){
        Node<K, V> node = new Node<>(key, val);
        int index = key.hashCode() % this.array.length;
        Node<K, V> cur = this.array[index];
        while(cur != null){
            if(cur.key.equals(key)){
                cur.val = val;
            }
            cur = cur.next;
        }
        node.next = array[index];
        this.array[index] = node;
        this.usedSize++;
        return true;
    }

    public V get(K key){
        int index = key.hashCode() % this.array.length;
        Node<K, V> cur = this.array[index];
        while(cur != null){
            if(cur.key.equals(key)){
                return cur.val;
            }
            cur = cur.next;
        }
        return null;
    }
}
