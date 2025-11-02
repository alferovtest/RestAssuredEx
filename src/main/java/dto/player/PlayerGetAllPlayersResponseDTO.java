package dto.player;

import java.util.List;
import com.fasterxml.jackson.annotation.JsonProperty;

public class PlayerGetAllPlayersResponseDTO{

	@JsonProperty("players")
	private List<PlayerDTO> players;

	public void setPlayers(List<PlayerDTO> players){
		this.players = players;
	}

	public List<PlayerDTO> getPlayers(){
		return players;
	}

	@Override
 	public String toString(){
		return 
			"PlayerGetAllPlayersResponseDTO{" + 
			"players = '" + players + '\'' + 
			"}";
		}
}