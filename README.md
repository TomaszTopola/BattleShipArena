# BattleShipClient
This is an arena for battle ship game. Your job is to create a bot that will win with all the others.

# Setup
First create your package, then create java class that implements BattleShipClient. There are four methods for you to fill. 
getFloatingShips() is responsible for calculating int value of floating units on your board. EG. you have a ship on 
fields A1 and A2. It returns 2 floating units. 
In receiveAttack() you'll define what should your bot do when it gets opponent's target. If they hit you, you should 
decrease value of floating units by 1. 
attack() is the most important one. Here you describe how your bot aims at opponent. You must return Location object 
in the end.
getBotName() returns a String value with your bot's name. It will be displayed in the console during competition.

# Simple setup
If you don't want to waste your time on creating all the methods and just want to focus on attacking the opponent you can 
create your bot as class which extends SimpleClient. You can always @override other methods later.

# Examples
You can find example bots in me.tomasztopola.clients. 
StupidStubbornClient always hits one location (0,0). 
JustRandomClient hits random locations on board. 
NotSoSimpleClient does same thing as JustRandomClient, but extends SimpleClient instead of implementing BatlleShipClient.
MindfulButStillRandomClient doesn't hit the same spot twice.

# I'm new to Object-Oriented Programming
Here are some rules that will help you keep your project organised.
1. Class name should be the same as file name. If you want to rename it, use refactor function (your IDE should have one)
2. Class name should start with upper case
3. In this project we use camelCase names. It means that we don't use dashes to separate words. 
   Just start every new word with capital.
   
# Tests
If you want to test your bot if it fits expectations you can always use testClient() method in Main.java.
It's not perfect but still more efficient than logging data to console. 
For testing BoardGenerators use BoardTest.
For creating your own test implement me.tomasztopola.api.Test

# Credits
Wojciech Miłek (https://github.com/wmilek) - He introduced me to the whole idea of BattleShipArena. Then I decided 
to make my own version of that interface.