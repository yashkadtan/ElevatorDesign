public class ElevatorCar {
    int id;
    ElevatorDisplay elevatorDisplay;
    InternalButtons internalButtons;
    ElevatorState elevatorState;
    int currentFloor;
    Direction direction;
    ElevatorDoor elevatorDoor;

    public ElevatorCar() {
        elevatorDisplay = new ElevatorDisplay();
        internalButtons = new InternalButtons();
        elevatorState = ElevatorState.IDLE;
        currentFloor = 0;
        direction = Direction.UP;
        elevatorDoor = new ElevatorDoor();
    }

    public void showDisplay(){
        elevatorDisplay.showDisplay();
    }

    public void pressButton(int destination){
        internalButtons.pressButton(destination, this);
    }

    public void setElevatorDisplay(){
        elevatorDisplay.setDisplay(currentFloor, direction);
    }

    public boolean moveElevator(Direction direction, int destinationFloor){
        int startFloor = currentFloor;
        if(direction == Direction.UP){
            for(int i=startFloor;i<=destinationFloor;i++){
                currentFloor = i;
                setElevatorDisplay();
                showDisplay();
                if(i==destinationFloor){
                    return true;
                }
            }
        }
        else{
            for(int i=startFloor;i>=destinationFloor;i--){
                currentFloor = i;
                setElevatorDisplay();
                showDisplay();
                if(i==destinationFloor){
                    return true;
                }
            }
        }
        return false;
    }
}
