// brute force approach
public class PrintAllPermutation{
    public static void permute(int[] nums){
        boolean[] used =new boolean[nums.length];
        List<Integer> path= new ArrayList<>();
        backtrack(nums, used,path);   
    }
    private static void backtrack(int[] nums, boolean[] used, List<Integer>path){
        //  base case 
        if(path.size()==nums.length){
            System.out.println(path);
            return;
        }
        for(int i=0;i<nums.length;i++){
            if(used[i]) continue;
            used[i]=true;
            path.add(nums[i]);
            backtrack(nums,used,path);

            // undo backtrack 
            path.remove(path.size()-1);
            used[i]=false;
        }
    }

    public static void main(String[] args){
        int[] arr={1,2,3};
        permute(arr);
    }

}
