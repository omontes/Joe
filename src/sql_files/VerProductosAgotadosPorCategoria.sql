SELECT P.`idProducto` AS Codigo, P.`Nombre` AS Producto, P.`Costo`
FROM producto AS P,inventario AS Inv, ubicacionproducto AS U,categoria AS Cat
WHERE Inv.`idUbicacionProducto` = U.`idUbicacionProducto` 
AND Cat.`idCategoria` = P.`idCategoriaProd` AND Cat.`Descripcion` = ? AND 
U.`Lugar` = ? AND Inv.`idProducto` = P.`idProducto` AND Inv.`Cantidad`<1 AND
P.`Estado` ="A"
GROUP BY P.`idProducto`;

