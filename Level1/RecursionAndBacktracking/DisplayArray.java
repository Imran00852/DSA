package Level1.RecursionAndBacktracking;

public class DisplayArray {
    public static void displayArr(int arr[],int idx){
        if(idx==arr.length){
            return;
        }
        System.out.println(arr[idx]);
        displayArr(arr,idx+1);

    }
    public static void main(String[] args) {
        int arr[]={10,20,30,40,50,60};
        displayArr(arr,0);
    }
}
