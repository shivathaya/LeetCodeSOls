class LRUCache {
    class Node {
        int key;
        int val;
        Node prev;
        Node next;

        Node(int key, int val) {
            this.key = key;
            this.val = val;
        }
    }

    Map<Integer, Node> cache;
    Node head;  // dummy head - most recently used side
    Node tail;  // dummy tail - least recently used side
    int capacity;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.cache = new HashMap<>();

        // dummy nodes - avoids null checks
        head = new Node(0, 0);
        tail = new Node(0, 0);
        head.next = tail;
        tail.prev = head;
    }

    private void remove(Node node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    private void insertToHead(Node node) {
        node.next = head.next;
        node.prev = head;
        head.next.prev = node;
        head.next = node;
    }

    public int get(int key) {
        if (!cache.containsKey(key)) return -1;

        Node node = cache.get(key);
        remove(node);        // remove from current position
        insertToHead(node);  // move to most recently used
        return node.val;
    }

    public void put(int key, int val) {
        if (cache.containsKey(key)) {
            remove(cache.get(key));  // remove old node
        }

        Node node = new Node(key, val);
        cache.put(key, node);
        insertToHead(node);  // insert as most recently used

        if (cache.size() > capacity) {
            Node lru = tail.prev;  // least recently used
            remove(lru);
            cache.remove(lru.key);  // this is why Node stores key
        }
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */