SELECT P.Nombre AS Producto,F.idFactura AS NumFact,F.Fecha,V.Nombre AS Vendedor,
C.`Nombre` AS Cliente,PCF.Cantidad AS Unidades,P.`Precio` AS PrecioRegular,
PCF.`PrecioVenta`
FROM Producto AS P, ProductoCantidadFact As PCF, Factura AS F, Persona AS C, 
Categoria AS CAT, persona AS V
WHERE  CAT.`Descripcion` = ? AND P.`idVersion`=PCF.`idVersionFact` AND 
P.idProducto = PCF.idProductoFact AND PCF.idFactura = F.idFactura 
AND CAT.`idCategoria`= P.`idCategoriaProd` AND F.`Estado` = "A"
AND SUBSTRING(F.Fecha,1,10) BETWEEN ? AND ? AND F.`idCliente` = C.`idPersona` 
AND F.`idVendedor` = V.`idPersona`
AND F.`idVersionFactura` = PCF.`idVersionFacturasProducto`
GROUP BY PCF.`idProductoCantidadFact`; 
