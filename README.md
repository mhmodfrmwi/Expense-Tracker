
# Expense Tracker Desktop App

A **JavaFX desktop application** for managing expenses and trips. The app uses **MongoDB** for backend storage, ensuring reliable and scalable data management. This project focuses on user authentication, expense tracking, and trip management, providing a seamless experience for desktop users.

---

## **How It Works**
1. **User Authentication**:
   - The application starts with a **login screen** where users authenticate using their email and password.
   - New users can register through the **registration page** by providing a unique username, email, and password.
   - MongoDB stores user details securely, and validation prevents duplicate accounts.

2. **Expense Tracking**:
   - After logging in, users can navigate to the **Expenses page** to add, view, and manage their expenses.
   - Users provide details like subject, merchant, total amount, currency, category, and description.
   - All expenses are stored in the MongoDB `expenses` collection.

3. **Trip Management**:
   - The **Trips page** allows users to manage trips by adding details such as name, type, departure, destination, and budget.
   - Trip data is fetched from the MongoDB `trips` collection and displayed in a table.

4. **Navigation**:
   - The app includes multiple navigation buttons to switch between pages, including Home, Expenses, Trips, and Settings.
   - Each page operates independently, fetching and updating data from MongoDB as needed.

5. **Database Operations**:
   - The application interacts with MongoDB through the `MongoDB Java Driver`, performing CRUD operations for users, expenses, and trips.
   - Error handling ensures data integrity and provides feedback in case of invalid input or connection issues.

---

## **Features**
- **User Registration and Login**:
  - Register new users with unique credentials.
  - Login functionality with validation against MongoDB.
- **Expense Management**:
  - Add and view expenses with detailed attributes.
  - Store expenses securely in the MongoDB database.
- **Trip Management**:
  - Add and view trips with comprehensive details.
- **Error Feedback**:
  - Informative error messages for incorrect inputs or authentication failures.
- **Navigation**:
  - Smooth transitions between pages using JavaFX.
  
---

## **Technologies Used**
- **Frontend**: JavaFX
- **Backend**: MongoDB
- **Language**: Java
- **Database Connection**: MongoDB Java Driver
- **Environment Variables**: `.env` for MongoDB configuration
- **Build Tool**: Maven (or Gradle, if used)

---

## **Setup and Installation**

### Prerequisites
1. **Java Development Kit (JDK)**: Version 8 or later.
2. **MongoDB**: Ensure MongoDB is installed and running locally or on a cloud service.
3. **JavaFX SDK**: Download and configure JavaFX for your IDE.
4. **Maven/Gradle**: Installed for managing dependencies.
5. **Environment Variables**: `.env` file for secure MongoDB connection.

### Steps
1. **Clone the Repository**
   ```bash
   git clone https://github.com/your-repo/expense-tracker.git
   cd expense-tracker
   ```
2. **Create a `.env` File**
   - Place the `.env` file in the project root.
   - Define your MongoDB connection details:
     ```
     MONGO_URI=mongodb://localhost:27017
     DATABASE_NAME=expense-tracker-desktop
     ```
   - Use environment variable libraries like `dotenv-java` to read these variables in your Java code.

3. **Configure MongoDB**
   - Create a database named `expense-tracker-desktop`.
   - Create the following collections:
     - `users`
     - `expenses`
     - `trips`

4. **Run the Application**
   - Open the project in your IDE.
   - Build the project to resolve dependencies.
   - Run the `HelloApplication.java` file to start the app.

---

## **Database Structure**

### **Environment Variables**
| Variable        | Description                       |
|------------------|-----------------------------------|
| `MONGO_URI`      | Connection string for MongoDB.   |
| `DATABASE_NAME`  | Name of the database to use.     |

### **Collections**
#### Users Collection
| Field       | Type   | Description               |
|-------------|--------|---------------------------|
| `username`  | String | User's unique username.   |
| `email`     | String | User's unique email.      |
| `password`  | String | Hashed password.          |

#### Expenses Collection
| Field         | Type    | Description                           |
|---------------|---------|---------------------------------------|
| `subject`     | String  | Subject of the expense.              |
| `merchant`    | String  | Name of the merchant.                |
| `date`        | String  | Date of the expense.                 |
| `total`       | Double  | Total expense amount.                |
| `currency`    | String  | Currency type (e.g., USD, EGP).      |
| `category`    | String  | Category (e.g., Food, Travel).       |
| `description` | String  | Additional description (optional).   |
| `employee`    | String  | Employee linked to the expense.      |
| `addToReport` | Boolean | Whether it's added to a report.      |

#### Trips Collection
| Field       | Type   | Description                    |
|-------------|--------|--------------------------------|
| `name`      | String | Name of the trip.             |
| `type`      | String | Business or Leisure.          |
| `departFrom`| String | Departure location.           |
| `destination`| String | Trip destination.             |

---

## **How to Contribute**
- Fork the repository.
- Create a feature branch:
  ```bash
  git checkout -b feature-name
  ```
- Commit your changes:
  ```bash
  git commit -m "Description of feature"
  ```
- Push the branch and create a pull request.

---

## **Future Enhancements**
- Add data export (PDF, CSV).
- Graphical insights for expenses and trips.
- Support for multiple currencies with exchange rates.
- Role-based access (e.g., admin, user).

