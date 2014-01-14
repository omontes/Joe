SELECT P.`idProducto` AS CodProduct,P.`Nombre` AS Producto,
SUM(PCF.`Cantidad`) AS Unidades,SUM(PCF.`PrecioVenta`) AS TotalFact
FROM Persona AS C, Producto AS P,Productocantidadfact AS PCF,Factura AS F
WHERE C.`Nombre`=? AND F.`idFactura` = PCF.`idFactura` 
AND F.Concepto!="Eliminada" AND F.idCliente=C.`idPersona` 
AND P.`idProducto`=PCF.`idProductoFact` AND F.Fecha  BETWEEN ? AND ?
GROUP BY P.`idProducto`; 