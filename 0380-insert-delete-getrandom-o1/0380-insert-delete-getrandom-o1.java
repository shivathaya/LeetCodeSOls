class RandomizedSet {

    private Map<Integer, Integer> map;
    private List<Integer> lst;
    private Random rand;
    public RandomizedSet() {
        this.map = new HashMap<>();
        this.lst = new ArrayList<>();
        this.rand = new Random();
    }
    
    public boolean insert(int val) {
        if(map.containsKey(val)) return false;

        lst.add(val);
        map.put(val,lst.size()-1);
        return true;
    }
    
    public boolean remove(int val) {
        if(!map.containsKey(val)) return false;

        int idx = map.get(val);
        int lstVal = lst.get(lst.size()-1);

        lst.set(idx, lstVal);
        map.put(lstVal, idx);
        lst.remove(lst.size() -1);
        map.remove(val);
        return true;


     }
    
    public int getRandom() {
        int indx = rand.nextInt(lst.size());
        return lst.get(indx);
    }
}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */