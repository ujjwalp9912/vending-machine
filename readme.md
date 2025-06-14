First, clarify the requirements with the interviewer

Currently, machine is in Idle state
1. Press insert coin button

Machine has gone into Has Money State 
2. Insert as many coins as you want

3. Press select product button
Machine will go into Selection state

In the has money state, if user cancels, the user will get the refund 
and machine will go into Idle state

Also, once user clicks on select product and then cancel,
machine will go from Selection state to Idle state

Also, when user chose the product but total money inserted is less than
the product price, then auto cancel will occur and machine will go
from selection state to Idle state and all coins will be returned

If everything will be fine, the Machine will go into Dispense state and 
product will be dispensed and then machine will go into Idle state

So, operation is dependent of the Machine's state
One state can perform only a certain set of operations


Idle state
1. Press insert coin button

Has Money state
1. Insert coin
2. Select product button
3. Cancel/Refund button

Selection state
1. Choose product
2. Cancel/Refund
3. Return change

Dispensing state
1. Dispense the product

So, it is a case of STATE DESIGN PATTERN



