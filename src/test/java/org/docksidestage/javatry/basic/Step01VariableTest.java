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
package org.docksidestage.javatry.basic;

import java.math.BigDecimal;

import org.docksidestage.unit.PlainTestCase;

/**
 * The test of variable. <br>
 * Operate exercise as javadoc. If it's question style, write your answer before test execution. <br>
 * (javadocの通りにエクササイズを実施。質問形式の場合はテストを実行する前に考えて答えを書いてみましょう)
 * @author jflute
 * @author your_name_here
 */
public class Step01VariableTest extends PlainTestCase {

    // ===================================================================================
    //                                                                      Local Variable
    //                                                                      ==============
    /**
     * What string is sea variable at the method end? <br>
     * (メソッド終了時の変数 sea の中身は？)
     */
    public void test_variable_basic() { // example, so begin from the next method
        String sea = "mystic";
        log(sea); // your answer? => mystic
    }

    /** Same as the previous method question. (前のメソッドの質問と同じ) */
    public void test_variable_initial() {
        String sea = "mystic";
        Integer land = 8;
        String piari = null;
        String dstore = "mai";
        sea = sea + land + piari + ":" + dstore;
        log(sea); // your answer? => mystic8:mai
    }

    // taiga.sunamoto nullって文字列として連結されるんだ...  (2026/07/24)
    // done sunamoto 全く同じことを思った記憶があります by fujisawa (2026/08/13)
    // taiga.sunamoto NPEは起こらないのか？  (2026/07/24)
    // done sunamoto [ふぉろー] びっくりされるかもですね笑 by jflute (2026/07/29)
    // プログラミング言語の決めで、他の言語だと、空文字になったり、エラーになったり、全部nullになったり色々です。
    // Javaの "null" って出てくる挙動:
    // o デメリット: 画面とかメールとかnullって表示されやすい。
    // o メリット: $プログラムを止めない(ケースに寄る)、開発時だとnullって表示されて欲しい。
    // 会員登録のメール送信エラーを止めない話の例。
    // 些細なことでもメリデメ考える習慣を。今後も A or B の選択を色々していくことになる。
    // 1on1での思考トレーニング。

    /** Same as the previous method question. (前のメソッドの質問と同じ) */
    public void test_variable_reassigned_basic() {
        String sea = "mystic"; // 1: 1丁目1番地
        String land = "oneman"; // 2: 2丁目2番地
        sea = land; // seaの紙の1丁目1番地を消しゴムで消して、2丁目2番地に書き換えてる
        land = land + "'s dreams"; // 3: 's dreams, 4: oneman's dreams
        log(sea); // your answer? => oneman (2)
        log(land); // oneman's dreams (2? or 4?) → (4)
    }

    // taiga.sunamoto 基本的には文字列リテラルを参照している形という理解  (2026/07/24)
    // taiga.sunamoto メモリ管理とかはCと似てたりするのかな  (2026/07/24)
    // done jflute 1on1にて、変数とインスタンスの関係性について話する予定 (2026/07/29)
    // #1on1: 変数のお話 (2026/07/30)
    // $アドレスが入っているイメージ → Javaでもオブジェクト型の場合はアドレスが入っている。
    // #1on1: インスタンスのお話 (2026/07/30)
    // $オブジェクトの複製品たちみたいな
    // 一軒家の例。
    // インスタンスフォーカスの大切さ。インスタンス間違いをしないように。
    // 変数とインスタンスは1:1で取り扱うことが多いけど、厳密にはn:1もあり得る。
    // 後半エクササイズのメソッド引数によるn:1の話。クラス間のn:1の話。
    // BigDecimalでのインスタンスエクササイズもやった。

    /** Same as the previous method question. (前のメソッドの質問と同じ) */
    public void test_variable_reassigned_int() {
        int sea = 94;
        int land = 415;
        sea = land;
        land++;
        log(sea); // your answer? => 415
        // #1on1: プリミティブ型 (2026/07/30)
        // 他の言語だと、もうプリミティブ型がない言語も。intと書いて実はオブジェクト扱い。
    }

    /** Same as the previous method question. (前のメソッドの質問と同じ) */
    public void test_variable_reassigned_BigDecimal() {
        BigDecimal sea = new BigDecimal(94);
        BigDecimal land = new BigDecimal(415);
        sea = land;
        sea = land.add(new BigDecimal(1));
        sea.add(new BigDecimal(1));
        log(sea); // your answer? => 416
    }

    // taiga.sunamoto  これっぽいなで正解しちゃったからちょっとちゃんと調べてみる (2026/07/24)
    // taiga.sunamoto  kotlinと同じくイミュータブルかそうでないかが重要になってきそう (2026/07/24)
    // taiga.sunamoto  StringとかBigDecimalはイミュータブルだから基本的に新しいインスタンスが作られる (2026/07/24)
    // taiga.sunamoto  なんか値オブジェクトみたい (2026/07/24)
    // taiga.sunamoto  というかStringとかBigDecimalとかってプリミティブな型じゃなくてクラスだからもろ値オブジェクトか？ (2026/07/24)
    // taiga.sunamoto  てかそもそもなんでStringとかIntegerってBigDecimalと違ってnewせずにインスタンス化できてるんだ？ (2026/07/24)
    // done sunamoto [いいね] 合っててもちゃんと調べてみると素晴らしい！ by jflute (2026/07/29)
    // immutable/mutableしっかり理解されているようでいいですね！
    // まあ、広義に捉えて「値オブジェクト」と言っても過言ではないかもですね。
    // Stringは、スーパー基本クラスなので特別扱いです。"abc" で new されます。
    // Integerは、基本的にはnewしないとインスタンス化されないですが...
    // プリミティヴ型からオートボクシングが発生した時に内部的newが発生することがありますね。
    // ラッパー型なのかどうか？というところがポイントで、BigDecimalはラッパー型ではないんですよね。
    // done sunamoto [読み物課題] プリミティブ型とラッパー型 by jflute (2026/07/29)
    // https://dbflute.seasar.org/ja/manual/topic/programming/java/beginners.html#primitivewrapper

    // 2026/07/24の週はここまで！！
    // もうちょいペース上げないと一生沼りそう
    // done sunamoto [いいね] 最初の基礎の基礎は大事なところなので、じっくりで大丈夫ですよ^^ by jflute (2026/07/29)
    // done sunamoto 焦らずじっくり頑張りましょー by fujisawa (2026/08/13)

    // done jflute 次回はimmutableやるぞ！ (2026/08/13)
    // #1on1: immutable/mutableとは？ (2026/08/14)
    // immutableという言葉使うか？ $ そこまでしっかり使ってない？
    // $ 気になって調べたら出てくる。→ それで意味は知ってる。
    // 
    // 不変な
    // o immutableなクラス(インスタンス) // default!?
    // o immutableな変数
    //
    // BigDecimal のコードを改めて読んでみてimmutableなクラスとして設計されている。
    // なので、newしたBigDecimalインスタンスは、immutableなインスタンスになる。
    //
    // immutableのメリット・デメリット:
    // (メリット)
    // o $ DDDの値オブジェクト、値の透過性？値が変わった時に新しいインスタンス？ by すなもとさん
    // o $ 前の状態を保持できる、残しておくことができる by すなもとさん
    // o 変わっちゃいけないものを変えられないようにして安全/安心を得る → 安全性
    // o 業務的に変わるの場合は？
    // o 後半エクササイズで読み飛ばしなどの可読性を実感
    // o 状態が変化するものを把握するというのは人間むずかしい (可読性の一つ)
    //   → インスタンスの中身は変わらないってルールの方が脳みそ優しいという考え方
    //
    // (デメリット)
    // o $ 値を変えたい時に、インスタンスが作られるのでメモリ使う
    // o immutableは、手間を掛けてimmutableにしている → 言語サポート欲しい
    //
    // immutableの歴史:
    // o 昔は、メモリが貧弱、new/newするプログラミングやってられない
    // o 昔は、言語が貧弱、immutableをサポートする文法が少ない
    // o 今や、メモリもたっぷり、言語発達、デメリット少なくなってきた
    //
    // ※アイディア自体は(大抵)昔からあって、
    // インフラ都合のデメリットが解消されて流行るようになる。
    //
    // immutableのバランス:
    // o 言語や組織や個人の文化に寄る
    // o Java: 歴史的なこともあり(古いクラス一杯)、コンセプトもimmutable全推しではない、
    //         ので、8:2くらいでimmutable寄りで、but 無理しない (jflute個人もそう)
    //         (mutableで書く時は、安全性/可読性を別の手段で演出するように工夫)
    // o 他の言語では、immutable全推しのものもある。

    // ===================================================================================
    //                                                                   Instance Variable
    //                                                                   =================
    private String instanceBroadway;
    private int instanceDockside;
    private Integer instanceHangar;
    private String instanceMagiclamp;

    /** Same as the previous method question. (前のメソッドの質問と同じ) */
    public void test_variable_instance_variable_default_String() {
        String sea = instanceBroadway;
        log(sea); // your answer? => null
    }
    // taiga.sunamoto  前回習ったやつ！ (2026/08/07)

    /** Same as the previous method question. (前のメソッドの質問と同じ) */
    public void test_variable_instance_variable_default_int() {
        int sea = instanceDockside;
        log(sea); // your answer? => 0
    }
    // taiga.sunamoto  インスタンス変数のintはデフォルトで0 (2026/08/07)

    /** Same as the previous method question. (前のメソッドの質問と同じ) */
    public void test_variable_instance_variable_default_Integer() {
        Integer sea = instanceHangar;
        log(sea); // your answer? => null
    }

    /** Same as the previous method question. (前のメソッドの質問と同じ) */
    public void test_variable_instance_variable_via_method() {
        instanceBroadway = "bbb";
        instanceMagiclamp = "magician";
        helpInstanceVariableViaMethod(instanceMagiclamp);
        String sea = instanceBroadway + "|" + instanceDockside + "|" + instanceHangar + "|" + instanceMagiclamp;
        log(sea); // your answer? => bigband|1|null|magician
    }
    // taiga.sunamoto  ローカル変数をに代入してるだけだからinstanceMagiclampは変わらない (2026/08/07)
    // taiga.sunamoto  thisとかつけてローカル変数とインスタンス変数区別する (2026/08/07)
    // taiga.sunamoto  IntelliJちゃんが頭良いせいで、「パラメーターはローカル変数に変換できます」って出てきちゃってた... (2026/08/07)
    // done sunamoto IDEの出してくる情報を気にするのは、実際の業務でも役に立つので継続しましょう by fujisawa (2026/08/13)

    private void helpInstanceVariableViaMethod(String instanceMagiclamp) {
        instanceBroadway = "bigband";
        ++instanceDockside;
        instanceMagiclamp = "burn";
    }

    // ===================================================================================
    //                                                                     Method Argument
    //                                                                     ===============
    // -----------------------------------------------------
    //                                 Immutable Method-call
    //                                 ---------------------
    /** Same as the previous method question. (前のメソッドの質問と同じ) */
    public void test_variable_method_argument_immutable_methodcall() {
        String sea = "harbor";
        int land = 415;
        helpMethodArgumentImmutableMethodcall(sea, land);
        log(sea); // your answer? => harbor
    }
    // taiga.sunamoto  "harbor416"はGC対象 (2026/08/07)
    // taiga.sunamoto  landは415のまま (2026/08/07)
    // done jflute 1on1にて、BigDecimalエクササイズのimmutableと合わせてフォロー予定 (2026/08/13)
    // #1on1: immutableがわかっていれば、helpメソッド読まなくても答えが出る (2026/08/14)
    // 読み飛ばしができるようになる。immutableってのは読み手にとっての情報でもある。
    // mutableだったら、変えてないにしてもそれを確認するためにくまなく読まないといけない。

    private void helpMethodArgumentImmutableMethodcall(String sea, int land) {
        ++land;
        String landStr = String.valueOf(land); // is "416"
        sea.concat(landStr);
    }

    // -----------------------------------------------------
    //                                   Mutable Method-call
    //                                   -------------------
    /** Same as the previous method question. (前のメソッドの質問と同じ) */
    public void test_variable_method_argument_mutable_methodcall() {
        StringBuilder sea = new StringBuilder("harbor");
        int land = 415;
        helpMethodArgumentMethodcall(sea, land);
        log(sea); // your answer? => harbor416
    }
    // if (i == Integer.MIN_VALUE) {
    //            append("-2147483648");
    //            return this;
    //        }
    // taiga.sunamoto  これを見て42を思い出した (2026/08/07)
    // done sunamoto [いいね] ソースコード読んでるの素晴らしい by jflute (2026/08/13)
    // done sunamoto [へー] 気になる笑 by jflute (2026/08/13)

    private void helpMethodArgumentMethodcall(StringBuilder sea, int land) {
        ++land;
        sea.append(land);
    }

    // -----------------------------------------------------
    //                                   Variable Assignment
    //                                   -------------------
    /** Same as the previous method question. (前のメソッドの質問と同じ) */
    public void test_variable_method_argument_variable_assignment() {
        StringBuilder sea = new StringBuilder("harbor");
        int land = 415;
        helpMethodArgumentVariable(sea, land);
        log(sea); // your answer? => harbor
    }

    private void helpMethodArgumentVariable(StringBuilder sea, int land) {
        ++land;
        String seaStr = sea.toString(); // is "harbor"
        sea = new StringBuilder(seaStr).append(land);
    }
    // taiga.sunamoto  新しいオブジェクトつくっちゃってるから元のseaには関係なし (2026/08/07)
    // done sunamoto [いいね] ちゃんとインスタンスの違いを理解されていますね！ by jflute (2026/08/13)

    // 第二週はここまで！！

    // ===================================================================================
    //                                                                           Challenge
    //                                                                           =========
    /**
     * Define variables as followings:
     * <pre>
     * o local variable named sea typed String, initial value is "mystic"
     * o local variable named land typed Integer, initial value is null
     * o instance variable named piari typed int, without initial value
     * o show all variables by log() as comma-separated
     * </pre>
     * (変数を以下のように定義しましょう):
     * <pre>
     * o ローカル変数、名前はsea, 型はString, 初期値は "mystic"
     * o ローカル変数、名前はland, 型はInteger, 初期値は null
     * o インスタンス変数、名前はpiari, 型はint, 初期値なし
     * o すべての変数をlog()でカンマ区切りの文字列で表示
     * </pre>
     */
    int piari;

    public void test_variable_writing() {
        // define variables here
        String sea = "mystic";
        Integer land = null;
        log(sea + "," +  land + "," +  piari);
    }

    // ===================================================================================
    //                                                                           Good Luck
    //                                                                           =========
    /**
     * Make your original exercise as question style about variable. <br>
     * (変数についてあなたのオリジナルの質問形式のエクササイズを作ってみましょう)
     * <pre>
     * _/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/
     * o ローカル変数、名前はraw, 型はString, 初期値は "生の"
     * o ローカル変数、名前はraw, 型はString, 初期値は "鶏"
     * o ローカル変数、名前はchicken, 型はString, 初期値は "鶏"
     * o ローカル変数、名前はmeat, 型はString, 初期値は "肉"
     * o ローカル変数、名前はhoge, 型はInteger, 初期値は null
     * o インスタンス変数、名前はfuga, 型はInteger, 初期値なし
     * o 上記の変数を組み合わせて、log()で「生の鶏肉はnullnull」と表示
     * _/_/_/_/_/_/_/_/_/_/
     * </pre>
     */
    Integer fuga;
    public void test_variable_yourExercise() {
        String raw = "生の";
        String chicken = "鶏";
        String meat = "肉";
        Integer hoge = null;

        log(raw + chicken + meat + "は" + hoge + fuga);
    }
}
