SELECT P.`idProducto` AS Codigo, P.`Nombre` AS Producto, P.`Costo`,P.`Precio`,
Inv.`Cantidad`
FROM producto AS P,inventario AS Inv, ubicacionproducto AS U
WHERE Inv.`idUbicacionProducto` = U.`idUbicacionProducto` AND U.`Lugar` = ? 
AND Inv.`idProducto` = P.`idProducto` AND P.`Estado` ="A";
