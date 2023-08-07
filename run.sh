#!/bin/bash
#SBATCH -p cluster_long
#SBATCH --time=100:00:00
#SBATCH -c 1
#SBATCH --job-name openszz

module load java

sh ./gradlew run
# sh ./gradlew run --args="-all https://github.com/apache/commons-bcel.git https://issues.apache.org/jira/projects/BCEL BCEL"
# java -jar ./app/build/libs/app.jar -all https://github.com/apache/commons-bcel.git https://issues.apache.org/jira/projects/BCEL BCEL
