package lesson8;

public class HashTableChainImpl<K, V> implements HashTable<K, V> {

    static class Node<K, V> {
        final K key;
        V value;
        Node<K, V> next;

        public Node(K key, V value) {
            this.key = key;
            this.value = value;
        }

        @Override
        public String toString() {
            return key + "=" + value;
        }
    }

    private final Node<K, V>[] data;
    private int size;

    @SuppressWarnings({"unchecked"})
    public HashTableChainImpl(int initialCapacity) {
        data = new Node[initialCapacity * 2];
    }

    public HashTableChainImpl() {
        this(16);
    }

    private int hashFunc(K key) {
        return Math.abs(key.hashCode()) % data.length;
    }

    private Node<K, V> findNode(int index, K key) {
        Node<K, V> node = data[index];
        while (node != null) {
            if (node.key.equals(key)) {
                return node;
            }
            node = node.next;
        }
        return null;
    }

    @Override
    public boolean put(K key, V value) {
        int index = hashFunc(key);

        if (data[index] == null) {
            data[index] = new Node<>(key, value);
        } else {
            Node<K, V> node = findNode(index, key);
            if (node != null) {
                node.value = value;
                return true;
            }

            Node<K, V> newNode = new Node<>(key, value);
            newNode.next = data[index];
            data[index] = newNode;
        }

        size++;
        return true;
    }


    @Override
    public V get(K key) {
        int index = hashFunc(key);

        if (data[index] == null) {
            return null;
        }

        Node<K, V> node = findNode(index, key);
        if (node != null) {
            return node.value;
        }
        return null;
    }

    @Override
    public V remove(K key) {
        int index = hashFunc(key);

        if (data[index] == null) {
            return null;
        }

        // if it first node
        Node<K, V> node = data[index];
        if (node.key.equals(key)) {
            data[index] = node.next;
            node.next = null;
            size--;
            return node.value;
        }

        Node<K, V> prev = node;
        node = node.next;

        while (node != null) {
            if (node.key.equals(key)) {
                prev.next = node.next;
                node.next = null;
                size--;
                return node.value;
            }
            prev = node;
            node = node.next;
        }

        return null;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public void display() {
        int bucket = 0;
        Node<K, V> node;
        System.out.println("--------------------------");
        for (Node<K, V> item : data) {
            node = item;
            System.out.println("bucket: " + bucket);
            while (node != null) {
                System.out.println("\t" + node.key + ": " + node.value);
                node = node.next;
            }
            bucket++;
        }
        System.out.println("--------------------------");
    }
}
