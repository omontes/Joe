SELECT P.`idProducto` AS CodProduct,P.`Nombre` AS Producto,
SUM(PCF.`Cantidad`) AS Unidades,SUM(PCF.`PrecioVenta`) AS TotalFact
FROM Persona AS C, Producto AS P,Productocantidadfact AS PCF,Factura AS F
WHERE C.`Nombre`=? AND F.`idFactura` = PCF.`idFactura` 
AND F.`Estado`="A" AND F.idCliente=C.`idPersona` 
AND P.`idProducto`=PCF.`idProductoFact` AND SUBSTRING(F.Fecha,1,10) BETWEEN ? AND ?
AND F.`idVersionFactura` = PCF.`idVersionFacturasProducto`
GROUP BY P.`idProducto`;