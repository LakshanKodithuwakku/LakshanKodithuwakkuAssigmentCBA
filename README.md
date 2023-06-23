# Android Native Application - JAVA

This is a simple Android native application that features a login page and a home page. Users can enter their username and password in the respective text fields and submit the form using the login button. If the entered username or password is incorrect, an error message will be displayed at the top of the login screen. Upon successful login, users will be navigated to the home screen.

## Features

- Login functionality with error handling for incorrect credentials.
- Retrieval of JSON data from an API and local storage using SharedPreferences.
- Viewing of profile data on the home screen, fetched from SharedPreferences.

## Getting Started

To run this application locally, follow these steps:

1. Clone the repository:

```bash
git clone https://github.com/LakshanKodithuwakku/LakshanKodithuwakkuAssigmentCBA.git
```

2. Open the project in Android Studio.
3. Build and run the application on an Android device or emulator.

## Usage

1. Launch the application on your Android device or emulator.
2. On the login screen, enter your username and password in the corresponding text fields.
   ```json
   {
    "username":"test",
    "password":"Test123"
   }
    ```
3. Tap the login button to submit the form.
4. If the entered credentials are incorrect, an error message will be displayed at the top of the login screen.
5. If the credentials are correct, you will be redirected to the home screen.
6. On the home screen, you will find a "View Profile" button.
7. Tap the "View Profile" button to display your profile data.
8. The profile data is retrieved from local storage (SharedPreferences) and will be displayed on the home screen.

## JSON Data and SharedPreferences

The application fetches JSON data from an API and stores it locally using SharedPreferences. The JSON data structure should be as follows:

```json
{
    "res_code": 0,
    "res_desc": "success",
    "user_data": {
        "id": "ID001",
        "email": "test@cba.lk",
        "name": "Test User CBA",
        "dob": "1971-01-01",
        "gender": "MALE",
        "company": "CBA - Dehiwala",
        "position": "Trainee SE"
    }
}
```

The retrieved JSON data is stored in SharedPreferences upon successful login. The profile data can then be accessed and displayed on the home screen.
