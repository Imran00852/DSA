package Arrays;

public class CeilAndFloor {
    public static void main(String[] args) {
        int[] arr = {20, 30, 45, 50, 55, 70, 80};
        int data = 52; //ceil=just bada number and floor=just chota number

        int lo = 0;
        int hi = arr.length - 1;

        int ceil = 0;
        int floor = 0;

        while (lo <= hi) {
            int mid = (lo + hi) / 2;
            if (data > arr[mid]) {
                lo = mid + 1;
                floor = arr[mid];

            } else if (data < arr[mid]) {
                hi = mid - 1;
                ceil = arr[mid];
            } else {
                ceil = arr[mid];
                floor = arr[mid];
            }
        }
        System.out.println("ceil" + "=" + " " + ceil);
        System.out.println("floor" + "=" + " " + floor);
    }
}
