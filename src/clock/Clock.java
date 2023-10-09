package clock;

import model.modelInterface;
import model.stateInterface;

import java.util.Scanner;

public class Clock implements modelInterface, stateInterface {
    private STATE current_state = STATE.GET_TIME;


    public enum STATE {
        GET_TIME,
        GET_DATE,
        CHANGE_TIME,
        CHANGE_DATE
    }

    @Override
    public void getTime() {
        if (current_state == STATE.GET_TIME) {
            System.out.println("Current time: ");
            time.Time time = new time.Time();
            time.getTime();
        } else if (current_state == STATE.GET_DATE) {
            changeState();
        } else if (current_state == STATE.CHANGE_TIME) {
            set();
        } else {
            System.out.println("Wrong state!");
        }
    }

    @Override
    public void getDate() {
        if (current_state == STATE.GET_DATE) {
            System.out.println("Current date: ");
            date.Date date = new date.Date();
            date.getDate();
        } else if (current_state == STATE.GET_TIME) {
            changeState();
        } else if (current_state == STATE.CHANGE_DATE) {
            set();
        } else {
            System.out.println("Wrong State!");
        }
    }

    @Override
    public void changeTime() {
        if (current_state == STATE.CHANGE_TIME) {
            time.Time time = new time.Time();
            time.changeTime();
        } else if (current_state == STATE.GET_TIME) {
            readyToSet();
        } else {
            System.out.println("Wrong state!");
        }
    }

    @Override
    public void changeDate() {
        if (current_state == STATE.CHANGE_DATE) {
            date.Date date = new date.Date();
            date.changeDate();
        } else if (current_state == STATE.GET_DATE) {
            readyToSet();
        } else {
            System.out.println("Wrong state!");
        }
    }

    @Override
    public void changeState() {
        if (getCurrentState() == STATE.GET_TIME) {
            current_state = STATE.GET_DATE;
        } else if (getCurrentState() == STATE.GET_DATE) {
            current_state = STATE.GET_TIME;
        }

    }

    @Override
    public void readyToSet() {
        if (getCurrentState() == STATE.GET_TIME) {
            current_state = STATE.CHANGE_TIME;
        } else if (getCurrentState() == STATE.GET_DATE) {
            current_state = STATE.CHANGE_DATE;
        }
    }

    @Override
    public void set() {
        if (getCurrentState() == STATE.CHANGE_TIME) {
            current_state = STATE.GET_TIME;
        } else if (getCurrentState() == STATE.CHANGE_DATE) {
            current_state = STATE.GET_DATE;
        } else {
            System.out.println("Wrong state!");
        }

    }

    public STATE getCurrentState() {
        return current_state;
    }

    public void mainLoop() {
        Scanner scanner = new Scanner(System.in);
        String input = "";

        while (!input.equals("q")) {
            System.out.println("_____________________________");
            System.out.println("Current state: " + getCurrentState());
            System.out.println("_____________________________");
            System.out.println("1. Get Time \n2. Get Date \n3. Change Time \n4. Change Date \nq. Quit ");
            input = scanner.nextLine().trim();

            switch (input) {
                case "1":
                    getTime();
                    break;
                case "2":
                    getDate();
                    break;
                case "3":
                    changeTime();
                    break;
                case "4":
                    changeDate();
                    break;
                case "q":
                    System.out.println("Exiting program...");
                    break;
                default:
                    System.out.println("Invalid command!");
                    break;
            }
        }
    }

    public static void main(String[] args) {
        Clock clock = new Clock();
        clock.mainLoop();
    }
}







