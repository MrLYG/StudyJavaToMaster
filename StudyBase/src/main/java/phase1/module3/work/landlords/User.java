package phase1.module3.work.landlords;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class User {
    private List<Card> cardsList = new ArrayList<>();  //保存该User对象的手牌
    private String name;
    private Boolean isLandlord = false; //是否为地主

    public void sortUserPokes(){ //给该对象的手牌进行排序
        Collections.sort(cardsList);
    }

    public Boolean getLandlord() {
        return isLandlord;
    }

    public void setLandlord(Boolean landlord) {
        isLandlord = landlord;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Card> getCardsList() {
        return cardsList;
    }

    public void setCardsList(List<Card> cardsList) {
        this.cardsList = cardsList;
    }

    public void setCardsList(Card card) {
        this.cardsList.add(card);
    }
}
