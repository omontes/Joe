SELECT P.Nombre AS Producto,F.idFactura AS NumFact,F.`TipoPago`,F.Fecha,
C.`Nombre` AS Cliente,PCF.Cantidad AS Unidades,P.`Precio` AS PrecioRegular,
PCF.`PrecioVenta`,(F.`Descuento`+F.`TotalFacturado`) AS SubTotal,F.`TotalFacturado`

FROM Producto AS P, ProductoCantidadFact As PCF, Factura AS F, Persona AS C
WHERE P.`idProducto` = 1512 AND P.`idVersion`=PCF.`idVersionFact` AND 
P.idProducto = PCF.idProductoFact AND PCF.idFactura = F.idFactura

AND F.Fecha BETWEEN "2010/02/02" AND "2014/02/02" AND F.`idCliente` = C.`idPersona` 
GROUP BY PCF.`idProductoCantidadFact`; 