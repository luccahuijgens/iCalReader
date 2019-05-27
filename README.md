# IoT-Alarm
REST-AP Service for IoT Alarm

## Endpoints
### Get all events
URL: http(s)://*hostname*/api/events
##### Description
Returns all events in the iCal file located at the given URL in JSON format.
  
|Header Param|Value|
|---|---|
|calendarurl|*your ical file url*|

### Get today's events
URL: http(s)://*hostname*/api/events/today
##### Description
Returns all today's events in the iCal file located at the given URL in JSON format.
  
|Header Param|Value|
|---|---|
|calendarurl|*your ical file url*|

### Get today's first event
URL: http(s)://*hostname*/api/events/today/first
##### Description
Returns the first event of today from the iCal file located at the given URL in JSON format.
  
|Header Param|Value|
|---|---|
|calendarurl|*your ical file url*|



# Heroku
A guide for setting up Heroku for the IoT Alarm.

## Requirements: 
A copy of this repository on a personal github account.

### Step 1: Signing up
<img src="./Resources/Sign up.png">
Go to the website of Heroku (https://www.heroku.com) and sign up if you don't already own a account.

### Step 2: Let's make a new app!
<img src="./Resources/Make a new app.png">
After you successfully created an account you arrive at the dashboard. Here you select “Create a new app” to get started.

### Step 3: Choose a name
<img src="./Resources/Select a name.png">
Now enter a name for your Heroku app and select your region.

### Step 4: Connecting to Github
<img src="./Resources/Connect to Github.png">
Select Github under "Deployment method" and press the "Connect to Github" button.

### Step 5: Search for your repository
<img src="./Resources/Connect to a repo.png">
Search for you IoT Alarm repository copy and connect it to heroku.

### Step 6: Deploy your code
<img src="./Resources/Deploy the code.png">
1:	Select your branch.
2:	Enable automatic deployment.
3: 	Deploy your code!

## Congratulations!
Your app is now deployed with as hostname the name you created at step 3. 
