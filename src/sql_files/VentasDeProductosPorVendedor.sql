SELECT P.`idProducto` AS CodProduct,P.`Nombre` AS Producto,
SUM(PCF.`Cantidad`) AS Unidades,SUM(PCF.`PrecioVenta`) AS TotalFact
FROM Persona AS V, Producto AS P,Productocantidadfact AS PCF,Factura AS F
WHERE V.`Nombre`=? AND F.`idFactura` = PCF.`idFactura` 
AND F.Concepto!="Eliminada" AND F.`idVendedor`=V.`idPersona` 
AND P.`idProducto`=PCF.`idProductoFact` AND F.Fecha  BETWEEN ? AND ?
GROUP BY P.`idProducto`; 