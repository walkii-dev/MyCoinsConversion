import java.util.Scanner;

public class Operations {
    Scanner input = new Scanner(System.in);

    public void valueToReturn(float coins){
        System.out.println("Insira o valor que deseja converter: ");
        float value = input.nextFloat();

        float result = value * coins;
        System.out.println(result);
    }
    public void valueToReturnReverse(float coins){
        System.out.println("Insira o valor que deseja converter: ");
        float value = input.nextFloat();

        float result = value / coins;
        System.out.println(result);
    }
}
