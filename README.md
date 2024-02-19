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

# 株式会社ゆめみ Android エンジニアコードチェック課題

## 概要

本プロジェクトは株式会社ゆめみ（以下弊社）が、弊社に Android
エンジニアを希望する方に出す課題のベースプロジェクトです。本課題が与えられた方は、下記の概要を詳しく読んだ上で課題を取り組んでください。

## アプリ仕様

本アプリは GitHub のリポジトリを検索するアプリです。

<img src="docs/app.gif" width="320">

### 環境

- IDE：Android Studio Flamingo | 2022.2.1 Patch 2
- Kotlin：1.6.21
- Java：17
- Gradle：8.0
- minSdk：23
- targetSdk：31

※ ライブラリの利用はオープンソースのものに限ります。
※ 環境は適宜更新してください。

### 動作

1. 何かしらのキーワードを入力
2. GitHub API（`search/repositories`）でリポジトリを検索し、結果一覧を概要（リポジトリ名）で表示
3. 特定の結果を選択したら、該当リポジトリの詳細（リポジトリ名、オーナーアイコン、プロジェクト言語、Star
   数、Watcher 数、Fork 数、Issue 数）を表示

## 課題取り組み方法

Issues を確認した上、本プロジェクトを [**Duplicate
** してください](https://help.github.com/en/github/creating-cloning-and-archiving-repositories/duplicating-a-repository)
（Fork しないようにしてください。必要ならプライベートリポジトリにしても大丈夫です）。今後のコミットは全てご自身のリポジトリで行ってください。

コードチェックの課題 Issue
は全て [`課題`](https://github.com/yumemi-inc/android-engineer-codecheck/milestone/1) Milestone
がついており、難易度に応じて Label
が [`初級`](https://github.com/yumemi-inc/android-engineer-codecheck/issues?q=is%3Aopen+is%3Aissue+label%3A初級+milestone%3A課題)、[`中級`](https://github.com/yumemi-inc/android-engineer-codecheck/issues?q=is%3Aopen+is%3Aissue+label%3A中級+milestone%3A課題+)
と [`ボーナス`](https://github.com/yumemi-inc/android-engineer-codecheck/issues?q=is%3Aopen+is%3Aissue+label%3Aボーナス+milestone%3A課題+)
に分けられています。課題の必須／選択は下記の表とします。

|         | 初級 | 中級 | ボーナス 
|--------:|:--:|:--:|:----:|
| 新卒／未経験者 | 必須 | 選択 |  選択  |
|  中途／経験者 | 必須 | 必須 |  選択  |

課題 Issueをご自身のリポジトリーにコピーするGitHub Actionsをご用意しております。  
[こちらのWorkflow](./.github/workflows/copy-issues.yml)
を[手動でトリガーする](https://docs.github.com/ja/actions/managing-workflow-runs/manually-running-a-workflow)
ことでコピーできますのでご活用下さい。

課題が完成したら、リポジトリのアドレスを教えてください。

## 参考記事

提出された課題の評価ポイントに関しては、[こちらの記事](https://qiita.com/blendthink/items/aa70b8b3106fb4e3555f)
に詳しく書かれてありますので、ぜひご覧ください。

## AIサービスの利用について

ChatGPTなどAIサービスの利用は禁止しておりません。

利用にあたって工夫したプロンプトやソースコメント等をご提出頂くことで、加点評価する場合もございます。 (
減点評価はありません)

また、弊社コードチェック担当者もAIサービスを利用させていただく場合があります。

AIサービスの利用は差し控えてもらいたいなどのご要望がある場合は、お気軽にお申し出ください。
