CREATE DATABASE JewelryAuctionSystem;
USE JewelryAuctionSystem;

CREATE TABLE User (
    userID INT PRIMARY KEY,
    username VARCHAR(255) NOT NULL,
    password VARCHAR(255) NOT NULL,
    email VARCHAR(255) NOT NULL,
    name VARCHAR(255) NOT NULL,
    phoneNumber VARCHAR(20),
    UNIQUE(username),
    UNIQUE(email)
);

CREATE TABLE Seller (
    sellerID INT PRIMARY KEY,
    userID INT,
    FOREIGN KEY (userID) REFERENCES User(userID)
);

CREATE TABLE Customer (
    customerID INT PRIMARY KEY,
    userID INT,
    FOREIGN KEY (userID) REFERENCES User(userID)
);

CREATE TABLE Employee (
    employeeID INT PRIMARY KEY,
    userID INT,
    FOREIGN KEY (userID) REFERENCES User(userID)
);

CREATE TABLE Manager (
    managerID INT PRIMARY KEY,
    employeeID INT,
    FOREIGN KEY (employeeID) REFERENCES Employee(employeeID)
);

CREATE TABLE Jewelry (
    jewelryID INT PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    description TEXT,
    initialPrice DOUBLE NOT NULL,
    finalPrice DOUBLE,
    status VARCHAR(50),
    sellerID INT,
    FOREIGN KEY (sellerID) REFERENCES Seller(sellerID)
);

CREATE TABLE Auction (
    auctionID INT PRIMARY KEY,
    startTime DATETIME NOT NULL,
    endTime DATETIME NOT NULL,
    status VARCHAR(50),
    jewelryID INT,
    FOREIGN KEY (jewelryID) REFERENCES Jewelry(jewelryID)
);

CREATE TABLE Orders (
    orderID INT PRIMARY KEY,
    auctionID INT,
    customerID INT,
    orderStatus VARCHAR(50),
    FOREIGN KEY (auctionID) REFERENCES Auction(auctionID),
    FOREIGN KEY (customerID) REFERENCES Customer(customerID)
);

CREATE TABLE Payment (
    paymentID INT PRIMARY KEY,
    orderID INT,
    paymentAmount DOUBLE NOT NULL,
    paymentDate DATETIME NOT NULL,
    FOREIGN KEY (orderID) REFERENCES Orders(orderID)
);

CREATE TABLE TransactionHistory (
    transactionID INT PRIMARY KEY,
    auctionID INT,
    jewelryID INT,
    transactionDate DATETIME NOT NULL,
    transactionAmount DOUBLE NOT NULL,
    FOREIGN KEY (auctionID) REFERENCES Auction(auctionID),
    FOREIGN KEY (jewelryID) REFERENCES Jewelry(jewelryID)
);
