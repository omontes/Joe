SELECT P.`idProducto` AS Codigo, P.`Nombre` AS Producto,
U.`Lugar` AS Ubicacion,P.`Costo`,P.`Precio`, Inv.`Cantidad` 
FROM producto AS P, inventario AS Inv , ubicacionproducto AS U
WHERE P.`Nombre` BETWEEN ? AND ? AND Inv.`idProducto` = P.`idProducto` AND
Inv.`idUbicacionProducto` = U.`idUbicacionProducto` AND P.`Estado` ="A";

