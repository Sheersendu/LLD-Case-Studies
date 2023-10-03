### Requirements
<hr>

1. Multiple floors
2. Each floor will have multiple slots
3. Slot types : Large, Medium, Small
4. Vehicle can only be parked at its own slot type
5. Multiple entry and exit gates
6. Each entry gate will have a display board
7. For entering operator will provide a ticket
8. For payment calculation can be done based on slot type and duration (First hour : X, subsequent hours : Y)
9. Modes of payment: CC, DC, Cash, Online(UPI, Net-banking)
10. Manual Payment Counter at every floor
11. Display board shows empty slots at every floor

## Kanmay's Requirements
Build an online parking lot management system that can support the following requirements:
* Should have multiple floors.
* Multiple entries and exit points.
* A person has to collect a ticket at entry and pay at or before exit.
* Pay at:
    * Exit counter (Cash to the parking attendant)
    * Dedicated automated booth on each floor
    * Online
* Pay via:
    * Cash
    * Credit Card
    * UPI
* Allow entry for a vehicle if a slot is available for it. Show on the display at entry if a slot is not available.
* Parking Spots of 3 types:
    * Large
    * Medium
    * Small
* A car can only be parked at its slot. Not on any other (even larger).
* A display on each floor with the status of that floor.
* Fees calculated based on per hour price: e.g. 50 rs for the first hour, then 80 rs per extra hour.
    * Small - 50, 80
    * Medium - 80, 100
    * Large - 100, 120

### Use Case diagram
<hr>

```plantuml
@startuml
left to right direction
actor ParkingAttendant
actor Customer
actor Admin

rectangle ParkingLot {
   Admin --> (Add a parking lot)
   Admin --> (Add a parking floor)
   Admin --> (Add a parking spot)
   Admin --> (Update status of parking spot)
   
   usecase "Pay" as Pay
   usecase "Pay Online" as PayOnline
   usecase "Pay Cash" as PayCash
   usecase "Allocate a slot" as AllocateSlot
   usecase "Issue a ticket" as IssueTicket
   usecase "Checkout" as Checkout
   
   Customer ->(Pay)
   Customer -->(Check spot's Status)
   
   ParkingAttendant --> (Check empty slots)
   ParkingAttendant --> IssueTicket
   ParkingAttendant --> (Collect payment)
   ParkingAttendant --> (Checkout)
   
   Pay <.. (PayOnline) : extends
   Pay <. (PayCash) : extends
   
   IssueTicket .> (AllocateSlot) : includes
   Checkout .> (CheckPaymentStatus) : includes

}
@enduml
```

### Class diagram
<hr>

```mermaid
classDiagram
    class ParkingLot {
       - name : String
       - address: String
       - floors : ParkingFloor[]
       - entryGates : ParkingGate[]
       - exitGates : ParkingGate[]
    }
    class ParkingGate {
       - gateID : String 
       - parkingGateType : ParkingGateType
       - parkingAttendant : ParkingAttendant
    }
    class ParkingGateType {
        <<enumerator>>
        ENTRY
        EXIT
    }
    class ParkingFloor {
       - floorNumber : int
       - parkingSpots : ParkingSpot[]
       - paymentCounter : PaymentCounter 
       - displayBoard : DisplayBoard
    }
    class ParkingSpot {
       - spotNumber : int
       - spotType : ParkingSpotType
       - status : ParkingSpotStatus
    }
    class PaymentCounter {
        - counterNumber : int
    }
    class ParkingSpotType {
        <<enumeration>>
        LARGE
        MEDIUM
        SMALL
    }
    class ParkingSpotStatus {
        <<enumeration>>
        OCCUPIED
        AVAILABLE
        OUTOFORDER
    }
    class Vehicle {
       - licencePlate : string
       - vehicleType : VehicleType 
    }
    class VehicleType {
        <<enumeration>>
        CAR
        TRUCK
        BUS
        BIKE
        SCOOTER
    }
    class Invoice {
       - invoiceId : String
       - exitTime : Date
       - parkingTicket : ParkingTicket
       - amount : Double
       - payment : Payment
    }
    class Payment {
       - parkingTicket : ParkingTicket
       - amount : Double
       - paymentType : PaymentType
       - paymentStatus : PaymentStatus
       - time : Date
    }
    class ParkingTicket {
       - ticketId : String
       - parkingSpot : ParkingSpot
       - entryTime : Date
       - vehicle : Vehicle
       - entryGate : ParkingGate
       - entryOperator : ParkingAttendant
    }
    class PaymentType {
        <<enumeration>>
        CREDITCARD
        DEBITCARD
        CASH
        UPI
    }
    class PaymentStatus {
        <<enumeration>>
        PENDING
        DONE
    }
    class ParkingAttendant {
       - name : String
       - email : String 
    }
    
    ParkingLot "1" --* "M" ParkingGate : entryGates
    ParkingLot "1" --* "M" ParkingGate : exitGates
    ParkingGate "M" --o "1" ParkingGateType
    ParkingLot "1" --* "M" ParkingFloor
    ParkingFloor "1" --* "M" ParkingSpot
    ParkingFloor "1" -- "1" PaymentCounter
    ParkingSpot "M" --o "1" ParkingSpotType
    ParkingSpot "M" --o "1" ParkingSpotStatus
    Vehicle "M" --o "1" VehicleType
    Invoice "1" --o "1" Payment : paid by
    Invoice "1" --o "1" ParkingTicket : generated for
    Payment "1" --o "1" ParkingTicket : paid for
    Payment "1" --o "1" PaymentType 
    Payment "1" --o "1" PaymentStatus
    ParkingTicket "M" --o "1" Vehicle : generated for
    ParkingTicket "M" --o "1" ParkingGate : generated at
    ParkingTicket "M" --o "1" ParkingAttendant : generated By
    ParkingGate "M" --o "1" ParkingAttendant
```

### API Design
<hr>
Pattern to follow : `API name` - `HTTP method` - `URL` - `?Request body` - `?Response body`

#### Parking Lot (CRUD)
1. Create a parking lot : `POST` - `/parking-lot` - `CreateParkingLotDTO` - `GetParkingLotResponse`

```mermaid
classDiagram
  class CreateParkingLotRequest {
      - name : String
      - addresses : String
      - numberOfFloors : int
      - numberOfSlotsPerFloor : int
      - numberOfGates : int
  }
  class GetParkingLotRequest {
      - name : String
      - address: String
      - floors : ParkingFloor[]
      - entryGates : ParkingGate[]
      - exitGates : ParkingGate[]
  }
```


2. 