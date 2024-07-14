package Level1.RecursionAndBacktracking;

public class DisplayArrInReverse {
    public static void displayInReverse(int arr[],int idx){
        if(idx== arr.length){
            return;
        }
        displayInReverse(arr,idx+1);
        System.out.println(arr[idx]);
    }
    public static void main(String[] args) {
        int arr[]={10,20,30,40,50,60};
        displayInReverse(arr,0);
    }
}
