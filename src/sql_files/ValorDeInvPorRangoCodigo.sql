SELECT P.`idProducto` AS Codigo,Cat.`Descripcion` AS Categoria,
 P.`Nombre` AS Producto, (P.`Costo`*Inv.`Cantidad`) AS CostoTotal,
(P.`Precio`*Inv.`Cantidad`) AS ValorTotal,Inv.`Cantidad`
FROM producto AS P,inventario AS Inv, ubicacionproducto AS U, categoria AS Cat
WHERE Inv.`idUbicacionProducto` = U.`idUbicacionProducto` 
AND P.`idProducto` BETWEEN ? AND ? AND U.`Lugar` = ? 
AND Cat.`idCategoria` =P.`idCategoriaProd`
AND Inv.`idProducto` = P.`idProducto` AND P.`Estado` ="A";
