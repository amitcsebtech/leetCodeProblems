class Solution {
    private boolean possible(Set<Integer> reverse, int[] arr){

        for(int el:arr){
            if(reverse.contains(el)){
                return false;
            }
        }

        return true;

    }
    public int maxNumberOfFamilies(int n, int[][] reservedSeats) {
        Map<Integer, Set<Integer>> map = new HashMap<>();
        int s = reservedSeats.length;
        int ans = 0;

        int[] group1 = new int[]{2,3,4,5};
        int[] group2 = new int[]{4,5,6,7};
        int[] group3 = new int[]{6,7,8,9};

        for(int i=0; i<s; i++){

            if(map.containsKey(reservedSeats[i][0])){
                Set<Integer> set = map.get(reservedSeats[i][0]);
                set.add(reservedSeats[i][1]);
                map.put(reservedSeats[i][0],set);
            }
            else{
                Set<Integer> set =new HashSet<>();
                set.add(reservedSeats[i][1]);
                map.put(reservedSeats[i][0],set);
            }

        }
        int emptySeat = n - map.size();
        ans += emptySeat*2;

        Set<Integer> key = map.keySet();
        for(Integer k : key){
            Set<Integer> reverse = map.get(k);

            boolean f1 = possible(reverse,group1);
            boolean f2 = possible(reverse,group2);
            boolean f3 = possible(reverse,group3);

            if(f1 && f3){
                ans += 2;
            }
            else if(f1 || f2 || f3){
                ans += 1;
            }
        }

        return ans;
    }
}