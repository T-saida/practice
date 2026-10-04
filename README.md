# Lab Work: Design Patterns - Bridge (Theme B: Notifications)

## Project Overview
This laboratory work demonstrates the application of the structural design pattern Bridge. The pattern decouples an abstraction (notification hierarchy: Notification, Reminder, UrgentAlert) from its implementation (delivery channel hierarchy: Channel, EmailChannel, SmsChannel, PushChannel), allowing both to vary independently at runtime.

## Developer Information
* Student: Astana IT University
* Major: Software Engineering
* Topic: Bridge - Notifications (Theme B)

## Class Structure and Project Map
* Abstraction:
  * org.example.Notification - base abstract notification class.
  * org.example.Reminder - refined abstraction (reminder).
  * org.example.UrgentAlert - refined abstraction (urgent alert).
* Implementor:
  * org.example.Channel - communication channel interface.
  * org.example.EmailChannel - email delivery implementation.
  * org.example.SmsChannel - SMS delivery implementation.
  * org.example.PushChannel - extended push notification implementation (I3).
* Entry Point:
  * Main.java - test scenario executing functionalities (T1-T7).

## Build and Run
1. Open the project in IntelliJ IDEA.
2. Ensure Java compiler (JDK 17 or higher) is configured.
3. Run the Main.java file.

## Expected Results (Demo Output)
T1 PASS | Reminder + EmailChannel | result=Email Envelope: [Reminder: Meeting at 5 PM]
T2 PASS | Reminder + SmsChannel | result=SMS: Reminder: Meeting at 5 PM
T3 PASS | UrgentAlert + EmailChannel | result=Email Envelope: [URGENT: Server is down]
T4 PASS | UrgentAlert + SmsChannel | result=SMS: URGENT: Server is down
T5 PASS sameObject=true | stateUnchanged=true
before=Email Envelope: [Reminder: System Backup] | after=SMS: Reminder: System Backup
T6 PASS | Reminder + PushChannel | result=Push Notification: [Reminder: New comment]
T7 PASS | UrgentAlert + PushChannel | result=Push Notification: {URGENT: Security breach}
SUMMARY: 7/7 PASS

## Accompanying Files in Project Root
* demo-output.txt - recorded console execution output.
* sources.txt - list of paths to all source files in the project.
* extension.diff - diff file containing changes made for the added PushChannel class.
