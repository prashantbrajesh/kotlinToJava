/*

Attribution
createdBY
UpdatedBy,
createOnEopc,
UpdatedOnEpoch,
isActive



 Game Id,noOfPlayers,100,LastPlayer

 GameToPlayersDetails
 GameId
 PayerId,
 PlayerRank null,
 PieceColor,
 Position,


 Player
 PlayerId.
 PlayerName,
 mobileNo,
 emailId,
 IsActive,

 boardEntity -> Attribution
 gameId
 entiyId
 startPosition
 endPosition
 entityType (Snack, Ladder)



 NextTurnStratgy

 NextTurnStratgy{
       PayerId getnextPlayer(gameId);
 }

 gameId createGame(List<boardEntity>){

 }
 registerPlayer()

 addPlayers(gameId, playerId, PieceColor);


 PlayTemplate{
 Map<s,e> snack;
  Map<s,e> ladder;

  Integer rollDice();
  Position getCurrentPlayerPosition(gameId, NextTurnStratgy);



  position updatedPostionBySnackLadder(position){

  }

 finalPosition  nextPlay(gameId){

   getCurrentPlayer(gameId, NextTurnStratgy)

 updatedPosition = updatedPostionBySnackLadder(position+  rollDice())

    }


 }

 nextPlay(gameId){

 }








 */


public class MainRunner {
    public static void main(String[] args) {
        System.out.printf("bab");
    }
}
