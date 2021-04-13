import java.util.Scanner;

import static java.lang.Double.parseDouble;

public class SolvingQuadraticEquations {
    public static void main(String[] args) {
        //написать программу для вычисления корней квадратного уравнения.

        Scanner sc = new Scanner(System.in);
        System.out.print("\n  Введите уравнение с квадратным корнем, придерживаясь приведенного ниже формата ввода -" +
                "\nаx^2+bx+c=0 | -c+ax^2=bx | −ax^2−bx=-c | ax^2+bx=0 | ax^2=−c+dx | -c+bx=ax^2 | c=ax-bx^2, где" +
                "\n а - 1-й коэффициент, b - 2-й коэффициент, c - свободный член, ^ - знак возведения в степень " +
                "\n (5x^2−14x+17=0 | -5+27x^2=6x | −7x^2−13x=-8 | x^2+0,25x=0 | 5x^2=−3+2x | -11+8x=12x^2 " +
                "\n 5x^2+17=0 | 3x^2=0 | 5x^2=125 | 9x^2-x=0 | -7x^2 | -6x^2=-x): ");
        String string = sc.nextLine().replace(" ", "").trim().toLowerCase().intern();
        String[] tempIn = string.split("=", 2);
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
        String temp;
        if (result[0].charAt(0) != '-' && result[0].charAt(0) != '−') {
            result[0] = '+' + result[0];
        }
        if (result[1].charAt(0) != '0') {
            if (result[1].charAt(0) == '-' || result[1].charAt(0) == '−') {
                String temp0 = result[1].replace('-', '*');
                temp0 = temp0.replace('−', '*');
                temp0 = temp0.replace('+', '-');
                temp0 = temp0.replace('*', '+');
                temp = result[0] + temp0;
            } else {
                String temp0 = result[1].replace('-', '*');
                temp0 = temp0.replace('−', '*');
                temp0 = temp0.replace('+', '-');
                temp0 = temp0.replace('*', '+');
                temp = result[0] + "-" + temp0;
            }
        } else {
            temp = result[0];
        }
        System.out.println("Уравнение приведенное к нулю: " + temp + "=0");

        int indexA = temp.indexOf("x^2");
        int indexA0 = indexA - 1;
        StringBuilder sbA = new StringBuilder();
        double a;
        if (temp.charAt(indexA0) == '−' || temp.charAt(indexA0) == '-') {
            a = -1;
        } else if (temp.charAt(indexA0) == '+') {
            a = 1;
        } else {
            while (Character.isDigit(temp.charAt(indexA0))) {
                sbA.insert(0, temp.charAt(indexA0));
                indexA0--;
            }
            if (temp.charAt(indexA0) == ',') {
                sbA.insert(0, "0.");
                indexA0 = indexA0 - 2;
            }
            a = parseDouble(sbA.toString().trim());
            if (temp.charAt(indexA0) == '−' || temp.charAt(indexA0) == '-') {
                a = a * (-1);
            }
        }
        System.out.println("Первый коэффициент: " + a);
        sbA.insert(0, temp.charAt(indexA0));
        temp = temp.replace(sbA + "x^2", "");

        if (!temp.contains("x")) {
            temp = temp + "+0x";
        }
        indexA = temp.indexOf("x");
        indexA0 = indexA - 1;
        StringBuilder sbB = new StringBuilder();
        double b;
        if (temp.charAt(indexA0) == '−' || temp.charAt(indexA0) == '-') {
            b = -1;
        } else if (temp.charAt(indexA0) == '+') {
            b = 1;
        } else {
            while (Character.isDigit(temp.charAt(indexA0))) {
                sbB.insert(0, temp.charAt(indexA0));
                indexA0--;
            }
            if (temp.charAt(indexA0) == ',') {
                sbB.insert(0, "0.");
                indexA0 = indexA0 - 2;
            }
            b = parseDouble(sbB.toString().trim());
            if (temp.charAt(indexA0) == '−' || temp.charAt(indexA0) == '-') {
                b = b * (-1);
            }
        }
        System.out.println("Второй коэффициент: " + b);
        sbB.insert(0, temp.charAt(indexA0));
        if (temp.length() == (sbB.length() + 1)) {
            temp = (temp + "+0").intern();
        }
        temp = temp.replace(sbB + "x", "");

        StringBuilder sbC = new StringBuilder();
        int index = temp.length() - 1;
        while (Character.isDigit(temp.charAt(index))) {
            sbC.insert(0, temp.charAt(index));
            index--;
        }
        if (temp.charAt(index) == ',') {
            sbC.insert(0, "0.");
        }
        double c = parseDouble(sbC.toString().trim());
        if (temp.charAt(0) == '−' || temp.charAt(0) == '-') {
            c = c * (-1);
        }
        System.out.println("Свободный член: " + c);

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
}