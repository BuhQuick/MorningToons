@echo off
chcp 1250
cls
COLOR 1F
d:
cd program files\eclipse\workspace16-17\MorningToons\src
javac MorningToonsList.java
java MorningToonsList c:\users\nbuqu\desktop\morningcartoons\MorningToons.csv
pause