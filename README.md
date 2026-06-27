# CodeAlpha_task_3
Stock Trading Platform
A console-based simulated trading application built in Java. It allows users to view live stock market data, buy and sell shares using a simulated virtual balance, track their investment portfolio, and monitor their real-time net worth.  
JAVA
+ 1

🚀 Features
Real-time Market Data: View available stocks (like Apple, Google, Amazon, Tesla, and Infosys) along with their current prices.  
JAVA

Simulated Buying: Purchase shares instantly if you have an adequate cash balance ($10,000.00 starting balance).  
JAVA

Simulated Selling: Sell owned shares from your portfolio back into the market at current rates to liquidate cash.  
JAVA

Portfolio & Net Worth Tracking: View a comprehensive breakdown of your owned shares, total portfolio asset value, cash balance, and overall net worth.  
JAVA

🛠️ Technical Details & Data Structures
Language: Java  
JAVA

LinkedHashMap (market): Used to store pre-defined stock tickers and their matching prices while preserving a predictable insertion order.  
JAVA

LinkedHashMap (portfolio): Tracks the quantities of shares owned by the user, dynamically updating when buying, selling, or completely liquidating a stock position.  
JAVA

Console Interface: Uses an interactive menu loop driven by java.util.Scanner for seamless user choices.  
JAVA

📋 How It Works (Sample Execution)
When run, the application presents a menu to manage your finances:  
JAVA

Plaintext
===== Stock Trading Platform =====
💰 Balance: $10000.00
1. View Market
2. Buy Stock
3. Sell Stock
4. View Portfolio
5. Exit
Enter choice: 
Buying a Stock Example
:
Plaintext
Enter stock name to buy: APPLE
Enter quantity: 10
✅ Bought 10 shares of APPLE for $1825.00
⚙️ How to Run Locally
Prerequisites
Ensure you have the Java Development Kit (JDK) installed on your system.

Execution Steps
Clone the repository:

Bash
git clone https://github.com/YOUR_USERNAME/StockTradingPlatform.git
Navigate to the directory:

Bash
cd StockTradingPlatform
Compile the Java file:

Bash
javac StockTradingPlatform.java
Run the application:

Bash
java StockTradingPlatform
💡 Pro-Tip for GitHub:
  
JAVA
Make sure to replace YOUR_USERNAME in the repository URL with your actual GitHub username before adding this to your profile!
