# 今回のYumemi Code Testの総括

## コーディング試験で行ったこと

1. Android ViewからJetpack composeへの移行
2. Hiltの追加
3. Github Search 画面の作成
4. issueベースで、自分で課題を見つけissueを立てて、closeにできるように取り組んだ
5. MVVM+Repositoryによるアーキテクチャーでの開発
6. Maestroによる、UIテストの追加
7. Github ActionsでktlintとUIテストの自動化
8. compose-navigationの追加
9. Coilの追加(画像を表示するlibrary)
10. 検索画面に画像、starcount,watchcountの追加してブラッシュアップ

## 課題進捗

| issue |      issue名      |  進捗  |
|:-----:|:----------------:|:----:|
|   1   |  ソースコードの可読性の向上   | 100% |
|   2   |  ソースコードの安全性の向上   | 100% |
|   3   |      バグの修正       | 100% |
|   4   | プログラム構造をリファクタリング | 100% |
|   5   |    アーキテクチャを適用    | 100% |
|   6   |      テストを追加      | 50%  |
|   7   |   UIのブラッシュアップ    | 50%  |
|   8   |      新機能の追加      | 100% |

## 開発の仕方

- issue、アーキテクチャ、機能ごとにブランチを作り、開発を進めることができた。
- PRを作成して、本番のプロジェクトに沿うような形で開発できた。
- commit,branchに
- Github Actionsで自動化を行った。
- ktlintを使ってコードの品質をキープしながら開発できた。
- 1つのクラスに処理が集中しないように、MVVMを意識して開発できた。
- NullPointExceptionの`!!`を使わないようにハンドリングできた

## 開発における反省点

- テストについて、書く機会が自分自身なかったので、どのようなケースでUnitテストを行えばいいのかわからず書くことができませんでした。
- commitメッセージに具体的なことができずに、reviewerに対して、わかりにくいコメントを付けってしまった。

## 今後の成長する機会
- Roomを使った、レポジトリのお気に入り機能の追加
- WebViewの用いたweb版でのレポジトリの表示
- 学習したことのアウトプット(学習したことをZennに投稿していく)

  [android入門](https://zenn.dev/dandan/scraps/6590b25b311dc3)

  [android coroutines学習](https://zenn.dev/dandan/scraps/c7e74a8700febf)
- workmanagerを活用したバックグランドの処理の実装
- Jetpack Glanceを使ったWidgetの作成
- Clean Architectureを使った開発手法
- Uiテスト、Unitテストの勉強(maestro,junit...etc)

## 少し困ったこと
- ブランチ、commitを適切な粒度で切ることができなかったので、ブランチ名、commitメーセージに困ることがあった。

## 質問したいこと 
- ブランチのどの粒度(機能...etc)で切っていくのが適切なのか？
- commitメッセージにはどのようなことを記述するのが良いのか?

## アプリの動作

1. キーワードを入力
2. GithubApiから情報を取得
3. Github Repositoryの詳細情報を表示する

## [Closeしたissue](https://github.com/darmadevZone/yumemi-coding-test/issues?q=is%3Aissue+is%3Aclosed)


------

