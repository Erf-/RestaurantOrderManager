## Encapsulation principle example.

Every layer is bound to a single responsibility:
- presentation layer: presents resources. Adaptation to the service layer. Contains:
  - DTOs (or resources)
  - Mappers from domain to resources and vice versa
  - Controllers
- service layer: only displays what the domain can do, which means the is no business logic implementation here. Adapation to the domain.
- domain layer: contains domain objects with all the business logic related to their respective responsibilities. Also contains interfaces to the data layer
- data layer: contains ORM logic

## Links:
