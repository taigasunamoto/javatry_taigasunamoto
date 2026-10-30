/*
 * Copyright 2019-2025 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND,
 * either express or implied. See the License for the specific language
 * governing permissions and limitations under the License.
 */
package org.docksidestage.bizfw.basic.buyticket;

/**
 * @author jflute
 */
public class TicketBooth {

    // ===================================================================================
    //                                                                          Definition
    //                                                                          ==========
    private static final int MAX_QUANTITY = 10;
    private static final int ONE_DAY_PRICE = 7400; // when 2019/06/15
    private static final int TWO_DAY_PRICE = 13200;

    // ===================================================================================
    //                                                                           Attribute
    //                                                                           =========
    // #1on1: $在庫は共有でいいのか？どうすればいいのか？迷った (2026/10/30)
    private int quantity = MAX_QUANTITY;
    private Integer salesProceeds; // null allowed: until first purchase

    // ===================================================================================
    //                                                                         Constructor
    //                                                                         ===========
    public TicketBooth() {
    }

    // ===================================================================================
    //                                                                          Buy Ticket
    //                                                                          ==========
    // you can rewrite comments for your own language by jflute
    // e.g. Japanese
    // /**
    // * 1Dayパスポートを買う、パークゲスト用のメソッド。
    // * @param handedMoney パークゲストから手渡しされたお金(金額) (NotNull, NotMinus)
    // * @throws TicketSoldOutException ブース内のチケットが売り切れだったら
    // * @throws TicketShortMoneyException 買うのに金額が足りなかったら
    // */
    // TODO sunamoto JavaDoc, 戻り値が追加されたので @return を追加で by jflute (2026/10/30)
    // 既存のJavaDocに注目、必要になったら修正。
    // TwoDayにJavaDocつけるか？付ける方がベターだけど、代表選手としてOneDayのみもアリ。
    // e.g. cb.query().setMemberStatusCode_Equal_AsMemberStatus(cdef) の例
    /**
     * Buy one-day passport, method for park guest.
     * @param handedMoney The money (amount) handed over from park guest. (NotNull, NotMinus)
     * @throws TicketSoldOutException When ticket in booth is sold out.
     * @throws TicketShortMoneyException When the specified money is short for purchase.
     */
    public Ticket buyOneDayPassport(Integer handedMoney) {
        buyPassport(handedMoney, ONE_DAY_PRICE);
        return new Ticket(ONE_DAY_PRICE);
    }

    public TicketBuyResult buyTwoDayPassport(Integer handedMoney) {
        int change = buyPassport(handedMoney, TWO_DAY_PRICE);
        Ticket ticket = new Ticket(TWO_DAY_PRICE);
        return new TicketBuyResult(ticket, change);
    }

    // TODO sunamoto publicのbuyとprivateのbuyを区別するテクニック by jflute (2026/10/30)
    // (些細だけど)単純なメソッド一覧で混ざって区別しづらい、会話上区別しづらいので...
    // 仮に業務で、buyとpurchaseって区分けされているのであればもうそれを使う。
    // だけど業務ではbuyという言葉しかない。
    // e.g. doBuyPassport(), internalBuyPassport()
    // (jfluteはdoBuy好き)
    private int buyPassport(Integer handedMoney, int price) {
        if (quantity <= 0) {
            throw new TicketSoldOutException("Sold out");
        }
        if (handedMoney < price) {
            throw new TicketShortMoneyException("Short money: " + handedMoney);
        }
        --quantity;
        if (salesProceeds != null) {
            salesProceeds = salesProceeds + price;
        } else {
            salesProceeds = price;
        }
        // TODO sunamoto お釣り、文脈でわかるにせよ、ストレートにわかりたい by jflute (2026/10/30)
        // o 変数に置く (名前付けのための変数)
        // o 横のすらすらコメントでお釣りって書く
        // o JavaDocちゃんと書く (ベター)
        //  i ちょっと面倒さが入る、しかも、privateメソッド、費用対効果は？
        //  i JavaDocの費用対効果、publicだったら大きい
        //  i privateメソッドは比較的小さくなる
        //  i ただこの場合は非常に存在感の大きいprivateメソッド
        //  i そういう場合は費用対効果も高くなるのでJavaDoc書くことも多い
        return handedMoney - price;
    }

    // #1on1: コメントどこまで書く？AIとの関連 (2026/10/30)
    // 良いコメントがあれば、AIもそれを読んでくれるし、真似てくれる。(体感)
    // $なかなか現場でもコメントできていない。規約も特にない。
    //
    // コメント書くの面倒という言い訳は言えなくなった。
    // ただ必要なことは、どんなコメント書けばいいのか？の理想像を持ってるかどうか？
    // (AIにどんなコメントを書かせればいいのか？につながる)
    //
    // 細かいフォーマットは置いておいて、「コードから読み取れないことを書く」
    // というシンプルなテーマでも良いのかなと。

    public static class TicketSoldOutException extends RuntimeException {

        private static final long serialVersionUID = 1L;

        public TicketSoldOutException(String msg) {
            super(msg);
        }
    }

    public static class TicketShortMoneyException extends RuntimeException {

        private static final long serialVersionUID = 1L;

        public TicketShortMoneyException(String msg) {
            super(msg);
        }
    }

    // ===================================================================================
    //                                                                            Accessor
    //                                                                            ========
    public int getQuantity() {
        return quantity;
    }

    public Integer getSalesProceeds() {
        return salesProceeds;
    }
}
