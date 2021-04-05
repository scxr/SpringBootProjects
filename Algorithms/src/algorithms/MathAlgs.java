package algorithms;

import java.lang.reflect.Array;
import java.util.ArrayList;

import static java.lang.Double.valueOf;

public class MathAlgs {
    public double FibO1(double n) {
        /* F(n) in constant time as a pose to n^2 like i was told throughout college */
        /* time complexity : O(1) */
        final double sqrtf = Math.sqrt(5);
        double A = (1+sqrtf) / 2;

        return Math.round(Math.pow(A, n) / sqrtf);
    }

    public double LinearIntegerSqrt(double n) {
        /* find the square root of an integer with linear search */
        /* time complexity : O(n) */
        for (int i = 0; i < n/2 + 2; i++) {
            if (i * i == n) {
                return i;
            }
        }
        return 0;
    }

    public boolean PerfectSquare(Integer n) {
        /* check if a number is a perfect square */
        /* time complexity : depends on javas square root algorithm, likely O(n) */
        return (Math.sqrt(n) * Math.sqrt(n)) == n;
    }

    public double Abs(double n) {
        /* find absolute value of a number */
        if (n < 0) {
            return n * -1;
        } else {
            return n;
        }
    }

    public double AbsMax(ArrayList<Double> in){
        double highest_curr = 0.0;
        for (Double val: in) {
            if (Abs(val) > highest_curr) {
                highest_curr = Abs(val);
            }
        }
        return highest_curr;

    }

    public double AbsMin(ArrayList<Double> in) {
        double lowest_curr = 1000000000000000000.0;
        for (Double val: in) {
            if (Abs(val) < lowest_curr) {
                lowest_curr = Abs(val);
            }
        }
        return lowest_curr;
    }

    public <T> int SumInt(ArrayList<T> inp) {
        int sum = 0;
        for (T val: inp) {
            sum += (int) val;
        }
        return sum;
    }

    public <T> double SumDouble(ArrayList<T> inp) {
        double sum = 0;
        for (T val: inp) {
            sum += (double) val;
        }
        return sum;
    }

    public int AliquotSum(Integer n) {
        ArrayList<Integer> divisors = new ArrayList<>();
        for (int i = 1; i < n; i++) {
            if (n % i == 0) {
                divisors.add(i);
            }
        }
        return SumInt(divisors);
    }


    public double SurfaceAreaCube(double side_length) {
        if (side_length <= 0) {
            return 0.0;
        }
        return 6 * Math.pow(side_length, 2);
    }

    public double SurfaceAreaSphere(double radius) {
        if (radius <= 0) {
            return 0.0;
        }
        return 4 * Math.PI * Math.pow(radius, 2);
    }

    public double AreaTrapezium(double a, double b, double h) {
        return ((a + b) / 2) * h;
    }

    public boolean ArmstrongNumber(int n) {
        int sum = 0;
        int num_of_digits = 0;
        int tmp = n;
        while (tmp > 0) {
            num_of_digits += 1;
            tmp /= 10;

        }
        tmp = n;

        while (tmp>0) {
            int remainder = tmp % 10;
            sum += Math.pow(remainder, num_of_digits);
            tmp /=10;
        }

        return n == sum;
    }

    public boolean NarcissisticNumber(int n) {
        /* according to google this doesnt work but idfk why */
        int int_len = String.valueOf(n).length();
        ArrayList<Integer> tmp = new ArrayList<>();
        for (int i = 0; i < int_len; i++) {
            char tmp_s = String.valueOf(n).charAt(i);
            int tmp_i = tmp_s - '0';
            System.out.printf("Current char : %h To power : %h", tmp_i, int_len);
            tmp.add((int) Math.pow(tmp_i, int_len));
        }
        System.out.println(tmp);
        System.out.println(SumInt(tmp));
        return SumInt(tmp) == n;
    }

    public <T> double Mean(ArrayList<T> vals) {
        return SumDouble(vals)/ vals.size();
    }

    public <T extends Number> ArrayList<T> MultiplyArr(ArrayList<T> vals, int mult) {
//        Class<? extends Number> cls = vals.get(0).getClass();
        ArrayList<T> nl = new ArrayList<>();
        for (int i=0; i<vals.size(); i++) {
            T val = vals.get(i);
            if (val instanceof Integer) {
                int to_replace = val.intValue() * mult;
                nl.add((T) Integer.valueOf(to_replace));
            } else if (val instanceof Double) {
                double to_replace = val.doubleValue() * mult;
                nl.add((T) Double.valueOf(to_replace));
            } else if (val instanceof Float) {
                float to_replace = val.floatValue() * (float) mult;
                nl.add((T) Float.valueOf(to_replace));
            } else if (val instanceof Long) {
                long to_replace = val.longValue() * mult;
                nl.add((T) Long.valueOf(to_replace));
            } else {
                return vals;
            }
        }
        return nl;
    }





}
