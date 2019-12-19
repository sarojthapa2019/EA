This example demonstrates Hibernate - in "Manual" mode

XML configuration of Entities
Explicitly managed Session & Transaction
You need to run the .SQL table creations manually

Vehicle is implemented...

-------------------------------------------------------------------
https://stackoverflow.com/questions/16373015/native-generator-class-in-hibernate

Native means Your generator will use identity or sequence columns according to what your current database support.

Docs explained about each strategy here

http://docs.jboss.org/hibernate/orm/3.3/reference/en/html/mapping.html#mapping-declaration-id

native

selects identity, sequence or hilo depending upon the capabilities of the underlying database.

assigned

lets the application assign an identifier to the object before save() is called. This is the default strategy if no element is specified.

For example: In Mysql if you have primary key column as a auto_increment, the db will be updated using this strategy
-------------------------------------------------------------------