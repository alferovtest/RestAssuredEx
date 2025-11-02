package dto.player;

import com.fasterxml.jackson.annotation.JsonProperty;

public class PlayerGetDeleteByPlayerIdRequestDTO {

	@JsonProperty("playerId")
	private int playerId;

	public void setPlayerId(int playerId){
		this.playerId = playerId;
	}

	public int getPlayerId(){
		return playerId;
	}

	@Override
 	public String toString(){
		return 
			"PlayerGetDeleteByPlayerIdRequestDTO{" +
			"playerId = '" + playerId + '\'' + 
			"}";
		}
}