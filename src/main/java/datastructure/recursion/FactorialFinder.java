package datastructure.recursion;

public class FactorialFinder {

    public int factorialOf(int number) {
        if(number == 0 || number == 1)
            return 1;
        return number * factorialOf(number - 1);
    }
}
