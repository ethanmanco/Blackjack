# Blackjack


~~~Rules~~~

Pack: Regular 52 card deck.

Objective: Reach a sum no greater than 21.

Scoring: Ace is 1 or 11, face cards are 10, other cards are their pip value.

Shuffle: The deck must be shuffled before each round.  One deck so no cut.

The Deal: The dealer gives one card face up to each player in rotation (including himeself).  
Another round of cards is dealt face up, except for the dealer (second card face down).

Naturals: If a players first two cards are a face card and an ace, this is a natural (blackjack).
If any player has a natural but the dealer does not, the dealer pays that player one and a half
times the amount of their bet.  If the dealer has a natural, they collect the bets of all players
who don't have naturals.  If the dealer and a player both have naturals, the bet of that player
is a stand-off (tie) and the player takes their bet.

The Play: The player to the left of the dealer goes first.  They can "stand" (not ask for another card)
or "hit".  A player can hit until they reach above 21, meaning they have "busted".  If you bust, you
lose your bet to the dealer.  The next player to the left takes their turn, etc.

The Dealer's Play: After every player has been served, the dealers face-down card is turned up.  If the
total is 17 or more, it must stand.  If the total is 16 or under, they must take a card.  The dealer
takes cards until the total is 17 or more where they will stay.  If the dealer has an ace and the sum
equals 17 or more (with the ace being 11), the dealer must count the ace as 11 and stand.  The dealers
actions are automatic on all plays.


~~~Additional Features~~~

Multiplayer (up to seven players).


~~~Sequence~~~

Blackjack Program: Create a deck and then shuffle it.  The deal begins and each player gets two cards 
(the dealers being face down).  Check for naturals.  The play starts and the first player decides how many 
times they want to hit or stand in place.  After each player takes theirturn, the dealer does his automatic 
play, and a winner is decided, ending the round.  The game then asks if you would like to play another round.


~~~Classes~~~

Blackjack (main), Deck, Card, Hand, Person, Dealer, Player