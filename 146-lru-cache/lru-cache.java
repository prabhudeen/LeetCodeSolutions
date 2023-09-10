class LRUCache {
 private LinkedHashMap<Integer, Integer> cache;
 private int capacity;
    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.cache = new LinkedHashMap<Integer, Integer>(capacity);
    }
    
    public int get(int key) {
        if(cache.get(key) == null) return -1;
        int value = cache.get(key);
        cache.remove(key);
        cache.put(key, value);
        return value;
        
    }
    
    public void put(int key, int value) {
        if(this.capacity == cache.size() && cache.get(key) == null) {
            Iterator<Map.Entry<Integer, Integer>> iterator = cache.entrySet().iterator();
            if(iterator.hasNext()) {
                iterator.next();
                iterator.remove();
            }
        }
        if(cache.get(key) != null) {
            cache.remove(key);
        }
         cache.put(key, value);
        
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */