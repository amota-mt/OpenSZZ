## 概要
実行したディレクトリ直下にcsvファイルが生成されます．
Javaのバージョンがコンパイル環境と同じ必要があるので，11と17の2パターン作りました．

## 実行コマンド
```
java -jar app-{version}.jar {projectKey}
```

例（Java11環境でBCELをダウンロードする場合）
```
java -jar app-11.jar BCEL
```

## コンパイル環境
```
openjdk 11.0.20 2023-07-18
OpenJDK Runtime Environment (build 11.0.20+8-post-Ubuntu-1ubuntu120.04)
OpenJDK 64-Bit Server VM (build 11.0.20+8-post-Ubuntu-1ubuntu120.04, mixed mode, sharing)
```
```
java 17.0.3.1 2022-04-22 LTS
Java(TM) SE Runtime Environment (build 17.0.3.1+2-LTS-6)
Java HotSpot(TM) 64-Bit Server VM (build 17.0.3.1+2-LTS-6, mixed mode, sharing)
```