SELECT P.Nombre AS Producto,F.idFactura AS NumFact,F.`TipoPago`,F.Fecha,
C.`Nombre` AS Cliente,PCF.Cantidad AS Unidades,P.`Precio` AS PrecioRegular,
PCF.`PrecioVenta`
FROM Producto AS P, ProductoCantidadFact As PCF, Factura AS F, Persona AS C, Categoria AS CAT
WHERE  CAT.`Descripcion` = ? AND P.`idVersion`=PCF.`idVersionFact` AND 
P.idProducto = PCF.idProductoFact AND PCF.idFactura = F.idFactura

AND F.Fecha BETWEEN ? AND ? AND F.`idCliente` = C.`idPersona` 
GROUP BY PCF.`idProductoCantidadFact`; 
