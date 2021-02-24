package Test;
/**
 Problem: Longest continous valid substring

 Your task is to find the longest continous substrings
 consists of only "valid" characters for each line and
 output the substring as a separate line to output.
 Here "valid" is defined as English letters (upper and
 lower cases) and space.

 Here is an example of two lines of input stream:
 ^%oA i923diuo
 (989872347897*&&:":}{?>
 And the ouput stream should also be two lines:
 oA i


 Please note that the output lines should be in the
 exact same order as their input lines and the number
 of input lines and output lines should be the same.

 InStream and OutStream are two already implemented
 interfaces for input and output respectively. You
 should use them for I/O and they have only the methods
 defined below. Don't read their implementations, which
 are not relevant to this interview.

 TWO TASKs:
 1. add enough (according to you) test cases in line 54.
 2. implement LongestValidSubstrings() of Processor class

 ADDITIONAL REQUIREMENTS:
 Do not use regular expression.
 Use as little memory as you can.

 You may search on the web freely when you code.

 If any questions please contact me.
 */

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * The interface for input stream
 *
 * Only sequential access allowed. Cannot get length information.
 *
 * Note:
 *     Ask question if anything is not clear.
 *     The implementations are just mock. Your code should not depend on them.
 */
class InStream
{
    // TASK 1: PLEASE ADD UNITTEST CASES HERE.
    private static String UnittestCases ="PASS ONE%^%NOTP9872\nwrong987PASS TWO098\n*(*&:PASS THREE\nPASS four%^%NOTP9872\nwrong987PASS five098\n*(*&:PASS six\nPASS seven%^%NOTP9872\nwrong987PASS eight098\n*(*&:PASS night\nPASS ten%^%NOTP9872\nwrong987PASS elven098\n*(*&:PASS tween\nALL TESTS PASSED";

    public Character readChar() throws IOException
    {
        int code = implReader.read();
        if (code == -1)
            return null;

        return Character.valueOf((char)code);
    }

    public String readLine() throws IOException
    {
        return implReader.readLine();
    }

    public String readBuffer(int size) throws IOException
    {
        char buffer[] = new char[size];
        int count = implReader.read(buffer, 0, size);
        if (count == -1)
            return null;
        else
            return new String(buffer);
    }

    public InStream()
    {
        implStream = new ByteArrayInputStream(UnittestCases.getBytes());
        implReader = new BufferedReader(new InputStreamReader(implStream));
    }

    private ByteArrayInputStream implStream = null;
    private BufferedReader implReader = null;
}

/**
 * The interface for output stream
 *
 * Note:
 *     Ask question if anything is not clear.
 *     The implementations are just mock. Your code should not depend on them.
 */
class OutStream
{
    public void writeChar(char ch)
    {
        System.out.print(ch);
    }

    public void writeLine(String line)
    {
        System.out.print(line);
    }

    public void writeBuffer(String buff)
    {
        System.out.print(buff);
    }
}

class Processor
{

    public Processor(InStream instream, OutStream outstream)
    {
        this.instream = instream;
        this.outstream = outstream;
    }

    public String LongestValidSubStrings(String str) throws IOException
    {
        int first = 0;
        int end = 0;
        int maxSub = 0;
        str = str+'@';
        for(int i = 0; i < str.length(); i++){
            if(((byte)str.charAt(i) >= 65 & (byte)str.charAt(i) <= 90 )||  ((byte)str.charAt(i) >= 97 &  (byte)str.charAt(i) <= 122) ||                    (str.charAt(i) == ' ') ){
            }else{
                if(i - first + 1 > maxSub){
                    maxSub = i - first + 1;
                    end  = i;
                }
                first = i  + 1;
            }
        }
        first = end - maxSub+1;
        StringBuilder sb = new StringBuilder();
        while(first < end){
            sb.append(str.charAt(first));
            first++;
        }
        System.gc();
//        outstream.writeLine(sb.toString());
        return sb.toString();
    }

    public InStream instream = null;
    private OutStream outstream = null;
};

class MyThread extends Thread  {
    Processor processor;

    public MyThread(){
        //编写子类的构造方法，可缺省
    }
    public MyThread(Processor p){
        //编写子类的构造方法，可缺省
        processor = p;
    }

    public void run(){
        //编写自己的线程代码
        String str = null ;
        int i =0;
        while(true){
            try {
                synchronized (processor.instream){
                    str = processor.instream.readLine();
                    if(str == null){
                        return ;
                    }
                    String res = processor.LongestValidSubStrings(str);
                    System.out.println(res);
                }




            }catch (Exception e){

            }
            i++;

        }

    }

}

class ShowMeBug
{
    public static void main(String[] args) throws IOException
    {


        InStream instream = new InStream();
        OutStream outstream = new OutStream();
        Processor processor = new Processor(instream, outstream);

        MyThread thread01 = new MyThread(processor);
        thread01.start();

        MyThread thread02 = new MyThread(processor);
        thread02.start();

        MyThread thread03 = new MyThread(processor);
        thread03.start();

    }
}