package com.company;
public class Main {

    public static void main(String[] args) {

        // for logging into the system
        Login login = new Login();

        while (true) {

            // display login screen and check if login was successful
            if (login.showLoginScreen()) {

                // instantiating system
                HotelRoomReservationSystem hrrs = new HotelRoomReservationSystem();

                // display system main menu
                hrrs.showMainMenu();
            }
        }
    }
}