package com.memorygame.petermartinez.myapplication;

import android.util.Log;

/**
 * Created by petermartinez on 8/16/16.
 */
public class CardDeck {
    int[] cardDealOrder;
    int[] assetIds;
    int[] cardState; //0 - unflipped, 1 - flipped, 2 - matched

    public CardDeck(int numberUnique){
        cardDealOrder = new int[numberUnique * 2];
        cardDealOrder = shuffleDealCards(numberUnique);
        assetIds = new int[numberUnique];
        assetIds = assetIdsSequentialNumbers(numberUnique);
        cardState = new int[numberUnique * 2];
    }

    public int[] getCardDealOrder() {
        return cardDealOrder;
    }

    public int getCardByPosition(int position){
        return cardDealOrder[position];
    }

    public int[] getAllAssetIds() {
        return assetIds;
    }

    public void setAllAssetIds(int[] assetIds) {
        this.assetIds = assetIds;
    }

    public int getAssetId(int position){
        return assetIds[position];
    }

    public void setAssetId(int position, int assetId){
        this.assetIds[position] = assetId;
    }

    public int[] getAllCardStates() {
        return cardState;
    }

    public void setAllCardStates(int[] cardState) {
        this.cardState = cardState;
    }

    public int getCardState(int card){
        return cardState[card];
    }

    public void setCardState(int newState, int card) {
        this.cardState[card] = newState;
    }

    private int[] shuffleDealCards(int numberUnique){ //redo, draw at random from remaining cards, not place randomly
        int[] cardDealTemp = new int[numberUnique * 2];
        for(int i = 0; i < numberUnique * 2; i++){
            int j = (int) (numberUnique * 2 * Math.random());
            if (cardDealTemp[j] == 0){
                cardDealTemp[j] = 1 + i / 2;
            } else {
                i = i - 1;
            }
        }

        for(int i = 0; i < numberUnique * 2; i++){
            Log.i("The shuffled cards", i + " : " + cardDealOrder[i]);
        }
        return cardDealOrder;
    }

    private int[] assetIdsSequentialNumbers(int numberUnique){
        int[] assetIdsTemp = new int[numberUnique];
        for(int i = 0; i < numberUnique; i++){
            assetIdsTemp[i] = i+1;
        }
        return assetIdsTemp;
    }

    public boolean checkIfAllMatched(CardDeck cards){
        for(int i = 0; i < cards.getCardDealOrder().length; i++){
            if(cards.getCardState(i) != 2){
                return false;
            }
        }
        return true;
    }



}
