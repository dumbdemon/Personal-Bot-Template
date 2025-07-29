@echo off
cd C:\Path\to\jar\folder
set path=C:\Program Files\Eclipse Adoptium\jdk-19.0.2.7-hotspot\bin;%path%
start javaw -jar .\PersonalBot.jar