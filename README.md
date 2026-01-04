# Atm-system-java-GU
Console-based ATM system using Java with file persistence
# ATM System – Java Console Project

## Project Overview
This project implements a console-based ATM system using Java. It demonstrates object-oriented programming, file handling, exception handling, and data persistence using serialization.

## Features
- Check account balance
- Deposit money
- Withdraw money with balance validation
- File-based data persistence
- Input validation and error handling
- Modular and layered design

## Technologies Used
- Java
- OOP (Encapsulation, Exceptions)
- File I/O
- Serialization

## Project Structure
- Account.java – Model class with encapsulated balance
- AccountDAO.java – Handles file read/write operations
- ATMSystem.java – Main application and user interface
- InsufficientFundsException.java – Custom exception

## How to Run
1. Compile:
   javac ATMSystem.java
2. Run:
   java ATMSystem

Account data is saved in `account.dat`.

## Validation & Error Handling
- Prevents negative or invalid input
- Handles insufficient balance
- Prevents application crashes due to wrong input

## Future Enhancements
- PIN-based authentication
- Transaction history
- GUI using Swing or JavaFX
- Multi-user support using database
