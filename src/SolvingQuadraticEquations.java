import org.jetbrains.annotations.NotNull;

import java.util.Scanner;

import static java.lang.Double.parseDouble;

public class SolvingQuadraticEquations {
    public static void main(String[] args) {
        //написать программу для вычисления корней квадратного уравнения.
        try {
            String[] tempIn = getInputEquation();
            String equation = equationToZero(tempIn);
            equation = equation.replace(",", ".");
            equation = equation.replace("−", "-");
            if (equation.indexOf("x^2") > 0) {
                System.out.println("Уравнение приведенное к нулю: " + equation + "=0");
            } else System.err.println("Строка, не является уравнением.");
            int index = equation.indexOf("x^2") - 1;
            StringBuilder firstCoeffStr = new StringBuilder();
            double a;
            if (equation.charAt(index) == '-') {
                a = -1;
            } else if (equation.charAt(index) == '+') {
                a = 1;
            } else {
                index = getIndex(equation, index, firstCoeffStr);
                index = getAnInt(equation, index, firstCoeffStr);
                a = parseDouble(firstCoeffStr.toString().trim());
                if (equation.charAt(index) == '-') {
                    a = a * (-1);
                }
            }
            System.out.println("Первый коэффициент: " + a);
            firstCoeffStr.insert(0, equation.charAt(index));
            equation = equation.replace(firstCoeffStr + "x^2", "");

            if (!equation.contains("x")) {
                equation = equation + "+0x";
            }
            index = equation.indexOf("x") - 1;
            StringBuilder secondCoeffStr = new StringBuilder();
            double b;
            if (equation.charAt(index) == '-') {
                b = -1;
            } else if (equation.charAt(index) == '+') {
                b = 1;
            } else {
                index = getIndex(equation, index, secondCoeffStr);
                index = getAnInt(equation, index, secondCoeffStr);
                b = parseDouble(secondCoeffStr.toString().trim());
                if (equation.charAt(index) == '-') {
                    b = b * (-1);
                }
            }
            System.out.println("Второй коэффициент: " + b);
            secondCoeffStr.insert(0, equation.charAt(index));
            if (equation.length() == (secondCoeffStr.length() + 1)) {
                equation = (equation + "+0").intern();
            }
            equation = equation.replace(secondCoeffStr + "x", "").intern();
            StringBuilder freeMembStr = new StringBuilder();
            index = equation.length() - 1;
            index = getIndex(equation, index, freeMembStr);
            getAnInt(equation, index, freeMembStr);

            double c = parseDouble(freeMembStr.toString().trim());
            if (equation.charAt(index) == '-') {
                c = c * (-1);
            }
            System.out.println("Свободный член: " + c);

            extracted(a, b, c);

        } catch (ArrayIndexOutOfBoundsException | StringIndexOutOfBoundsException e) {
            System.err.println("Введите корректно уравнение, придерживаясь правил.");
        }

    }

    private static void extracted(double a, double b, double c) {
        double d = (b * b) - (4 * a * c);
        if (0 <= d) {
            double f = Math.sqrt(d);
            double x1 = ((-1 * b) + f) / (2 * a);
            double x2 = ((-1 * b) - f) / (2 * a);
            if (x1 == -0) {
                x1 = 0;
            }
            if (x2 == -0) {
                x2 = 0;
            }
            if (x1 == x2) {
                System.out.format("Корень квадратного уравнения: %.2f", x1);
            } else System.out.format("Корни квадратного уравнения: %.2f и %.2f", x1, x2);
        } else System.out.println("Уравнение не имеет действительных корней.");
    }

    @NotNull
    private static String[] getInputEquation() {
        Scanner sc = new Scanner(System.in);
        System.out.print("\n  Введите уравнение с квадратным корнем, придерживаясь приведенного ниже формата ввода -" +
                "\nаx^2+bx+c=0 | -c+ax^2=bx | −ax^2−bx=-c | ax^2+bx=0 | ax^2=−c+dx | -c+bx=ax^2 | c=ax-bx^2, где" +
                "\n а - 1-й коэффициент, b - 2-й коэффициент, c - свободный член, ^ - знак возведения в степень " +
                "\n (5x^2−14x+17=0 | -5+27x^2=6x | −7x^2−13x=-8 | x^2+0,25x=0 | 5x^2=−3+2x | -11+8x=12x^2 " +
                "\n 5x^2+17=0 | 3x^2=0 | 5x^2=125 | 9x^2-x=0 | -7x^2 | -6x^2=-x): ");
        String string = sc.nextLine().replace(" ", "").trim().toLowerCase().intern();
        return string.split("=", 2);
    }

    private static int getAnInt(String equation, int index, StringBuilder secondCoeffStr) {
        if (equation.charAt(index) == '.') {
            secondCoeffStr.insert(0, ".");
            index--;
            while (Character.isDigit(equation.charAt(index))) {//
                secondCoeffStr.insert(0, equation.charAt(index));
                index--;
            }
        }
        return index;
    }

    private static int getIndex(String equation, int index, StringBuilder firstCoeffStr) {
        while (Character.isDigit(equation.charAt(index))) {
            firstCoeffStr.insert(0, equation.charAt(index));
            index--;
        }
        return index;
    }

    @NotNull
    private static String equationToZero(String[] tempIn) {
        String[] result = new String[2];
        if (tempIn[0].equals("") || tempIn[0].equals("0")) {
            tempIn[0] = tempIn[1];
            tempIn[1] = "0";
        }
        if (tempIn.length == 1) {
            result[0] = tempIn[0];
            result[1] = "0";
        } else {
            result[0] = tempIn[0];
            result[1] = tempIn[1];
        }
        String equation;
        if (result[0].charAt(0) != '-') {
            result[0] = '+' + result[0];
        }
        if (result[1].charAt(0) != '0') {
            String temp = result[1].replace('-', '*');
            temp = temp.replace('+', '-');
            temp = temp.replace('*', '+');
            if (result[1].charAt(0) == '-') {
                equation = result[0] + temp;
            } else {
                equation = result[0] + "-" + temp;
            }
        } else {
            equation = result[0];
        }
        return equation;
    }
}