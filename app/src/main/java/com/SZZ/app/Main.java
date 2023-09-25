package com.SZZ.app;

public class Main {
    public static void main(String[] args) {
        // args = new String[4];
		// args[0] = "-all";
		// args[1] = "https://github.com/apache/commons-bcel.git";
		// args[2] = "https://issues.apache.org/jira/projects/BCEL";
		// args[3] = "BCEL";

        long startTime = System.currentTimeMillis();
        
        try {
            SZZApplication.main(args);
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        
        long endTime = System.currentTimeMillis();
		System.out.println("処理時間：" + (endTime - startTime) + " ms");
    }
}