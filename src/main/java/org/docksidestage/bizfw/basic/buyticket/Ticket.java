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
public class Ticket {

    // ===================================================================================
    //                                                                           Attribute
    //                                                                           =========
    // #1on1: スーパーいいね、remainingDaysという名前Good (2026/11/20)
    // $最初に、"残り日数" という単語が出てきた。他にも良いものがあるかも？
    // いや、良い。"残り日数" という概念が適しているので、それをそのまま変数にするのが良い。
    // 変数名を考えるというのは、プログラム上の名前を考えるというより、業務概念を考えているに等しい。
    // 仕事仲間との会話で、通じる概念の名前(日本語)があれば、それをそのまま適用するだけ。
    // コメント日本語話。コメントは何言語で書く？
    // OSSの話とか、国際化チームの話とか。昔のサービスの話とか。
    private final int displayPrice; // written on ticket, park guest can watch this
    private final TicketType ticketType;
    private int remainingDays; // one doInPark() call consumes one day

    // ===================================================================================
    //                                                                         Constructor
    //                                                                         ===========
    public Ticket(int displayPrice) {
        this(displayPrice, TicketType.ONE_DAY);
    }

    public Ticket(int displayPrice, TicketType ticketType) {
        this.displayPrice = displayPrice;
        this.ticketType = ticketType;
        this.remainingDays = ticketType.getUsableDays();
    }

    // ===================================================================================
    //                                                                             In Park
    //                                                                             =======
    public void doInPark() {
        if (remainingDays <= 0) {
            throw new IllegalStateException("Already in park by this ticket: displayedPrice=" + displayPrice);
        }
        --remainingDays;
    }

    // ===================================================================================
    //                                                                            Accessor
    //                                                                            ========
    public int getDisplayPrice() {
        return displayPrice;
    }

    public TicketType getTicketType() {
        return ticketType;
    }

    // #1on1: いいね、isAlreadyIn()は残している、互換性のため (2026/11/20)
    // isAlreadyIn()を今すぐ直すかどうか？はチームポリシー次第。
    // リファクタリングをどこでやるか？のポリシー。
    // $最初現場で一緒に直したいと思ったが、ちーむぽりしーがしっかりある。
    // 一番つらいのはチームポリシーがないケース、曖昧でやっていいのかだめなのか迷う。
    // 別Issueにしたとき、そのIssueいつやる？
    // $そこなんですよね。別Issueにするのはレビューしやすいし賛成にはなったけど...ジレンマ課題感
    // $リファクタリングチケットだけが増えていっている
    // 日々の業務開発が怒涛のように押し寄せるので、どうしてもリファクタリングチケット置き去りにされる。
    // チームの法律みたいにしないとなかなか成り立たない。(他の業種のお話を踏まえて)
    // セキュリティのお話、似たジレンマ。
    // セキュリティ対策とリファクタリングの関係性。
    //
    // // リファクタリングという行為が好きか？ 
    // https://jflute.hatenadiary.jp/entry/20220328/loverefactor
    //
    public boolean isAlreadyIn() {
        return remainingDays <= 0;
    }
}
