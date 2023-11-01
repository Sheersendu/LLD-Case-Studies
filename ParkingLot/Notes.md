1. Pattern to follow for API design: `API name` - `HTTP method` - `URL` - `?Request body` - `?Response body`
2. Structure controller:
   1. Entity Level (A lot of different classes but maintainable)
   2. Usecase/Flow based (Related code is together but very hard to find single API. Eg: EntryFlowController, ExitFlowController)
3. DTOs are used when interacting with outer world(request, response)
4. Controllers are responsible for request validation and transformation/Data mapping (Convert DTOs to Models). Also delegate calls to service class
5. Service class method accepts models not DTOs(still it depends)
6. When it's very common for us to convert a DTO to a model then we can add a method for the conversion in the DTO itself
7. What if the no of floors, slots are same for a new parking lot : only id, name, address changes hence we can use prototype design pattern
8. Whenever we are using different components(ParkingLot, ParkingSpot) in each other, calls the same level of the other class. Eg: If we are planning to use ParkingSpot in ParkingLot Service then call ParkingSpot Service. 
