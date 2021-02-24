package lagou.phase1.module3.work.landlords;

import java.util.*;

public class Landlords {
    private User userA,userB,userC;
    private final List<Card> cardsPool = new ArrayList<>();
    private List<Card> landLordCards = new ArrayList<>(); //记录地主牌
    public Landlords(User userA, User userB, User userC) {
        this.userA = userA;
        this.userB = userB;
        this.userC = userC;
    }

    public Landlords() {
    }

    /**
     * 用代码块初始化扑克牌池
     */
    {
        List<String> color = new ArrayList<>();
        color.add("黑桃");
        color.add("红桃");
        color.add("梅花");
        color.add("方块");

        // 11 - 13 代表JQK; 14、15代表A、2; 16、17代表小王，大王
        cardsPool.add(new Card(16));
        cardsPool.add(new Card(17));
        Integer[] value = {3,4,5,6,7,8,9,10,11,12,13,14,15};

        for (String c:color ) {
            for (int i:value ) {
                cardsPool.add(new Card(c,i));
            }
        }
        Collections.shuffle(cardsPool);
        System.out.println(cardsPool);
//        Collections.sort(cardsPool);
//        System.out.println(cardsPool);
    }

    //配合deal() 发牌方法，打印发牌过程
    private void printPokes(User u , Card c){
        System.out.println("将扑克牌:" + c + "发送给--->:" + u.getName() );
        System.out.println(u.getName()+"的目前手牌为:"+u.getCardsList()+"\n");
    }

    //发牌过程
    public void deal(){
        Iterator it = cardsPool.iterator();
        Card c;
        int i = 0; //用于计数
        while(it.hasNext()){
            if(i>=51){
                landLordCards.add((Card)it.next());
                continue;
            }
            c = (Card)it.next();   //记录 从cardPool获取到的牌，用于打印;
            userA.setCardsList(c);
            printPokes(userA,c);
            i++;

            c = (Card)it.next();   //记录 从cardPool获取到的牌，用于打印;
            userB.setCardsList(c);
            printPokes(userB,c);
            i++;

            c = (Card)it.next();   //记录 从cardPool获取到的牌，用于打印;
            userC.setCardsList(c);
            printPokes(userC,c);
            i++;

        }
        System.out.println("最后三张底牌为:" + landLordCards);
    }

    public User getUserA() {
        return userA;
    }

    public void setUserA(User userA) {
        this.userA = userA;
    }

    public User getUserB() {
        return userB;
    }

    public void setUserB(User userB) {
        this.userB = userB;
    }

    public User getUserC() {
        return userC;
    }

    public void setUserC(User userC) {
        this.userC = userC;
    }

    /**
     * 给对象u的手牌进行排序
     * @param u
     */
    private void sortPlayerPokes(User u){
        u.sortUserPokes();
    }


    public void dealLandLordCards(User b) {  //派发地主牌
        for (Card c: landLordCards ) {
            b.setCardsList(c);
        }

    }

    public void printPlayerPokes(User u){
        sortPlayerPokes(u);  // 给对象u的手牌进行排序
        System.out.println(u.getName() + "的手牌为:" + u.getCardsList());
    }

    public static void main(String[] args) {
        User a = new User();
        User b = new User();
        User c = new User();
        a.setName("玩家A");
        b.setName("玩家B");
        c.setName("玩家C");

        Landlords l = new Landlords(a,b,c);
        l.deal(); //发牌并，打印发牌过程

        Scanner sc = new Scanner(System.in);
        System.out.println("请指定地主,请输入1,2,3; 1,2,3代表玩家被发牌的顺序");
        int landLordIndex = sc.nextInt();
        switch (landLordIndex){
            case 1: a.setLandlord(true);l.dealLandLordCards(a);break;
            case 2: b.setLandlord(true);l.dealLandLordCards(b);break;
            case 3: c.setLandlord(true);l.dealLandLordCards(c);break;
        }
        //打印每个玩家的手牌
        l.printPlayerPokes(a);
        l.printPlayerPokes(b);
        l.printPlayerPokes(c);

    }




}
