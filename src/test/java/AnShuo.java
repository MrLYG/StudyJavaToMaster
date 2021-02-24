public class AnShuo {
    public static void main(String[] args) {
        int i = 0 ;
//        do {
//            System.out.println(i++);
//        }while(++i<3);
        for (;i<3;i=++i*2){
            System.out.println(i);
        }
    }
}
