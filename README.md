
# Expense Tracker Desktop Application

This is a desktop application built using **JavaFX** and **MongoDB** for tracking expenses and managing trips. The application includes features like user authentication, expense management, and trip planning.

## Features

### General
- **Login/Register:** Secure user authentication system.
- **Home Screen:** Easy navigation to different features.

### Expense Management
- Add, view, and manage expenses with details such as:
  - **Subject**
  - **Merchant**
  - **Amount**
  - **Date**

### Trip Planning
- Create and save trips with the following details:
  - **Name**
  - **Purpose**
  - **Type (Domestic/International)**
  - **Departure Location**
  - **Destination**
  - **Budget**
  - **Hotel**

### Data Storage
- All data is stored in a **MongoDB** database, ensuring scalability and reliability.

## Technology Stack

- **Frontend:** JavaFX
- **Backend:** Java
- **Database:** MongoDB
- **Environment Configuration:** `dotenv` for managing sensitive credentials.

## Installation and Setup

1. Clone the repository:
   ```bash
   git clone https://github.com/yourusername/expense-tracker-desktop.git
   ```
2. Navigate to the project directory:
   ```bash
   cd expense-tracker-desktop
   ```
3. Set up your environment variables:
   - Create a `.env` file in the `src/main/resources` directory.
   - Add the following variables:
     ```
     MONGO_URI=<Your MongoDB Connection String>
     ```
4. Run the application:
   - Use your preferred Java IDE (e.g., IntelliJ IDEA or Eclipse) to build and run the project.

## Project Structure

```
src/main/java/com/example/demo/
├── AddTrip.java          # Controller for adding trips
├── DB.java               # Database connection and operations
├── Expense.java          # Expense model
├── Expenses.java         # Controller for managing expenses
├── HelloApplication.java # Main application entry point
├── Home.java             # Controller for the home screen
├── Login.java            # Controller for login
└── Trip.java             # Trip model
```

## How to Use

1. **Login/Register:**
   - Use the login screen to register as a new user or log in with existing credentials.

2. **Expense Management:**
   - Navigate to the "Expenses" section to add, view, and manage your expenses.

3. **Trip Planning:**
   - Go to the "Add Trip" section to plan and save details about your trips.

## Contributing

Contributions are welcome! To contribute:
1. Fork the repository.
2. Create a new branch (`feature/your-feature`).
3. Commit your changes.
4. Push to the branch.
5. Create a pull request.

## License

This project is licensed under the MIT License. See the [LICENSE](LICENSE) file for details.

## Contact

For any questions or feedback, feel free to reach out at **your-email@example.com**.
