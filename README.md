# BattleShipClient
This is an arena for battle ship game. Your job is to create a bot that will win with all the others.

# Setup
First create your package, then create java class that implements BattleShipClient. There are four methods for you to fill. 
getFloatingShips() is responsible for calculating int value of floating units on your board. EG. you have a ship on fields A1 and A2. It returns 2 floating units.
In receiveAttack() you'll define what should your bot do when it gets opponent's target. If they hit you, you should decrease value of floating units by 1.
attack() is the most important one. Here you describe how your bot aims on opponent. You must return Location object in the end.
getBotName() returns a String value with your bot's name. It will be displayed in the console during competition.
