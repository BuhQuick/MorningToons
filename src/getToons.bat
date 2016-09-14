@echo off
chcp 65001
d:
cd program files\eclipse\workspace16-17\MorningToons\src
javac MorningToonsList.java
java MorningToonsList 09.17.MorningToons.csv 5
pause