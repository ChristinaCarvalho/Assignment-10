import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class App {
    public static int[] createRandomArray(int arrayLength){
        int[] array = new int[arrayLength];
        Random random = new Random();
        for(int i=0; i<arrayLength; i++){
            array[i] = random.nextInt(100);
        }
        return array;
    }

    public static void bubbleSort(int[] array){
        
        for(int i=0; i<array.length; i++){
            boolean swapped = false;
            for(int j=0; j<array.length-i-1; j++){
                if(array[j]>array[j+1]){
                    int temp = array[j];
                    array[j] = array[j+1];
                    array[j+1] = temp;                    
                    swapped = true;
                }
            }
            if (swapped != true){ 
                
                break;                
            } 
        }
       
    } 

    public static void mergeSort(int[] array, int left, int right){
        if(right - left > 1){
            int mid = (left + right)/2;
            mergeSort(array, left, mid);
            mergeSort(array, mid, right);
            merge(array, left, mid, right);
        }
    }

    public static void merge(int[] array, int left, int mid, int right){
        int[] leftArray = Arrays.copyOfRange(array, left, mid);
        int[] rightArray = Arrays.copyOfRange(array, mid, right);
        int i=0, j=0;
        for(int k=left; k<right; k++){
            if(i == leftArray.length){
                array[k] = rightArray[j++];
            } else if(j == rightArray.length){
                array[k] = leftArray[i++];
            } else if(leftArray[i] <= rightArray[j]){
                array[k] = leftArray[i++];
            } else {
                array[k] = rightArray[j++];
            }
        }
    }

    public static void main(String[] args) throws Exception {        
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter length of array:");
        int arrayLength = scanner.nextInt();

        int[] array = createRandomArray(arrayLength);
        int[] array2 = array;
        System.out.println("Generated array:");
        System.out.println(Arrays.toString(array));
        
        long startTime = System.nanoTime();
        bubbleSort(array);
        long endTime = System.nanoTime() - startTime;
        System.out.println("Sorted array using bubble sort:");
        System.out.println(Arrays.toString(array));
        System.out.println("Time taken: "+endTime+" ns");
                
        long startTime2 = System.nanoTime();
        mergeSort(array2, 0, array2.length);
        long endTime2 = System.nanoTime() - startTime2;
        System.out.println("Sorted array using merge sort:");
        System.out.println(Arrays.toString(array2));
        System.out.println("Time taken: "+endTime2+" ns");

        if(endTime < endTime2){
            System.out.println("Bubble sort was faster.");
        }else if(endTime2 < endTime){
            System.out.println("Merge sort was faster");
        } else {
            System.out.println("Both took the same amount of time to sort.");
        }

        scanner.close();
    }
}
