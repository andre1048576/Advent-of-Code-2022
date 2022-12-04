package day2;


public class Hand {
    
    enum HandType {
        Rock,
        Paper,
        Scissors
    }

    HandType hand_type;

    Hand(String initial_value) {
        switch(initial_value) {
            case "A":
                this.hand_type = HandType.Rock;
                break;
            case "B":
                this.hand_type = HandType.Paper;
                break;
            case "C":
                this.hand_type = HandType.Scissors;
                break;
            default:
                System.out.println("hold up " + initial_value + " isn't valid");
        }
    }

    public HandType get_hand_type() {
        return hand_type;
    }

    //note that 1 is a win, 0 is a tie, and -1 is a loss
    public int against(Hand otherHand) {
        switch(this.hand_type) {
            case Paper:
                switch(otherHand.get_hand_type()) {
                    case Paper:
                        return 0;
                    case Rock:
                        return 1;
                    case Scissors:
                        return -1;
                }
            case Rock:
                switch(otherHand.get_hand_type()) {
                    case Paper:
                        return -1;
                    case Rock:
                        return 0;
                    case Scissors:
                        return 1;
                }
            case Scissors:
                switch(otherHand.get_hand_type()) {
                    case Paper:
                        return 1;
                    case Rock:
                        return -1;
                    case Scissors:
                        return 0;
                }
            default:
                return -99;

        }
    }
}