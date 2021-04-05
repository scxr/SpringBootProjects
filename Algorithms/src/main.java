import algorithms.MD5;
import algorithms.MathAlgs;
import algorithms.RandomAlgs;

import java.math.BigInteger;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.Month;
import java.util.ArrayList;
import java.util.stream.StreamSupport;

public class main {

    public static void main(String[] args) throws Exception {
//        MathAlgs MAlgs = new MathAlgs();
        LocalDate dob = LocalDate.of(2007, Month.JUNE, 26);
        System.out.println(RandomAlgs.HowLongAlive(dob));
//        System.out.println(MAlgs.FibO1(100));
//        System.out.println(MAlgs.PerfectSquare(16));
//        System.out.println(MAlgs.PerfectSquareBinarySearch(16));
//        System.out.println(MAlgs.Abs(-10));
//        ArrayList<Double> myarr = new ArrayList<>();
//
//        myarr.add(19.0);
//        myarr.add(10.0);
//        myarr.add(200.0);
//        myarr.add(29.0);
//        myarr.add(1.0);
//        myarr.add(20.0);
//        myarr.add(100.0);

//        System.out.println(MAlgs.AliquotSum(12));
//        System.out.println(MAlgs.AbsMin(myarr));
//        System.out.println(MAlgs.AbsMax(myarr));

//        System.out.println(MAlgs.Mean(myarr));

//        System.out.println(MAlgs.MultiplyArr(myarr, 10));
//        MD5 md5alg = new MD5();

//        System.out.println(MD5.rearrange("1234567890abcdfghijklmnopqrstuvw").equals("pqrstuvwhijklmno90abcdfg12345678")); >>> true
//        System.out.println(MD5.reformatHex(666) == "9a020000" ? "true": MD5.reformatHex(666));
//        long mynum = 34342342342342343242;

//        System.out.println(Long.toBinaryString(mynum));
//        System.out.println();
//        String expected = "1234567890abcdfghijklmnopqrstuvw100000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000010000000000000000000000000000000000000000000000000000000000000";
//        System.out.println(MD5.pad("1234567890abcdfghijklmnopqrstuvw").equals(expected)); // whoop whoop whoop finally
//        System.out.println(MD5.pad("1234567890abcdfghijklmnopqrstuvw"));
    }
}
