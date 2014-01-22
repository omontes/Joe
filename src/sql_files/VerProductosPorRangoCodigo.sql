SELECT P.`idProducto` AS Codigo, P.`Nombre` AS Producto,
Cat.`Descripcion` AS Categoria,U.`Lugar` AS Ubicacion, P.`Precio`, Inv.`Cantidad` 
FROM producto AS P, categoria AS Cat, inventario AS Inv , ubicacionproducto AS U
WHERE P.`idProducto` BETWEEN ? AND ? AND Inv.`idProducto` = P.`idProducto` AND
Inv.`idUbicacionProducto` = U.`idUbicacionProducto`
AND P.`Estado` ="A";