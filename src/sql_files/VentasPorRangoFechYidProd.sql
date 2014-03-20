SELECT P.Nombre AS Producto,F.idFactura AS NumFact,F.Fecha,V.Nombre AS Vendedor,
C.`Nombre` AS Cliente,PCF.Cantidad AS Unidades,P.`Precio` AS PrecioRegular,
PCF.`PrecioVenta`
FROM Producto AS P, ProductoCantidadFact As PCF, Factura AS F, Persona AS C, Persona AS V
WHERE P.`idProducto` = ? AND P.`idVersion`=PCF.`idVersionFact` AND 
P.idProducto = PCF.idProductoFact AND PCF.idFactura = F.idFactura AND 
F.`Estado`="A" AND SUBSTRING(F.Fecha,1,10) BETWEEN ? AND ? AND F.`idCliente` = C.`idPersona` 
AND F.`idVersionFactura` = PCF.`idVersionFacturasProducto` AND V.`idPersona` = F.`idVendedor`
GROUP BY PCF.`idProductoCantidadFact`; 