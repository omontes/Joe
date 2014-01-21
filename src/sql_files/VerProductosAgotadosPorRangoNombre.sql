SELECT P.`idProducto` AS Codigo, P.`Nombre` AS Producto, P.`Costo`, 
MAX(F.`Fecha`) AS UltimaVenta
FROM producto AS P, factura AS F, productocantidadfact AS PCF, 
inventario AS Inv, ubicacionproducto AS U
WHERE Inv.`idUbicacionProducto` = U.`idUbicacionProducto` 
AND P.`Nombre` BETWEEN ? AND ? AND U.`Lugar` = ? AND
PCF.`idProductoFact`= P.`idProducto` AND PCF.`idVersionFact`=P.`idVersion` 
AND Inv.`idProducto` = P.`idProducto` 
AND PCF.`idVersionFacturasProducto` =F.`idVersionFactura` 
AND PCF.`idFactura` = F.`idFactura` AND Inv.`Cantidad`<1 AND P.`Estado` ="A" 
GROUP BY P.`idProducto`;