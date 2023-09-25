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

## コンパイル方法
- Mainクラスを以下に書き換え
```java:app/src/main/java/com/SZZ/app/Main.java
package com.SZZ.app;

public class Main {
    public static void main(String[] args) {
        // args = new String[4];
		// args[0] = "-all";
		// args[1] = "https://github.com/apache/commons-bcel.git";
		// args[2] = "https://issues.apache.org/jira/projects/BCEL";
		// args[3] = "BCEL";

        
        SZZApplication.saveJira(args[0]);
        // long startTime = System.currentTimeMillis();
        
        // try {
        //     SZZApplication.main(args);
        // }
        // catch (Exception e) {
        //     e.printStackTrace();
        // }
        
        // long endTime = System.currentTimeMillis();
		// System.out.println("処理時間：" + (endTime - startTime) + " ms");
    }
}
```

- FatJarとしてコンパイルする
```
./gradlew shadowJar
```
