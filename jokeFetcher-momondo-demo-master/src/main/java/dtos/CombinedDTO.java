/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dtos;

/**
 *
 * @author mikke
 */
public class CombinedDTO {
    private String dadJoke; 
    private String dadJokeURL; 
    private String chuckJoke; 
    private String chuckJokeURL; 

    public CombinedDTO(DadDTO dadDTO, ChuckDTO chuckDTO) {
        this.dadJoke = dadDTO.getJoke();
        this.dadJokeURL = "https://icanhazdadjoke.com"; 
        this.chuckJoke = chuckDTO.getValue();
        this.chuckJokeURL = "https://api.chucknorris.io/jokes/random";
    }
    
     
    
    
    
}
