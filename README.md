Featured Additions:
  1. Users now have the choice to debuff an enemy instead of attack them. (text narration has been changed accordingly)
  2. The Monster class now has a simple AI method to decide whether to use normal or specialized attacks against the player
  3. After a monster is killed, it drops an item. The player will decide whether to pick it up or leave it. These items will either boost the player's strength, defense, or health.
  
Code Restructurings:
  1. The attack while loop has been restructured to allow for the debuff option with 2 separate executions of the loop depending on   whether the player specializes or not.
  2. A new Double[] variable has been used for the debuff stats
  3. A new debuff method has been made to the Character class
  4. A new monsterAI method has been added to the Monster class
  5. Finalized String arrays for each separate class were added to the YoRPG class. This allows for each subclass (Warrior, Beggar, etc) to encounter different items.
  6. When a monster is dead, the player is presented with the option to pick up or leave an item that the monster has dropped.
  7. A new method in YoRPG class named getItem has been added. This method picks a random item from the String array and changes the player's stats according to which item it is. The player is notified what he/she has picked up and how the item has changed his/her stats.
  
How To Play:
  1. Download these files into a single folder
  2. Compile and run YoRPG.java
  3. Follow the on screen instructions and enter input followed by pressing enter when requested
  4. Enjoy the game
  5. To play again, just run it again. No need to compile :)
