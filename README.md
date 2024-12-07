# Proyecto Market API

Pequeña API para practicar autenticacion Digest, POA (Programacion Orientada a Aspectos) y algunos test usando Mockito y JUnit5

## Resumen

Tres controladores:
- Product
- Customer
- Order

Cada uno con un CRUD donde los datos se guardan en una cache.

Para la implementación de POA se creo un aspecto para logs en los servicios, toma en cuenta aquellos que contengan el nombre metodos como **GetAll**, **Save** o **Delete**.

Para la configuracion de Digest Auth, se creo un bean se seguridad en el paquete Config el cual permite cualquier consumo para los paths de '*/customer*' y '*/product*' pero para el path *'/order'* se debe enviar un user y password con su correspondiente *Realm Name*
