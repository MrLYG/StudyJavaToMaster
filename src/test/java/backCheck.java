//import java.lang.reflect.Array;
//import java.util.Arrays;
//import java.util.Stack;
//
//public class backCheck {
//    public static void main(String[] args) {
////        int m = 6;
////        int n = 6;
////        int[] A = {1,2,3,4,5,6};
////        int[] B = {3,4,5,6,7,8};
////        System.out.println(Arrays.toString(A));
//        String UnittestCases = "adas a&^%@6947asfewadsd";
//        char[] arr = UnittestCases.toCharArray();
//        System.out.println(Arrays.toString(arr));
//        Stack<Character> stack = new Stack<Character>();
//        int index = 0;
//
//        for(int i = 0; i < arr.length ;i++){
//            System.out.println((byte)arr[i]);
////            if((int)arr[i] >=65 && (int)arr[i]<=122 ){
////                stack.push(arr[i]);
////                System.out.print((int)arr[i]);
////            }
////         arr[i] = ' '
//            index = i;
////            System.out.println(index);
//        }
//        String text = "\"'''''"""""";
//
//        text = text.replaceAll("('|\")", "\\\\$1");
//        System.out.println(text);
//    }
//}
//        -----
//
//
//
//        /**
//Problem: Longest continous valid substring
//
//Your task is to find the longest continous substrings
//consists of only "valid" characters for each line and
//output the substring as a separate line to output.
//Here "valid" is defined as English letters (upper and
//lower cases) and space.
//
//Here is an example of two lines of input stream:
//^%oA i923diuo
//(989872347897*&&:":}{?>
//And the ouput stream should also be two lines:
//oA i
//
//
//Please note that the output lines should be in the
//exact same order as their input lines and the number
//of input lines and output lines should be the same.
//
//InStream and OutStream are two already implemented
//interfaces for input and output respectively. You
//should use them for I/O and they have only the methods
//defined below. Don't read their implementations, which
//are not relevant to this interview.
//
//TWO TASKs:
//1. add enough (according to you) test cases in line 54.
//2. implement LongestValidSubstrings() of Processor class
//
//ADDITIONAL REQUIREMENTS:
//Do not use regular expression.
//Use as little memory as you can.
//
//You may search on the web freely when you code.
//
//If any questions please contact me.
//*/
//
//import java.io.*;
///**
// * The interface for input stream
// *
// * Only sequential access allowed. Cannot get length information.
// *
// * Note:
// *     Ask question if anything is not clear.
// *     The implementations are just mock. Your code should not depend on them.
// */
//class InStream
//{
//    // TASK 1: PLEASE ADD UNITTEST CASES HERE.
//    private static String UnittestCases ="PASS ONE%^%NOTP9872\nwrong987PASS TWO098\n*(*&:PASS THREE\n\nALL TESTS PASSED";
//
//
//    public Character readChar() throws IOException
//    {
//        int code = implReader.read();
//        if (code == -1)
//            return null;
//
//        return Character.valueOf((char)code);
//    }
//
//    public String readLine() throws IOException
//    {
//        return implReader.readLine();
//    }
//
//    public String readBuffer(int size) throws IOException
//    {
//        var buffer = new char[size];
//        var count = implReader.read(buffer, 0, size);
//        if (count == -1)
//            return null;
//        else
//            return new String(buffer);
//    }
//
//    public InStream()
//    {
//        implStream = new ByteArrayInputStream(UnittestCases.getBytes());
//        implReader = new BufferedReader(new InputStreamReader(implStream));
//    }
//
//    private ByteArrayInputStream implStream = null;
//    private BufferedReader implReader = null;
//}
//
///**
// * The interface for output stream
// *
// * Note:
// *     Ask question if anything is not clear.
// *     The implementations are just mock. Your code should not depend on them.
// */
//class OutStream
//{
//    public void writeChar(char ch)
//    {
//        System.out.print(ch);
//    }
//
//    public void writeLine(String line)
//    {
//        System.out.println(line);
//    }
//
//    public void writeBuffer(String buff)
//    {
//        System.out.print(buff);
//    }
//}
//class Processor
//{
//
//    public Processor(InStream instream, OutStream outstream)
//    {
//        this.instream = instream;
//        this.outstream = outstream;
//    }
//
//    public void LongestValidSubStrings() throws IOException
//    {
//      int first = 0;
//      int end = 0;
//      int maxSub = 0;
//      String str = instream.readLine()+'@';
//      for(int i = 0; i < str.length(); i++){
//         if(((byte)str.charAt(i) >= 65 & (byte)str.charAt(i) <= 90 )||                    ((byte)str.charAt(i) >= 97 &  (byte)str.charAt(i) <= 122) ||                    (str.charAt(i) == ' ') ){
//          }else{
//            if(i - first + 1 > maxSub){
//              maxSub = i - first + 1;
//              end  = i;
//            }
//            first = i  + 1;
//          }
//      }
//      first = end - maxSub+1;
//      while(first < end){
//        outstream.writeChar(str.charAt(first));
//        first++;
//      }
//      System.gc();
//      outstream.writeLine(" ");
//    }
//
//    private InStream instream = null;
//    private OutStream outstream = null;
//};
//
//
//class ShowMeBug
//{
//    public static void main(String[] args) throws IOException
//    {
//        var instream = new InStream();
//        var outstream = new OutStream();
//        var processor = new Processor(instream, outstream);
//
////         processor.test();
//      int i =0;
//      while(i<6){
//         processor.LongestValidSubStrings();
//         i++;
//      }
//
//    }
//}