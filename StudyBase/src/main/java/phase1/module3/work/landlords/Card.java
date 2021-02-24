package phase1.module3.work.landlords;

public class Card implements Comparable<Card>{
    private String flowerColor; //保存Card的花色
    private int value; //保存Card的数字大小

    public Card() {
    }

    public Card(int value) {
        this.value = value;
    }

    @Override
    public String toString() {
        String str = null;
        switch (value){
            case 11: str = "J";break;
            case 12: str = "Q";break;
            case 13: str = "K";break;
            case 14: str = "A";break;
            case 15: str = "2";break;
            case 16: str = "小王";break;
            case 17: str = "大王";break;

        }
        if(str != null){
            return "{" +
                    "'" + flowerColor + '\'' +
                    "," + str +
                    '}';
        }
        return "{" +
                "'" + flowerColor + '\'' +
                "," + value +
                '}';
    }

    public Card(String flowerColor, int value) {
        this.flowerColor = flowerColor;
        this.value = value;
    }

    public String getFlowerColor() {
        return flowerColor;
    }

    public void setFlowerColor(String flowerColor) {
        this.flowerColor = flowerColor;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    @Override
    public int compareTo(Card o) {
        return o.getValue()-this.getValue();
    }
}
