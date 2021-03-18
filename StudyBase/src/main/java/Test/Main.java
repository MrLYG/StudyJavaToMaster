package Test;



import java.io.IOException;
import java.util.*;

class Main {
    static class Cll implements Comparable<Cll>{
        public  String src;
        public String value;
        public int count;


        @Override
        public int compareTo(Cll o) {
            return  this.count-o.count;
        }

        @Override
        public String toString() {
            return "Cll{" +
                    "value='" + value + '\'' +
                    ", count=" + count +
                    '}';
        }
    }

    public static HashMap<String, List<String>> dict = new HashMap<>();


    public static void out(String q){
        List<Cll> list = new ArrayList<>();

        Set<Map.Entry<String, List<String>>> entries = dict.entrySet();

        for (Map.Entry<String, List<String>> en:entries ) {
            for (String s: en.getValue()) {
                if(q.contains(s)){
                    int index = q.indexOf(s);
                    Cll c = new Cll();
                    c.count = index;
                    boolean f = true;
                    for (Cll c1:list ) {
                        if(c1.count == index){
                            c1.value = en.getKey()+","+c1.value;
                            f = false;
                        }

                    }

                    if(f){
                        c.src = s;
                        c.value = en.getKey();
                        list.add(c);
                    }


                }
            }
        }


        Collections.sort(list);


        for (Cll c:list ) {
            System.out.println(c.src +":["+c.value+"]");

        }


    }


    public static void main(String[] args) throws IOException {

        Scanner in = new Scanner(System.in);

        String query = "";
        while (true) {

            String str = in.next();
            if(!str.contains("dict") || !str.contains("query")){
                break;
            }
            if(str.contains("dict")){
                String[] s = str.split("\\:");
                String[] ss = s[2].split(",");
                List<String> t = new ArrayList<>(Arrays.asList(ss));
                dict.put(s[1],t);
            }
            if(str.contains("query")){
                query = str;
                break;
            }
        }

        out(query);
    }
}