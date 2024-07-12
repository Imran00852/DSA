package Level1.Arrays;

public class MergeTwoSortedArrays {
    public static int[] mergedArrays(int arr1[],int arr2[]){
        int res[]=new int[arr1.length+ arr2.length];
        int i=0;
        int j=0;
        int k=0;

        while (i<arr1.length && j<arr2.length){
            if(arr1[i]<arr2[j]){
                res[k]=arr1[i];
                i++;
            }else {
                res[k]=arr2[j];
                j++;
            }
            k++;
        }

        while (i< arr1.length){
            res[k]=arr1[i];
            i++;
            k++;
        }

        while (j<arr2.length){
            res[k]=arr2[j];
            j++;
            k++;
        }


        return res;
    }
    public static void main(String[] args) {
        int arr1[]={2,4,6,8,10};
        int arr2[]={12,16,18,20,22};

        int res[]=mergedArrays(arr1,arr2);
        for(int i=0;i<res.length;i++){
            System.out.print(res[i] + " ");
        }
    }
}
