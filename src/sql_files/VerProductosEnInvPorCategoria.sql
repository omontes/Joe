SELECT P.`Nombre` AS Producto,
Cat.`Descripcion` AS Categoria,P.Costo,P.`Precio`, Inv.`Cantidad` 
FROM producto AS P, inventario AS Inv , ubicacionproducto AS U, categoria AS Cat
WHERE P.`idCategoriaProd`=Cat.`idCategoria` AND Cat.`Descripcion` =? AND 
Inv.`idProducto` = P.`idProducto` AND
Inv.`idUbicacionProducto` = U.`idUbicacionProducto` AND U.`Lugar` =? 
AND P.`Estado` ="A";
