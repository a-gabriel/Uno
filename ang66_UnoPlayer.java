
import java.awt.Color;
import java.util.List;

public class ang66_UnoPlayer implements UnoPlayer {

    /**
     * play - This method is called when it's your turn and you need to
     * choose what card to play.
     *
     * The hand parameter tells you what's in your hand. You can call
     * getColor(), getRank(), and getNumber() on each of the cards it
     * contains to see what it is. The color will be the color of the card,
     * or "Color.NONE" if the card is a wild card. The rank will be
     * "Rank.NUMBER" for all numbered cards, and another value (e.g.,
     * "Rank.SKIP," "Rank.REVERSE," etc.) for special cards. The value of
     * a card's "number" only has meaning if it is a number card. 
     * (Otherwise, it will be -1.)
     *
     * The upCard parameter works the same way, and tells you what the 
     * up card (in the middle of the table) is.
     *
     * The calledColor parameter only has meaning if the up card is a wild,
     * and tells you what color the player who played that wild card called.
     *
     * Finally, the state parameter is a GameState object on which you can 
     * invoke methods if you choose to access certain detailed information
     * about the game (like who is currently ahead, what colors each player
     * has recently called, etc.)
     *
     * You must return a value from this method indicating which card you
     * wish to play. If you return a number 0 or greater, that means you
     * want to play the card at that index. If you return -1, that means
     * that you cannot play any of your cards (none of them are legal plays)
     * in which case you will be forced to draw a card (this will happen
     * automatically for you.)
     */
    public int play(List<Card> hand, Card upCard, Color calledColor, GameState state) {
    	
    	//Checks if any playable color
    	//If no color playable, checks if number card playable
    	//If no number playable, checks if WD or WD+4 is in hand
    	
    	if(upCard.getColor()!=Color.NONE){
    		int x = -2;
    		int x4 = -2;
    		for (int i = 0; i<hand.size(); i++){
    			if (hand.get(i).getColor() != upCard.getColor()){
    				if(upCard.getNumber()!=-1){

    	    			if (hand.get(i).getNumber()!=upCard.getNumber()){
    	    				if (hand.get(i).getRank()!=Rank.WILD){
    	    					if (hand.get(i).getRank()!=Rank.WILD_D4){
    	    						continue;
    	    				}
    	    				}
    	    				
    				
    			
    	    				if (hand.get(i).getRank()==Rank.WILD){
    	    					x = i;
    	    					continue;}
    	    				if (hand.get(i).getRank()==Rank.WILD_D4){
    	    					x4 = i;
    	    					continue;
    	    				}
    	    			
    	    				}
    	    		else if (hand.get(i).getNumber()==upCard.getNumber()){
    	    				return i;
    	    			}	
    	    		}
    			}
    			else if (hand.get(i).getColor()==upCard.getColor()){
    				return i;
    			}
    		}
    	if (x >= 0){
    		return x;}
    	if (x4>=0) {
    		return x4;
    	}
    	}
    	
    	//Checks if upCard is Wild
    	//Checks if playable calledColor card
    	//If not playable color card, checks if WD or WD+4 is in hand
    	
    	if(upCard.getColor()==Color.NONE){
    		for (int i = 0; i<hand.size(); i++){
    			if(hand.get(i).getColor() != calledColor){
    					if(hand.get(i).getRank()==Rank.WILD){
    						return i;
    					}
    					else if (hand.get(i).getRank()==Rank.WILD_D4){
    						return i;
    					}
    					else {continue;}}
    					
    			else{return i;}
    			}
    		}
    					

    	//Checks if upCard is special card
    	//If card is special, check in hand if playable color card
    	//If no playable color card, check in hand if rank playable card
    	//If no playable rank card, check if hand contains WD or WD+4
    	
    	if(upCard.getNumber() == -1){
    		int x = -2;
    		int x4 = -2;
    	
    		
    		for (int i = 0; i<hand.size(); i++){
    			if (hand.get(i).getColor()!=upCard.getColor()){
    				if(upCard.getRank()==Rank.SKIP){
    					if (hand.get(i).getRank()!=Rank.SKIP){
    						if(hand.get(i).getRank()!=Rank.WILD){
    							if(hand.get(i).getRank()!=Rank.WILD_D4){
    								continue;
    							}
    						}
    						if (hand.get(i).getRank()==Rank.WILD){
    							x = i;
    							continue;
    						}
    						if (hand.get(i).getRank()==Rank.WILD_D4){
    							x4 = i;
    							continue;
    						}
    					}
    					else {
    						return i;
    					}
    				}
    				if(upCard.getRank()==Rank.REVERSE){
    					if(hand.get(i).getRank()!=Rank.REVERSE){
    						if (hand.get(i).getRank()!=Rank.WILD){
    							if(hand.get(i).getRank()!=Rank.WILD_D4){
    								continue;
    							}
    						}
    						if (hand.get(i).getRank()==Rank.WILD){
    							x = i;
    							continue;
    						}
    						if(hand.get(i).getRank()==Rank.WILD_D4){
    							x4 =i;
    							continue;
    							}
    						}
    					if(hand.get(i).getRank()==Rank.REVERSE){
    						return i;
    					}
    				}
    				if(upCard.getRank()==Rank.DRAW_TWO){
    					if(hand.get(i).getRank()!=Rank.DRAW_TWO){
    						if (hand.get(i).getRank()!=Rank.WILD){
    							if (hand.get(i).getRank()!=Rank.WILD_D4){
    							continue;
    						}
    					}
    					
    						if (hand.get(i).getRank()==Rank.WILD){
    							x = i;
    							continue;
    						}
    						if (hand.get(i).getRank()==Rank.WILD_D4){
    							x4 = i;
    							continue;
    						}
    					}
    					else{
    						return i;}	
    				}   			
    			}		
    		}

        if (x >= 0){
        	return x;}
        else if (x4>=0){
        	return x4;
        }
    
        }
    
    	return -1;}
    


    /**
     * callColor - This method will be called when you have just played a
     * wild card, and is your way of specifying which color you want to 
     * change it to.
     *
     * You must return a valid Color value from this method. You must not
     * return the value Color.NONE under any circumstances.
     */
    public Color callColor(List<Card> hand) {
    	int blue = 0;
    	int green = 0;
    	int yellow = 0;
    	int red = 0;
    	int [] colors = {blue, green, yellow, red};
    	
    	for (int i = 0; i<hand.size(); i++){
    		if (hand.get(i).getColor()==Color.BLUE){
    			blue ++;
    		}
    		if (hand.get(i).getColor()==Color.GREEN){
    			green ++;
    		}
    		if (hand.get(i).getColor()==Color.YELLOW){
    			yellow++;
    		}
    		if(hand.get(i).getColor()==Color.RED){
    			red++;
    		if(hand.get(i).getColor()==Color.NONE){
    			continue;}
 
    		}
    	}
    	int max=0;
    	for (int i = colors.length; i>0; i--){
    		for (int j = 0; j<i; j++){
    			if(colors[j]>colors[max]){
    				max = colors[j];
    			}
    			else {continue;}
    			
    		
    		}
    	
    		}
    	
    	if (max==colors[0]){
			return Color.BLUE;
		}
		if (max == colors [1]){
			return Color.GREEN;
		}
		if (max == colors[2]){
			return Color.YELLOW;
		}
		if (max == colors[3]){
			return Color.RED;
			}
		return Color.BLUE;}
    }

   
