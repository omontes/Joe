SELECT P.`idProducto` AS Codigo, P.`Nombre` AS Producto, P.`Costo`
FROM producto AS P,inventario AS Inv, ubicacionproducto AS U
WHERE Inv.`idUbicacionProducto` = U.`idUbicacionProducto` 
AND P.`Nombre` BETWEEN ? AND ? AND U.`Lugar` = ? 
AND Inv.`idProducto` = P.`idProducto` 
 AND Inv.`Cantidad`<1 AND P.`Estado` ="A" 
GROUP BY P.`idProducto`;
