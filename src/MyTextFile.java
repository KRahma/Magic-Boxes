import java.util.Scanner;

/**
 * Created by KaziRahma on 10/9/16.
 */
public class MyTextFile {

    public static void main(String[] args){
        Merge merge = new Merge();
        Selection select = new Selection();
        int[] array = readInput();

        select.sortSelection8Sort(array);
        //select.sortSelection8Min(array);
        //merge.sortMerge8Sort(array);
        //merge.sortMerge(array);
        System.out.println("\nprinting output");
        for (int i = 0; i < array.length; i++){
            System.out.println(array[i]);
        }

    }
    public static int[] readInput(){
        Scanner s = new Scanner(System.in);

        int n = s.nextInt();
        int[] array = new int[n];
        for (int i = 0; i < n; i++) {
            array[i] = s.nextInt();
        }

        return array;
    }
}
