package Lesson39_lambda_function.classwork.task2_lambda_function;

public class Practice {
    public static void main(String[] args) {
        LambdaFunction lambdaFunction = (first, second, third) -> {
            return first > second && first > third ? first : second > first && second > third ? second : third;
        };

        System.out.println(lambdaFunction.findTheBiggestValue(3, 5, 7));
    }
}

interface LambdaFunction {
    int findTheBiggestValue(int a, int b, int c);
}
