This example demonstrates Hibernate - in "Manual" mode
WITH Annotations INSTEAD of HBM files

Explicitly managed Session & Transaction
You need to run the .SQL table creations manually

Vehicle is implemented...

With the generation  GenerationType.AUTO hibernate will look for the default hibernate_sequence table , so change generation to  IDENTITY as below :
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private Long id;