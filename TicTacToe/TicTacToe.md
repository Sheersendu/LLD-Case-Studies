## Design TicTacToe

<hr>

### Requirements

<hr>

1. Board can be of NxN size
2. There can be 2 players
3. Each player will be allotted a symbol
4. The symbol can be O and X
5. The players can be humans or bots
6. Each human player will have name, email, profile image
7. Each bot player will have a difficulty level
8. Any random player can start the game
9. Each the players will take turn alternatively
10. The player with N consecutive of their symbol in a row or column or diagonal wins
11. If board is full and no player wins then its draw

### Entities and attributes

<hr>

1. Board
   1. Size
   2. Cell[][]
2. Player
   1. Symbol
   2. Type - Human, Bot
3. Symbol
4. Human Player
   1. Name
   2. Email
   3. Photo
5. Bot Player
   1. Difficulty level
6. Game
   1. Board
   2. Players
7. Cell
   1. X, Y
   2. Symbol

### Use Case Diagram
```plantuml
@startuml
left to right direction
actor HumanPlayer
actor Bot
rectangle Game {
    HumanPlayer -- (Start Game)
    HumanPlayer -- (Make Move)
    Bot -- (Make Move)
    HumanPlayer -- (Register)
    (Make Move) .> (Check Winner) : includes
}
@enduml
```

### Class Diagram
```mermaid
classDiagram
class Game {
    - board : Board
    - players : Player[]
    + register(Player)
    +startGame(Player, Player, int row, int column) void
    +makeMove(Player, int x, int y) Board
    +checkWinner(Board, Player, Player) Player
}
class Board {
    - cells : Cell[][] 
    +Board(int, int)  Board
}
class Cell {
    - x : int
    - y : int
    - symbol : Symbol
}
class Player {
    <<abstract>>
    - symbol : Symbol
    +play(Board)* Cell
}
class User {
    - name : String
    - email : String
    - photo : byte[]
}
class HumanPlayer {
    - user : User
    - playingStrategy : PlayingStrategy 
    +play(Board) Cell
}
class Bot {
    - difficultyLevel : Level
    - playingStrategy : PlayingStrategy
    +play(Board) Cell
}
class Symbol {
    <<enumerator>>
    X
    O
}
class Level {
    <<enumerator>>
    EASY
    MEDIUM
    HARD
}
class PlayingStrategy {
    <<interface>>
    +play(Board) Cell
}
class RandomPlayingStrategy {
    +play(Board) Cell
}
class MinMaxPlayingStrategy {
    +play(Board) Cell
}
class AlphaBetaPlayingStrategy {
    +play(Board) Cell
}

Game "1" --* "1" Board : Comprises of
Board "1" --* "M" Cell : Consists of
Player "1" --o "1" Symbol : Contains
Game "1" --* "M" Player : has
HumanPlayer --|> Player : implements
HumanPlayer "M" --o "1" User : has a 
Bot --|> Player : implements
Cell "1" --* "1" Symbol : Contains
PlayingStrategy  <|-- RandomPlayingStrategy
PlayingStrategy  <|-- MinMaxPlayingStrategy
PlayingStrategy  <|-- AlphaBetaPlayingStrategy
Bot "M" --o "1" PlayingStrategy
Bot "1" --o "1" Level : has a 
```

### Notes:
* SRP, OCP violation in Bot class as playing behaviour changes based on difficulty levels : `Strategy Pattern` : Here it will be PlayingStrategy
* Photo in HumanPlayer is a problem as memory issue + every game we play these metadata needs to be repeated : `Flyweight`. Here it will be User class
* Use Factory for object creation nas client needs to know about subclasses(HumanPlayer, BotPlayer) for object creation(Check test class)
* Now if we can create board of any dimensions, so the winning rules will vary accordingly, hence winningStrategy

### Side Assignment:
* What if we want to undo our move? Store all the moves