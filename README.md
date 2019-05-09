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
URL: http(s)://<hostname>/api/events/today
##### Description
Returns all today's events in the iCal file located at the given URL in JSON format.
  
|Header Param|Value|
|---|---|
|calendarurl|*your ical file url*|

### Get today's first event
URL: http(s)://<hostname>/api/events/today/first
##### Description
Returns the first event of today from the iCal file located at the given URL in JSON format.
  
|Header Param|Value|
|---|---|
|calendarurl|*your ical file url*|


