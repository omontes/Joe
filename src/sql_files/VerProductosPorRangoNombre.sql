SELECT P.`idProducto` AS Codigo, P.`Nombre` AS Producto,
Cat.`Descripcion` AS Categoria,U.`Lugar` AS Ubicacion,P.`Precio`, Inv.`Cantidad` 
FROM producto AS P, inventario AS Inv , ubicacionproducto AS U, categoria AS Cat
WHERE P.`Nombre` BETWEEN ? AND ? AND Inv.`idProducto` = P.`idProducto` AND
Inv.`idUbicacionProducto` = U.`idUbicacionProducto` AND
Cat.`idCategoria` = P.`idCategoriaProd` AND P.`Estado` ="A";
